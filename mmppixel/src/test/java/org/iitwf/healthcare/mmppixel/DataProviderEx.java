package org.iitwf.healthcare.mmppixel;

import java.io.IOException;

import org.iitwf.lib.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx {

	@DataProvider(name = "test2")
	public String[][] feedDP() throws IOException
	{
		String data[][]= ExcelUtils.readExcel("mmpdata.xlsx","data");
		return data;
	}
	 
	@DataProvider(name = "test1")
	public Object[][] createData1() {
	 return new Object[][] {
	   { "Cedric", 36 },
	   { "Anne", 37},
	   { "Anne", 37}
	 };
	}

	 
	@Test(dataProvider = "test2")
	public void verifyData1(String n1, String n2) {
	 System.out.println(n1 + " " + n2);
	}
	 
}
