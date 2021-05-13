package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TenMinutEmailPage extends AbstractPage{
    private final Logger logger = LogManager.getRootLogger();
    private static final String PAGE_URL = "https://10minutemail.com";

    public TenMinutEmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public TenMinutEmailPage openPage() {
        driver.get(PAGE_URL);
        return this;
    }

    @FindBy(xpath = "//input[@id='mail_address']")
    private WebElement mailAddress;

    @FindBy(xpath = "//div[@id='copy_address']")
    private WebElement copyMailAddressBtn;

    @FindBy(xpath = "//div[@class='small_sender']")
    private WebElement incomingMail;

    @FindBy(xpath = "//h3[contains(.,'USD')]")
    private WebElement totalEstimatedCostFromEmail;

    public String copyMailAddress() {
        scrollToView(mailAddress);
        return waitVisibilityOfEmail(mailAddress).getAttribute("value");
    }

    public TenMinutEmailPage openMail() {
        waitVisibilityOf(incomingMail).click();
        logger.info("Ten Minute Email Page opened");
        return this;
    }

    public double getTotalEstimatedMonthlyCostFromEmail() {
        double estimatedMonthlyCostFromEmail = Double.parseDouble(totalEstimatedCostFromEmail.getText()
                                                        .split(" ")[1]
                                                        .replaceAll(",", ""));
        logger.info("Total Estimated Monthly Cost received from email");
        return estimatedMonthlyCostFromEmail;
    }

    protected WebElement waitVisibilityOfEmail(WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.attributeContains(element, "value", "@"));
        return element;
    }

}
