package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",glue="StepDefinition",monochrome = true,
    plugin = {
        "pretty",
        "json:target/Cucumber.json" ,"pretty",
        "html:target/cucumber-reports"                   
    },
    tags = "@BPP-16164")

public class TestRunner {

}
