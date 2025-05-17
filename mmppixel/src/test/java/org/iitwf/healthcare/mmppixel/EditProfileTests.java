package org.iitwf.healthcare.mmppixel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EditProfileTests {
	
	MMPCustomLibrary mmpLib;
	Properties prop;
	@BeforeClass
	public void setUp() throws IOException
	{
	    mmpLib = new MMPCustomLibrary();
		mmpLib.instantiateDriver();
		prop= mmpLib.readProperties();
	}

	@Parameters({"successfulMsg"})
	@Test
	public void MMP_PAT_EP_001_validateEditFunc(String successfulMsg)
	{
	 
		mmpLib.launchBrowser(prop.getProperty("patient_url"));
		
		mmpLib.login(prop.getProperty("patient_username"),prop.getProperty("patient_password"));

		mmpLib.selectModule("Profile");
		
		boolean result =mmpLib.editFields(successfulMsg);
		 
		Assert.assertTrue(result);
	}
//	@Test
//	public void MMP_PAT_EP_002_validateAllEditFieldsFunc(String successfulMsg)
//	{
//	 
//		mmpLib.launchBrowser(prop.getProperty("patient_url"));
//		
//		mmpLib.login(prop.getProperty("patient_username"),prop.getProperty("patient_password"));
//
//		mmpLib.selectModule("Profile");
//		
//		//FName,LName,SSN,Age,City
//		boolean result =mmpLib.editAllFields(successfulMsg);
//		 
//		Assert.assertTrue(result);
//	}

	@Parameters({"errMsg"})
	@Test
	public void MMP_PAT_EP_003_validateEditFunc_invaliddata(String errMsg)
	{
	 
		mmpLib.launchBrowser(prop.getProperty("patient_url"));
		
		mmpLib.login(prop.getProperty("patient_username"),prop.getProperty("patient_password"));

		mmpLib.selectModule("Profile");
		
		boolean result =mmpLib.editFieldsInvalidData(errMsg);
		 
		Assert.assertTrue(result);
	}
	
}

