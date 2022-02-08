package org.iit.healthcare.mmp.adminmodule.tests;

import java.util.HashMap;

import org.iit.healthcare.mmp.BaseClass;
import org.iit.healthcare.mmp.LoginPage;
import org.iit.healthcare.mmp.MMPLibrary;
import org.iit.healthcare.mmp.adminmodule.pages.MessagesPage;
import org.iit.healthcare.mmp.patientmodule.pages.HomePage;
import org.iit.healthcare.mmp.patientmodule.pages.SendMessagesPage;
import org.testng.annotations.Test;

public class MessagesTest extends BaseClass {
	
	@Test
	public void ValidateMessagesE2E()
	{
	MMPLibrary lib=new MMPLibrary(driver);
	lib.launchBrowser(pro.getProperty("patientURL"));
	LoginPage lPage=new LoginPage(driver);
	HomePage hPage=lPage.login(pro.getProperty("patientusername"), pro.getProperty("patientpassword"));
	hPage.navigateToAModule("Messages");
	SendMessagesPage sPage=new SendMessagesPage(driver);
	HashMap<String,String>expectedHMap=sPage.sendMessages("Need to get appointment", "High fever");
	lib.launchBrowser(pro.getProperty("adminURL"));
	lPage=new LoginPage(driver);
	hPage=lPage.login(pro.getProperty("adminusername"), pro.getProperty("adminpassword"));
	hPage.navigateToAModule("Messages");
	MessagesPage mPage= new MessagesPage(driver);
	HashMap<String,String>actualHMap=mPage.getMessageDetails();
	}

}
