package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;

    protected abstract AbstractPage openPage();
    protected final int WAIT_TIMEOUT_SECONDS = 20;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;

    }

    protected WebElement waitVisibilityOf(WebElement element) {
//        if (!element.isDisplayed()) {
//            // Scrolling down the page till the element is found
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].scrollIntoView();", element);
//        }

        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitVisibilityOf(String locator, String propertyValue) {
//        WebElement element = driver.findElement(By.xpath(String.format(locator, propertyValue)));
//
//        if (!element.isDisplayed()) {
//            // Scrolling down the page till the element is found
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].scrollIntoView();", element);
//        }

        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        //.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(locator, propertyValue))));
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(locator, propertyValue))));
    }
}
