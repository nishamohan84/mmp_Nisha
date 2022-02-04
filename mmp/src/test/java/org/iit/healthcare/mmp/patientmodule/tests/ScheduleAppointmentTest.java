package org.iit.healthcare.mmp.patientmodule.tests;
import java.util.HashMap;

import org.iit.healthcare.mmp.AppLibrary;
import org.iit.healthcare.mmp.BaseClass;
import org.iit.healthcare.mmp.LoginPage;
import org.iit.healthcare.mmp.MMPLibrary;
import org.iit.healthcare.mmp.patientmodule.pages.HomePage;
import org.iit.healthcare.mmp.patientmodule.pages.ScheduleAppointmentPage;
import org.testng.Assert;
import org.testng.annotations.Test;
public class ScheduleAppointmentTest extends BaseClass {

	@Test
	public void validateScheduleAppointment()
	{
		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.launchBrowser(pro.getProperty("patientURL"));
		LoginPage lPage  = new LoginPage(driver);
		HomePage hPage = lPage.login(pro.getProperty("patientusername"),pro.getProperty("patientpassword"));
		hPage.navigateToAModule("Schedule Appointment");
		String date= AppLibrary.getFutureDate(15,"dd/MMMM/YYYY");
		String  expectedDateFormat =  AppLibrary.getFutureDate(15,"MM/dd/YYYY");
		ScheduleAppointmentPage sPage = new ScheduleAppointmentPage(driver);
		HashMap<String,String> actualHMap = sPage.scheduleAppointment(pro.getProperty("doctor"),date,"10Am","Fever");
		Assert.assertEquals(actualHMap.get("date"), expectedDateFormat);
		Assert.assertEquals(actualHMap.get("time"), "10Am");
		Assert.assertEquals(actualHMap.get("doctor"),"Beth" );
		Assert.assertEquals(actualHMap.get("sym"), "Fever");
		System.out.println("Executed the tests successfully");

	}

     

}
