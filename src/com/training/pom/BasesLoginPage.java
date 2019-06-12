package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasesLoginPage {
	
private WebDriver driver; 
	
	public BasesLoginPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@class = 'fa fa-user-o']")
	public WebElement accountDropdown; 
	
	@FindBy(xpath="//*[@class = 'tb_link tb_menu_system_account_login']")
	private WebElement loginIDLink; 
	
	@FindBy(xpath="//*[contains(text(), 'MY ORDERS')]")
	public WebElement ordersLink; 
	
	public void accountDropdownBtn() {
		this.accountDropdown.click(); 
	}
	
	public void loginIDLink() {
		this.loginIDLink.click(); 
	}
	
	public void clickOrdersLink() {
		this.ordersLink.click(); 
	}
}
