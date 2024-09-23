package commonFunctions;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentsReports extends CommonMain{
	public static ExtentReports extentrp;

	public static ExtentReports myExtentsReports() throws Exception {
		extentrp = new ExtentReports();
		System.out.println(directory);
		File exfile= new File(directory+"//reportsfolder//Myreport.html");
		ExtentSparkReporter sparkrp = new ExtentSparkReporter(exfile);
		extentrp.attachReporter(sparkrp);
		return extentrp;

		//The file create after flush only.!!!!!!!!!
		//		extentrp.flush();
		//		System.out.println(exfile.exists());
	}

}
