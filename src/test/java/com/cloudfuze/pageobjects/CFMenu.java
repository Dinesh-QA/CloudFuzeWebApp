package com.cloudfuze.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CFMenu {
	WebDriver driver;
	public CFMenu(WebDriver driver){
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}	

	@FindBy(how=How.XPATH,using="//i[@class='fa fa-user-circle-o']")
	WebElement profilepic;

	@FindBy(how=How.CLASS_NAME,using="mYaccontlogout")
	WebElement Logout;
	
	@FindBy(how=How.XPATH,using="//span[@id='dash-uname']")
	WebElement displayName;

	public void LogOut() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(profilepic));
		Actions action = new Actions(driver);
		action.moveToElement(profilepic).perform();
		System.out.println("User Account Name is "+displayName.getText());
		if(profilepic.isEnabled()&&profilepic.isDisplayed()) {
			Logout.click();
			System.out.println("Logged Out from Application");
		}
		else {
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("arguments[0].click();", Logout);
		}
	}
}
