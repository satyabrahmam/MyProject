package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.BasesLoginPage;
import com.training.pom.ChangePasswordPage;
import com.training.pom.MyAccountInfoPage;
import com.training.pom.MyAccountPage;
import com.training.pom.OrderHistoryPage;
import com.training.pom.UserLoginPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_004 {
	private WebDriver driver;
	private String baseUrl;
	private BasesLoginPage baseLoginPage ;
	private UserLoginPage userLoginPage;
	private MyAccountPage myAccountPage;
	private static Properties properties;
	private ChangePasswordPage changePasswordPage;
	private MyAccountInfoPage myAccountInfoPage;
	private OrderHistoryPage orderHistoryPage;
	private ScreenShot screenShot;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseLoginPage = new BasesLoginPage(driver); 
		userLoginPage = new UserLoginPage(driver);
		myAccountPage = new MyAccountPage(driver);
		myAccountInfoPage = new MyAccountInfoPage(driver);
		changePasswordPage = new ChangePasswordPage(driver);
		orderHistoryPage = new OrderHistoryPage(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void viewOrderDetails()
	{
		baseLoginPage.accountDropdownBtn();
		userLoginPage.sendUserName("manzoor@gmail.com");
		userLoginPage.sendPassword("Newcall@18");
		userLoginPage.clickLoginBtn();
		screenShot.captureScreenShot();
		Actions action = new Actions(driver);		
		action.moveToElement(baseLoginPage.accountDropdown).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(baseLoginPage.ordersLink)).click();
		screenShot.captureScreenShot();
		orderHistoryPage.clickviewIconImg();
		screenShot.captureScreenShot();
		if(driver.getTitle() == "Order Information")
		{
			System.out.println("Test case Success");
		}
		
		
	}	
}
