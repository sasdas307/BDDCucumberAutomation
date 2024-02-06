package com.base.auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;

import com.base.WebDriverUtil;

public abstract class AbstractPage {
	
	public AbstractPage(){
		
	}
	
	public static <P extends AbstractPage> P install(Class<P> pageClazz){
		P page = instantiateOrThrow(pageClazz);
		
		WebDriver driver = WebDriverUtil.driver();
		PageFactory.initElements(driver, page);
		//initElementsWithinInternalClasses -- TO DO
		page.waitForPageLoad();
		
		return page;
		
	}
	
	private static <P extends AbstractPage> P instantiateOrThrow(Class<P> pageClazz) {

		try {
			return pageClazz.newInstance();
		} catch (WebDriverException wdue) {
			throw wdue;
		} catch (Exception e) {
			throw new PageObjectInstantiationException(pageClazz, e);
		}
	}

	public static class PageObjectInstantiationException extends RuntimeException {
		private PageObjectInstantiationException(Class<?> pageClazz, Throwable cause) {
			super("Failed to instantiate page: " + pageClazz, cause);
		}
	}
	
	public void waitForPageLoad(){
		By locator = defineUniqueElement();
		//waitForElementVisible - TO Implement
	}
	
	protected abstract By defineUniqueElement();
	
}
