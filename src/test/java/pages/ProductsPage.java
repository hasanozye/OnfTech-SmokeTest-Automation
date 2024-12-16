package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.Products.TWG;


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
        Products product = Products.fromName(productName);
        scrollIntoElement(product.getReportLocator());
        click(product.getReportLocator());
    }

}

enum Products {
    TWG("TWG - Tanfeeth Watheeq Gateway",
            By.xpath("//h2/child::a[contains(.,'TWG - Tanfeeth Watheeq Gateway')]")
    ),
    LGG(
            "LGG - Letter of Guarantee Gateway",
            By.xpath("//h2/child::a[contains(.,'LGG - Letter of Guarantee Gateway')]")
    );


    private final String productName;
    private final By productXPathLocator;

    Products(String productName, By productXPathLocator) {
        this.productName = productName;
        this.productXPathLocator = productXPathLocator;
    }

    public By getReportLocator() {
        return productXPathLocator;
    }

    public String getProductName() {
        return productName;
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
