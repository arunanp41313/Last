package commonFunctions;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentsReports extends CommonMain{

	public static void myExtentsReports() throws Exception {
		ExtentReports extentrp = new ExtentReports();
		System.out.println(directory);
		File exfile= new File(directory+"//reportsfolder//mytest.html");
		//exfile.mkdirs();
		ExtentSparkReporter sparkrp = new ExtentSparkReporter(exfile);
		extentrp.attachReporter(sparkrp);
		System.out.println(exfile.exists());
		
		
		extentrp.flush();	
	}

}
