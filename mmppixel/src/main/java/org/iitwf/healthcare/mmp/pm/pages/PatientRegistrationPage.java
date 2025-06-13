package org.iitwf.healthcare.mmp.pm.pages;

import java.time.Duration;
import java.util.HashMap;

import org.iitwf.healthcare.mmppixel.FutureDate;
import org.iitwf.healthcare.mmppixel.RandomUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PatientRegistrationPage {

	protected WebDriver driver;

	public PatientRegistrationPage(WebDriver driver) {
		this.driver = driver;

	}

	public HashMap<String, String> registerPatient() {
		String fName = RandomUtils.generateRandomString(6);
		String lName = RandomUtils.generateRandomString(6);
		String licenseNumber = RandomUtils.generateRandomNumber(8);
		String ssn = RandomUtils.generateRandomNumber(9);
		String userName = RandomUtils.generateRandomString(6);
		String password = RandomUtils.generateRandomPwd(9);
		click("id", "firstname", fName);
		click("id", "lastname", lName);
		click("id", "datepicker", "12212000");
		click("id", "license", "00000000");
		click("id", "ssn", ssn);
		click("id", "state", "TN");
		click("id", "city", "Franklin");
		click("id", "address", "Carlisle Pl");
		click("id", "zipcode", "30720");
		click("id", "age", "32");
		click("id", "height", "154");
		click("id", "weight", "112");
		click("id", "pharmacy", "My Pharmacy");
		click("id", "pharma_adress", "Franklin Pharmacy");
		click("id", "email", RandomUtils.generateRandomEmailID());
		click("id", "username", userName);
		click("id", "password", password);
		click("id", "confirmpassword", password);
		select("id", "security", "what is your pet name");
		click("id", "answer", "Bob");
		click("name", "register");
		acceptAlert();

		System.out.println("#########################Registration page Values######################################");
		System.out.println("fName--userName---password--ssn--licenseNumber");
		System.out.println(fName + "--" + userName + "---" + password + "---" + ssn + "---" + licenseNumber);
		System.out.println("#########################Registration page Values######################################");

		HashMap<String, String> regHMap = new HashMap<String, String>();
		regHMap.put("fName", fName);
		regHMap.put("userName", userName);
		regHMap.put("password", password);
		regHMap.put("ssn", ssn);
		regHMap.put("licenseNumber", licenseNumber);

		return regHMap;

	}

	private void select(String locator, String locatorRef, String value) {
		Select dropdown;
		if (locator.equals("id")) {
			dropdown = new Select(driver.findElement(By.id(locatorRef)));
			dropdown.selectByVisibleText(value);
			// dropdown.selectByIndex(2);
		}
	}

	public void click(String locator, String locatorRef, String value) {
		if (locator.equals("id")) {
			driver.findElement(By.id(locatorRef)).sendKeys(value);
		} else if (locator.equals("name")) {
			driver.findElement(By.name(locatorRef)).sendKeys(value);
		} else if (locator.equals("xpath")) {
			driver.findElement(By.xpath(locatorRef)).sendKeys(value);
		}
	}

	public void click(String locator, String locatorRef) {
		
		if (locator.equals("id")) {
			driver.findElement(By.id(locatorRef)).click();
		} else if (locator.equals("name")) {
			driver.findElement(By.name(locatorRef)).click();
		} else if (locator.equals("xpath")) {
			driver.findElement(By.xpath(locatorRef)).click();
		}
	}

	public void clickMenu(String menuName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions
				.textToBePresentInElementLocated(By.xpath("//span[normalize-space()='" + menuName + "']"), "Users"));
		driver.findElement(By.xpath("//span[normalize-space()='" + menuName + "']")).click();
	}

	public void clickPatientName(String ssn, String fName) {
		// td[normalize-space()='478496633']/preceding-sibling::td/a[normalize-space()='ATFirstNametucr']
		driver.findElement(By.xpath(
				"//td[normalize-space()='" + ssn + "']/preceding-sibling::td/a[normalize-space()='" + fName + "']"))
				.click();
	}

	private void acceptAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		System.out.println("Alert message :: " + alert.getText());
		alert.accept();
	}

}
