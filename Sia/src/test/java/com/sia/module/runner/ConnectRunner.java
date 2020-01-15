
package com.sia.module.runner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;



@CucumberOptions(features = { "classpath:featurefile/ToConnect.feature" }, glue = {
        "classpath:com.sia.module.stepdefinition",
        "classpath:com.cucumber.framework.helper" }, plugin = { "pretty",
        "json:target/ConnectRunner.json" })
public class ConnectRunner extends AbstractTestNGCucumberTests {
}
