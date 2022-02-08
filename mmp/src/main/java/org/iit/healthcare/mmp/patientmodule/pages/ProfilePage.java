package org.iit.healthcare.mmp.patientmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
	
protected WebDriver driver;
	
	public ProfilePage (WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getPatientName()
	{
		return driver.findElement(By.id("fname")).getText();
	}


}
