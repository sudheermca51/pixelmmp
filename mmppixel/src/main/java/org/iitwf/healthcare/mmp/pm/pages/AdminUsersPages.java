package org.iitwf.healthcare.mmp.pm.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminUsersPages {

	protected WebDriver driver;
	
	public AdminUsersPages (WebDriver driver) {
		this.driver=driver;
	}
	
	
	private By nextBtnBy=By.xpath("//a[normalize-space(text())='Last »']");
	private By selectStatusBy=By.xpath("//select[@id='sapproval']");
	private By submitFormBy=By.xpath("//input[@value='Submit']");
	
	public void clickOnNextBtn() {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(nextBtnBy)).perform();
		driver.findElement(nextBtnBy).click();
	}
	
	public void clickOnUserName(String ssn) {
		driver.findElement(By.xpath("//td[normalize-space(text())='"+ssn+"']/preceding-sibling::td/a")).click();
	}
	
	public void selectStatus(String text) {
		Select select = new Select(driver.findElement(selectStatusBy));
		select.selectByVisibleText(text);
	}
	
	public void submitform() {
		driver.findElement(submitFormBy).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
	}

}
