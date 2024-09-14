package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.LoginPageObjects;
import commonFunctions.*;

public class LoginPageTestCases extends CommonMain{
	@Test(dataProvider = "myExcelDataRead", dataProviderClass = ExcelDatasRead.class)
	public void LoginMethod(String Uname, String Pword) throws Exception{
		System.out.println("Loginpage testcases Started");
		PageFactory.initElements(driver, LoginPageObjects.class);
		//Using property file
		//		LoginPageObjects.username.sendKeys(property.getProperty("Username"));
		//		LoginPageObjects.password.sendKeys(property.getProperty("Password"));
		//		LoginPageObjects.loginbtn.click();
		//Using Apache POI
		LoginPageObjects.username.sendKeys(Uname);
		LoginPageObjects.password.sendKeys(Pword);
		LoginPageObjects.loginbtn.click();
		TakeScreenshot.myTakeScreenshot("loginpage.png");
		System.out.println("Loginpage testcases success");

	}
}
