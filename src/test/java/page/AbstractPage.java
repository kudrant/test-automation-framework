package page;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class AbstractPage {
    protected WebDriver driver;

    protected abstract AbstractPage openPage();
    protected final int WAIT_TIMEOUT_SECONDS = 300;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement waitVisibilityOf(WebElement element) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitVisibilityOf(String locator, String propertyValue) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(locator, propertyValue))));
    }

    protected void scrollToView(WebElement element) {
        if (driver instanceof FirefoxDriver) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});",
                    waitVisibilityOf(element));
        }
        else
            waitVisibilityOf(element);
    }

}
