package com.orangeHRM.Framework.Pages;

import org.openqa.selenium.WebDriver;

import com.orangeHRM.Framework.PageObjects.LogoutPageObjects;
import com.orangeHRM.Framework.WebDriverActions.SeleniumActions;

public class LogoutPage extends LogoutPageObjects{
	private SeleniumActions sel;
	public LogoutPage(WebDriver driver) {
		super(driver);
		this.sel=new SeleniumActions(driver);
	}

	public void clickOnUserDropDown()
	{
		sel.click(BTN_UserDropDown);
	}
	
	public void clickOnLogout()
	{
		sel.click(BTN_Logout);
	}
	
	public boolean userDropDownExist()
	{
		return sel.isDisplayed(BTN_UserDropDown);
		
	}

}
