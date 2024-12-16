package stepdefs;

import driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class HomePageSteps {

    HomePage homePage;
    WebDriver driver;


    public HomePageSteps() {
        driver = Driver.getDriver();
        homePage = new HomePage();
    }

    @Given("I am on the OnfTech Home Page")
    public void iAmOnTheOnfTechHomePage() {
        homePage.navigateToOnftechLoginPage();
        homePage.waitUntilPageLoadedFully();
    }


    @Then("I should see the logo")
    public void iShouldSeeTheLogo() {
        homePage.verifyLogoIsDisplayed();
    }

    @And("the page URL should be {string}")
    public void thePageURLShouldBe(String url) {
        homePage.verifyTheURL(url);
    }

    @And("the page title should contain {string}")
    public void thePageTitleShouldContain(String pageTitle) {
        homePage.verifyTheTitle(pageTitle);
    }

    @And("the slider content should be visible")
    public void theSliderContentShouldBeVisible() {
        homePage.verifyTheSliderContentIsVisible();
    }

    @When("I click on the burger menu")
    public void iClickOnTheBurgerMenu() {
        homePage.clickBurgerMenu();
    }

    @Then("I should see the sidebar with its contents")
    public void iShouldSeeTheSidebarWithItsContents() {
        homePage.waitForSidebarContentsToBeVisible();
    }

    @When("I open the {string} page")
    public void iOpenThePage(String linkName) {
        homePage.openTheSpecifiedPage(linkName);
    }
}
