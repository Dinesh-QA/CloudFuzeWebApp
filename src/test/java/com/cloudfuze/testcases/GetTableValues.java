package com.cloudfuze.testcases;

import org.testng.annotations.Test;

import com.cloudfuze.pageobjects.DashBoard;

public class GetTableValues extends LoginTest{
@Test(priority=2)
public void gettablevalues() {
	DashBoard dash = new DashBoard(driver);
	dash.ClickonManageclouds();
	dash.gettablevalues();
}
}
