package org.iit.healthcare.mmp.adminmodule.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MessagesPage {
	
private WebDriver driver;
	
	public MessagesPage (WebDriver driver)
	{
		this.driver=driver;
	}
	
	public HashMap<String,String> getMessageDetails()
	{
		HashMap<String,String> mHMap=new HashMap<String,String>();
		
		String patientName=driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[1]")).getText().trim();
		String subject=driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[2]")).getText().trim();
		String date=driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[3]")).getText().trim();
		String message=driver.findElement(By.xpath("//table[@class='table']/tbody/tr[3]/td[2]")).getText().trim();
		mHMap.put("patientName",patientName );
		mHMap.put("subject", subject);
		mHMap.put("date", date);
		mHMap.put("message", message);
		return mHMap;
	}

}
