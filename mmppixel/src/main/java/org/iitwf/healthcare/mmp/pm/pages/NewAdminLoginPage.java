package org.iitwf.healthcare.mmp.pm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewAdminLoginPage {


	private By usernameBy = By.id("username");
	private By passwordBy = By.id("password");
	private By signinBy = By.name("admin");
	 
	
	protected WebDriver driver;
	public NewAdminLoginPage(WebDriver driver)
	{
		this.driver = driver;

	}
	public AdminHomePage login(String uname,String pword)
	{
		//1. Login to mmp application
		driver.findElement(usernameBy).sendKeys(uname);
		driver.findElement(passwordBy).sendKeys(pword);
		driver.findElement(signinBy).click();
		return new AdminHomePage(driver);
	}

}



