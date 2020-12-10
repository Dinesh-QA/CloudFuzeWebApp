
package com.cloudfuze.testcases;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cloudfuze.utilities.ReadingConfig;

public class BaseClass {
	WebDriver driver;
	ExtentReports reports;
	ExtentTest test;
	@BeforeSuite
	public void Baseclass() throws IOException, InterruptedException {
		ReadingConfig read = new ReadingConfig();
		System.setProperty("webdriver.chrome.driver", "D://Drivers/chromedriver.exe"); 
		driver = new ChromeDriver(); 
		driver.get(read.url());
		System.out.println(read.url());
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@BeforeClass
	public void ExtentReports() {
		DateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		Date date = new Date();
		String extentfile = "./ExtentReports/"+format.format(date).replace(":", ".")+" ExtentReport.html";
		ExtentHtmlReporter reportor = new ExtentHtmlReporter(extentfile);
		reports = new ExtentReports();
		reports.attachReporter(reportor);
		test = reports.createTest("WebApp testing", "Cloudfuze Application test");
		test.log(Status.INFO, "Test Started");
	}

	@AfterSuite
	public void closingresource() {
		test.info("Closing browser");
		reports.flush();
		driver.close();
		driver.quit();
	}
}
