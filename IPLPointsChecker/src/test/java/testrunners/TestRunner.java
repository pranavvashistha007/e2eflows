package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/features", // path to .feature file
glue = {"stepdefinitions", "hooks"}, // package of step defs
tags = "@nowrun", // optional: filter scenarios
plugin = {
        "pretty",
        "html:target/cucumber-html-report",
        "json:target/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    },
	monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests{
	
}
