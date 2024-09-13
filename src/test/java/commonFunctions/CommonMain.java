package commonFunctions;

import java.io.File;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

public class CommonMain {
	public static Properties property;
	public static File directory;
	public static WebDriver driver;

	@BeforeSuite
	public static void myCommonMain() {
		//For folder creation method
		try {
			directory	=FolderCreation.myFolderCreation();
			System.out.println("Folder creation method Success");
		} catch (Exception e) {
			System.out.println("Folder creation method failed");
		}
		//For property filr load method
		try {
			property = ConfigPropertyFileLoad.myConfigPropertyFileLoad();
			System.out.println("Property file load method Success");
		} catch (Exception e) {
			System.out.println("Property file load method failed");
		}
		//For browser launch
		try {
			driver =BrowserLaunch.myBrowserLaunch();
			System.out.println("Browser launching method Success");
		} catch (Exception e) {
			System.out.println("Browser launching method failed");
		}
	}

}
