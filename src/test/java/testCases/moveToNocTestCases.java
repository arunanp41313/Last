package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import commonFunctions.CommonMain;
import pageObjects.moveToNocPageObjects;

public class moveToNocTestCases extends CommonMain{

	@Test
	public void moveToNocMethod() {
		ExtentTest moveToNocMethod_rp=extentrp.createTest("moveToNocMethod");
		moveToNocMethod_rp.info("driver passing in moveToNocPageObjects.class");
		PageFactory.initElements(driver, moveToNocPageObjects.class);
		//		String name=moveToNocPageObjects.clientname.getText();
		//		System.out.println(name);
		
		//Select Client
		String Selected_attribute_clientname=moveToNocPageObjects.clientname.findElement(By.xpath("//option[@value='1']")).getAttribute("selected");
		if (Selected_attribute_clientname == null) {
			moveToNocMethod_rp.info("Try to select anunta");
			System.out.println("Try to select anunta");
			Select s=new Select(moveToNocPageObjects.clientname);
			s.selectByValue("1");
			System.out.println("anunta client is selected");
		} else {
			moveToNocMethod_rp.info("anunta client was already selected");
			System.out.println("anunta client is already selected");
		}

		//Select Role
		String Selected_attribute_rolename=moveToNocPageObjects.rolename.findElement(By.xpath("//option[@value='NOC Administrator']")).getAttribute("selected");
		if (Selected_attribute_rolename == null) {
			moveToNocMethod_rp.info("Try to select Noc Admin");
			System.out.println("Try to select Noc Admin");
			Select s=new Select(moveToNocPageObjects.rolename);
			s.selectByValue("NOC Administrator");
			System.out.println("Noc Admin role is selected");
		} else {
			moveToNocMethod_rp.info("Noc Admin role was already selected");
			System.out.println("Noc admin role is already selected");
		}
	}

}
