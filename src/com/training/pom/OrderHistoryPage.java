package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {
	
private WebDriver driver; 
	
	public OrderHistoryPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@title = 'View']")
	private WebElement viewIconImg; 

	public void clickviewIconImg()
	{
		this.viewIconImg.click();
	}
}
