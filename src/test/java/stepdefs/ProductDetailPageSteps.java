package stepdefs;

import driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.ProductDetailPage;

public class ProductDetailPageSteps {

    ProductDetailPage productDetailPage;
    HomePage homePage;
    WebDriver driver;

    public ProductDetailPageSteps() {
        productDetailPage = new ProductDetailPage();
        homePage = new HomePage();
        driver = Driver.getDriver();
    }


    @Then("I should see the product details page for the clicked link")
    public void iShouldSeeTheProductDetailsPageFor() {
        homePage.waitUntilPageLoadedFully();
        homePage.verifyLogoIsDisplayed();
        productDetailPage.verifyTheProductDetailPageComponents();
    }

    @And("I should be able to return to the Products page")
    public void iShouldBeAbleToReturnToTheProductsPage() {
        productDetailPage.returnToProductsPage();
    }
}
