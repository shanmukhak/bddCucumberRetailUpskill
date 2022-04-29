package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",
glue = {"stepDefinitions","pages"},
dryRun=false,
monochrome = true,
plugin = {"pretty","html:reports/htmlreport","json:reports/jsonreport.json","junit:reports/xmlreport.xml"})

public class TestRunner {

}
