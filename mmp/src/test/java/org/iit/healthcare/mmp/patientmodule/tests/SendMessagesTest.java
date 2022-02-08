package org.iit.healthcare.mmp.patientmodule.tests;

import java.util.HashMap;

import org.iit.healthcare.mmp.BaseClass;
import org.iit.healthcare.mmp.LoginPage;
import org.iit.healthcare.mmp.MMPLibrary;
import org.iit.healthcare.mmp.patientmodule.pages.HomePage;
import org.iit.healthcare.mmp.patientmodule.pages.SendMessagesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendMessagesTest extends BaseClass{
	
	@Test
	public void validateSendMessagesTest()
	{
	MMPLibrary lib=new MMPLibrary(driver);
	lib.launchBrowser(pro.getProperty("patientURL"));
	
	LoginPage lPage=new LoginPage(driver);
	HomePage hPage=lPage.login(pro.getProperty("patientusername"), pro.getProperty("patientpassword"));
	hPage.navigateToAModule("Messages");
	SendMessagesPage sPage=new SendMessagesPage(driver);
	HashMap<String,String>hMap=sPage.sendMessages("Need to get appointment", "High fever");
	String expected="Messages Successfully sent.";
	String actual=lib.getAlertText();
	Assert.assertEquals(actual, expected);
	}
	

}
