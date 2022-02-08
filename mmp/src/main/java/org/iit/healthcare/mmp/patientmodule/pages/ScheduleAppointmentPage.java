package org.iit.healthcare.mmp.patientmodule.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ScheduleAppointmentPage {

	protected WebDriver driver;
	private String doctorName;
	
	private By newAppointmentButton=By.xpath("//input[@value='Create new appointment']");
	private By selectDoctor=By.xpath("//h4[normalize-space()='Dr."+doctorName+"']/ancestor::ul/following-sibling::button");
	private By datePickerId=By.xpath("//input[@id='datepicker']");
	private By yearDatePicker=By.xpath("//span[@class='ui-datepicker-year']");
	private By arrowDatePicker=By.cssSelector(".ui-icon.ui-icon-circle-triangle-e");
	private By monthDatePicker=By.xpath("//span[@class='ui-datepicker-month']");
	private By timeId=By.xpath("//select[@id='time']");
	private By continueButton=By.cssSelector("#ChangeHeatName");
	private By symptomsId=By.xpath("//textarea[@id='sym']");
	private By submitButton=By.xpath("//input[@value='Submit']");
	private By actualDateXpath=By.xpath("//table[@class='table']/tbody/tr[1]/td[1]");
	private By actualTimeXpath=By.xpath("//table[@class='table']/tbody/tr[1]/td[2]");
	private By actualSymptomXpath=By.xpath("//table[@class='table']/tbody/tr[1]/td[3]");
	private By actualDocXpath=By.xpath("//table[@class='table']/tbody/tr[1]/td[4]");
	
	public ScheduleAppointmentPage(WebDriver driver)
	{
		this.driver = driver;
		 
	}
	
	
	//schedule appointment
	public HashMap<String,String> scheduleAppointment(String doctorName,String date,String time,String symptoms)
	{
		HashMap<String,String>hmap=new HashMap<String,String>();
		
		
		driver.findElement(newAppointmentButton).click();
		
		//Select doctor
		this.doctorName=doctorName;
		driver.findElement(By.xpath("//h4[normalize-space()='Dr."+doctorName+"']/ancestor::ul/following-sibling::button")).click();
		
		driver.switchTo().frame(0);
		driver.findElement(datePickerId).click();
		String expecteddate=date;
	    String datearray[]=expecteddate.split("/");
		String exp_month=datearray[0];
		String exp_day=datearray[1];
		String exp_year=datearray[2];
		
		String act_yr=driver.findElement(yearDatePicker).getText();
		while(!exp_year.equals(act_yr))
		{
			driver.findElement(arrowDatePicker).click();
			act_yr=driver.findElement(yearDatePicker).getText();
		}
		String act_month=driver.findElement(monthDatePicker).getText();
		while(!exp_month.equals(act_month))
		{
			driver.findElement(arrowDatePicker).click();
			act_month=driver.findElement(monthDatePicker).getText();
		}
		driver.findElement(By.linkText(exp_day)).click();	
		
		//time
		Select timedrop=new Select(driver.findElement(timeId));
		timedrop.selectByVisibleText(time);
		
		driver.findElement(continueButton).click();
		//Symptoms
		
		driver.findElement(symptomsId).sendKeys(symptoms);
		driver.findElement(submitButton).click();
		
		String act_date=driver.findElement(actualDateXpath).getText();
		String act_time=driver.findElement(actualTimeXpath).getText();
		String act_sym=driver.findElement(actualSymptomXpath).getText();
		String act_doc=driver.findElement(actualDocXpath).getText();
		hmap.put("date", act_date);
		hmap.put("time", act_time);
		hmap.put("symptoms",  act_sym);
		hmap.put("doctor", act_doc);
		return hmap;
	}

}
