package com.cloudfuze.pageobjects;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCloudsPage {
	static WebDriver driver;
	static JavascriptExecutor jse;
	public AddCloudsPage(WebDriver driver){
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	//BoxIcon
	@FindBy(how=How.CSS,using="a#doOauth_Box")
	static WebElement boxicon;

	//BoxOauthPage
	@FindBy(how=How.CSS,using="body.body device_ visible")
	static WebElement boxOauth;

	//BoxUserID
	@FindBy(how=How.CSS,using="input#login")
	static WebElement boxUserId;

	//BoxPassword
	@FindBy(how=How.CSS,using="input#password")
	static WebElement boxPassword;

	//BoxAuthorize
	@FindBy(how=How.XPATH,using="//input[@title='Authorize']")
	static WebElement boxAuthorize;

	//BoxAccept
	@FindBy(how=How.XPATH,using="//button[@id='consent_accept_button']")
	static WebElement boxaccept;

	public void addingboxcloud(String userId,String Password) {
		boxicon.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Set<String> windows = driver.getWindowHandles();
		for(String handle : windows) {
			driver.switchTo().window(handle);
		}
		boxUserId.sendKeys(userId);
		boxPassword.sendKeys(Password);
		boxAuthorize.click();
		boxaccept.click();
		driver.switchTo().parentFrame();
	}
}
