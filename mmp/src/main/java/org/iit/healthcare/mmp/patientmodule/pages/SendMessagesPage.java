package org.iit.healthcare.mmp.patientmodule.pages;

import java.util.HashMap;

import org.iit.healthcare.mmp.AppLibrary;
import org.iit.healthcare.mmp.patientmodule.pages.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendMessagesPage {
	
protected WebDriver driver;
	
	public SendMessagesPage (WebDriver driver)
	{
		this.driver=driver;
	}
	
	By subject=By.id("subject");
	By message=By.id("message");
	By send=By.xpath("//input[@value='Send']");
	
	public HashMap<String,String> sendMessages(String subject,String message)
	{
		HashMap<String,String>msgHMap=new HashMap<String,String>();
		
		msgHMap.put("subject", subject);
		msgHMap.put("message", message);
		driver.findElement(By.id("subject")).sendKeys(subject);
		driver.findElement(By.id("message")).sendKeys(message);
		driver.findElement(By.xpath("//input[@value='Send']")).click();
		
		ProfilePage profPage=new ProfilePage(driver);
		String patientName=profPage.getPatientName();
		msgHMap.put("patientName", patientName);
		msgHMap.put("date", AppLibrary.getFutureDate(0, "dd-mm-YYYY"));
		return msgHMap;

	}

}
