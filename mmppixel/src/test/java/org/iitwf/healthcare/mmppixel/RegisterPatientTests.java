package org.iitwf.healthcare.mmppixel;

import org.iitwf.healthcare.mmp.pm.pages.HomePage;
import org.iitwf.healthcare.mmp.pm.pages.LoginPage;
import org.iitwf.healthcare.mmp.pm.pages.RegisterPatientPage;
import org.iitwf.lib.FrameworkLibrary;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class RegisterPatientTests extends FrameworkLibrary {
	LoginPage loginPage;
	RegisterPatientPage regPage;
	HomePage homePage;
	ExtentTest extentTest;
	//ScreenshotUtil screenshotUtil;
	
	/**
	 * This test case is used to register a new patient in the system.
	 * It navigates to the patient registration page, fills in the required details,
	 * and submits the registration form.
	 */

	@Test(groups = { "regression", "ui" })
	public void MMP_PAT_REG_001_Register_Patient() {
		ExtentTest extentTest = extent.createTest("##########Register Patient Tests######################");

		regPage = new RegisterPatientPage(driver);
		extentTest.info("Loading the website successfully");
		launchBrowser(prop.getProperty("reg_url"));
		extentTest.info("Navigated to the registration page.");
		//loginPage = new LoginPage(driver);
		//loginPage.loginNoHomePage(prop.getProperty("admin_username"), prop.getProperty("admin_password"), prop.getProperty("reg_url"));
		regPage.registerPatient();
		extentTest.info("Filled in the registration form with patient details.");		
		extentTest.pass("Patient registered successfully.");
		closeBrowser();
		
	}	
	

}
