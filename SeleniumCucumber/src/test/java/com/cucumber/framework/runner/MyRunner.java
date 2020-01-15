
package com.cucumber.framework.runner;

        import cucumber.api.CucumberOptions;
        import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:featurefile/basket.feature" }, glue = {
        "classpath:com.cucumber.framework.stepdefinition",
        "classpath:com.cucumber.framework.helper" }, plugin = { "pretty",
        "json:target/MyRunner.json" })
public class MyRunner extends AbstractTestNGCucumberTests {
}
