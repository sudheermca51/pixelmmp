package org.iitwf.healthcare.mmp.pm.pages;

import java.time.Duration;
import java.util.HashMap;

import org.iitwf.healthcare.mmppixel.NewRandomUtils;
import org.iitwf.healthcare.mmppixel.RandomUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

	protected static WebDriver driver;
	public static int randomSSN;
	public static String password = "B4252541234a";
	public static String userNameText;
	public static String fname;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	public static HashMap<String, String> expectedUserNameHMap = new HashMap<>();

	public static void registrationDetails() {
		
		WebElement firstNameField = driver.findElement(By.id("firstname"));
		fname = RandomUtils.generateRandomString(8);
		System.out.println("Generated FirstName:" + fname);
		firstNameField.sendKeys(fname);

		WebElement lastNameField = driver.findElement(By.id("lastname"));
		lastNameField.sendKeys(String.valueOf(RandomUtils.generateRandomString(8)));

		driver.findElement(By.xpath("//input[@name='dob']")).sendKeys("02062000");

		driver.findElement(By.xpath("//input[@id='license']")).sendKeys("34567892");

		randomSSN = NewRandomUtils.generateRandom9DigitNumber();
		driver.findElement(By.xpath("//input[@id='ssn']")).sendKeys(String.valueOf(randomSSN));
		System.out.println("After:" + randomSSN);

		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("GA");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("JohnsCreek");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("7890 Wollastonrd");
		driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("92122");
		driver.findElement(By.xpath("//input[@id='age']")).sendKeys("24");
		driver.findElement(By.xpath("//input[@id='height']")).sendKeys("5.5");
		driver.findElement(By.xpath("//input[@id='weight']")).sendKeys("54");
		driver.findElement(By.xpath("//input[@id='pharmacy']")).sendKeys("Walgreens");
		driver.findElement(By.xpath("//input[@id='pharma_adress']")).sendKeys("3000 HastingsDr");
		driver.findElement(By.id("email")).sendKeys(
				RandomUtils.generateRandomString(5) + RandomUtils.generateRandomInteger(50, 100) + "@gmail.com");

		driver.findElement(By.id("password")).sendKeys(password);

		userNameText = RandomUtils.generateRandomString(5);
		System.out.println("Generated UserName:" + userNameText);
		driver.findElement(By.id("username")).sendKeys(userNameText);

		expectedUserNameHMap.put("username", userNameText);

		driver.findElement(By.id("confirmpassword")).sendKeys(password);
		System.out.println("Password:" + "B4252541234a");

		Select dropDown = new Select(driver.findElement(By.id("security")));
		dropDown.selectByVisibleText("what is your pet name");
		
		driver.findElement(By.id("answer")).sendKeys(RandomUtils.generateRandomString(3));
		driver.findElement(By.xpath("//input[@value='Save']")).click();

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			System.out.println("Alert message :: " + alert.getText());
			alert.accept();
		} catch (Exception e) {
			System.out.println("No alert appeared. Exception: " + e.getMessage());
		}
	}
}
