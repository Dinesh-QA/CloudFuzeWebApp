package com.cloudfuze.testcases;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.cloudfuze.pageobjects.CFMenu;
import com.cloudfuze.pageobjects.DashBoard;
import com.cloudfuze.pageobjects.LoginPageObjects;
import com.cloudfuze.pageobjects.TeamMigrationWindow;
import com.cloudfuze.utilities.ReadingExcel;
import com.cloudfuze.utilities.getsScreenshot;

public class LoginTest extends BaseClass {
	@Test(priority=1)
	public void LoginTesting() throws InterruptedException {
		String[][] login = ReadingExcel.ReadingExcelmethod("./TestData/Test.xlsx", "xlsx", "Sheet1");
		System.out.println(login[1][1]);
		test.log(Status.PASS, "OpenedURL");
		LoginPageObjects pageobj = new LoginPageObjects(driver);
		pageobj.userId(login[1][1]);
		pageobj.password(login[1][2]);
		getsScreenshot screenshot = new getsScreenshot(driver);
		screenshot.TakesScreenShot();
		pageobj.click();
	}
}
