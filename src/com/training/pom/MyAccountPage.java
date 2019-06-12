package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	
private WebDriver driver; 
	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(text(), 'Edit your')]")
	private WebElement editInformationLink; 
	
	@FindBy(xpath="//*[contains(text(), 'Change')]")
	private WebElement ChangePasswordLink; 

	@FindBy(xpath = "//*[contains(text(), 'Success: Your password')]")
	private WebElement passwordChangeMessage;
	
	
	
	public void clickEditInfoLink()
	{
		this.editInformationLink.click();
	}
	
	public void clickChangePasswordLink() {
		this.ChangePasswordLink.click(); 
	}
	
	public boolean isPasswordChangeMessageDisplay()
	{
		return this.passwordChangeMessage.isDisplayed();
		
	}
	
	

}
