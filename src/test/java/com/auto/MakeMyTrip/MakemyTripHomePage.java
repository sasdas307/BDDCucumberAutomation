package com.auto.MakeMyTrip;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakemyTripHomePage {

	By loginOrCreateAccount = By.xpath("//li[@data-cy='account']");
	By userName = By.xpath("//input[@id='username']");
	By googleLogin = By.xpath("//div[@data-cy='googleLogin']");
	By googleUsername = By.xpath("//input[@autocomplete='username']");

	By next = By.xpath("//*[@id='identifierNext']/div/button");
	By password = By.xpath("//input[@type='password']");

	By loginPopup = By.xpath("//p[text()='Login/Signup for Best Prices']");
	By flights = By.xpath("//li[@data-cy='menu_Flights']");
	By roundTrip = By.xpath("//li[@data-cy='roundTrip']");

	By fromCity = By.xpath("//input[@data-cy='fromCity']");
	By toCity = By.xpath("//input[@data-cy='toCity']");
	By departure = By.xpath("//input[@data-cy='departure']");
	By returnDate = By.xpath("//input[@data-cy='return']");
	By travellers = By.id("travellers");
	By travellersApply = By.xpath("//button[@data-cy='travellerApplyBtn']");

	String adultObj = "//p[@data-cy='adultRange']/following-sibling::ul[starts-with(@class, 'guestCounter font12')]";
	String childObj = "//p[@data-cy='childrenRange']/following-sibling::ul[starts-with(@class, 'guestCounter font12')]";

	By search = By.xpath("//p[@data-cy='submit']/a");
	By nonStopFilter = By.xpath("//p[text()='Popular Filters']/../div//span[@title='Non Stop']");
	By bookNow = By.xpath("//button[text()='Book Now']");
	By continueButton = By.xpath("//button[text()='Continue']");

	public WebElement waitForElement(WebDriver driver, By by) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		WebElement webElement = driver.findElement(by);
		wait.until(ExpectedConditions.visibilityOf(webElement));
		return webElement;
	}

	public void BookTicket(WebDriver driver) {

		String FromCity = "Delhi";
		String ToCity = "Bengaluru";
		boolean isReviewPageDisplayed = false;

		SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd yyyy");
		Date date = new Date();
		String fromDate = formatter.format(date);

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		Date targetDate = cal.getTime();
		String toDate = formatter.format(targetDate);

		// Handle login pop up
		if (driver.findElements(loginPopup).size() > 0) {
			driver.findElement(loginOrCreateAccount).click();
		}
		
		//Enter Trip Details
		driver.findElement(roundTrip).click();
		driver.findElement(fromCity).sendKeys(FromCity);
		driver.findElement(fromCity).sendKeys(Keys.ENTER);
		waitForElement(driver, toCity).sendKeys(ToCity);
		driver.findElement(toCity).sendKeys(Keys.ENTER);
		driver.findElement(toCity).sendKeys(Keys.ESCAPE);

		//Select Date details
		driver.findElement(departure).sendKeys(Keys.ENTER);
		if (driver.findElements(By.xpath("//div[@aria-label='" + fromDate + "']")).size() > 0) {
			driver.findElement(By.xpath("//div[@aria-label='" + fromDate + "']")).click();
		} else {
			assertTrue("Departure 'From Date' could not be selected successfully", false);
		}

		driver.findElement(returnDate).sendKeys(Keys.ENTER);
		if (driver.findElements(By.xpath("//div[@aria-label='" + toDate + "']")).size() > 0) {
			driver.findElement(By.xpath("//div[@aria-label='" + toDate + "']")).click();
		} else {
			assertTrue("Departure 'Return Date' could not be selected successfully", false);
		}

		//Enter traveller details
		driver.findElement(travellers).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(adultObj + "/li[text()='2']")).click();
		driver.findElement(By.xpath(childObj + "/li[text()='1']")).click();
		driver.findElement(travellersApply).click();

		try {
			driver.findElement(search).click();
		} catch (TimeoutException te) {
			if (!driver.findElement(By.xpath("//p[contains(text(),'Flights from')]")).isDisplayed()) {
				assertTrue("Something went wrong, Search Itinerary page is not displayed", false);
			}
			te.printStackTrace();
		}

		//Choose Non stop filter option and continue
		driver.findElement(nonStopFilter).click();
		driver.findElement(bookNow).click();
		waitForElement(driver, continueButton).click();

		Set<String> windowHandles = driver.getWindowHandles();

		for (String eachWindow : windowHandles) {
			if (driver.switchTo().window(eachWindow).getCurrentUrl().contains("review")) {
				isReviewPageDisplayed = true;
				break;
			}

		}
		assertTrue("Something went wrong, 'Review Your Booking' page is not displayed", isReviewPageDisplayed);

	}

}
