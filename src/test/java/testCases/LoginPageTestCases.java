package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import com.aventstack.extentreports.ExtentTest;

import pageObjects.LoginPageObjects;
import commonFunctions.*;

public class LoginPageTestCases extends CommonMain{

	@Test(dataProvider = "myExcelDataRead", dataProviderClass = ExcelDatasRead.class)
	public void LoginMethod(String Uname, String Pword) throws Exception{
			System.out.println("Loginpage testcases Started---");
			PageFactory.initElements(driver, LoginPageObjects.class);
			//Using Apache POI
			LoginPageObjects.username.sendKeys(Uname);
			LoginPageObjects.password.sendKeys(Pword);
			LoginPageObjects.loginbtn.click();
			System.out.println("Loginpage testcases success---");
			//TakeScreenshot.myTakeScreenshot("//Loginpage//loginpage.jpg");
			//Assert.assertTrue(false);
	}
	
	
	
	//reports handles
	@Test
	public void loginTestTwo() {
		ExtentTest t1=extentrp.createTest("jhgjgjgju");
		t1.info("start1");
		try {
				Assert.assertTrue(false);		
			//driver.findElement(By.id("dee")).click();
		} catch (Throwable e) {
			t1.info("start2");
			t1.fail(e);
			System.out.println("Test 2 failed---------");
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
