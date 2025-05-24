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
	 
 
	 
}

