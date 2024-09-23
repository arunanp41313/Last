package testCases;

import org.testng.annotations.Test;

import commonFunctions.CommonMain;

public class UrlUp extends CommonMain{
	
	@Test
	public void myUrlUp() {
		System.out.println("URL Up starts");
		driver.get(property.getProperty("URL"));
		driver.manage().window().maximize();
		System.out.println("URL Up success");
	}

}
