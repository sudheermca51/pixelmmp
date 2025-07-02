package org.iitwf.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.iitwf.healthcare.mmppixel.FutureDate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class FrameworkLibrary {

	protected Properties prop;
	protected WebDriver driver;
	protected ExtentReports extent;
	private static String browserType,environment;
	
	@BeforeSuite(groups= {"functest"})
	public void loadReports()
	{

		// directory where output is to be printed
		String timeStamp = FutureDate.generateFutureDate(0,"dd_MM_yy_HH-mm-ss");
		 
		String reporterFilePath = System.getProperty("user.dir")+"//reports//MMPReport"+timeStamp+".html";
		File reporterFile = new File(reporterFilePath);
		
		ExtentSparkReporter spark = new ExtentSparkReporter(reporterFile);
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}

	@BeforeClass(groups= {"functest"})
	public void setUp() throws IOException
	{
		prop= readProperties("mmp_global.properties");
		browserType = prop.getProperty("browserType");
		environment = prop.getProperty("environment");
		instantiateDriver(browserType);

		switch (environment)
		{
		case "dev":
			prop= readProperties("mmp_dev.properties");
			System.out.println("In Dev Case:::"+ prop.getProperty("patient_url"));
			break;
		case "qa":
			prop= readProperties("mmp_qa.properties");
			break;	
		}
	}
	public void instantiateDriver(String browserType)
	{

		switch (browserType)
		{
		case "edge":
			driver = new EdgeDriver();
			break;
		case "chrome":
			driver = new ChromeDriver();
			break;	
		}
		driver.manage().window().maximize();
	}
	public void launchBrowser(String url)
	{
		driver.get(url);
	}
	public Properties readProperties(String fileName) throws IOException 
	{                  //   C:\Users\sudhe\eclipse-workspace\IITWF2025\mmppixel
		//  C:\Users\sudhe\eclipse-workspace\IITWF2025\mmppixel
		//	  C:\Users\sudhe\eclipse-workspace\IITWF2025\mmppixel\config\mmp.properties
		String filePath = System.getProperty("user.dir")+"//config//"+fileName;
		File f = new File(filePath);
		FileInputStream fis = new FileInputStream(f);
		Properties prop = new Properties();
		prop.load(fis);
		System.out.println("Properties details" + prop);
		return prop;

	}
	@AfterSuite(groups= {"functest"})
	public void closeResources()
	{
		extent.flush();
	}

}
