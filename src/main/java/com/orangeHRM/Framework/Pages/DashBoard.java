package com.orangeHRM.Framework.Pages;
import org.openqa.selenium.WebDriver;

import com.orangeHRM.Framework.PageObjects.DashBoardObjects;
import com.orangeHRM.Framework.WebDriverActions.SeleniumActions;
public class DashBoard extends DashBoardObjects{
   private SeleniumActions sel;
	public DashBoard(WebDriver driver) {
		super(driver);	
		this.sel=new SeleniumActions(driver);
	}
	
	public boolean verifyDashBoardTextDisplayed()
	{
		return sel.isDisplayed(TXT_dashBoard);
	}
	
	public boolean verifySearchTextDisplayed()
	{
		return sel.isDisplayed(Txt_search);
	}
	
	public boolean verifyAdminButtonDisplayed()
	{
		return sel.isDisplayed(BTN_Admin);
	}
	
	public boolean verifyPimButtonDisplayed()
	{
		return sel.isDisplayed(BTN_pIM);
	}
	
	public boolean verifyLeaveButtonDisplayed()
	{
		return sel.isDisplayed(BTN_leave);
	}
	
	public boolean verifyTimeButtonDisplayed()
	{
		return sel.isDisplayed(BTN_time);
	}
	
	public boolean verifyrecruitmentButtonDisplayed()
	{
		return sel.isDisplayed(BTN_recruitment);
	}
	
	public boolean verifyMyInfoButtonDisplayed()
	{
		return sel.isDisplayed(BTN_myInfo);
	}
	
	public boolean verifyPerformanceButtonDisplayed()
	{
		return sel.isDisplayed(BTN_performance);
	}

	
	public void verifyDashBoardButtonDisplayed()
	{
		sel.isDisplayed(BTN_dashboard);
	}
	
	public void verifyDirectoryButtonDisplayed()
	{
		sel.isDisplayed(BTN_directory);
	}
		
	public void verifyMaintenanceButtonDisplayed()
	{
		sel.isDisplayed(BTN_performance);
	}
	
	public void verifyClaimButtonDisplayed()
	{
		sel.isDisplayed(BTN_claim);
	}
	
	public void verifyBuzzButtonDisplayed()
	{
		sel.isDisplayed(BTN_buzz);
	}

	
		
	}
