package org.iitwf.healthcare.mmppixel;

import java.io.File;
import java.io.IOException;

import org.iitwf.lib.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportEx {
	
	@Test
	public void loadExtentReport() throws IOException
	{
		// directory where output is to be printed
		String reporterFilePath = System.getProperty("user.dir")+"//reports//MMPReport.html";
		File reporterFile = new File(reporterFilePath);
		
		ExtentSparkReporter spark = new ExtentSparkReporter(reporterFile);
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);
		
		
		
		
		
		
		ExtentTest extentTest = extent.createTest("##########Schedule Appointment Tests######################");
		WebDriver driver = new ChromeDriver();
		driver.get("http://85.209.95.122/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		
		extentTest.info("Loading the website successfully");
		
		ScreenshotUtil screenshotUtil = new ScreenshotUtil(driver);
		String screenshotPath = screenshotUtil.captureScreenshot("HomePage");
		extentTest.addScreenCaptureFromPath(screenshotPath, "HomePage of MMP WebSite");
		
		Assert.assertEquals("Login", driver.getTitle());
		extent.flush();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
