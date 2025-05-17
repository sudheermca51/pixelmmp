package org.iitwf.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class FrameworkLibrary {
	 
	protected Properties prop;
	protected WebDriver driver;
	@BeforeClass
	public void setUp() throws IOException
	{
		 
	   instantiateDriver();
	   prop= readProperties("mmp.properties");
	}
	public void instantiateDriver()
	{
		driver = new ChromeDriver();
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
