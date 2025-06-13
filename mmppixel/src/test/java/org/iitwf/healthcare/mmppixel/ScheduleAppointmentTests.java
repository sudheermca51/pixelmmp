package org.iitwf.healthcare.mmppixel;

import java.io.IOException;
import java.util.HashMap;

import org.iitwf.healthcare.mmp.pm.pages.HomePage;
import org.iitwf.healthcare.mmp.pm.pages.LoginPage;
import org.iitwf.healthcare.mmp.pm.pages.ScheduleAppointmentPage;
import org.iitwf.lib.FrameworkLibrary;
import org.iitwf.lib.ScreenshotUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class ScheduleAppointmentTests extends FrameworkLibrary{
		
	@Test(groups={"regression", "scheduleappointment" ,"ui"})
	public void MMP_PAT_SCH_001_Schedule_Appointment() throws IOException
	{
		ExtentTest extentTest = extent.createTest("##########Schedule Appointment Tests######################");
		
		
		launchBrowser(prop.getProperty("patient_url"));
		extentTest.info("Loading the website successfully");
		LoginPage lPage = new LoginPage(driver);
		ScreenshotUtil screenshotUtil = new ScreenshotUtil(driver);
		HomePage hPage = lPage.login(prop.getProperty("patient_username"),prop.getProperty("patient_password"));
		String screenshotPath = screenshotUtil.captureScreenshot("HomePage");
		extentTest.addScreenCaptureFromPath(screenshotPath, "HomePage of MMP WebSite");
		
		hPage.selectModule("Schedule Appointment");

		ScheduleAppointmentPage sPage = new ScheduleAppointmentPage(driver);
		
		HashMap<String,String> expectedHMap =sPage.bookAppointment(365,"d/MMMM/YYYY","Cardiologist","11Am");
		System.out.println("Expected HMap :::" + expectedHMap);
		screenshotUtil.captureScreenshot("SCH_001_Book_Appointment");
		
		HashMap<String,String> actualHMap  = hPage.fetchPatientPortalData();
		System.out.println("Actual HMap :::" + actualHMap);
		screenshotUtil.captureScreenshot("SCH_001_Fetch_Book_Appointment_Data");
		
		Assert.assertEquals(actualHMap, expectedHMap);
	}
//	@Test(enabled=false)
//	public void MMP_PAT_SCH_002_ScheduleAppointment()
//	{
//		 
//		sa.launchBrowser("http://85.209.95.122/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
//		
//		sa.login("ria1","Ria12345");
//
//		sa.selectModule("Schedule Appointment");
//
//		HashMap<String,String> expectedHMap =sa.bookAppointment(30,"d/MMMM/YYYY","Cardiologist","11Am");
//		System.out.println("Expected HMap :::" + expectedHMap);
//
//		HashMap<String,String> actualHMap  = sa.fetchPatientPortalData();
//		System.out.println("Actual HMap :::" + actualHMap);
//		
//		Assert.assertEquals(actualHMap, expectedHMap);
//	}
}

