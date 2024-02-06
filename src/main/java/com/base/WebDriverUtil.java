package com.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.common.BrowserTypes;
import com.common.Configuration;

public final class WebDriverUtil {
	
	/**
	 * The default implicit wait, in seconds 
	 */
	private static final ThreadLocalDrivers drivers = new ThreadLocalDrivers();
	private static final ActiveDrivers activeDrivers = new ActiveDrivers();
	private static final DriverPresence driverPresence = new DriverPresence();
	
	public static final long DEFAULT_IMPLICIT_WAIT=5;
	
	public static WebDriver driver(){
		return drivers.get().driver;
	}
	
	public static WebDriver establishWebDriver(BrowserTypes browseType){
		if(null==browseType){
			throw new NullPointerException("Browser Type is not allowed to be Null");
		}
		WebDriver webDriver = null;
		DesiredCapabilities capabilities;
		switch(browseType){
		case CHROME:
			System.setProperty("webdriver.chrome.driver",Configuration.CHROME_WEBDRIVER);
			capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setPlatform(Platform.ANY);
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("test-type", "start-maximized", "no-default-browser-check",
                    "--disable-extensions");
			webDriver = new ChromeDriver(chromeOptions);
			break;
		}
		
		/*EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(webDriver);
		eventFiringWebDriver.register(new WebDriverEventListener());*/
		return configureDriver(webDriver,browseType);
	}
	
	private static WebDriver configureDriver(WebDriver webDriver, BrowserTypes browserType){
		WebDriver.Options options = webDriver.manage();
		setImplicitTimeout(webDriver,DEFAULT_IMPLICIT_WAIT);
		options.deleteAllCookies();
		
		activeDrivers.add(webDriver);
		driverPresence.set(true);
		
		return webDriver;
	}
	
	private static void setImplicitTimeout(WebDriver driver, long timeInSeconds){
		driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
	}
	
	private static final class WebDriverPacket{
		private final WebDriver driver;
		private final BrowserTypes browserType;
		private long implicitWait;
		
		WebDriverPacket(WebDriver driver,BrowserTypes browserType){
			this.driver = driver;
			this.browserType = browserType;
			implicitWait = DEFAULT_IMPLICIT_WAIT;
		}
	}
	private static class ThreadLocalDrivers extends ThreadLocal<WebDriverPacket>{
		
		@Override
		protected WebDriverPacket initialValue(){
			BrowserTypes browseType = Configuration.BROWSER;
			WebDriver webDriver = establishWebDriver(browseType);
			return new WebDriverPacket(webDriver,browseType);
		}
	}
	
	private static class ActiveDrivers{
		private final List<WebDriver> drivers = new ArrayList<>();
		
		synchronized void add(WebDriver driver){
			drivers.add(driver);
		}
		
	}
	
	private static class DriverPresence extends ThreadLocal<Boolean>{
		@Override
		protected Boolean initialValue(){
			return Boolean.FALSE;
		}
	}

}
