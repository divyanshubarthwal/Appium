package Rahulshettyacademy.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasics {
	AppiumDriver driver;

	@Test
	public void AppiumTest() throws MalformedURLException{
		//code to start server
		//Appium code-> Appium server->Mobile
		
		//start and stop appium server programatically using AppiumBuilder in cmd 
		//C:\Users\DELL\AppData\Roaming\npm\node_modules\appium\build\lib \main.js
		//path for main.js for appium server
		//download appium inspector to get the locators of elements just like selectorshub
		
		AppiumDriverLocalService service=new AppiumServiceBuilder().withAppiumJS(new File("C://Users//DELL//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		
		service.start();
		
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setDeviceName("Pixel");
		
		options.setApp(System.getProperty("user.dir")+ "/src/test/java/resources/ApiDemos-debug.apk");
	
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		 
		//Actual automation
		//Xpath(By) ,id(By),accessibilityId(AppiumBy),classname(By),androidUIAutomator(AppiumBy)
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		
		driver.quit();
		service.stop();
		//stop server
	}
}
