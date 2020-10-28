package com.testautomation;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.remote.MobileCapabilityType;

public class JGAuto_baseprops {
	

	

	@SuppressWarnings("rawtypes")
	private static ThreadLocal<AndroidDriver> appiumDriver = new ThreadLocal<>();
	protected static AndroidDriver<MobileElement> driver;
	static WebDriver drive;
	public ExtentReports extent;
	public ExtentTest parentTest;
	public ExtentTest childTest;
	private Map<Long, ExtentTest> parentContext = new HashMap<Long, ExtentTest>();
	//private static final Logger logger = Logger.getLogger(ProfilePage.class);
	public static final String screenCapturePath = "/TestResult/screenshots";
	int totalTests = 0;
	int failedTests = 0;
	int passedTests = 0;
	int skippedTests = 0;
	int timeout = 10;

	@AndroidFindBy(id = "login_button")
	private WebElement login_Button;

	public static AndroidDriver getDriver() {
		return appiumDriver.get();
	}

	protected static void setDriver(AndroidDriver driver) {
		appiumDriver.set(driver);
	}

	@BeforeSuite
	public void setupcapabs() throws Exception {
		deleteScreenShotDirectory();
		File classRootPath = new File(System.getProperty("user.dir"));
		//String appType= String.valueOf(commonUtils.getAppType());
		//File app = new File(classRootPath, appType+".apk");
		//File app = new File("./APK/fobber-preprod_-amap_-inhouse.apk");
		DesiredCapabilities capability = new DesiredCapabilities();
		
			//capability.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());	
		
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		capability.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S7" );
		capability.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
		capability.setCapability("automationName", "appium");
		//capability.setCapability(MobileCapabilityType.APP_PACKAGE, "");
		//capability.setCapability(MobileCapabilityType.APP_ACTIVITY,"com.daimler.mm.android.onboarding.appstart.AppStartActivity");
		capability.setCapability(CapabilityType.SUPPORTS_LOCATION_CONTEXT, true);
		//capability.setCapability("fastReset", true);
		capability.setCapability("newCommandTimeout", 120);
		capability.setCapability(MobileCapabilityType.SELENDROID_PORT, "8080");
		capability.setCapability("noReset", true);
		//System.setProperty("webdriver.chrome.driver","./driversfiles/chromedriver.exe");
		drive = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		//logger.info("Session ID from application class is: " + driver.getSessionId());
		//logger.info(driver.getCapabilities() + " is the driver capability");
		//logger.info(Thread.currentThread().getId() + " from application class");
		System.out.println("base proeprtis is working now ");
		
	}

	
	
	public void waitForElement(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
	}

	
	public void recentApps(AndroidDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		driver.pressKeyCode(187);
		Thread.sleep(2000);
		driver.pressKeyCode(187);
		Thread.sleep(2000);
		
	}
	/*
	 * Wait for list of all the elements to exists in a page
	 */
	public void waitForElements(WebDriver driver, List<WebElement> elements) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	
	/*
	 * Capture screenshots
	 */
	public void captureScreenshot(WebDriver driver, String ImageName) throws Exception {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(screenCapturePath + ImageName + ".png"));
	}

	
	/*
	 * WebDriver wait for visibility
	 */
	public void explicitWaitDisappear(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	
	
	
	/*
	 * Find element on UI
	 */
	public boolean isEnabled(WebElement element) {
		boolean check = false;
		try {
			check = element.isEnabled();
		} catch (Exception e) {
			check = false;
		}
		return check;
	}
	
	
	
	@SuppressWarnings("rawtypes")
	public void swipe(AppiumDriver driver, String direction) throws InterruptedException {
		Dimension dimension = driver.manage().window().getSize();
		int width = dimension.getWidth();
		int height = dimension.getHeight();
		switch (direction) {
		case "right":
			driver.swipe((int) (width * (0.1)), (int) (height * (0.5)), (int) (width * (0.9)), (int) (height * (0.5)),
					800);
			break;
		case "left":
			driver.swipe((int) (width * (0.9)), (int) (height * (0.6)), (int) (width * (0.1)), (int) (height * (0.6)),
					800);
			break;
		case "up":
			driver.swipe((int) (width * (0.5)), (int) (height * (0.90)), (int) (width * (0.5)), (int) (height * (0.20)),
					800);
			break;
		case "down":
			driver.swipe((int) (width * (0.5)), (int) (height * (0.20)), (int) (width * (0.5)), (int) (height * (0.90)),
					800);
			break;
		default:
			break;
		}
		Thread.sleep(1000);
	}

	protected String getStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);
		return sw.toString();
	}
	
	private void deleteScreenShotDirectory() {
        File dir = new File("./TestResult/screenshots");
		
		if(dir.isDirectory() == false) {
			System.out.println("Not a directory. Do nothing");
			return;
		}
		File[] listFiles = dir.listFiles();
		for(File file : listFiles){
			System.out.println("Deleting "+file.getName());
			file.delete();
		}
		//now directory is empty, so we can delete it
		System.out.println("Deleting Directory. Success = "+dir.delete());
	}
	
	
	public static String runcommand(String command){
		
		String output=null;
		try{
			Scanner scan = new Scanner(Runtime.getRuntime().exec(command).getInputStream()).useDelimiter("//A");			
		}
		catch (IOException e){
			throw new RuntimeException(e.getMessage());	
		}
		return output;	
	}
	
	

	
}
