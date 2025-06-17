package org.iitwf.healthcare.mmp.pm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsersPage {
	
	protected static WebDriver driver;
	public static int randomSSN;
	

	public UsersPage(WebDriver driver) {
		this.driver = driver;
	}
		
		public static void clickUsers() throws InterruptedException
		{	
			
			driver.findElement(By.xpath("//span[normalize-space()='Users']")).click();
		
			WebElement SSN=driver.findElement(By.xpath("//td[normalize-space()='"+RegisterPage.randomSSN+"']"));
			if(SSN.isDisplayed())
			{
				
				driver.findElement(By.xpath("//a[normalize-space()='"+RegisterPage.fname+"']")).click();
			}
			

		
	}


}
