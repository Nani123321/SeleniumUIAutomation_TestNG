package com.orangeHRM.Framework.ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.orangeHRM.Framework.Pages.BaseClass;

public class ExtentReportManager implements ITestListener {

	 private ExtentReports extent;
	    private ExtentTest test;
	    private String repName = null;
  // WebDriver reference for screenshots
	    private BaseClass baseClass;
	    // Constructor
	    public ExtentReportManager(BaseClass baseClass) {
	        this.baseClass = baseClass;
	    }
	    // Setter method to inject WebDriver instance
	    

	    public void onStart(ITestContext testContext) {
	        // Initialize the Extent Report
	        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	        repName = "Test-Report-" + timeStamp + ".html";
	        String repopath = System.getProperty("user.dir") + "/reports/" + repName;

	        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(repopath);
	        sparkReporter.config().setDocumentTitle("OrangeHRM Automation Report");
	        sparkReporter.config().setReportName("OrangeHRM Functional Testing");
	        sparkReporter.config().setTheme(Theme.DARK);

	        extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);
	        extent.setSystemInfo("Application Name", "OrangeHRM");
	        extent.setSystemInfo("Module", "Admin");
	        extent.setSystemInfo("user Name", System.getProperty("user.name"));
	        extent.setSystemInfo("Environment", "QA");

	        String os = testContext.getCurrentXmlTest().getParameter("os");
	        extent.setSystemInfo("Operating System", os);
	        String browser = testContext.getCurrentXmlTest().getParameter("browser");
	        extent.setSystemInfo("Browser", browser);

	        List<String> includegroups = testContext.getCurrentXmlTest().getIncludedGroups();
	        if (!includegroups.isEmpty()) {
	            extent.setSystemInfo("Groups", includegroups.toString());
	        }
	    }

	    public void onTestSuccess(ITestResult result) {
	        test = extent.createTest(result.getName());
	        test.assignCategory(result.getMethod().getGroups());
	        test.log(Status.PASS, result.getName() + " got Successfully Executed.");
	    }

	    public void onTestFailure(ITestResult result) {
	        test = extent.createTest(result.getName());
	        test.assignCategory(result.getMethod().getGroups());
	        test.log(Status.FAIL, result.getName() + " got failed");
	        test.log(Status.INFO, result.getThrowable().getMessage());

	        try {
	            // Capture screenshot using the WebDriver instance injected in the constructor
	         //   String screenshotPath = baseClass.(result.getName());
	        //    test.addScreenCaptureFromPath(screenshotPath);  // Attach screenshot to the report
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public void onTestSkipped(ITestResult result) {
	        test = extent.createTest(result.getTestClass().getName());
	        test.assignCategory(result.getMethod().getGroups());
	        test.log(Status.SKIP, result.getName() + " got Skipped");
	        test.log(Status.INFO, result.getThrowable().getMessage());
	    }

	    public void onFinish(ITestContext context) {
	        extent.flush();

	        // Open the report after completion
	        String pathOfExtentreport = System.getProperty("user.dir") + "/reports/" + repName;
	        File extentReport = new File(pathOfExtentreport);
	        try {
	            Desktop.getDesktop().browse(extentReport.toURI());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	   
//		try {
//			URL url = new URL ("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);
//			ImageHtmlEmail email = new ImageHtmlEmail();
//			email.setDataSourceResolver(new DataSourceUrlResolver(url));
//			email.setHostName("smtp.googlemail.com");
//			email.setSmtpPort(465);
//			email.setAuthentication("b.narayana1223@gmail.com", "password");
//			email.setSSLOnConnect(true);
//			email.setFrom("b.narayana1223@gmail.com");
//			email.setSubject("Test Results");
//			email.setMsg("Please Find the Attached Report");
//			email.addTo("pasupuletilakshmi563gmail.com");
//			email.attach(url, "Extent report", "Plaese check report");
//			email.send();				
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
    
   	
	}

