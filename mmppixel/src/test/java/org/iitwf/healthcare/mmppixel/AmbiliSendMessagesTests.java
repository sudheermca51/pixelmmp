package org.iitwf.healthcare.mmppixel;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import org.iitwf.lib.FrameworkLibrary;
import org.iitwf.lib.ScreenshotUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.iitwf.healthcare.mmp.pm.pages.AdminHomePage;
import org.iitwf.healthcare.mmp.pm.pages.AdminLoginPage;
import org.iitwf.healthcare.mmp.pm.pages.AdminMessagePage;
import org.iitwf.healthcare.mmp.pm.pages.HomePage;
import org.iitwf.healthcare.mmp.pm.pages.LoginPage;
import org.iitwf.healthcare.mmp.pm.pages.MessagesPage;

public class AmbiliSendMessagesTests extends FrameworkLibrary{
	
	@Test

	public void MMP_PAT_SND_MSG_001_Send_Messages() throws InterruptedException, IOException
	{
		ExtentTest extentTest = extent.createTest("##########Send Messages Tests######################");
		extentTest.info("Loading the website successfully");
		launchBrowser(prop.getProperty("patient_url"));
		LoginPage lPage = new LoginPage(driver);
		ScreenshotUtil screenshotUtil = new ScreenshotUtil(driver);
		HomePage hPage =lPage.login(prop.getProperty("patient_username"), prop.getProperty("patient_password"));
		String screenshotPath = screenshotUtil.captureScreenshot("HomePage");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Selenium 4+ style
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Profile']"))); // Replace with actual locator

		hPage.selectModule("Profile");
		String expectedPatientName = hPage.getPatientName();
		hPage.selectModule("Messages");
		
		MessagesPage mPage = new MessagesPage(driver);
		HashMap<String, String> expectedHMap = mPage.sendMessage(expectedPatientName, "Monthly visit", "Emergency");
		System.out.println("Expected HMap :::" + expectedHMap);
		
		launchBrowser(prop.getProperty("admin_url"));
		extentTest.info("Loading the website successfully");
		AdminLoginPage adLoginPage = new AdminLoginPage(driver);
		AdminHomePage adHomePage = adLoginPage.login(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		screenshotPath = screenshotUtil.captureScreenshot("HomePage");
		extentTest.addScreenCaptureFromPath(screenshotPath, "HomePage of MMP Admin WebSite");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Messages']")));
		adHomePage.selectModule("Messages");
		
		// Refresh, adjust viewport, and zoom
        driver.navigate().refresh();
        driver.manage().window().setSize(new Dimension(1200, 800));
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//table[@class='table']//td[contains(text(), 'Emergency')]")
        ));

		
		AdminMessagePage adMessagePage = new AdminMessagePage(driver);
		HashMap<String,String>actualHMap =adMessagePage.fetchmessage();
		screenshotUtil.captureScreenshot("SNDM_001_Send_Messages_Data");
		System.out.print("Actual HMap--->" +actualHMap);
		
		Assert.assertEquals(actualHMap, expectedHMap);
		
		
	}

}
