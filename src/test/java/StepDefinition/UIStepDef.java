package StepDefinition;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.amazon.web.page.LoginPage;
import com.base.WebDriverUtil;
import com.base.auto.AbstractPage;
import com.maps.ApplicationData;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;

public class UIStepDef {
	
	LoginPage loginPage = null;
	
	@Given("^the user is on sauce demo Home Page$")
	public void sauceDemoHomePage() throws Throwable {
		WebDriverUtil.driver().get(ApplicationData.dataMap.get("APPLICATION_URL"));
		loginPage = AbstractPage.install(LoginPage.class);
		
		
	}
	@Given("^the user enters username as \"([^\"]*)\"$")
	public void the_user_enters_user_name_as(String arg1) throws Throwable {
		WebDriverUtil.driver().findElement(By.id("user-name")).sendKeys(arg1);
	}
	
	@Given("^the user enters password as \"([^\"]*)\"$")
	public void the_user_enters_password_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverUtil.driver().findElement(By.id("password")).sendKeys(arg1);
		WebDriverUtil.driver().findElement(By.id("login-button")).click();
		
	}

	@Then("^the user should verify sauce demo home page$")
	public void the_user_should_verify_sauce_demo_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		boolean bStatus = WebDriverUtil.driver().findElement(By.className("app_logo")).isDisplayed();
		Assert.assertTrue("Login failed", bStatus);
		
	}
	
	private void initializeTestEnvironmentData(){
		
	}
}
