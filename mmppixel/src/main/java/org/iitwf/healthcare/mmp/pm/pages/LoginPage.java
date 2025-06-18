package org.iitwf.healthcare.mmp.pm.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private By usernameBy = By.id("username");
	private By passwordBy = By.id("password");
	private By signinBy = By.name("submit");
	private By registerBtnBy=By.xpath("//input[@value='Register']") ;
	
	protected WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;

	}
	public HomePage login(String uname,String pword)
	{
		//1. Login to mmp application
		driver.findElement(usernameBy).sendKeys(uname);
		driver.findElement(passwordBy).sendKeys(pword);
		driver.findElement(signinBy).click();
		return new HomePage(driver);
	}
	
	public RegistrationPage clickOnrRegisterBtn() {
		driver.findElement(registerBtnBy).click();
		return new RegistrationPage(driver);
		
}
	
	 
}
