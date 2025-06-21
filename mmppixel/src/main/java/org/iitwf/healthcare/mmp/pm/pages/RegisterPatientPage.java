package org.iitwf.healthcare.mmp.pm.pages;

import org.iitwf.healthcare.mmppixel.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPatientPage {

	private WebDriver driver;
	private String password;
	private String licenseNumber;
	
	// Locators for various elements on the Register Patient page can be added here
	By firstNameBy = By.id("firstname");
	By lastNameBy = By.id("lastname");
	By dobBy = By.id("datepicker");
	By licenseNumberBy = By.id("license");
	By socialSecurityNumberBy = By.id("ssn");
	By addressBy = By.id("address");
	By cityBy = By.id("city");
	By stateBy = By.id("state");
	By zipCodeBy = By.id("zipcode");
	By ageBy = By.id("age"); 
	By heightBy = By.id("height");
	By weightBy = By.id("weight");
	By emailBy = By.id("email");
    By phoneBy = By.id("phone");
    By passwordBy = By.id("password");
    By usernameBy = By.id("username");
    By confirmPasswordBy = By.id("confirmpassword");
    By submitButtonBy = By.xpath("//input[@type='submit']");
    By resetButtonBy = By.xpath("//input[@type='reset']");
    By selectSecurityQuestionBy = By.id("security");
    By securityAnswerBy = By.id("answer");

	
	
	public RegisterPatientPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void registerPatient() {
		
		driver.findElement(firstNameBy).sendKeys("FName"+RandomUtils.generateRandomString(5)); // Example first name, replace with actual name if needed
		driver.findElement(lastNameBy).sendKeys("LName"+RandomUtils.generateRandomString(5)); // Example last name, replace with actual name if needed
		driver.findElement(dobBy).sendKeys("01/01/1990"); // Example date, replace with actual date format if needed
		
//licenseNumber = String.valueOf(RandomUtils.generateRandomEightDigitNumber());

//System.out.println("Generated License Number: " + licenseNumber);

driver.findElement(licenseNumberBy).sendKeys("23234747"); // Example license number, replace with actual format if needed
		
		driver.findElement(socialSecurityNumberBy).sendKeys(String.valueOf(RandomUtils.generateRandomNumber(1000000000))); // Example SSN, replace with actual format if needed
		driver.findElement(addressBy).sendKeys("123 Main St, Apt 4B, Springfield, IL"); // Example address
		driver.findElement(cityBy).sendKeys("Springfield");
		driver.findElement(stateBy).sendKeys("IL"); // Example state, replace with actual state if needed
		driver.findElement(zipCodeBy).sendKeys("12378"); // Example zip code, replace with actual zip code if needed
		driver.findElement(ageBy).sendKeys(String.valueOf(RandomUtils.generateRandomNumber(100))); // Example age, replace with actual age if needed
		driver.findElement(heightBy).sendKeys(String.valueOf(RandomUtils.generateRandomNumber(100))); // Example height in cm, replace with actual height if needed
		driver.findElement(weightBy).sendKeys(String.valueOf(RandomUtils.generateRandomNumber(100))); // Example weight in kg, replace with actual weight if needed
		driver.findElement(emailBy).sendKeys("testuser" + RandomUtils.generateRandomNumber(1000) + "@example.com"); // Example email, replace with actual email format if needed
		//driver.findElement(phoneBy).sendKeys("1234567890"); // Example phone number, replace with actual phone format if needed
		driver.findElement(usernameBy).sendKeys("user" + RandomUtils.generateRandomNumber(1000)); // Example username, replace with actual username format if needed
		password = "Abcdef"+ RandomUtils.generateRandomNumber(100000); // Example password, replace with actual password format if needed
		driver.findElement(passwordBy).sendKeys(password);						driver.findElement(confirmPasswordBy).sendKeys(password); // Assuming confirm password is same as password
		// Assuming there is a security question dropdown, select it if needed
		driver.findElement(selectSecurityQuestionBy).click();
selectSecurityQuestionBy = By.xpath("//option[contains(text(),'What is your mother maiden name')]");
		driver.findElement(selectSecurityQuestionBy).click(); // Select a security question	
		driver.findElement(securityAnswerBy).sendKeys(RandomUtils.generateRandomString(8)); // Replace with actual answer
		driver.findElement(submitButtonBy).click();
		// Handle any alert that appears after submission
		// This is a placeholder, actual alert handling may vary based on the application behavior
		// You may need to switch to the alert and accept it
		// For example, if an alert appears after submission, you can handle it like this:
		// Note: Ensure that the alert is present before switching to it
		try {
			Thread.sleep(2000); // Wait for 2 seconds to allow the alert to appear (adjust as necessary)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().alert().accept(); // Handle any alert that appears after submission
		//driver.switchTo().defaultContent(); // Switch back to the main content after handling the alert
	}
}
