package pages;

import com.github.javafaker.Faker;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView();", element);
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
        wait.until(ExpectedConditions.attributeToBe(element, attribute, expectedValue));
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

    /**
     * Verilen locator ile bulunan tüm elementlerin görünür olmasını bekler.
     *
     * @param locator Beklenecek elementlerin By locator'ı
     * @return Görünür olan WebElement'lerin listesi
     */
    public List<WebElement> waitForVisibilityOfAllElements(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void sleep(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }


}