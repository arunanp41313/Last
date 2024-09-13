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
		SimpleDateFormat dateformat=new SimpleDateFormat("dd_MMM_yy_HH_mm_ss", Locale.ENGLISH);
		String formateddate=dateformat.format(date);
		System.out.println("Folder created Time : " +formateddate);
		String jenkinsWorkspace = System.getenv("WORKSPACE");
		System.out.println("Jenkins Workspace available or Not : " +jenkinsWorkspace);
		//If jenkins Workspace not available
		if (jenkinsWorkspace == null) {
			directory=new File(".//src//test//resources//"+ formateddate);
			System.out.println("Local Directory is available or Not : " +directory.exists());
			if (!directory.exists()) {
				boolean created = directory.mkdirs(); // Create directories recursively
				if (created) {
					System.out.println("Local Directory created path : " + directory.getAbsolutePath());
				} else {
					System.out.println("Failed to create Local directory : " + directory.getAbsolutePath());
				}
			} else {
				System.out.println("Local Directory already exists : " + directory.getAbsolutePath());
			}
		} else { //If Jenkins Workspace available
			directory = new File(jenkinsWorkspace + "//" + formateddate);
			if (!directory.exists()) {
				boolean created = directory.mkdirs(); // Create directories recursively
				if (created) {
					System.out.println("Jenkins Directory created path : " + directory.getAbsolutePath());
				} else {
					System.out.println("Failed to create Jenkins directory : " + directory.getAbsolutePath());
				}
			} else {
				System.out.println("Jenkins Directory already exists : " + directory.getAbsolutePath());
			}
		}
		return directory;
	}
}
