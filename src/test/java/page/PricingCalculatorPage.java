package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricingCalculatorPage extends AbstractPage{


    public PricingCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//div[@class='tab-holder compute']//div[@class='name ng-binding']")
    private WebElement computeEngine;


    @FindBy(xpath = "//label[contains(text(), 'Number of instances')]/../input[@name='quantity']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']")
    private WebElement operatingSystemsDropdownList;

    private String operatingSystem = "//md-option[@value='%s']";

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.class']")
    private WebElement machineClassDropdownList;

    private String machineClass = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='%s']";

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.series']")
    private WebElement machineSeriesDropDownList;

    private String machineSeries = "//md-option[@value='%s']";

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.instance']")
    private WebElement machineTypeDropdownList;

    private String machineType = "//md-option[@value='%s']";

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement addGPUsCheckbox;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuCount']")
    private WebElement numberOfGPUsDropdownList;

    private String numberOfGPUs = "//md-option[@ng-repeat='item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]'][@value='%s']";

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuType']")
    private WebElement gpuTypeDropdownList;

    private String gpuType = "//md-option[@value='%s']";

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.ssd']")
    private WebElement localSSDDropdownList;

    private String localSSD = "//md-option[@ng-repeat='item in listingCtrl.supportedSsd'][@value='%s']";

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
    private WebElement datacenterLocationDropdownList;

    private String datacenterLocation = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='%s']";

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.cud']")
    private WebElement committedUsageDropdownList;

    private String committedUsage = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='%s']";

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[@aria-label='Add to Estimate']")
    private WebElement addToEstimateBtn;

    @FindBy(xpath = "//h2[@class='md-title']/b[@class='ng-binding']")
    private WebElement totalEstimatedMonthlyCost;

    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    private WebElement emailEstimateBtn;

    @FindBy(xpath = "//input[@ng-model='emailQuote.user.email']")
    private WebElement mailAddressField;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailBtn;


    public PricingCalculatorPage goToCalculatorFrame() {
        driver.switchTo().frame(0).switchTo().frame("myFrame");
        return this;
    }

    public PricingCalculatorPage activateComputeEngine() {
        waitVisibilityOf(computeEngine).click();
        return this;
    }

    public PricingCalculatorPage selectNumberOfInstances(String instancesCount) {
        numberOfInstances.sendKeys(instancesCount);
        return this;
    }

    public PricingCalculatorPage selectOS(String operatingSystemProperty) {
        operatingSystemsDropdownList.click();
        waitVisibilityOf(operatingSystem, operatingSystemProperty).click();
        return this;
    }

    public PricingCalculatorPage selectMachineClass(String machineClassProperty) {
        machineClassDropdownList.click();
        waitVisibilityOf(machineClass, machineClassProperty).click();
        return this;
    }

    public PricingCalculatorPage selectMachineSeries(String machineSeriesProperty) {
        machineSeriesDropDownList.click();
        waitVisibilityOf(machineSeries, machineSeriesProperty).click();
        return this;
    }

    public PricingCalculatorPage selectMachineType(String machineTypeProperty) {
        machineTypeDropdownList.click();
        waitVisibilityOf(machineType, machineTypeProperty).click();
        return this;
    }

    public PricingCalculatorPage selectAddGPUsCheckbox() {
        addGPUsCheckbox.click();
        return this;
    }

    public PricingCalculatorPage selectNumberOfGPUs(String numberOfGPUsProperty) {
        numberOfGPUsDropdownList.click();
        waitVisibilityOf(numberOfGPUs, numberOfGPUsProperty).click();
        return this;
    }

    public PricingCalculatorPage selectGPUType(String gpuTypeProperty) {
        gpuTypeDropdownList.click();
        waitVisibilityOf(gpuType, gpuTypeProperty).click();
        return this;
    }

    public PricingCalculatorPage selectLocalSSD(String localSSDProperty) {
        localSSDDropdownList.click();
        waitVisibilityOf(localSSD, localSSDProperty).click();
        return this;
    }

    public PricingCalculatorPage selectDatacenterLocation(String datacenterLocationProperty) {
        datacenterLocationDropdownList.click();
        waitVisibilityOf(datacenterLocation, datacenterLocationProperty).click();
        return this;
    }

    public PricingCalculatorPage selectCommittedUsage(String committedUsageProperty) {
        committedUsageDropdownList.click();
        waitVisibilityOf(committedUsage, committedUsageProperty).click();
        return this;
    }

    public PricingCalculatorPage clickAddToEstimateButton() {
        waitVisibilityOf(addToEstimateBtn).click();
        return this;
    }

    public double getTotalEstimatedMonthlyCost() {
        return Double.parseDouble(totalEstimatedMonthlyCost.getText()
                .split("USD ")[1]
                .replaceAll(",", "")
                .split(" ")[0]);
    }

    public PricingCalculatorPage clickEmailEstimateButton() {
        waitVisibilityOf(emailEstimateBtn).click();
        return this;
    }

    public PricingCalculatorPage fillEmailField(String mailAddress) {
        waitVisibilityOf(mailAddressField).sendKeys(mailAddress);
        return this;
    }

    public PricingCalculatorPage clickSendEmailButton() {
        waitVisibilityOf(sendEmailBtn).click();
        return this;
    }


    @Override
    protected PricingCalculatorPage openPage() {
        return this;
    }

}
