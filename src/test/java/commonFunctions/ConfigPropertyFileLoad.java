package commonFunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertyFileLoad {
	public static Properties property;

	public static  Properties myConfigPropertyFileLoad() throws Exception {
		try {
			File file=new File("./src/test/resources/Config.properties");
								
			System.out.println("Config.Properties file is available : " +file.exists());
			FileInputStream stream=new FileInputStream(file);
			property=new Properties();
			property.load(stream);
		} catch (FileNotFoundException e) {
			System.out.println("Config.Properties file not Found!!!");
		}
		return property;
	}
}
