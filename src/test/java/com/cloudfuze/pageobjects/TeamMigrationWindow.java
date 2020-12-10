package com.cloudfuze.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TeamMigrationWindow {
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;
	public TeamMigrationWindow(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//BoxCloudasSource
	@FindBy(how=How.XPATH,using="//input[@id='5fcdf4c3e4b0b720cb905497']")
	WebElement boxcloudasSource;

	//ODFBasDestinationcloud
	////input[@id='5fcdf4eae4b0b720cb9054a6']
	@FindBy(how=How.XPATH,using="//input[@name='dstCloud' and @id='5fcdf4eae4b0b720cb9054a6']")
	WebElement odfbasdestination;

	//NextButtoninTeamMigration
	@FindBy(how=How.ID,using="forNextMove")
	WebElement nextbutton;

	//SelectAllMappings
	@FindBy(how=How.CSS,using="input#chkInput")
	WebElement selectallmappings;
	
	//JobTypeDropdown
	@FindBy(how=How.XPATH,using="//select[@id='jobType_dropDown']")
	WebElement JobTypeDropdown;
	
	public void BFBtoODFBmigration() {
		try {
		wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOf(boxcloudasSource));
		boxcloudasSource.click();
		odfbasdestination.click();
		wait.until(ExpectedConditions.visibilityOf(nextbutton));
		nextbutton.click();
		wait.until(ExpectedConditions.visibilityOf(selectallmappings));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", selectallmappings);
		wait.until(ExpectedConditions.visibilityOf(nextbutton));
		js.executeScript("arguments[0].click();", nextbutton);
		System.out.println("Entered into Options window");
		Thread.sleep(2000);
		nextbutton.click();
		System.out.println("Entered into preview window");
		Thread.sleep(2000);
		nextbutton.click();
		System.out.println("Entered into Intiate migration window");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void DeltaBFBtoODFBmigration() {
		try {
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOf(boxcloudasSource));
		boxcloudasSource.click();
		odfbasdestination.click();
		wait.until(ExpectedConditions.visibilityOf(nextbutton));
		nextbutton.click();
		wait.until(ExpectedConditions.visibilityOf(selectallmappings));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", selectallmappings);
		wait.until(ExpectedConditions.visibilityOf(nextbutton));
		js.executeScript("arguments[0].click();", nextbutton);
		wait.until(ExpectedConditions.visibilityOf(JobTypeDropdown));
		Select select = new Select(JobTypeDropdown);
		select.selectByVisibleText("Delta");
		Thread.sleep(2000);
		nextbutton.click();
		System.out.println("Entered into preview screen");
		Thread.sleep(5000);
		nextbutton.click();
		System.out.println("Intiated migration");
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
}
}
