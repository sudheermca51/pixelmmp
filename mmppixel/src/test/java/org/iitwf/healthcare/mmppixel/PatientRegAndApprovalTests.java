package org.iitwf.healthcare.mmppixel;

import org.iitwf.healthcare.mmp.pm.pages.AdminHomePage;
import org.iitwf.healthcare.mmp.pm.pages.AdminLoginPage;
import org.iitwf.healthcare.mmp.pm.pages.AdminUsersPages;
import org.iitwf.healthcare.mmp.pm.pages.HomePage;
import org.iitwf.healthcare.mmp.pm.pages.LoginPage;
import org.iitwf.healthcare.mmp.pm.pages.RegistrationPage;
import org.iitwf.lib.FrameworkLibrary;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class PatientRegAndApprovalTests extends FrameworkLibrary {
	@Test
	public void PatientRegistration() {
		ExtentTest extentTest = extent.createTest("##########Test Case :: Register Patient##############");
		launchBrowser(prop.getProperty("patient_url"));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickOnrRegisterBtn().registerNewPatient(RandomUtils.generateRandomString(5), // first name
				RandomUtils.generateRandomString(5), // last name
				FutureDate.getPastDate(25, "dd/MM/yyyy", "Asia/Kolkata"), // date
				// RandomUtils.generateRandomNumber(50000000,60000000),//licence number
				12345678, RandomUtils.generateRandomInteger(500000000, 600000000), // ssn
				RandomUtils.generateRandomString(5), // state
				RandomUtils.generateRandomString(5), // city
				RandomUtils.generateRandomString(10), // address
				RandomUtils.generateRandomInteger(10000, 90000), // zip
				RandomUtils.generateRandomInteger(18, 99), // age
				RandomUtils.generateRandomInteger(110, 190), // height
				RandomUtils.generateRandomInteger(20, 100), // weight
				RandomUtils.generateRandomString(5), // pharmacy
				RandomUtils.generateRandomString(10), // pharmacy address
				RandomUtils.randomEmail(), // random email
				RandomUtils.generateRandomString(5), // username
				RandomUtils.generateRandomString(5), // password
				1, // confirm password and selecting first question
				RandomUtils.generateRandomString(5));// entering the security answer
		
		launchBrowser(prop.getProperty("admin_url"));
		AdminLoginPage adminloginPage = new AdminLoginPage(driver);
		adminloginPage.login(prop.getProperty("admin_username"),prop.getProperty("admin_password"));
		AdminHomePage adminHomepage= new AdminHomePage(driver);
		adminHomepage.selectModule("Users");
		AdminUsersPages adminUserPage=new AdminUsersPages(driver);
		adminUserPage.clickOnNextBtn();
		adminUserPage.clickOnUserName(RegistrationPage.ssn);
		adminUserPage.selectStatus("Accepted");
		adminUserPage.submitform();
		launchBrowser(prop.getProperty("patient_url"));
		loginPage.login(RegistrationPage.userName, RegistrationPage.password);
		HomePage homePage=new HomePage(driver);
		Assert.assertNotEquals(homePage.getLoginSuccessfulMsg(), RegistrationPage.userName);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
	/*
	 * //@Test public void ApprovePatientAsAdmin() {
	 * launchBrowser(prop.getProperty("admin_url")); AdminLoginPage adminloginPage =
	 * new AdminLoginPage(driver);
	 * adminloginPage.login(prop.getProperty("admin_username"),prop.getProperty(
	 * "admin_password")); AdminHomePage adminHomepage= new AdminHomePage(driver);
	 * adminHomepage.selectModule("Users"); AdminUsersPages adminUserPage=new
	 * AdminUsersPages(driver); adminUserPage.clickOnNextBtn();
	 * adminUserPage.clickOnUserName(RegistrationPage.ssn);
	 * adminUserPage.selectStatus("Accepted"); adminUserPage.submitform();
	 * 
	 * }
	 * 
	 * public void VerifyApprovedPatientLoginSuccessFully() {
	 * launchBrowser(prop.getProperty("patient_url")); LoginPage loginPage = new
	 * LoginPage(driver); loginPage.login(RegistrationPage.userName,
	 * RegistrationPage.password); }
	 */
}























