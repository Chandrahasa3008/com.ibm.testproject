package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigRead {
	Properties prop;

	public ConfigRead() throws Exception {

		FileInputStream fis = new FileInputStream("./testData/config.properties");

		prop = new Properties();

		prop.load(fis);

	}

	public String getAppURL() {

		return prop.getProperty("app_url");

	}
	
	
	public String getSampleAppURL() {

		return prop.getProperty("appURL_sample");

	}

	public String getBrowser() {

		return prop.getProperty("browser");

	}

	
	
	public String getAdminUser() {

		return prop.getProperty("userName");

	}

	public String getAdminPass() {

		return prop.getProperty("password");

	}
}
