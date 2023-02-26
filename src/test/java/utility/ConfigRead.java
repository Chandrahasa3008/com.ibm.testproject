package utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigRead {
	Properties prop;

	public ConfigRead() throws Exception {

		FileInputStream fis = new FileInputStream("./testData/config.properties");

		prop = new Properties();

		prop.load(fis);

	}

	public String getAppURL(String url) {

		return prop.getProperty(url);

	}
	
	
	public String getSampleAppURL() {

		return prop.getProperty("appURL_sample");

	}

	public String getBrowser() {

		return prop.getProperty("browser");

	}

	
	
	public String getAdminUser(String username) {

		return prop.getProperty(username);

	}

	public String getAdminPass(String password) {

		return prop.getProperty(password);

	}
}
