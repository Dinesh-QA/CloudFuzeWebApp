package com.cloudfuze.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class saitest {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.cloudfuze.com");
		
	}

}
