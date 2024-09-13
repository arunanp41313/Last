package commonFunctions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunch extends CommonMain{
	public static WebDriver driver;

	public static WebDriver myBrowserLaunch() throws IOException {
	
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
			System.out.println("URL not Found or Browser not UP!!!");
		}
		return driver;
	}
	
}
