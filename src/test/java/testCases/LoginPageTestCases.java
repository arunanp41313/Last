package testCases;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import pageObjects.LoginPageObjects;
import commonFunctions.*;

public class LoginPageTestCases extends CommonMain{

	@Test(dataProvider = "myExcelDataRead", dataProviderClass = ExcelDatasRead.class)
	public void LoginMethod(String Uname, String Pword) throws Exception{
		ExtentTest LoginMethod_rp=extentrp.createTest("LoginMethod");
		LoginMethod_rp.info("driver passing in LoginPageObjects.class");
		PageFactory.initElements(driver, LoginPageObjects.class);
		//Using Apache POI
		LoginMethod_rp.info("Enter Username");
		LoginPageObjects.username.sendKeys(Uname);
		LoginMethod_rp.info("Enter password");
		LoginPageObjects.password.sendKeys(Pword);
		LoginMethod_rp.info("Click login button");
		LoginPageObjects.loginbtn.click();
		try {
			boolean loginvalidation=LoginPageObjects.loginvalidate.isDisplayed();
			assertEquals(loginvalidation, true);
			String path=TakeScreenshot.myTakeScreenshot("//LoginMethod//LoginMethod.jpg");
			LoginMethod_rp.pass("Login successful", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} catch (Throwable e) {
			String path=TakeScreenshot.myTakeScreenshot("//LoginMethod//LoginMethod.jpg");
			LoginMethod_rp.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
	}


	//	@Test
	//	public void LoginMethod2() throws Exception {
	//		System.out.println("Loginpage testcases Started---2");
	//		PageFactory.initElements(driver, LoginPageObjects.class);
	//		//Using property file
	//		LoginPageObjects.username.sendKeys(property.getProperty("Username"));
	//		LoginPageObjects.password.sendKeys(property.getProperty("Password"));
	//		LoginPageObjects.loginbtn.click();
	//		System.out.println("Loginpage testcases success---2");
	//
	//	}

}
