package com.cloudfuze.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class getsScreenshot {
	WebDriver driver;
	public getsScreenshot(WebDriver driver){
		this.driver = driver;
	}
	//ScreenShot
	public void TakesScreenShot() {
		try {
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils fileutils = new FileUtils();
		DateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		Date date = new Date();
		String destinationpath = "./+Screenshots+format.format(date)";
		fileutils.copyFile(screenshot, new File("./Screenshots/"+format.format(date).replace(":",".")+" screenshot.png"));
		System.out.println("Took the Screenshot");
		}catch(Exception e) {
			System.out.println("Screenshot failed"+e.getMessage());
		}
	}
}
