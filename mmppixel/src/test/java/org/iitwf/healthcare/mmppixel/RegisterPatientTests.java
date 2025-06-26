package org.iitwf.healthcare.mmppixel;

import java.io.IOException;

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
	ScreenshotUtil ssu;
	
	/**
	 * This test case is used to register a new patient in the system.
	 * It navigates to the patient registration page, fills in the required details,
	 * and submits the registration form.
	 * @throws IOException 
	 */

	@Test(groups = { "regression", "ui" })
	public void MMP_PAT_REG_001_Register_Patient() throws IOException {
		ExtentTest extentTest = extent.createTest("##########Register Patient Tests######################");
		ssu = new ScreenshotUtil();
		extentTest.info("Starting the patient registration test.");
		regPage = new RegisterPatientPage(driver);
		extentTest.info("Loading the website successfully");
		launchBrowser(prop.getProperty("reg_url"));
		extentTest.info("Navigated to the registration page.");
		regPage.registerPatient();
		extentTest.info("Filled in the registration form with patient details.");	
		extentTest.pass("Patient registered successfully.");
		closeBrowser();		
	}	
}
