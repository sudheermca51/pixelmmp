package org.iitwf.healthcare.mmppixel;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPatient {

	public static void main(String[] args) {
		
		

		WebDriver driver = new ChromeDriver();
		//Launch login page
		driver.get("https://o2.openmrs.org/openmrs/login.htm");

		//Enter credentials
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("Admin123");

		//select location and login
		driver.findElement(By.id("Inpatient Ward")).click();

		driver.findElement(By.xpath("//input[@Value='Log In']")).click();
 

		//Register a patient
		driver.findElement(By.
				id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")).click();


		driver.findElement(By.name("givenName")).sendKeys("AUTGName"+RandomUtils.generateRandomNumber(1000));
		driver.findElement(By.name("middleName")).sendKeys("AUTMName"+RandomUtils.generateRandomNumber(1000));
		driver.findElement(By.name("familyName")).sendKeys("AUTFName"+RandomUtils.generateRandomNumber(1000));


		driver.findElement(By.id("next-button")).click();

		Select genderSelect = new Select(driver.findElement(By.id("gender-field")));
		String genderValue="Male";
		genderSelect.selectByVisibleText(genderValue);
		 
		driver.findElement(By.id("next-button")).click();


		driver.findElement(By.id("birthdateDay-field")).sendKeys("01");
		String day = driver.findElement(By.id("birthdateDay-field")).getDomProperty("value");

		WebElement birthMonthWE = driver.findElement(By.id("birthdateMonth-field"));
		Select monthSelect = new Select(birthMonthWE);

		monthSelect.selectByVisibleText("July");
		String month = monthSelect.getFirstSelectedOption().getText();

		driver.findElement(By.id("birthdateYear-field")).click();
		driver.findElement(By.id("birthdateYear-field")).sendKeys("1982");
		String year = driver.findElement(By.id("birthdateYear-field")).getDomProperty("value");


		driver.findElement(By.id("next-button")).click();



		driver.findElement(By.id("address1")).click();
		driver.findElement(By.id("address1")).sendKeys("Address1");
		driver.findElement(By.id("address2")).sendKeys("Addres2");
		driver.findElement(By.id("next-button")).click();

		driver.findElement(By.name("phoneNumber")).sendKeys("1231231231");
		driver.findElement(By.id("next-button")).click();

		WebElement dropdown = driver.findElement(By.id("relationship_type"));
		Select relationShipSelect = new Select(dropdown);
		relationShipSelect.selectByVisibleText("Doctor");

		driver.findElement(By.cssSelector(".person-typeahead")).click();
		driver.findElement(By.cssSelector(".person-typeahead")).sendKeys("123awdgsa");
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.id("submit")).submit();//click on confirm


		//		//Navigate to homePage
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/em[text()='Patient ID']/following-sibling::span")));
	
		String patientID =driver.findElement(By.xpath("//em[text()='Patient ID']/following-sibling::span")).getText();
		System.out.println("patient ID:::" + patientID);
	 
		//driver.findElement(By.cssSelector("ul#breadcrumbs>li")).click();
	}

}
