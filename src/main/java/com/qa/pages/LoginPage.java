package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	//private Locators
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?");

	//public Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	//public page actions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}
//	public void enterUserName(String userName) {
//		driver.findElement(emailId).sendKeys(userName);
//	}
//	public void enterPassword(String pwd) {
//		driver.findElement(password).sendKeys(pwd);
//	}
//	public void clickOnLogin() {
//		driver.findElement(signInButton).click();
//	}
	
	public AccountsPage loginToApplication(String userName, String passWd) {
		System.out.println("Login with: "+userName+" and "+passWd);
		driver.findElement(emailId).sendKeys(userName);
		driver.findElement(password).sendKeys(passWd);
		driver.findElement(signInButton).click();
		return new AccountsPage(driver);
	}
}
