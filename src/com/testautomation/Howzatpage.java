package com.testautomation;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Howzatpage extends JGAuto_baseprops {
	
	
	
	private static final Logger logger = Logger.getLogger(Howzatpage.class);
	
	@FindBy(xpath = "//android.view.View[@text='Login']")
	private WebElement loginButton_Element;
	
	
	@FindBy(xpath = "//android.view.View[@text='Download App']")
	private WebElement DownloadButton_Element;
	
	
	@FindBy(xpath = "//android.view.View[@text='Register Now']")
	private WebElement registerButton_Element;
	
	@FindBy(xpath = "//android.widget.Button[@text='Continue']")
	private WebElement continueButton_Element;
	
	
	@FindBy(xpath = "//android.widget.Button[@text='OK']")
	private WebElement OKButton_Element;
	
	/*
	 * @FindBy(xpath = "//android.view.View[@text='Register Now']") private
	 * WebElement registerButton_Element;
	 */
	
	
	
	/**
	 * @author Praveen 
	 *             Launching the Howzat URI in chrome browser
	 * 
	 */
	public void LaunchURI() {
		
		JGAuto_baseprops.drive.get("https://www.howzat.com");
		
	}
	
	
	/**
	 * @author Praveen
	 * @param drive
	 * @throws exception 
	 *             Downloading the howzat app in chrome browser
	 */
	public void download_App() throws InterruptedException {
		
		waitForElement(Howzatpage.drive, DownloadButton_Element);
		DownloadButton_Element.click();
		logger.info("downlolad button is  enabled and clicked");	
		if (continueButton_Element.isDisplayed() || !isEnabled(continueButton_Element)) {
			continueButton_Element.click();
			logger.info("continue button is  enabled and clicked");
			return;
		}
		
		if (OKButton_Element.isDisplayed() || !isEnabled(OKButton_Element)) {
			OKButton_Element.click();
			logger.info("OK button button is  enabled and clicked");
			return;
		}
		
		swipe(driver, "up");
	}
	
	
	/**
	 * @author Praveen
	 * @param drive
	 * @throws exception 
	 *             Registering the user details in  the howzat app in chrome browser
	 */
	public void doResgister() throws InterruptedException {
		
		waitForElement(Howzatpage.drive, registerButton_Element);
		registerButton_Element.click();
		logger.info("register  button is  enabled and clicked");
		
		
	}

}
