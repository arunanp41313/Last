package commonFunctions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TakeScreenshot extends CommonMain{
	
	public static String myTakeScreenshot(String SSname) throws Exception {
		String filepath = null;
		try {
			System.out.println("Screenshot taken Started");
			//METHOD-- 1 ( It requires common.io dependency for using fileutils
			TakesScreenshot screenshot= (TakesScreenshot) driver;
			File sourcefile= screenshot.getScreenshotAs(OutputType.FILE);
			File destinationfile= new File(directory+SSname);
			FileUtils.copyFile(sourcefile, destinationfile);
			 filepath=destinationfile.getAbsolutePath();
			System.out.println("Screenshot taken Path :" + filepath);
			System.out.println("Screenshot taken successful");
		} catch (Exception e) {
			System.out.println("Screen Shot taken failed");
		}
		return filepath;
	}
}
