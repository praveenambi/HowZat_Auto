package com.testautomation;

import org.testng.annotations.Test;

public class JG_LoginTest extends JGAuto_baseprops {
	Howzatpage howzpage = new Howzatpage();
	@Test()
	public void launchURI() {
		try {
			setupcapabs();
			howzpage.LaunchURI();
			howzpage.download_App();
			howzpage.doResgister();
			drive.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

		
	@Test()
	public void downloadapplication() {



		try {

			howzpage.download_App();

		} catch (Exception e) {

			e.printStackTrace();
		}


	}

	@Test()
	public void resgister() {
		try {

			howzpage.doResgister();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	
	

}

