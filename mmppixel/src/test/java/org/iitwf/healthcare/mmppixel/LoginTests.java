package org.iitwf.healthcare.mmppixel;

import org.iitwf.healthcare.mmp.pm.pages.HomePage;
import org.iitwf.healthcare.mmp.pm.pages.LoginPage;
import org.iitwf.lib.FrameworkLibrary;
import org.testng.Assert;
import org.testng.annotations.Test;

//ctrl+shift+o organize imports
//project configuration ->right click on pom.xml -> Maven - > update
public class LoginTests extends FrameworkLibrary{
	
	@Test
	public  void loginAsValidUser() {
		
		launchBrowser(prop.getProperty("patient_url"));
		LoginPage lPage = new LoginPage(driver);
		HomePage hPage = lPage.login(prop.getProperty("patient_username"),prop.getProperty("patient_password"));
		String actual = hPage.getLoginSuccessfulMsg();
		String expected = prop.getProperty("patient_username");
		Assert.assertEquals(actual, expected);
		
//		lPage.login(prop.getProperty("patient_username"),prop.getProperty("patient_password"));
//		HomePage hPage = new HomePage(driver);
//		String actual = hPage.getLoginSuccessfulMsg();
//		String expected = prop.getProperty("patient_username");
//		Assert.assertEquals(actual, expected);
		
		String title = driver.getTitle();
		System.out.println(title.length());
	}

}
