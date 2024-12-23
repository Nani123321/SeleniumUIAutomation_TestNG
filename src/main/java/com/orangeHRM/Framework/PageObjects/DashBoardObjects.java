package com.orangeHRM.Framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashBoardObjects extends BasePage{

	protected  DashBoardObjects(WebDriver driver) {
		super(driver);
	}
	
@FindBy(xpath="//span//h6")  
protected WebElement TXT_dashBoard;

//@FindBy(how=How.XPATH, using="//input[@placeholder='Search']")  
//public WebElement Txt_search;

@FindBy(how=How.XPATH, using="//input")  
public WebElement Txt_search;

@FindBy(how=How.XPATH, using="//span[normalize-space()='Admin']")  
public WebElement BTN_Admin;

@FindBy(how=How.XPATH, using="//span[normalize-space()='PIM']")  
public WebElement BTN_pIM;

@FindBy(how=How.XPATH, using="//span[normalize-space()='Leave']")  
public WebElement BTN_leave;

@FindBy(how=How.XPATH, using="//span[normalize-space()='Time']")  
public WebElement BTN_time;

@FindBy(how=How.XPATH, using="//span[normalize-space()='Recruitment']")  
public WebElement BTN_recruitment;

@FindBy(how=How.XPATH, using="//span[normalize-space()='My Info']")  
public WebElement BTN_myInfo;

@FindBy(how=How.XPATH, using="//span[normalize-space()='Performance']") 
public WebElement BTN_performance;

@FindBy(how=How.XPATH,using="//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Dashboard']")  
public WebElement BTN_dashboard;

@FindBy(how=How.XPATH, using="//span[normalize-space()='Directory']")  
public WebElement BTN_directory;

@FindBy(how=How.XPATH, using="//span[normalize-space()='Maintenance']")  
public WebElement BTN_maintenance;

@FindBy(how=How.XPATH, using="//span[normalize-space()='Claim']")  
public WebElement BTN_claim;

@FindBy(how=How.XPATH, using="//span[normalize-space()='Buzz']")  
public WebElement BTN_buzz;

}
