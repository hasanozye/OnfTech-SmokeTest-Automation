package stepdefs;

import driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.ProductsPage;

public class ProductsPageSteps {

    ProductsPage productsPage;
    HomePage homePage;
    WebDriver driver;

    public ProductsPageSteps() {
        driver = Driver.getDriver();
        productsPage = new ProductsPage();
        homePage = new HomePage();
    }

    @Then("I should see the list of available products")
    public void iShouldSeeTheListOfProducts() {
        productsPage.verifyAllProductsExistsInPage();
    }

    @When("I click on the {string} product link")
    public void iClickOnTheProductLink(String productLink) {
        homePage.waitUntilPageLoadedFully();
        homePage.verifyLogoIsDisplayed();
        productsPage.openTheProductDetailsPage(productLink);
    }

}
