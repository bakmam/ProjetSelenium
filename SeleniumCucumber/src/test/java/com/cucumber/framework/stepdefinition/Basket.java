package com.cucumber.framework.stepdefinition;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


public class Basket {
    WebDriver driver;
    private HomePage hPage;
    private ItemsBag bag;
    private Userdetails details;

    @Given("^that i am on the shopping website$")
    public void that_i_am_on_the_shopping_website() throws Throwable {

       System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win\\chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        ObjectRepo.driver.get(ObjectRepo.reader.getWebsite());
        String url = ObjectRepo.driver.getCurrentUrl();
        //hPage.navigateTo("https://www.edgewordstraining.co.uk/demo-site/");
        driver.get(ObjectRepo.reader.getWebsite());
        //ObjectRepo.driver.navigate().to(url);
       // ObjectRepo.driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id=\'woocommerce-product-search-field-0\']")));
        driver.findElement(By.xpath("//input[@id=\'woocommerce-product-search-field-0\']")).click();
        driver.findElement(By.xpath("//input[@id=\'woocommerce-product-search-field-0\']")).sendKeys("Cap");
       // driver.findElement(By.xpath("//input[@id=\'woocommerce-product-search-field-0\']")).sendKeys(Keys.ENTER);
       // driver.findElement(By.xpath("//input[@id=\'entry-summary button\']")).click();
       // driver.findElement(By.linkText("Cart")).click();
       // assertTrue(driver.findElement(By.linkText("Cap")).isDisplayed());
       // driver.findElement(By.linkText("×")).click();
        driver.manage().window().maximize();
    }

    @When("^i add an item to the basket$")
    public void i_add_an_item_to_the_basket() throws Throwable {
   //     driver.findElement(By.cssSelector(".entry-summary button")).click();
    }

    @Then("^i can view the item in my basket$")
    public void i_can_view_the_item_in_my_basket() throws Throwable {
        try {
        driver.findElement(By.linkText("Polo")).click();
        assertTrue(driver.findElement(By.linkText("Polo")).isDisplayed());
        driver.findElement(By.linkText("×")).click();
        // explicit wait for item to be removed as may use AJAX
        WebDriverWait wait=new WebDriverWait(driver, 20); //explicit wait if we want to use
        WebElement returnToShopLink;
        returnToShopLink= wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Return to shop")));
        returnToShopLink.click();
        //driver.findElement(By.linkText("Return to shop")).click();
            driver.quit();
        } catch (Exception ex) {
            //logger.debug("Exception :" +  ex.getMessage());
            ex.printStackTrace();
        }

    }

}