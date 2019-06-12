package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.BasesLoginPage;
import com.training.pom.ChangePasswordPage;
import com.training.pom.LoginPOM;
import com.training.pom.MyAccountPage;
import com.training.pom.UserLoginPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_006 {
	
	private WebDriver driver;
	private String baseUrl;
	private BasesLoginPage baseLoginPage ;
	private UserLoginPage userLoginPage;
	private MyAccountPage myAccountPage;
	private static Properties properties;
	private ChangePasswordPage changePasswordPage;
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
		changePasswordPage = new ChangePasswordPage(driver);
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
	public void changePasswordTest() {
		baseLoginPage.accountDropdownBtn();
		userLoginPage.sendUserName("a.satyabrahmam@gmail.com");
		userLoginPage.sendPassword("Newcall@18");
		userLoginPage.clickLoginBtn();
		screenShot.captureScreenShot();
		myAccountPage.clickChangePasswordLink();
		screenShot.captureScreenShot();
		changePasswordPage.sendNewPassword("Newcall@19");
		changePasswordPage.sendConfirmPassword("Newcall@19");
		screenShot.captureScreenShot();
		changePasswordPage.clickcontinueBtn();
		screenShot.captureScreenShot();
		if(myAccountPage.isPasswordChangeMessageDisplay())
		{
			System.out.println("Test Case Passed");
		}
		
		
	}

}
