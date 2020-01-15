package com.sia.module.stepdefinition;

import com.cucumber.framework.helper.PageObject.homepage.HomePage;
import com.cucumber.framework.helper.PageObject.itemsbag.ItemsBag;
import com.cucumber.framework.helper.PageObject.userdetails.Userdetails;
import com.cucumber.framework.settings.ObjectRepo;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class ConnectStep {
    WebDriver driver;
    private HomePage hPage;
    private ItemsBag bag;
    private Userdetails details;

    @Given("^that i am on the sia website$")
    public void that_i_am_on_the_sia_website() throws Throwable {
        System.out.println("Entré");
        ObjectRepo.driver.get(ObjectRepo.reader.getWebsite());
        hPage = new HomePage(ObjectRepo.driver);
        hPage.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        ObjectRepo.data.put("HomePage", hPage);
        hPage.getDriver().findElement(By.xpath("//input[@id=\'Email\']")).click();
    }

    @When("^i enter email sia website$")
    public void i_enter_email_sia_website() throws Throwable {

        hPage.getDriver().findElement(By.xpath("//input[@id=\'Email\']")).sendKeys(ObjectRepo.reader.getUserName());
        hPage.getDriver().findElement(By.xpath("//input[@id=\'Email\']")).sendKeys(Keys.ENTER);
        hPage.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        hPage.getDriver().findElement(By.xpath("//input[@id=\'password-field\']")).click();

    }

    @Then("^i enter password and click on website$")
    public void i_enter_password_and_click_on_website() throws Throwable {
        hPage.getDriver().findElement(By.xpath("//input[@id=\'password-field\']")).sendKeys(ObjectRepo.reader.getPassword());
        hPage.getDriver().findElement(By.xpath("//input[@id=\'password-field\']")).sendKeys(Keys.ENTER);
        hPage.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

}