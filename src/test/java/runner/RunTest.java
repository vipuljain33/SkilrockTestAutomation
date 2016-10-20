package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty","json:target/cucumberreports.json"},
glue="stepDefinitions",
features="src\\test\\resources\\features",
tags={"@invalid"},
monochrome=false)
public class RunTest {

}
