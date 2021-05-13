package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PricingCalculatorPage extends AbstractPage{
    private final Logger logger = LogManager.getRootLogger();

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

    String machineClassDropdownListLocator = "//md-select[@ng-model='listingCtrl.computeServer.class']";
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.class']")
    private WebElement machineClassDropdownList;

    private String machineClass = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='%s']";

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.series']")
    private WebElement machineSeriesDropdownList;

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
        waitVisibilityOf(numberOfInstances).sendKeys(instancesCount);
        return this;
    }

    public PricingCalculatorPage selectOS(String operatingSystemProperty) {
        scrollToView(operatingSystemsDropdownList);
        operatingSystemsDropdownList.click();
        waitVisibilityOf(operatingSystem, operatingSystemProperty).click();
        logger.info("Operating system / Software selected");
        return this;
    }

    public PricingCalculatorPage selectMachineClass(String machineClassProperty) {
        scrollToView(machineClassDropdownList);
        machineClassDropdownList.click();
        waitVisibilityOf(machineClass, machineClassProperty).click();
        logger.info("Machine class selected");
        return this;
    }

    public PricingCalculatorPage selectMachineSeries(String machineSeriesProperty) {
        scrollToView(machineSeriesDropdownList);
        machineSeriesDropdownList.click();
        waitVisibilityOf(machineSeries, machineSeriesProperty).click();
        logger.info("Machine series selected");
        return this;
    }

    public PricingCalculatorPage selectMachineType(String machineTypeProperty) {
        scrollToView(machineTypeDropdownList);
        machineTypeDropdownList.click();
        waitVisibilityOf(machineType, machineTypeProperty).click();
        logger.info("Machine type selected");
        return this;
    }

    public PricingCalculatorPage selectAddGPUsCheckbox() {
        scrollToView(addGPUsCheckbox);
        addGPUsCheckbox.click();
        return this;
    }

    public PricingCalculatorPage selectNumberOfGPUs(String numberOfGPUsProperty) {
        scrollToView(numberOfGPUsDropdownList);
        numberOfGPUsDropdownList.click();
        waitVisibilityOf(numberOfGPUs, numberOfGPUsProperty).click();
        return this;
    }

    public PricingCalculatorPage selectGPUType(String gpuTypeProperty) {
        gpuTypeDropdownList.click();
        waitVisibilityOf(gpuType, gpuTypeProperty).click();
        logger.info("GPU type selected selected");
        return this;
    }

    public PricingCalculatorPage selectLocalSSD(String localSSDProperty) {
        scrollToView(localSSDDropdownList);
        localSSDDropdownList.click();
        waitVisibilityOf(localSSD, localSSDProperty).click();
        logger.info("Local SSD selected");
        return this;
    }

    public PricingCalculatorPage selectDatacenterLocation(String datacenterLocationProperty) {
        scrollToView(datacenterLocationDropdownList);
        datacenterLocationDropdownList.click();
        waitVisibilityOf(datacenterLocation, datacenterLocationProperty).click();
        logger.info("Datacenter location selected");
        return this;
    }

    public PricingCalculatorPage selectCommittedUsage(String committedUsageProperty) {
        scrollToView(committedUsageDropdownList);
        committedUsageDropdownList.click();
        waitVisibilityOf(committedUsage, committedUsageProperty).click();
        return this;
    }

    public PricingCalculatorPage clickAddToEstimateButton() {
        scrollToView(addToEstimateBtn);
        addToEstimateBtn.click();
        return this;
    }

    public double getTotalEstimatedMonthlyCost() {
        double monthlyCost = Double.parseDouble(totalEstimatedMonthlyCost.getText()
                                    .split("USD ")[1]
                                    .replaceAll(",", "")
                                    .split(" ")[0]);
        logger.info("Total estimated monthly cost parsed");
        return monthlyCost;

    }

    public PricingCalculatorPage clickEmailEstimateButton() {
        scrollToView(emailEstimateBtn);
        emailEstimateBtn.click();
        return this;
    }

    public PricingCalculatorPage fillEmailField(String mailAddress) {
        scrollToView(mailAddressField);
        mailAddressField.sendKeys(mailAddress);
        return this;
    }

    public PricingCalculatorPage clickSendEmailButton() {
        scrollToView(sendEmailBtn);
        sendEmailBtn.click();
        logger.info("Email estimate request sent");
        return this;
    }


    @Override
    public PricingCalculatorPage openPage() {
        driver.manage().window().maximize();
        driver.get("https://cloud.google.com/products/calculator");
        logger.info("Google Cloud Pricing Calculator Page opened");
        return this;
    }

}
