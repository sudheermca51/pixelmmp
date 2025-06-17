package org.iitwf.healthcare.mmp.pm.pages;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminMessagePage {

	protected WebDriver driver;

	public AdminMessagePage(WebDriver driver) {
		this.driver = driver;
	}

	public HashMap<String, String> fetchmessage() {

		String actualPatientName = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[1]/b"))
				.getText();
		String actualReason = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[2]/b")).getText();
		String actualMessage = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[3]/td[2]")).getText();
	//	String actualDate = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[3]")).getText();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table']/tbody/tr[2]/td[3]"))); // or match your date format
		
		String actualDate = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[3]")).getText();


		HashMap<String, String> actualHmap = new HashMap<String, String>();
		actualHmap.put("patientName", actualPatientName);
		actualHmap.put("reason", actualReason);
		actualHmap.put("message", actualMessage);
		actualHmap.put("date", actualDate);

		return actualHmap;
	}
}
