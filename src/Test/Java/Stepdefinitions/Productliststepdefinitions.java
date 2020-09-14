package Stepdefinitions;

import Pageobjects.ProductlistPageobject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Productliststepdefinitions {

    WebDriver driver;


    @Given("the customer is on a product list page")    // The User is on the Browser Page
    public void the_customer_is_on_a_product_list_page() {
        // Write code here that turns the phrase above into concrete actions
       System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\NarayanasS\\Documents\\Intellij\\Drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://magento.abox.co.za/index.php/");

    }

    @Given("the customer has selected desired number of items to be displayed per page")   // Customer to type bag in search field
    public void the_customer_has_selected_desired_number_of_items_to_be_displayed_per_page()  {
        // Write code here that turns the phrase above into concrete actions
        ProductlistPageobject Productlist =
                PageFactory.initElements(driver, ProductlistPageobject.class);
        Productlist.entersearch("bag");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @When("a certain number of items is displayed per page") // Bag items are displayed
    public void a_certain_number_of_items_is_displayed_per_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement SearchResult = driver.findElement(By.xpath("//*[@id=\"toolbar-amount\"]"));
        String SearchResultText = SearchResult.getText();
        System.out.println(SearchResultText);
        Assert.assertTrue("Does not contain the text 'Items 1-9 of 10'", SearchResultText.contains("Items 1-9 of 10"));

    }

    @When("the customer proceeds to the next page")  // User to click on next to view next set of Product
    public void the_customer_proceeds_to_the_next_page() {
        // Write code here that turns the phrase above into concrete actions
        WebElement Next = driver.findElement(By.xpath("/html/body/div[1]/main/div[3]/div[1]/div[2]/div[3]/div[2]/ul/li[3]/a"));
        Next.click();
    }

    @Then("the system will display the next set of items") // The system to display Items
    public void the_system_will_display_the_next_set_of_items()  {
        // Write code here that turns the phrase above into concrete actions
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement SearchResult = driver.findElement(By.id("toolbar-amount"));
        String SearchResultText = SearchResult.getText();
        System.out.println(SearchResultText);
        Assert.assertTrue("Does not contain the text 'Items 10-10 of 10'", SearchResultText.contains("Items 10-10 of 10"));
        driver.close();
    }
}


