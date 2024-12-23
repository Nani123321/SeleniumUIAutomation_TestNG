package com.orangeHRM.Framework.TestPages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangeHRM.Framework.ExcelUtilities.DataProviders;
import com.orangeHRM.Framework.Pages.BaseClass;
import com.orangeHRM.Framework.Pages.LoginPage;
import com.orangeHRM.Framework.Pages.LogoutPage;

public class TC003_LogoutPageTest extends BaseClass{
	
	LoginPage lp;
	LogoutPage lo;
	@Test(dataProvider = "LoginData" , dataProviderClass = DataProviders.class, groups= {"DataProvider","Sanity"})
	public void verifyLogoutFunctionality(String username, String password, String exp) throws InterruptedException
	{

		lp=new LoginPage(driver);
		Thread.sleep(2000);
		lp.setUserName(username);
		lp.setPassWord(password);
		lp.clickOnLoginButton();
		lo=new LogoutPage(driver);
		boolean targetPage = lo.userDropDownExist();		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(targetPage==true)
			{
				lo.clickOnUserDropDown();
				lo.clickOnLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(targetPage==true)
			{
				lo.clickOnUserDropDown();
				lo.clickOnLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}		

	}

}
