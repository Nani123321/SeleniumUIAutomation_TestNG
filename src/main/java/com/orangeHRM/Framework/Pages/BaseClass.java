package com.orangeHRM.Framework.Pages;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.orangeHRM.Framework.ExtentReports.ExtentReportManager;
import com.orangeHRM.Framework.FileReader.FileReaderManager;
import com.orangeHRM.Framework.FileReader.ProperyFileReader;
import com.orangeHRM.Framework.LogUtilities.LoggerUtilities;

public class BaseClass {
	protected WebDriver driver;
    private ExtentReportManager extentReportManager;  // Private instance

    public static FileReaderManager fileReaderManager = FileReaderManager.getInstance();
    public static ProperyFileReader propertyFileReader = fileReaderManager.getPropertyFileReader();

    @BeforeClass(groups = {"Sanity", "Regression", "Dataprovider"})
    @Parameters({"os", "browser"})
    public void setup(String os, String browser) {
        // Initialize the logger
        Logger logger = LoggerUtilities.getLogger(BaseClass.class);

        // Initialize WebDriver based on the browser parameter
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                logger.error("Invalid browser name provided: " + browser);
                return;
        }

        // Set up WebDriver configurations
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(propertyFileReader.getUrl());
        logger.info("Launching the url with {" + browser + "} browser successfully.");
        driver.manage().window().maximize();
        
        // Initialize ExtentReportManager and inject WebDriver
        extentReportManager = new ExtentReportManager(this);  // Pass WebDriver instance to ExtentReportManager
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); // Additional wait for elements to load
    }

    @AfterClass(groups = {"Sanity", "Regression", "Dataprovider"})
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    
    private String captureScreenshot(String tname) throws IOException {
        if (driver == null) {
            throw new NullPointerException("WebDriver is not initialized!");
        }

        // Generate a timestamp for uniqueness
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        // Take screenshot
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // Define the relative path to store screenshots
        String targetFilePath = "screenShots" + File.separator + tname + "_" + timeStamp + ".png";

        // Ensure the screenshots directory exists
        File screenshotDir = new File(System.getProperty("user.dir") + File.separator + "screenShots");
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs(); // Create directory if it doesn't exist
        }

        // Define the target file for the screenshot
        File targetFile = new File(System.getProperty("user.dir") + File.separator + targetFilePath);

        // Copy the screenshot file to the target location
        org.apache.commons.io.FileUtils.copyFile(sourceFile, targetFile);

        // Return the relative path to the screenshot
        return targetFilePath;
    }
}
