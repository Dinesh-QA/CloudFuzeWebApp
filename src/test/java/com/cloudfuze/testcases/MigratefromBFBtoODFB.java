package com.cloudfuze.testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.cloudfuze.pageobjects.DashBoard;
import com.cloudfuze.pageobjects.TeamMigrationWindow;

public class MigratefromBFBtoODFB extends LoginTest{
	@Test(priority=2)
	public void migratefromBFBtoODFBbusiness() {
		DashBoard dashboard = new DashBoard(driver);
		dashboard.ClickonTeamMigration();
		test.info("Clicked on TeamMigrationButton");
		TeamMigrationWindow teammigration = new TeamMigrationWindow(driver);
		teammigration.BFBtoODFBmigration();
		test.log(Status.PASS, "MIGRATION intiated");
	}
}
