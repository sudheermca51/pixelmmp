package org.iitwf.lib;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	
	
	WebDriver driver;
	public ScreenshotUtil(WebDriver driver) {
		 
		this.driver = driver;
	}
	public void captureScreenshot(String fileName) throws IOException
	{
		
		Date date= Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yy_HH-mm-ss");
		String timeStamp = sdf.format(date);
		
		
		//Take the screenshot
		TakesScreenshot tsh = (TakesScreenshot) driver;
		
		//capture the screenshot and store in a file 
		File srcFile = tsh.getScreenshotAs(OutputType.FILE);
		
		String destFilePath = System.getProperty("user.dir")+"/screenshots/"+fileName+"_"+timeStamp+".png";
		
		
		File destFile = new File(destFilePath);
		
		//copy the screenshot into a specified location
		FileUtils.copyFile(srcFile, destFile);
		
		
	}

}
