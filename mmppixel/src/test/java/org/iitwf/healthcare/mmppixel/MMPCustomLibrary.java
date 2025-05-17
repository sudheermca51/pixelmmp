package org.iitwf.healthcare.mmppixel;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


//1. Login to mmp application
//2. Click on Schedule Appointment module.
//3. Click on <Create new appointment> button.
//4. Select the <Cardiologist> doctor and click on bookAppointment button.
//5. Select the FutureDate - 30 days from today.
//6. Select the Time: 10 AM
//7. VAlidate the Text OK is displayed.
//7. Click on continue button.
//9. Enter the symptoms in the text area.
//10. Click on Submit
//11. Validate the data entered during schedule appointment is matching with the patient portal table contents

public class MMPCustomLibrary {
	
	WebDriver driver;
	
	public MMPCustomLibrary(WebDriver driver)
	{
		this.driver= driver;
		System.out.println("from cons"+ this);
	}
	
	
	public boolean editFields(String expectedMsg)
	{
		boolean result = false;
		//click on edit button
		
		clickOnEditButton();
		String expectedFName = "FName"+RandomUtils.generateRandomString(5);
		String expectedLName = "LName"+RandomUtils.generateRandomString(5);
		editFirstName(expectedFName);
		editLastName(expectedLName);
		clickOnSaveButton();
		String actualMsg = getEditMsg();
		String actualFName=getFirstNameValue();
		String actualLName=getLastNameValue();
		
		if(expectedFName.equals(actualFName) && expectedLName.equals(actualLName) &&  expectedMsg.equals(actualMsg))
		{
			result = true;
		}
		
		return result;
	}
	public boolean editFieldsInvalidData(String errMsg)
	{
		boolean result = false;
		clickOnEditButton();
		String fNameValue = "FName"+RandomUtils.generateRandomInteger(100, 200);
		String lNameValue = "LName"+RandomUtils.generateRandomInteger(100, 200);
		editFirstName(fNameValue);
		editLastName(lNameValue);
		clickOnSaveButton();
		String actFNameInvMsg = getFNameInvalidMsg();
		String actLNameInvMsg = getLNameInvalidMsg();
		
		if(errMsg.equals(actFNameInvMsg) && errMsg.equals(actLNameInvMsg) )
		{
			result = true;
		}
		
		return result;
		
	}
	public String getFNameInvalidMsg()
	{
		String invalidMsg = driver.findElement(By.id("firsterr1")).getText();
		return invalidMsg;
		
	}
	public String getLNameInvalidMsg()
	{
		String invalidMsg = driver.findElement(By.id("lasterr1")).getText();
		return invalidMsg;
		
	}
	public String getFirstNameValue()
	{
		WebElement firstNameWE = driver.findElement(By.id("fname"));
		return firstNameWE.getDomProperty("value");
	}
	public String getLastNameValue()
	{
		WebElement lastNameWE = driver.findElement(By.id("lname"));
		return lastNameWE.getDomProperty("value");
	}
	public String getEditMsg()
	{
		Alert alrt = driver.switchTo().alert();
		String editMsg = alrt.getText();
		alrt.accept();
		return editMsg;
	}
	public void clickOnSaveButton()
	{
		driver.findElement(By.id("Sbtn")).submit();
		
	}
	public void clickOnEditButton() {
		
		driver.findElement(By.id("Ebtn")).click();
	}
	public void editFirstName(String expectedFName ) {
		WebElement firstNameWE = driver.findElement(By.id("fname"));
		firstNameWE.clear();
		firstNameWE.sendKeys(expectedFName);
		
		
	}
	public void editLastName(String expectedLName)
	{
		WebElement lastNameWE = driver.findElement(By.id("lname"));
		lastNameWE.clear();
		lastNameWE.sendKeys(expectedLName);	
	}
	public void login(String uname,String pword)
	{
		//1. Login to mmp application
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
	}
	public void selectModule(String moduleName)
	{
		//2. Click on Schedule Appointment module.
				driver.findElement(By.xpath("//span[normalize-space()='"+moduleName+"']")).click();

	}
	public HashMap<String, String> bookAppointment(int n,String format,String specialization,String time)
	{
		
		//3. Click on <Create new appointment> button.
		driver.findElement(By.xpath("//input[@value='Create new appointment']")).click();


		//4. Select the <Cardiologist> doctor and click on bookAppointment button.
		String expectedDoctor=driver.findElement(By.xpath("//p[contains(text(),'"+specialization+"')]/parent::div/preceding-sibling::h4")).getText().replace("Dr.","");		
		driver.findElement(By.xpath("//p[contains(text(),'"+specialization+"')]/ancestor::ul/following-sibling::button")).click();
		
		 
		//5. Select the FutureDate - 30 days from today.
		
		driver.switchTo().frame("myframe");
		
		driver.findElement(By.id("datepicker")).click();
		 

		String expectedOutput=FutureDate.generateFutureDate(n,format);


		String outputArray[] = expectedOutput.split("/");
		System.out.println(outputArray[0]);
		System.out.println(outputArray[1]);
		System.out.println(outputArray[2]);
		System.out.println("Expected Output::::: "+ expectedOutput);
		String expectedYear = outputArray[2];//2026
		String actualYear = driver.findElement(By.className("ui-datepicker-year")).getText();//2025
		
		while(!(actualYear.equals(expectedYear)))
		{
			
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actualYear = driver.findElement(By.className("ui-datepicker-year")).getText();//2025
			
		}
		
		String expectedMonth=outputArray[1];//April
		String actualMonth = driver.findElement(By.className("ui-datepicker-month")).getText();//January
		while(!(actualMonth.equals(expectedMonth)))
		{
			
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actualMonth = driver.findElement(By.className("ui-datepicker-month")).getText();//January
			
		}

		String expectedDay=outputArray[0]; 

		driver.findElement(By.linkText(expectedDay)).click();
		
		
		String expectedDate = driver.findElement(By.id("datepicker")).getDomProperty("value");

		//6. Select the Time: 10 AM
		Select timeSelect = new Select(driver.findElement(By.name("time")));
	    timeSelect.selectByVisibleText(time);
		
		String expectedTime=new Select(driver.findElement(By.name("time"))).getFirstSelectedOption().getText();
		
		
		 
		//7. VAlidate the Text OK is displayed.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("status")), "OK"));

		 
		//8. Click on continue button.
		driver.findElement(By.id("ChangeHeatName")).click();

		
		//9. Enter the symptoms in the text area.
		driver.switchTo().defaultContent();
		
		driver.findElement(By.id("sym")).sendKeys("fever");
		
		String expectedSymptom= driver.findElement(By.id("sym")).getDomProperty("value");

		 
	   driver.findElement(By.xpath("//input[@value='Submit']")).click();
	   //Expected Result
	   System.out.println("#########################Expected Values######################################");
	   System.out.println("expectedDate--expectedDoctor---expectedTime--expectedSymptom");
	   System.out.println(expectedDate+"--"+expectedDoctor+"---"+expectedTime+"---"+expectedSymptom);
	   System.out.println("#########################Expected Values######################################");
	   
	   HashMap<String,String> expectedHMap = new HashMap<String,String>();
	   expectedHMap.put("date", expectedDate);
	   expectedHMap.put("doctor", expectedDoctor);
	   expectedHMap.put("time", expectedTime);
	   expectedHMap.put("sym", expectedSymptom);
	   return expectedHMap;
	   
	   
	}
	public HashMap<String, String> fetchPatientPortalData()
	{
		  System.out.println("#########################Actual Values######################################");
		   System.out.println("actualDate--actualDoctor---actualTime--actualSymptom");
		   String actualDate= driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[1]")).getText();
		   String actualTime= driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[2]")).getText();
		   String actualSymptom= driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[3]")).getText();
		   String actualDoctor= driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[4]")).getText();
		   System.out.println(actualDate+"--"+actualDoctor+"---"+actualTime+"---"+actualSymptom);
		   System.out.println("#########################Actual Values######################################");
		   HashMap<String,String> actualHMap = new HashMap<String,String>();
		   actualHMap.put("date", actualDate);
		   actualHMap.put("doctor", actualDoctor);
		   actualHMap.put("time", actualTime);
		   actualHMap.put("sym", actualSymptom);
		   return actualHMap;
	}
	 
}

