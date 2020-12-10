package com.cloudfuze.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	WebDriver driver;
	public LoginPageObjects(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//User ID
	@FindBy(how=How.CSS,using="input#email")
	private WebElement userid;
	//password
	@FindBy(how=How.CSS,using="input#safariChange")
	private WebElement password;
	//ClickButton
	@FindBy(how=How.CSS,using="button#login-submit")
	private WebElement click;

	public void userId(String UserId) {
		userid.sendKeys(UserId);
	}

	public void password(String Password) {
		password.sendKeys(Password);
	}

	public void click() {
		click.click();
	}
}
