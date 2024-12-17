package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ScenarioContext;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductDetailPage extends BaseTest {

    public ProductDetailPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='menu']/li[contains(.,'Our Products')]")
    public WebElement quickLinkOurProducts;
    @FindBy(xpath = "(//div[@class='col-md-9']/p)[1]")
    public WebElement firstDescriptionElement;


    public void verifyTheProductDetailPageComponents() {
        Products currentProduct = (Products) ScenarioContext.getContext("currentProduct");
        String productName = currentProduct.getProductName();
        String currentProductDescText = (String) ScenarioContext.getContext("currentProductDescText");


        By detailMainContentHeaderLocator = By.tagName("h1");
        By currentItemSmallTextLocator = By.xpath("//li[@class='item-current']");
        By detailSecondContentHeaderLocator = By.xpath("//h2[@class='post-name']");


        waitForTextToBePresentInLocated(detailMainContentHeaderLocator, productName);
        waitForTextToBePresentInLocated(currentItemSmallTextLocator, productName);
        waitForTextToBePresentInLocated(detailSecondContentHeaderLocator, productName);

        assertEquals(firstDescriptionElement.getText().trim(), currentProductDescText.trim());
        //TODO: String manuplation yapıp regex ile eşleşecek kadar str seçilmeli, şuan eşleşmeyen stringler var.


    }


    public void returnToProductsPage() {
        navigateBackWithKeyboard();
        ScenarioContext.clearParameter("currentProduct");
        ScenarioContext.clearParameter("currentProductDescText");
    }
}
