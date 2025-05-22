package org.iitwf.healthcare.mmppixel;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import org.iitwf.lib.FrameworkLibrary;
import org.testng.annotations.Test;

public class FullScreenshotEx extends FrameworkLibrary {
	
	@Test
	public void checkTitle()

	{
		launchBrowser("https://www.google.com");
		String fileAbsolutePath = System.getProperty("user.dir")+"/screenshots/google.png";
		StringSelection clipBoardPath = new StringSelection(fileAbsolutePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipBoardPath, null);
		
	}
}
