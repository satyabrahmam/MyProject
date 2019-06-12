package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountInfoPage {
	
private WebDriver driver; 
	
	public MyAccountInfoPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name ="firstname")
	private WebElement firstname;
	
	@FindBy(id ="input-lastname")
	private WebElement lastname;
	
	@FindBy(name ="email")
	private WebElement email;
	
	@FindBy(id ="input-telephone")
	private WebElement phoneNumber;
	
	@FindBy(xpath ="//*[@class = 'btn btn-primary']")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//*[contains(text(), 'Your account has been successfully updated.')]")
	private WebElement accountUpdatedMsg;
	
	public void sendFirstname(String firstname) {
		this.firstname.clear();
		this.firstname.sendKeys(firstname);
	}
	public void sendLastname(String lastname) {
		this.lastname.clear();
		this.lastname.sendKeys(lastname);
	}
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	public void sendPhoneNumber(String phoneNumber) {
		this.phoneNumber.clear();
		this.phoneNumber.sendKeys(phoneNumber);
	}
	
	public void clickContinueBtn()
	{
		this.continueBtn.click();
	}
	public boolean isYourAccountUpdated()
	{
		
		return this.accountUpdatedMsg.isDisplayed();
	}
}
