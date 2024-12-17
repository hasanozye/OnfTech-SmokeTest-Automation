package pages;

import com.github.javafaker.Faker;
import driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public Faker faker;

    public BaseTest() {
        driver = Driver.getDriver();
        wait = Driver.getWait();
        faker = new Faker();
    }

    public void click(WebElement element) {
        wait.until(webDriver -> {
            try {

                element.click();
                return true;

            } catch (Exception e) {
                try {

                    new Actions(webDriver)
                            .moveToElement(element)
                            .click()
                            .perform();
                    return true;

                } catch (Exception exception) {
                    try {

                        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click()", element);
                        return true;

                    } catch (Exception e1) {
                        return false;
                    }
                }
            }
        });
    }

    public void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        click(element);
    }

    public void sendKeys(WebElement element, CharSequence... text) {

        wait.until(webDriver -> {
            try {
                element.clear();
                element.sendKeys(text);
                return true;
            } catch (Exception e) {
                try {
                    element.clear();
                    new Actions(webDriver)
                            .moveToElement(element)
                            .sendKeys(text)
                            .perform();
                    return true;
                } catch (Exception e2) {
                    try {
                        ((JavascriptExecutor) webDriver).executeScript("arguments[0].value()'" + Arrays.toString(text) + "'", element);
                        return true;
                    } catch (Exception e3) {
                        return false;
                    }
                }
            }
        });
    }

    public void selectByVisibleText(WebElement element, String visibleTextMsg) {
        waitForVisibility(element);
        Select select = new Select(element);
        select.selectByVisibleText(visibleTextMsg);
    }

    public void scrollIntoElement(By locator) {
        scrollIntoElement(wait.until(ExpectedConditions.presenceOfElementLocated(locator)));
    }

    public void scrollIntoElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver())
                .executeScript("arguments[0].scrollIntoView(false);", element);
    }


    /**
     * Verilen elementin tıklanabilir olmasını bekler.
     *
     * @param element Beklenecek WebElement
     */
    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Verilen elementin görünür olmasını bekler.
     *
     * @param element Beklenecek WebElement
     */
    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Verilen locator ile elementin görünür olmasını bekler.
     *
     * @param locator Beklenecek elementin By locator'ı
     */
    public void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForAttributeToBeExpectedValue(WebElement element, String attribute, String expectedValue) {
        try {
            wait.until((ExpectedCondition<Boolean>) driverInstance -> {
                try {
                    // Element DOM'da mevcutsa
                    if (element.isDisplayed()) {
                        String attrValue = element.getAttribute(attribute);
                        // Eğer attribute '99' ise true dön
                        if ("99".equals(attrValue)) {
                            return true;
                        }
                    }
                    return false; // Element mevcut ama '99' değilse false dön
                } catch (NoSuchElementException | StaleElementReferenceException e) {
                    // Element DOM'da değilse (yani silinmişse) true dön
                    return true;
                }
            });
        } catch (TimeoutException e) {
            System.out.println("Timeout: Attribute did not become '99' or element did not disappear.");
        }
        /*try {
            wait.until(driver -> {
                String attrValue = element.getAttribute(attribute);
                // Eğer null veya beklenen değer ise true dön (bazen bu değer null oluyor ondan hata fırlatmasını önlemek için)
                return attrValue == null || attrValue.equals(expectedValue);
            });
        } catch (TimeoutException e) {
            System.out.println("Attribute '" + attribute + "' is neither null nor '" + expectedValue + "' after wait.");
        }*/
    }

    /**
     * Verilen locator ile elementin görünmez olmasını bekler.
     *
     * @param locator Beklenecek elementin By locator'ı
     */
    public void waitForElementToBeInvisible(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForElementToBeInvisible(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * Verilen locator ile bulunan elementlerin sayısının belirli bir sayıdan fazla olmasını bekler.
     *
     * @param locator Beklenecek elementlerin By locator'ı
     * @param number  Beklenen minimum element sayısı
     */
    public void waitForNumberOfElementsToBeMoreThan(By locator, int number) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, number));
    }

    public void waitForURLToBeExpectedValue() {
        wait.until(ExpectedConditions.urlToBe("https://onftech.com/"));
    }

    /**
     * Verilen locator ile elementin var olmasını bekler.
     *
     * @param locator Beklenecek elementin By locator'ı
     * @return Bulunan WebElement
     */
    public WebElement waitForPresenceOfElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<WebElement> waitForPresenceOfAllElements(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void waitForTextToBePresentInLocated(By locator, String expectedValue) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedValue));
    }

    /**
     * Verilen locator ile bulunan tüm elementlerin görünür olmasını bekler.
     *
     * @param locator Beklenecek elementlerin By locator'ı
     * @return Görünür olan WebElement'lerin listesi
     */
    public List<WebElement> waitForVisibilityOfAllElements(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void navigateBackWithKeyboard() {
        Driver.getDriver().navigate().back();
    }

    public void sleep(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }


}
