package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;
	
	// private locators
	private By accountSections = By.cssSelector("div#center_column span");
	
	// public constructor
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//public action methods
	
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}
	
	public int getAccountsSectionCount() {
		return driver.findElements(accountSections).size();
	}
	
	public List<String> getAccountsSectionList() {
		List<String>accountList = new ArrayList<String>();
		List<WebElement>accountsHeaderList = driver.findElements(accountSections);
		for(WebElement e : accountsHeaderList) {
			String headerText = e.getText();
			System.out.println(headerText);
			accountList.add(headerText);
		}
		return accountList;
	}
}
