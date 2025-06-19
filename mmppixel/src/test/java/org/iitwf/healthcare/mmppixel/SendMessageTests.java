package org.iitwf.healthcare.mmppixel;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.iitwf.healthcare.mmp.pm.pages.AdminHomePage;
import org.iitwf.healthcare.mmp.pm.pages.AdminLoginPage;
import org.iitwf.healthcare.mmp.pm.pages.HomePage;
import org.iitwf.healthcare.mmp.pm.pages.LoginPage;
import org.iitwf.healthcare.mmp.pm.pages.MessagesPage;
import org.iitwf.healthcare.mmp.pm.pages.ScheduleAppointmentPage;
import org.iitwf.lib.FrameworkLibrary;
import org.iitwf.lib.ScreenshotUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class SendMessageTests extends FrameworkLibrary {
	@Test
	public void MMP_PAT_SNDM_001_Send_Messages() throws IOException {
		ExtentTest extentTest = extent.createTest("##########Send Messages Tests######################");

		launchBrowser(prop.getProperty("patient_url"));
		extentTest.info("Loading the website successfully");
		LoginPage lPage = new LoginPage(driver);
		ScreenshotUtil screenshotUtil = new ScreenshotUtil(driver);
		HomePage hPage = lPage.login(prop.getProperty("patient_username"), prop.getProperty("patient_password"));
		String screenshotPath = screenshotUtil.captureScreenshot("HomePage");
		extentTest.addScreenCaptureFromPath(screenshotPath, "HomePage of MMP WebSite");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Selenium 4+ style
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Profile']"))); // Replace with actual locator
		hPage.selectModule("Profile");
		String expectedPatientName = hPage.getPatientName();

		System.out.println("expectedPatientName is: " + expectedPatientName);
		
		hPage.selectModule("Messages");

		MessagesPage mPage = new MessagesPage(driver);
		HashMap<String, String> expectedHMap = mPage.sendMessage(expectedPatientName, "Early medicine refill", "Need to discuss with doctor");
		System.out.println("Expected HMap :::" + expectedHMap);
		screenshotUtil.captureScreenshot("SNDM_001_Send_Messages");

		launchBrowser(prop.getProperty("admin_url"));
		extentTest.info("Loading the website successfully");
		AdminLoginPage adLoginPage = new AdminLoginPage(driver);
		AdminHomePage adHomePage = adLoginPage.login(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		screenshotPath = screenshotUtil.captureScreenshot("HomePage");
		extentTest.addScreenCaptureFromPath(screenshotPath, "HomePage of MMP Admin WebSite");
		
		
		adHomePage.selectModule("Messages");
		
		
		// Refresh, adjust viewport, and zoom
        driver.navigate().refresh();
        driver.manage().window().setSize(new Dimension(1200, 800));
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//table[@class='table']//td[contains(text(), 'Need to discuss with doctor')]")
        ));
        
        HashMap<String, String> actualHMap = adHomePage.fetchMessage();
		System.out.println("Actual HMap :::" + actualHMap);
		screenshotUtil.captureScreenshot("SNDM_001_Send_Messages_Data");

		Assert.assertEquals(actualHMap, expectedHMap);

	}

}
