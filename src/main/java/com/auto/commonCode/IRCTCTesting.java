package com.auto.commonCode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IRCTCTesting {
	
	public static void main(String[] args) throws java.text.ParseException{
		
		By From = By.xpath("//input[@placeholder = 'From*']");
		By To = By.xpath("//input[@placeholder = 'To*']");
		By Date = By.xpath("//input[@placeholder = 'Journey Date(dd-mm-yyyy)*']");
		
		WebDriver driver = null;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:\\ProjectWork\\SOFTWARES\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver(options);
//		driver.get("https://www.irctc.co.in");
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		
		
		/*driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		driver.findElement(From).sendKeys("BHUBANESWAR - BBS");
		driver.findElement(To).sendKeys("BENGALURU CANT - BNC");
		driver.findElement(Date).clear();
		
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar ng-tns-c14-6 ng-star-inserted']/tbody/tr[3]/td[2]")).click();
		*/
		
		
		//table[@class='ui-datepicker-calendar ng-tns-c14-6 ng-star-inserted']/tbody/tr[3]/td[2]
		
		/*Alert alert = driver.switchTo().alert();
		alert.dismiss();*/
		/*List<WebElement> departureTimeWebElement = driver.findElements(By.xpath("//table/tbody/tr/td[6]"));
		List<Date> actualdepartureTimeList = new ArrayList<Date>();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		for(WebElement ele:departureTimeWebElement){
			System.out.println(ele.getText());
			try{
				if(!ele.getText().contains("--")){
					actualdepartureTimeList.add(sdf.parse(ele.getText()));
				}
				
			}catch(ParseException e){
				e.printStackTrace();
			}
		}
		List<Date> expdepartureTimeList = new ArrayList<Date>(actualdepartureTimeList);
		Collections.sort(expdepartureTimeList);
		System.out.println(expdepartureTimeList.equals(actualdepartureTimeList));*/
		
		System.out.println("DEBUG");
		
	}

}
