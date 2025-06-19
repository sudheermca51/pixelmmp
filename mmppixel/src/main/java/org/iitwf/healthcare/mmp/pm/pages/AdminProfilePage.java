package org.iitwf.healthcare.mmp.pm.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminProfilePage {
	protected static WebDriver driver;
	
	public AdminProfilePage(WebDriver driver) {
		this.driver = driver;

	}
	
	public void selectstatus()
	{
	Select statusDropdown = new Select(driver.findElement(By.id("sapproval")));
	statusDropdown.selectByVisibleText("Accepted");
	driver.findElement(By.xpath("//input[@value='Submit']")).click();
	}

	public static void alertHandle(String message)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		try {
			alert = driver.switchTo().alert();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Alert message :: " + alert.getText());
		alert.accept();
	}



}
