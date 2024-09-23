package commonFunctions;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;

public class CommonMain {
	public static Properties property;
	public static File directory;
	public static WebDriver driver;
	public static ExtentReports extentrp;

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
		//for extents reports
		try {
			System.out.println("extent report method started");
			extentrp= ExtentsReports.myExtentsReports();
		} catch (Exception e) {
			System.out.println("extent report method failed");
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

	@AfterSuite
	public void quit() throws Exception {
		//driver.quit();
		System.out.println("-------------------------Driver.quite----------------------------");
		extentrp.flush();
		//Desktop.getDesktop().browse(new File(directory+"//reportsfolder//Myreport.html").toURI());
	}

}
