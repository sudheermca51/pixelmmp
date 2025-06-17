package org.iitwf.healthcare.mmp.pm.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminHomePage {
	private By validMsgBy = By.tagName("h3");

	protected WebDriver driver;

	public AdminHomePage(WebDriver driver) {
		this.driver = driver;

	}

	public String getLoginSuccessfulMsg() {
		return driver.findElement(validMsgBy).getText().trim();
	}

	public void selectModule(String moduleName) {
		// 2. Click on Messages module.
		driver.findElement(By.xpath("//span[normalize-space()='" + moduleName + "']")).click();

	}
	

	public HashMap<String, String> fetchMessage() {

		System.out.println("#########################Actual Values######################################");
		System.out.println("actualPatientName--actualReason---actualMessage---actualDate");
		String actualPatientName = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[1]")).getText();
		String actualReason = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[2]")).getText();
		String actualMessage = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[3]/td[2]")).getText();
		String actualDate = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[3]")).getText();
		System.out.println(actualPatientName + "--" + actualReason + "---" + actualMessage + "---" + actualDate);
		System.out.println("#########################Actual Values######################################");

		HashMap<String, String> actualHMap = new HashMap<String, String>();
		actualHMap.put("patientName", actualPatientName);
		actualHMap.put("reason", actualReason);
		actualHMap.put("message", actualMessage);
		actualHMap.put("date", actualDate);

		return actualHMap;
	}
}
