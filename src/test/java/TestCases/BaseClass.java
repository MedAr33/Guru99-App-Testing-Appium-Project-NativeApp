package TestCases;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.internal.TestNGClassFinder;
import org.testng.internal.annotations.TestAnnotation;

import com.aventstack.extentreports.model.Test;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	public static AndroidDriver<AndroidElement> driver;
	public static AppiumDriverLocalService service;
	public static final Logger logger =LogManager.getLogger(TestAnnotation.class.getName());
	
	@BeforeClass
	public void beforeClass() throws IOException, InterruptedException {
		
		service = startServer();
		// startEmulator();

		DesiredCapabilities capabilities = new DesiredCapabilities();

		// capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "myEmulator");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability("uiautomator2ServerLaunchTimeout", 100000);

		capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "\\Guru99App.apk");
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

	}

	@AfterClass
	public void afterClass() {
		service.stop();
	}

	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException {
		// taskkill /F /IM node.exe
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);

	}

	public AppiumDriverLocalService startServer() {
		//
		boolean flag = checkIfServerIsRunnning(4723);
		if (!flag) {

			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;

	}

	public static boolean checkIfServerIsRunnning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);

			serverSocket.close();
		} catch (IOException e) {
			// If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public static void startEmulator() throws IOException, InterruptedException {

		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\startEmulator.bat");
		Thread.sleep(120000);
	}

	public static AndroidElement scrollTo(String visibleText) {
		return driver.findElementByAndroidUIAutomator(
				"" + "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
						+ "new UiSelector().textContains(\"" + visibleText + "\").instance(0))");
	}
	
	public void captureScreen(AndroidDriver driver, String tcname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/screenshots/" + tcname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}