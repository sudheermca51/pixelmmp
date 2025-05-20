package org.iitwf.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;

public class FrameworkLibrary {

	protected Properties prop;
	protected WebDriver driver;
	private static String browserType,environment;
	@BeforeClass
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
		return prop;

	}


}
