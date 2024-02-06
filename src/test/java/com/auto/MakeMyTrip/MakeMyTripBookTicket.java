package com.auto.MakeMyTrip;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MakeMyTripBookTicket {

	WebDriver driver = null;
	MakemyTripHomePage makemyTripHomePage = null;

	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\ChromeDriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void bookTicket() throws InterruptedException {

		makemyTripHomePage = new MakemyTripHomePage();
		makemyTripHomePage.BookTicket(driver);

	}
	
	@After
	public void tearDown() throws Exception {

		driver.quit();
	}

}
