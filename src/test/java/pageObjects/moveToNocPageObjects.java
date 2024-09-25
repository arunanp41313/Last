package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class moveToNocPageObjects {
	
	@FindBy(id = "SelectedClientId")
	public static WebElement clientname;
	
	@FindBy(id = "SelectedRole")
	public static WebElement rolename;
	
	@FindBy(xpath = "//option[@value='NOC Administrator']")
	public static WebElement rolename_noc;

}
