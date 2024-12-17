package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.ScenarioContext;


public class ProductsPage extends BaseTest {

    public ProductsPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void verifyAllProductsExistsInPage() {
        By productNameLocator = By.tagName("h2");
        waitForPresenceOfAllElements(productNameLocator);
    }

    public void openTheProductDetailsPage(String productName) {
        Products currentProduct = Products.fromName(productName);
        ScenarioContext.setContext("currentProduct", currentProduct);

        By productDescriptionXPathLocator = currentProduct.getProductDescriptionXPathLocator();
        String productDescriptionXPathStringText = driver.findElement(productDescriptionXPathLocator).getText();
        ScenarioContext.setContext("currentProductDescText", productDescriptionXPathStringText);

        scrollIntoElement(currentProduct.getProductDescriptionXPathLocator());
        click(currentProduct.getProductHeaderXPathLocator());

    }

}

enum Products {
    TWG("Tanfeeth Watheeq Gateway",
            By.xpath("//h2/child::a[contains(.,'TWG - Tanfeeth Watheeq Gateway')]"),
            By.xpath("//div[@class='project-desc' and contains(.,'Tanfeeth')]")
    ),
    LGG(
            "Letter of Guarantee Gateway",
            By.xpath("//h2/child::a[contains(.,'LGG - Letter of Guarantee Gateway')]"),
            By.xpath("//div[@class='project-desc' and contains(.,'LGG')]")
    ),
    ODG(
            "Online Document Gateway",
            By.xpath("//h2/child::a[contains(.,'ODG - Online Document Gateway')]"),
            By.xpath("//div[@class='project-desc' and contains(.,'ODG')]")
    ),
    IANALYTICS(
            "iAnalytics",
            By.xpath("//h2/child::a[contains(.,'iAnalytics')]"),
            By.xpath("//div[@class='project-desc' and contains(.,'iAnalytics')]")
    ),
    EGG(
            "Electronic Government Gateway",
            By.xpath("//h2/child::a[contains(.,'EGG - Electronic Government Gateway')]"),
            By.xpath("//div[@class='project-desc' and contains(.,'EGG')]")
    ),
    GSAD(
            "Gateway of SADAD",
            By.xpath("//h2/child::a[contains(.,'GSAD - Gateway of SADAD')]"),
            By.xpath("//div[@class='project-desc' and contains(.,'GSAD')]")
    ),
    OBRIDGE(
            "Open Banking Solution",
            By.xpath("//h2/child::a[contains(.,'OBridge - Open Banking Solution')]"),
            By.xpath("//div[@class='project-desc' and contains(.,'Open Banking solution')]")
    ),
    ONFTICKET(
            "Your Ultimate IT Service Management Solution",
            By.xpath("//h2/child::a[contains(.,'ONFTicket - Your Ultimate IT Service Management Solution')]"),
            By.xpath("//div[@class='project-desc' and contains(.,'ONFTicket')]")
    ),
    IAK(
            "Unlock Compliance Excellence",
            By.xpath("//h2/child::a[contains(.,'IAK (Integrated AML-KYC) - Unlock Compliance Excellence')]"),
            By.xpath("//div[@class='project-desc' and contains(.,'IAK')]")
    ),
    IGRC(
            "The Integrated Governance, Risk, and Compliance",
            By.xpath("//h2/child::a[contains(.,'IGRC - The Integrated Governance, Risk, and Compliance')]"),
            By.xpath("//div[@class='project-desc' and contains(.,'IGRC')]")
    ),
    AGIP(
            "API Gateway",
            By.xpath("//h2/child::a[contains(.,'API Gateway (AGIP)')]"),
            By.xpath("//div[@class='project-desc' and contains(.,'API')]")
    );


    private final String productName;
    private final By productHeaderXPathLocator;
    private final By productDescriptionXPathLocator;

    Products(String productName, By productHeaderXPathLocator, By productDescriptionXPathLocator) {
        this.productName = productName;
        this.productHeaderXPathLocator = productHeaderXPathLocator;
        this.productDescriptionXPathLocator = productDescriptionXPathLocator;
    }

    public By getProductHeaderXPathLocator() {
        return productHeaderXPathLocator;
    }

    public String getProductName() {
        return productName;
    }

    public By getProductDescriptionXPathLocator() {
        return productDescriptionXPathLocator;
    }

    public static Products fromName(String productName) {
        for (Products product : Products.values()) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        throw new IllegalArgumentException("No product found with the name: " + productName);
    }


}
