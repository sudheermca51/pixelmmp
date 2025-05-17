package org.iitwf.healthcare.mmppixel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//ctrl+shift+o organize imports
//project configuration ->right click on pom.xml -> Maven - > update
public class LoginTests {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		//Launch login page
		driver.get("https://o2.openmrs.org/openmrs/login.htm");

		//Enter credentials
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("Admin123");

		//select location and login
		driver.findElement(By.id("Inpatient Ward")).click();
		
		driver.findElement(By.xpath("//input[@Value='Log In']")).click();

		//verify login message
		String logInMsg = driver.findElement(By.xpath("//h4")).getText();

		System.out.println("Log In MSg"+ logInMsg);
		
	}

}
