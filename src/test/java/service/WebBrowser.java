package service;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;

public enum WebBrowser {
    CHROME {
       @Override public WebDriver getDriver() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            return driver;
        }

        @Override
        public void createNewTab() {
            ((JavascriptExecutor)driver).executeScript("window.open()");
            tabs = new ArrayList<>(driver.getWindowHandles());
        }
    },
    FIREFOX {
        @Override public WebDriver getDriver() {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            return driver;
        }

        @Override
        public void createNewTab() {
            ((JavascriptExecutor)driver).executeScript("window.open('about:blank','_blank');");
            tabs = new ArrayList<>(driver.getWindowHandles());
        }
    };

    private static WebDriver driver;
    private static ArrayList<String> tabs;


    public abstract WebDriver getDriver();
    public abstract void createNewTab();

    public void openFirstTab() {
        driver.switchTo().window(tabs.get(0));
    }

    public void openSecondTab() {
        driver.switchTo().window(tabs.get(1));
    }



    public static void closeDriver(){
        driver.quit();
        driver = null;
    }

}
