package com.cloudfuze.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoard {
	WebDriver driver;
	public DashBoard(WebDriver driver) {
		this.driver=driver;
        PageFactory.initElements(driver, this);
	}
	
	//TeamMigration
	@FindBy(how=How.XPATH,using="//i[@class='cf-group2']")
	WebElement teammigration;
	
	//ManageClouds
	@FindBy(how=How.XPATH,using="//i[@class='icon-wrench '] ")
	WebElement manageclouds;
	
	////table[@class='table table-condensed']/tbody/tr[]/td[]
	
	String tablebody = "//table[@class='table table-condensed']/tbody/tr[";
	String tablebody2 = "]/td[";
	String tablebody3 = "]";
	
	public void ClickonTeamMigration() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(teammigration));
		teammigration.click();
	}
	
	public void ClickonManageclouds() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(manageclouds));
		manageclouds.click();
	}
	
	public void gettablevalues() {
		for(int i=1;i<=8;i++) {
			for(int j=1;j<=6;j++) {
				WebElement element = driver.findElement(By.xpath(tablebody+i+tablebody2+j+tablebody3));
				System.out.print(element.getText()+" ");
			}
			System.out.println();
		}
		
	}
}
