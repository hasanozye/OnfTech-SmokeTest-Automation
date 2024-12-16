package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import readers.property.PropertyReader;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage extends BaseTest {

    private String loginPageUrl = PropertyReader.read().getProperty("baseUrl");

    public HomePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='pace-progress']")
    public WebElement paceProgress;
    @FindBy(xpath = "//div[@class='header__logo']")
    public WebElement headerLogo;
    @FindBy(xpath = "//div[@class='owl-item active']/descendant::div[@class='slider-content']")
    public WebElement sliderContent;
    @FindBy(xpath = "//div[@class='header-burger']")
    public WebElement burgerMenu;


    public void navigateToOnftechLoginPage() {
        driver.get(loginPageUrl);
    }

    public void waitUntilPageLoadedFully() {
        String paceProgressAttribute = "data-progress";
        waitForAttributeToBeExpectedValue(paceProgress, paceProgressAttribute, "99");
        waitForElementToBeInvisible(paceProgress);
    }

    public void verifyLogoIsDisplayed() {
        waitForVisibility(headerLogo);
        assertTrue(headerLogo.isDisplayed());
    }

    public void verifyTheURL(String expectedUrl) {
        waitForURLToBeExpectedValue();
        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, expectedUrl);
    }

    public void verifyTheTitle(String expectedPageTitle) {
        String actualPageTitle = driver.getTitle();
        assertEquals(actualPageTitle, expectedPageTitle);
    }

    public void verifyTheSliderContentIsVisible() {
        waitForVisibility(sliderContent);
        assertTrue(sliderContent.isDisplayed());
    }

}
