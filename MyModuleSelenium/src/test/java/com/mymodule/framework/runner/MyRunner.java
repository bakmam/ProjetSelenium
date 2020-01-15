
package com.mymodule.framework.runner;

        import cucumber.api.CucumberOptions;
        import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:featurefile/basket.feature" }, glue = {
        "classpath:com.mymodule.framework.stepdefinition",
        "classpath:com.mymodule.framework.helper" }, plugin = { "pretty",
        "json:target/MyRunner.json" })
public class MyRunner extends AbstractTestNGCucumberTests {
}
