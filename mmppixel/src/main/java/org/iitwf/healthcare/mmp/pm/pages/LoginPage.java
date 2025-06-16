package org.iitwf.healthcare.mmp.pm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private By usernameBy = By.id("username");
	private By passwordBy = By.id("password");
	private By signinBy = By.name("submit");
	 
	
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
	
	public void loginNoHomePage(String uname, String pword, String url) {
		driver.get(url);
		driver.findElement(usernameBy).sendKeys(uname);
		driver.findElement(passwordBy).sendKeys(pword);
		driver.findElement(signinBy).click();
	}
	 
}
