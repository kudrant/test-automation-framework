package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResultsPage extends AbstractPage{
    public GoogleSearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//b[text()='Google Cloud Platform Pricing Calculator']/parent::a")
    private WebElement calculatorLink;

    public PricingCalculatorPage goToPricingCalculator() {
        waitVisibilityOf(calculatorLink).click();
        return new PricingCalculatorPage(driver);
    }

    @Override
    protected GoogleSearchResultsPage openPage() {
        return this;
    }
}
