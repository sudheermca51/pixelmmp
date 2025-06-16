package org.iitwf.healthcare.mmppixel;

import java.io.IOException;
import java.util.HashMap;

import org.iitwf.healthcare.mmp.pm.pages.AdminHomePage;
import org.iitwf.healthcare.mmp.pm.pages.AdminLoginPage;
import org.iitwf.healthcare.mmp.pm.pages.HomePage;
import org.iitwf.healthcare.mmp.pm.pages.LoginPage;
import org.iitwf.healthcare.mmp.pm.pages.MessagesPage;
import org.iitwf.lib.FrameworkLibrary;
import org.iitwf.lib.ScreenshotUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class SendMessageTests extends FrameworkLibrary {
	@Test(groups={ "regression", "ui" })
	public void MMP_PAT_SNDM_001_Send_Messages() throws IOException {
		ExtentTest extentTest = extent.createTest("##########Send Messages Tests######################");

		launchBrowser(prop.getProperty("patient_url"));
		extentTest.info("Loading the website successfully");
		LoginPage lPage = new LoginPage(driver);
		ScreenshotUtil screenshotUtil = new ScreenshotUtil(driver);
		HomePage hPage = lPage.login(prop.getProperty("patient_username"), prop.getProperty("patient_password"));
		String screenshotPath = screenshotUtil.captureScreenshot("HomePage");
		extentTest.addScreenCaptureFromPath(screenshotPath, "HomePage of MMP WebSite");
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
		HashMap<String, String> actualHMap = adHomePage.fetchMessage();
		System.out.println("Actual HMap :::" + actualHMap);
		screenshotUtil.captureScreenshot("SNDM_001_Send_Messages_Data");

		Assert.assertEquals(actualHMap, expectedHMap);

	}

}
