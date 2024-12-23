package com.orangeHRM.Framework.TestPages;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.orangeHRM.Framework.LogUtilities.LoggerUtilities;
import com.orangeHRM.Framework.Pages.BaseClass;
import com.orangeHRM.Framework.Pages.LoginPage;

public class TC000_LoginPageTest extends BaseClass{

	
	LoginPage lp;
	Logger logger = LoggerUtilities.getLogger(TC000_LoginPageTest.class);
@Test(groups= {"Sanity","Regression"})
public void verifyLoginTest()
{
	lp=new LoginPage(driver);
	lp.setUserName(propertyFileReader.getUserName());
	lp.setPassWord(propertyFileReader.getPassWord());
	lp.clickOnLoginButton();
	logger.info("Login Succesfully.");
	
}
	
}
