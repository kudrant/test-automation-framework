package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import service.WebBrowser;
import util.TestListener;


@Listeners({TestListener.class})
public class CommonConditions {

    protected static WebDriver driver;
    protected WebBrowser browser;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod()
    public void setUp()
    {
        browser = WebBrowser.valueOf(System.getProperty("browser").toUpperCase());
        driver = browser.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        browser.closeDriver();
    }
}

