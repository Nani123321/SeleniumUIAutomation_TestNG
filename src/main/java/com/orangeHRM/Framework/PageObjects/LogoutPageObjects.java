package com.orangeHRM.Framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogoutPageObjects extends BasePage{

	public LogoutPageObjects(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how=How.XPATH, using="//p[@class='oxd-userdropdown-name']") 
	protected WebElement BTN_UserDropDown;

	@FindBy(xpath="//a[normalize-space()='Logout']") 
	protected WebElement BTN_Logout;

	
}
