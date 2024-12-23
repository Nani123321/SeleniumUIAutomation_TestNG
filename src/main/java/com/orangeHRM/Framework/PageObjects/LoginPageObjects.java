package com.orangeHRM.Framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageObjects extends BasePage {
	protected LoginPageObjects(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(how=How.XPATH , using="//*[@name=\"username\"]")
	public WebElement TXT_userName;
	
	@FindBy(how=How.XPATH , using="//*[@name=\"password\"]")
	public WebElement TXT_password;
	
	@FindBy(how=How.XPATH , using="//button[@type=\"submit\"]")
	public WebElement BTN_login;
	
	

}
