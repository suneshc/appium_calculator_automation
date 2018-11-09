package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataprovider.ConfigFileReader;

@RunWith(Suite.class)
@SuiteClasses({AppiumTest.class})

public class BaseTest  {
	
	static WebDriver androidDriver;
	public static WebDriverWait wait;
	static ConfigFileReader objconfigreader = new ConfigFileReader();
	public static String deviceName = objconfigreader.getPropertyValue("deviceName");
	public static String appActivity = objconfigreader.getPropertyValue("appActivity");
	public static String appPackage = objconfigreader.getPropertyValue("appPackage");
	public static String platformVersion = objconfigreader.getPropertyValue("platformVersion");
	public static String platformName = objconfigreader.getPropertyValue("platformName");
	public static String url = objconfigreader.getPropertyValue("url");
	public static String i1=objconfigreader.getPropertyValue("input1");
	public static String i2=objconfigreader.getPropertyValue("input2");
	
	
	public static WebDriver getDriver() {
		return androidDriver;
	}
	
    @BeforeClass
		public  static void setup() throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", deviceName);
		caps.setCapability("platformName", platformName);
		caps.setCapability("platformVersion", platformVersion);
		caps.setCapability("appPackage", appPackage);
		caps.setCapability("appActivity", appActivity);
		caps.setCapability("noReset", "true");
	
		androidDriver = new RemoteWebDriver(new URL(url), caps);
		
		}
    
      
     @AfterClass
     public static void tearDown() {	
		androidDriver.quit();
	  }

}