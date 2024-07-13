package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.After;
import org.junit.Before;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Base_Test {
	
	 protected AppiumDriver<MobileElement> driver;
	    private Properties properties;
	    private Map<String, String> testData;

	    public void loadConfig() throws IOException {
	        properties = new Properties();
	        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
	        properties.load(fis);
	    }

	    public void loadTestData() throws IOException {
	        testData = new HashMap<>();
	        BufferedReader br = new BufferedReader(new FileReader("src/test/resources/testdata.csv"));
	        String line;
	        while ((line = br.readLine()) != null) {
	            String[] values = line.split(",");
	            testData.put(values[0], values[1] + "," + values[2] + "," + values[3]);
	        }
	    }

	    public void setUp(String platform) throws MalformedURLException, IOException {
	        loadConfig();
	        loadTestData();
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, properties.getProperty(platform + ".platform.name"));
	        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, properties.getProperty(platform + ".device.name"));

	        if (platform.equalsIgnoreCase("Android")) {
	            capabilities.setCapability("appPackage", properties.getProperty("android.app.package"));
	            capabilities.setCapability("appActivity", properties.getProperty("android.app.activity"));
	        } else if (platform.equalsIgnoreCase("iOS")) {
	            capabilities.setCapability("bundleId", properties.getProperty("ios.app.bundleId"));
	            capabilities.setCapability("udid", properties.getProperty("ios.udid"));
	        }

	        driver = new AppiumDriver<>(new URL(properties.getProperty("appium.server.url")), capabilities);
	    }

	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }

	    public String getTestData(String key) {
	        return testData.get(key);
	    }

}
