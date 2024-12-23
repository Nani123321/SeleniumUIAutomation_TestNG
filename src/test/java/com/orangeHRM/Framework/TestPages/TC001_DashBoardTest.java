package com.orangeHRM.Framework.TestPages;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangeHRM.Framework.LogUtilities.LoggerUtilities;
import com.orangeHRM.Framework.Pages.BaseClass;
import com.orangeHRM.Framework.Pages.DashBoard;
import com.orangeHRM.Framework.Pages.LoginPage;

public class TC001_DashBoardTest extends BaseClass{
	
	
	LoginPage lp;
	DashBoard db;
	Logger  logger = LoggerUtilities.getLogger(TC001_DashBoardTest.class);;
	@Test(groups={"Sanity","Regression"})
	public void Verify_DashBoardElements() throws InterruptedException
	{
		logger.info("TC001 started to verify ALL element displayed in DashBoard Page");
		try {
			
			lp=new LoginPage(driver);
			db=new DashBoard(driver);		
			lp.setUserName(propertyFileReader.getUserName());
			lp.setPassWord(propertyFileReader.getPassWord());
			lp.clickOnLoginButton();
			Thread.sleep(3000);
			Assert.assertEquals(db.verifyDashBoardTextDisplayed(), true);
			Assert.assertEquals(db.verifySearchTextDisplayed(), true);
			Assert.assertEquals(db.verifyAdminButtonDisplayed(), true);
			Assert.assertEquals(db.verifyPimButtonDisplayed(), true);
			Assert.assertEquals(db.verifyLeaveButtonDisplayed(), true);
			Assert.assertEquals(db.verifyTimeButtonDisplayed(), true);
			Assert.assertEquals(db.verifyrecruitmentButtonDisplayed(), true);
			Assert.assertEquals(db.verifyMyInfoButtonDisplayed(), true);
			//		db.verifyAdminButtonDisplayed();
			//		db.verifyPimButtonDisplayed();
			//		db.verifyLeaveButtonDisplayed();
			//		db.verifyTimeButtonDisplayed();
			//		db.verifyrecruitmentButtonDisplayed();
			//		db.verifyMyInfoButtonDisplayed();
			//		db.verifyPerformanceButtonDisplayed();
			//		db.verifyDashBoardButtonDisplayed();
			//		db.verifyDirectoryButtonDisplayed();
			//		db.verifyMaintenanceButtonDisplayed();
			//		db.verifyClaimButtonDisplayed();
			//		db.verifyBuzzButtonDisplayed();
			logger.info("TC001 Execution completed and verified all DashBoard Page elements");
		}catch (Exception e) {
			Assert.fail();
		}
	}
}
