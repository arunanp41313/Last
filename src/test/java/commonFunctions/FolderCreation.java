package commonFunctions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.testng.annotations.Test;

public class FolderCreation {
	public static File directory;

	public static File  myFolderCreation() {

		Date date= new Date();
		SimpleDateFormat dateformat=new SimpleDateFormat("dd_MMM_yy_HHmmss", Locale.ENGLISH);
		String formateddate=dateformat.format(date);
		System.out.println(formateddate);
		String jenkinsWorkspace = System.getenv("WORKSPACE");
		System.out.println(jenkinsWorkspace);
		//If jenkins Workspace not available
		if (jenkinsWorkspace == null) {
			directory=new File(".//src//test//resources//"+ formateddate);
			System.out.println("folder is available : " +directory.exists());
			if (!directory.exists()) {
				boolean created = directory.mkdirs(); // Create directories recursively
				if (created) {
					System.out.println("Directory created: " + directory.getAbsolutePath());
				} else {
					System.out.println("Failed to create directory: " + directory.getAbsolutePath());
				}
			} else {
				System.out.println("Directory already exists: " + directory.getAbsolutePath());
			}
		} else { //If Jenkins Workspace available
			directory = new File(jenkinsWorkspace + "//" + formateddate);
			if (!directory.exists()) {
				boolean created = directory.mkdirs(); // Create directories recursively
				if (created) {
					System.out.println("Directory created: " + directory.getAbsolutePath());
				} else {
					System.out.println("Failed to create directory: " + directory.getAbsolutePath());
				}
			} else {
				System.out.println("Directory already exists: " + directory.getAbsolutePath());
			}
		}
		return directory;
	}
}
