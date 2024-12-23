package com.orangeHRM.Framework.Pages;
import org.openqa.selenium.WebDriver;

import com.orangeHRM.Framework.PageObjects.LoginPageObjects;
import com.orangeHRM.Framework.WebDriverActions.SeleniumActions;

public class LoginPage extends LoginPageObjects{
	SeleniumActions sel;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.sel= new SeleniumActions(driver);
	}

	public void setUserName(String username)
	{
		sel.enterText(TXT_userName, username);
	}


	public void setPassWord(String password)
	{
		sel.enterText(TXT_password, password);
	}

	public void clickOnLoginButton()
	{
		sel.click(BTN_login);
	}

}




