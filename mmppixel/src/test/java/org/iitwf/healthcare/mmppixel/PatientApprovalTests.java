package org.iitwf.healthcare.mmppixel;

import java.io.IOException;
import java.time.Duration;

import org.iitwf.healthcare.mmp.pm.pages.AdminHomePage;
import org.iitwf.healthcare.mmp.pm.pages.AdminLoginPage;
import org.iitwf.healthcare.mmp.pm.pages.AdminProfilePage;
import org.iitwf.healthcare.mmp.pm.pages.HomePage;
import org.iitwf.healthcare.mmp.pm.pages.LoginPage;
import org.iitwf.healthcare.mmp.pm.pages.NewAdminHomePage;
import org.iitwf.healthcare.mmp.pm.pages.NewAdminLoginPage;
import org.iitwf.healthcare.mmp.pm.pages.NewHomePage;
import org.iitwf.healthcare.mmp.pm.pages.NewLoginPage;
import org.iitwf.healthcare.mmp.pm.pages.RegisterPage;
import org.iitwf.healthcare.mmp.pm.pages.UsersPage;
import org.iitwf.lib.FrameworkLibrary;
import org.iitwf.lib.ScreenshotUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class PatientApprovalTests extends FrameworkLibrary {

	@Test

	public void MMP_PAT_APPROVAL_001_Patient_Appoval() throws InterruptedException, IOException {

		ExtentTest extentTest = extent.createTest("##########Patient Approval Tests######################");

		launchBrowser(prop.getProperty("patient_url"));
		extentTest.info("Loading the website successfully");

		LoginPage lPage = new LoginPage(driver);
		lPage.clickRegister();

		ScreenshotUtil screenshotUtil = new ScreenshotUtil(driver);
		
		RegisterPage regPage = new RegisterPage(driver);
		regPage.registrationDetails();

		
		launchBrowser(prop.getProperty("admin_url"));

		AdminLoginPage adminlogin = new AdminLoginPage(driver);
		adminlogin.login(prop.getProperty("admin_username"), prop.getProperty("admin_password"));

		AdminHomePage adminhome = new AdminHomePage(driver);
		
		adminhome.selectModule("Users");

		UsersPage users = new UsersPage(driver);
		users.clickUsers();

		AdminProfilePage adminprofile = new AdminProfilePage(driver);
		adminprofile.selectstatus();

		adminprofile.alertHandle("UpdateUser");

		launchBrowser(prop.getProperty("patient_url"));
		LoginPage patientLogin = new LoginPage(driver);
		patientLogin.login(regPage.userNameText, regPage.password);

		String exptedUserName = RegisterPage.expectedUserNameHMap.get("username");
		System.out.println(exptedUserName);

		HomePage homePage = new HomePage(driver);
		String actualUserName = homePage.getLoginSuccessfulMsg();
		screenshotUtil.captureScreenshot("PAT_APRVL_001_NewUserName");

		System.out.println(actualUserName);

		Assert.assertEquals(actualUserName, exptedUserName);

	}

}
