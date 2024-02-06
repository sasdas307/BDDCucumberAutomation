package StepDefinition;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import com.base.WebDriverUtil;
import com.common.Configuration;
import com.common.DataMaps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

//import cucumber.api.Scenario;
//import cucumber.api.java.Before;

public class Hooks {

	@Before
	public void onSetup(Scenario scenario){
		DataMaps.outputmap.put("currentScenario", scenario);
		if("WebTester".equals(Configuration.TESTER_TYPE)){
			WebDriverUtil.driver().manage().window().setSize(new Dimension(1600, 900));
			WebDriverUtil.driver().manage().window().setPosition(new Point(0, 0));
		}
		
	}

}
