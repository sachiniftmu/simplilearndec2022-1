package com.bdd.runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/java/FeatureFiles/" }, plugin = { "pretty", "html:target/cucumber-reports",
		"json:target/cucumber-reports/Cucumber.json" }, glue = "com.bdd.test.scenarios", tags = { "@smoke",
				"not @regression" })
public class LoginModuleRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
