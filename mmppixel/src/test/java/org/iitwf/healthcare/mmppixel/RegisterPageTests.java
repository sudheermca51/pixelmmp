package org.iitwf.healthcare.mmppixel;

import java.io.IOException;

import org.iitwf.healthcare.mmp.pm.pages.AdminProfilePage;
import org.iitwf.healthcare.mmp.pm.pages.HomePage;
import org.iitwf.healthcare.mmp.pm.pages.NewAdminHomePage;
import org.iitwf.healthcare.mmp.pm.pages.NewAdminLoginPage;
import org.iitwf.healthcare.mmp.pm.pages.NewHomePage;
import org.iitwf.healthcare.mmp.pm.pages.NewLoginPage;
import org.iitwf.healthcare.mmp.pm.pages.RegisterPage;
import org.iitwf.healthcare.mmp.pm.pages.UsersPage;
import org.iitwf.lib.FrameworkLibrary;
import org.iitwf.lib.ScreenshotUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class RegisterPageTests extends FrameworkLibrary {

	@Test

	public void MMP_PAT_APPROVAL_001_Patient_Appoval() throws InterruptedException, IOException {

		ExtentTest extentTest = extent.createTest("##########Patient Approval Tests######################");

		launchBrowser(prop.getProperty("patient_url"));
		extentTest.info("Loading the website successfully");

		NewLoginPage lPage = new NewLoginPage(driver);
		lPage.clickRegister();

		ScreenshotUtil screenshotUtil = new ScreenshotUtil(driver);
		
		RegisterPage regPage = new RegisterPage(driver);
		regPage.registrationDetails();

		
		launchBrowser(prop.getProperty("admin_url"));

		NewAdminLoginPage adminlogin = new NewAdminLoginPage(driver);
		adminlogin.login(prop.getProperty("admin_username"), prop.getProperty("admin_password"));

		NewAdminHomePage adminhome = new NewAdminHomePage(driver);
		adminhome.selectModule("Users");

		UsersPage users = new UsersPage(driver);
		users.clickUsers();

		AdminProfilePage adminprofile = new AdminProfilePage(driver);
		adminprofile.selectstatus();

		adminprofile.alertHandle("UpdateUser");

		launchBrowser(prop.getProperty("patient_url"));
		NewLoginPage patientLogin = new NewLoginPage(driver);
		patientLogin.login(regPage.userNameText, regPage.password);

		String exptedUserName = RegisterPage.expectedUserNameHMap.get("username");
		System.out.println(exptedUserName);

		NewHomePage homePage = new NewHomePage(driver);
		String actualUserName = homePage.getLoginSuccessfulMsg();
		screenshotUtil.captureScreenshot("PAT_APRVL_001_NewUserName");

		System.out.println(actualUserName);

		Assert.assertEquals(actualUserName, exptedUserName);

	}

}
