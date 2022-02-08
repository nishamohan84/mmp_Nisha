package org.iit.healthcare.mmp;

import org.iit.healthcare.mmp.patientmodule.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	protected WebDriver driver;
	private By usernameBy = By.id("username");
	private By passwordBy = By.id("password");
	private By signinBy=By.cssSelector("input[value='Sign In']");
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public HomePage login(String uname,String pword)
	{

		driver.findElement(usernameBy).sendKeys(uname);
		driver.findElement(passwordBy).sendKeys(pword);
		driver.findElement(signinBy).click();
		return new HomePage(driver);
	}

}
