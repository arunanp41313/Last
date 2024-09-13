package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.LoginPageObjects;
import commonFunctions.*;

public class LoginPageTestCases extends CommonMain{
	@Test
	public void LoginMethod() throws Exception{
		System.out.println(property.getProperty("Username"));
		
		PageFactory.initElements(driver, LoginPageObjects.class);
		LoginPageObjects.username.sendKeys(property.getProperty("Username"));
		LoginPageObjects.password.sendKeys(property.getProperty("Password"));
		LoginPageObjects.loginbtn.click();
		
		TakeScreenshot.myTakeScreenshot("loginpage.png");
		System.out.println("Loginpage success");
		

	}
}
