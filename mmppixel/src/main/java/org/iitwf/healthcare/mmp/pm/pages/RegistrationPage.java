package org.iitwf.healthcare.mmp.pm.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class RegistrationPage {

	protected WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;

	}

	public static String password;
	public static String userName;
	public static String ssn;
	//public static String 

	private By firstNameBy = By.xpath("//input[@id='firstname']");
	private By lastNameBy = By.xpath("//input[@id='lastname']");
	private By dateOfBirthBy = By.xpath("//input[@id='datepicker']");
	private By licenceBy = By.xpath("//input[@id='license']");
	private By ssnBy = By.xpath("//input[@id='ssn']");
	private By stateBy = By.xpath("//input[@id='state']");
	private By cityBy = By.xpath("//input[@id='city']");
	private By addressBy = By.xpath("//input[@id='address']");
	private By zipcodeBy = By.xpath("//input[@id='zipcode']");
	private By ageBy = By.xpath("//input[@id='age']");
	private By heightBy = By.xpath("//input[@id='height']");
	private By weightBy = By.xpath("//input[@id='weight']");
	private By pharmacyBy = By.xpath("//input[@id='pharmacy']");
	private By PharmacyAddressBy = By.xpath("//input[@id='pharma_adress']");
	private By emailBy = By.xpath("//input[@id='email']");
	private By passwordBy = By.xpath("//input[@id='password']");
	private By usernameBy = By.xpath("//input[@id='username']");
	private By ConfirmPasswordBy = By.xpath("//input[@id='confirmpassword']");
	private By answerBy = By.xpath("//input[@id='answer']");
	private By selectSecQueBy = By.xpath("//select[@id='security']");
	private By saveBtnBy = By.xpath("//input[@name='register']");

	public void enterFristName(String text) {
		driver.findElement(firstNameBy).clear();
		driver.findElement(firstNameBy).sendKeys(text);
	}

	public void enterLastName(String text) {
		driver.findElement(lastNameBy).clear();
		driver.findElement(lastNameBy).sendKeys(text);
	}

	public void enterDateOfBirth(String text) {
		driver.findElement(dateOfBirthBy).clear();
		driver.findElement(dateOfBirthBy).sendKeys(text);
	}

	public void enterLicence(int value) {
		driver.findElement(licenceBy).click();
		// driver.findElement(licenceBy).clear();
		driver.findElement(licenceBy).click();
		driver.findElement(licenceBy).sendKeys(String.valueOf(value));

	}

	public void enterSSN(int value) {
		driver.findElement(ssnBy).clear();
		ssn=String.valueOf(value);
		driver.findElement(ssnBy).sendKeys(ssn);
	}

	public void enterState(String text) {
		driver.findElement(stateBy).clear();
		driver.findElement(stateBy).sendKeys(text);
	}

	public void enterCity(String text) {
		driver.findElement(cityBy).clear();
		driver.findElement(cityBy).sendKeys(text);
	}

	public void enterAddress(String text) {
		driver.findElement(addressBy).clear();
		driver.findElement(addressBy).sendKeys(text);
	}

	public void enterZipcode(int value) {
		driver.findElement(zipcodeBy).clear();
		driver.findElement(zipcodeBy).sendKeys(String.valueOf(value));
	}

	public void enterAge(int value) {
		driver.findElement(ageBy).clear();
		driver.findElement(ageBy).sendKeys(String.valueOf(value));
	}

	public void enterHeight(int value) {
		driver.findElement(heightBy).clear();
		driver.findElement(heightBy).sendKeys(String.valueOf(value));
	}

	public void enterWeight(int value) {
		driver.findElement(weightBy).clear();
		driver.findElement(weightBy).sendKeys(String.valueOf(value));
	}

	public void enterPharmacy(String text) {
		driver.findElement(pharmacyBy).clear();
		driver.findElement(pharmacyBy).sendKeys(text);
	}

	public void enterPharmacyAddress(String text) {
		driver.findElement(PharmacyAddressBy).clear();
		driver.findElement(PharmacyAddressBy).sendKeys(text);
	}

	public void enterEmail(String text) {
		driver.findElement(emailBy).clear();
		driver.findElement(emailBy).sendKeys(text);
	}

	public void enterUserName(String text) {
		driver.findElement(usernameBy).clear();
		userName=text;
		driver.findElement(usernameBy).sendKeys(userName);
	}

	public void enterPassword(String text) {

		driver.findElement(passwordBy).clear();
		password = text + "123";
		driver.findElement(passwordBy).sendKeys(password);
		System.out.println(password + "*****************");
	}

	public void enterConfirmPassword() {
		driver.findElement(ConfirmPasswordBy).clear();
		driver.findElement(ConfirmPasswordBy).sendKeys(password);
		System.out.println(password + "***********con******");
	}

	public void SelectSecQues(int index) {
		Select select = new Select(driver.findElement(selectSecQueBy));
		select.selectByIndex(index);
	}

	public void enterAnswer(String text) {
		driver.findElement(answerBy).clear();
		driver.findElement(answerBy).sendKeys(text);
	}

	public void clickSaveBtn() {
		driver.findElement(saveBtnBy).click();

	}

	public String getSuccsessRegisterMsg() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			String successMsg = alert.getText();
			alert.accept();
			return successMsg;
			
		} catch (NoAlertPresentException e) {
			System.out.println("No alert present: " + e.getMessage());
			return null;
		} catch (Exception e) {
			System.out.println("Error occurred: " + e.getMessage());
			return null;
		}
	}

	

	public void registerNewPatient(String fn, String ln, String dob, int licence, int ssn, String state, String city,
			String address, int zip, int age, int height, int weight, String pharmacy, String pharmacyAddress,
			String email, String userName, String pass, int index, String secQueAns) {

		enterFristName(fn);
		enterLastName(ln);
		enterDateOfBirth(dob);
		enterSSN(ssn);
		enterLicence(licence);
		enterState(state);
		enterCity(city);
		enterAddress(address);
		enterZipcode(zip);
		enterAge(age);
		enterHeight(height);
		enterWeight(weight);
		enterPharmacy(pharmacy);
		enterPharmacyAddress(pharmacyAddress);
		enterEmail(email);
		enterUserName(userName);
		enterPassword(pass);
		enterConfirmPassword();
		SelectSecQues(index);
		enterAnswer(secQueAns);
		clickSaveBtn();
		//getSuccsessRegisterMsg();
		System.out.println(getSuccsessRegisterMsg());

	}

}
