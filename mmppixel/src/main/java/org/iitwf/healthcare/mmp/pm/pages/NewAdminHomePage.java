package org.iitwf.healthcare.mmp.pm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAdminHomePage {
	
	private By validMsgBy = By.tagName("h3");

	protected WebDriver driver;

	public NewAdminHomePage(WebDriver driver) {
		this.driver = driver;

	}

	public String getLoginSuccessfulMsg() {
		return driver.findElement(validMsgBy).getText().trim();
	}

	public void selectModule(String moduleName) {
		// 2. Click on Messages module.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='"+moduleName+"']")));

		driver.findElement(By.xpath("//span[normalize-space()='" + moduleName + "']")).click();

	}
	

}
