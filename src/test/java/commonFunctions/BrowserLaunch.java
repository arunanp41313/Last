package commonFunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

public class BrowserLaunch {
	public static WebDriver driver;
	public static Properties property;
	public static File directory;

	@BeforeSuite
	public void browserandpropertyLaunch() throws IOException {
		
		try {
			directory	=FolderCreation.myFolderCreation();
		} catch (Exception e) {
			System.out.println("!!!!");
		}
		
		
		try {
			 property = ConfigPropertyFileLoad.myConfigPropertyFileLoad();
		} catch (Exception e) {
			System.out.println("????");
		}

		

		try {
			switch (property.getProperty("Browser").toLowerCase()) {
			case "chrome":
				driver= new ChromeDriver();
				driver.get(property.getProperty("URL"));
				driver.manage().window().maximize();
				break;
			case "edge":
				driver=new EdgeDriver();
				driver.get(property.getProperty("URL"));
				driver.manage().window().maximize();
				break;	
			case "firefox":
				driver=new FirefoxDriver();
				driver.get(property.getProperty("URL"));
				driver.manage().window().maximize();
				break;
			default:
				driver= new ChromeDriver();
				driver.get(property.getProperty("URL"));
				driver.manage().window().maximize();
				break;
			}
		} catch (Exception e) {
			System.out.println("URL not Found!!!");
		}
	}
	
}
