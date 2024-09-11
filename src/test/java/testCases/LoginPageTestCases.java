package testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.LoginPageObjects;
import commonFunctions.*;

public class LoginPageTestCases extends BrowserLaunch{
	@Test
	public void LoginMethod() throws IOException{
		PageFactory.initElements(driver, LoginPageObjects.class);
		LoginPageObjects.username.sendKeys(property.getProperty("Username"));
		LoginPageObjects.password.sendKeys(property.getProperty("Password"));
		LoginPageObjects.loginbtn.click();
		
		//METHOD-- 1 ( It requires common.io dependency for using fileutils
			TakesScreenshot screenshot= (TakesScreenshot) driver;
			File sourcefile= screenshot.getScreenshotAs(OutputType.FILE);
			File destinationfile= new File(directory+ "//screenshot1.jpg");
			FileUtils.copyFile(sourcefile, destinationfile);

	}
}
