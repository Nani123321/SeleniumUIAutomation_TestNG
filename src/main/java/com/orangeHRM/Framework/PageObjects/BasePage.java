package com.orangeHRM.Framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public class BasePage {
	 public WebDriver driver;

	    // Constructor to initialize WebDriver
	    public BasePage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	   
}



