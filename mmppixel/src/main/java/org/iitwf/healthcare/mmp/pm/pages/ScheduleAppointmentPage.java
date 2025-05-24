package org.iitwf.healthcare.mmp.pm.pages;

import java.time.Duration;
import java.util.HashMap;

import org.iitwf.healthcare.mmppixel.FutureDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScheduleAppointmentPage {

 
	protected WebDriver driver;
	public ScheduleAppointmentPage(WebDriver driver)
	{
		this.driver = driver;

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
	 
 
}
