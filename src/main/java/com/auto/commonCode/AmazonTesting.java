package com.auto.commonCode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.common.Configuration;

public class AmazonTesting {
	public static void main(String[] args){
		
		System.out.println(Configuration.BROWSER);
		/*WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "C:\\ProjectWork\\SOFTWARES\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();*/
		/*driver.get("https://www.amazon.in");
		By AllDropDown = By.id("searchDropdownBox");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(AllDropDown)).build().perform();
		
		List<WebElement> dropdownOptions = driver.findElements(By.xpath("//select[@id='searchDropdownBox']/option"));
		
		for(WebElement ele: dropdownOptions){
			if(ele.getText().equals("Books")){
				ele.click();
			}
		}
		
		//Select from suggestion box
//		driver.findElement(By.name("site-search")).click();
//		driver.findElement(By.name("site-search")).sendKeys("Java");
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.name("site-search"))).build().perform();
//		driver.findElement(By.name("site-search")).sendKeys("Java");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java");
		Thread.sleep(2000);
		List<WebElement> suggestionList = driver.findElements(By.xpath("//div[@id='suggestions']/div"));
		for(WebElement ele: suggestionList){
			if(ele.getAttribute("data-keyword").equals("java 10th edition")){
				ele.click();
				break;
			}
		}
		driver.findElement(By.xpath("//span[text()='Java - The Complete Reference']/parent::a")).click();
		Set<String> listOfHandles = driver.getWindowHandles();
		for(String eachHandle:listOfHandles){
			driver.switchTo().window(eachHandle);
			if(driver.getTitle().contains("Java - The Complete Reference")){
				break;
			}
		}
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(1000);
		List<WebElement> priceListElement = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		List<Integer> actualPriceList = new ArrayList<Integer>();
		
		for(WebElement price:priceListElement){
			try{
				int i = Integer.parseInt(price.getText());
				actualPriceList.add(Integer.valueOf(i));
			}catch(NumberFormatException ne){
//				System.out.println(ne.getMessage());
			}
		}
		List<Integer> expPriceList = new ArrayList<Integer>(actualPriceList);
		
		Collections.sort(expPriceList);*/
		
		
		System.out.println("DEBUG");
		
	}

}
