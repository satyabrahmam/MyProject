package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage {
	
private WebDriver driver; 
	
	public ChangePasswordPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@name = 'password']")
	private WebElement newPassword; 
	
	@FindBy(xpath="//*[@name = 'confirm']")
	private WebElement confirmPassword; 

	@FindBy(xpath="//*[@value = 'Continue']")
	private WebElement continueBtn; 

	public void sendNewPassword(String newPassword) {
		this.newPassword.clear();
		this.newPassword.sendKeys(newPassword);
	}
	
	public void sendConfirmPassword(String confirmPassword) {
		this.confirmPassword.clear(); 
		this.confirmPassword.sendKeys(confirmPassword); 
	}
	public void clickcontinueBtn() {
		this.continueBtn.click(); 
	}

}
