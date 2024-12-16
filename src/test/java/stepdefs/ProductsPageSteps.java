package stepdefs;

import driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ProductsPage;

public class ProductsPageSteps {

    ProductsPage productsPage;
    WebDriver driver;

    public ProductsPageSteps() {
        driver = Driver.getDriver();
        productsPage = new ProductsPage();
    }

    @Then("I should see the list of available products")
    public void iShouldSeeTheListOfProducts() {
        productsPage.verifyAllProductsExistsInPage();
    }

    @When("I click on the {string} product link")
    public void iClickOnTheProductLink(String productLink) {
        productsPage.openTheProductDetailsPage(productLink);
    }

    @Then("I should see the product details page for {string}")
    public void iShouldSeeTheProductDetailsPageFor(String arg0) {
    }

    @And("I should be able to return to the Products page")
    public void iShouldBeAbleToReturnToTheProductsPage() {
    }
}
