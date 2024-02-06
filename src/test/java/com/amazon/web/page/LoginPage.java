package com.amazon.web.page;

import org.openqa.selenium.By;

import com.base.PageBase;

public class LoginPage extends PageBase{
	
	By userName = By.xpath("//span[(text()='Hello. Sign in')]");
	
	
	@Override
	protected By defineUniqueElement(){
		return userName;
	}
	
	public void enterUserName() {
		
	}

}
