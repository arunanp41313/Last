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
			System.out.println("Folder creation method Started");
			directory	=FolderCreation.myFolderCreation();
			System.out.println("Folder creation method Success");
		} catch (Exception e) {
			System.out.println("Folder creation method failed");
		}
		//For property filr load method
		try {
			System.out.println("Property file load method Started");
			property = ConfigPropertyFileLoad.myConfigPropertyFileLoad();
			System.out.println("Property file load method Success");
		} catch (Exception e) {
			System.out.println("Property file load method failed");
		}
		//foe extents reports
		System.out.println("extent report starts");
		try {
			ExtentsReports.myExtentsReports();
		} catch (Exception e) {
			System.out.println("extent report failed");
		}
		//For browser launch
		try {
			System.out.println("Browser launching method Started");
			driver =BrowserLaunch.myBrowserLaunch();
			System.out.println("Browser launching method Success");
		} catch (Exception e) {
			System.out.println("Browser launching method failed");
		}
	}

}
