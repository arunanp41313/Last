package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects {
	
	@FindBy(id = "username")
	public static WebElement username;
	
	@FindBy(id = "pwd")
	public static WebElement password;
	
	@FindBy(id = "btnSubmit")
	public static WebElement loginbtn;
	
	@FindBy(partialLinkText  = "EuvDev")
	public static WebElement loginvalidate;
	
}
