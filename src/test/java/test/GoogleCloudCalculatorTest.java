package test;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.GoogleCloudPage;
import page.PricingCalculatorPage;
import page.TenMinutEmailPage;
import static service.TestDataReader.getTestData;
import service.WebBrowser;
import util.TestListener;


@Listeners({TestListener.class})
public class GoogleCloudCalculatorTest {

    public static final String CALC_NUMBER_OF_INSTANCES = "calc.numberOfInstances";
    public static final String CALC_OPERATING_SYSTEM = "calc.operatingSystem";
    public static final String CALC_MACHINE_CLASS = "calc.machineClass";
    public static final String CALC_MACHINE_SERIES = "calc.machineSeries";
    public static final String CALC_MACHINE_TYPE = "calc.machineType";
    public static final String CALC_NUMBER_OF_GPUS = "calc.numberOfGPUs";
    public static final String CALC_GPU_TYPE = "calc.gpuType";
    public static final String CALC_LOCAL_SSD = "calc.localSSD";
    public static final String CALC_DATACENTER_LOCATION = "calc.datacenterLocation";
    public static final String CALC_COMMITTED_USAGE = "calc.committedUsage";

    private WebDriver driver;
    protected WebBrowser browser;


    @BeforeMethod()
    public void setUp()
    {
        browser = WebBrowser.valueOf(System.getProperty("browser").toUpperCase());
        driver = browser.getDriver();
    }

    public WebBrowser getBrowser() {
        return browser;
    }

    @Test
    public void checkTotalEstimatedMonthlyCost() {

       /* 1. Открыть https://cloud.google.com/
        * 2. Нажав кнопку поиска по порталу вверху страницы, ввести в поле поиска"Google Cloud Platform Pricing Calculator"
        * 3. Запустить поиск, нажав кнопку поиска.
        * 4. В результатах поиска кликнуть "Google Cloud Platform Pricing Calculator" и перейти на страницу калькулятора.
        */
        PricingCalculatorPage calculatorPage = new GoogleCloudPage(driver)
                .openPage()
                .clickSearchBtn()
                .searchForPricingCalculator("Google Cloud Platform Pricing Calculator")
                .goToPricingCalculator();

        double totalEstimatedMonthlyCost = calculatorPage
                .goToCalculatorFrame()
                .activateComputeEngine() // 5. Активировать раздел COMPUTE ENGINE вверху страницы
                .selectNumberOfInstances(getTestData(CALC_NUMBER_OF_INSTANCES)) // filling out the form
                .selectOS(getTestData(CALC_OPERATING_SYSTEM))
                .selectMachineClass(getTestData(CALC_MACHINE_CLASS))
                .selectMachineSeries(getTestData(CALC_MACHINE_SERIES))
                .selectMachineType(getTestData(CALC_MACHINE_TYPE))
                .selectAddGPUsCheckbox()
                .selectNumberOfGPUs(getTestData(CALC_NUMBER_OF_GPUS))
                .selectGPUType(getTestData(CALC_GPU_TYPE))
                .selectLocalSSD(getTestData(CALC_LOCAL_SSD))
                .selectDatacenterLocation(getTestData(CALC_DATACENTER_LOCATION))
                .selectCommittedUsage(getTestData(CALC_COMMITTED_USAGE))
                .clickAddToEstimateButton() // 7. Нажать Add to Estimate
                .getTotalEstimatedMonthlyCost();

        // 9. В новой вкладке открыть https://10minutemail.com или аналогичный сервис для генерации временных email'ов
        browser.createNewTab();
        browser.openSecondTab();


        // 10. Скопировать почтовый адрес сгенерированный в 10minutemail
        TenMinutEmailPage mailPage = new TenMinutEmailPage(driver);
        String mailAddress = mailPage.openPage().copyMailAddress();

        // 11. Вернуться в калькулятор,
        browser.openFirstTab();

        calculatorPage.goToCalculatorFrame()
                .clickEmailEstimateButton() // 8. Выбрать пункт EMAIL ESTIMATE
                .fillEmailField(mailAddress)  // в поле Email ввести адрес из предыдущего пункта
                .clickSendEmailButton(); // 12. Нажать SEND EMAIL

        //13. Дождаться письма с расчетом стоимости и проверить
        // что Total Estimated Monthly Cost в письме совпадает с тем, что отображается в калькуляторе
        browser.openSecondTab();
        double totalEstimatedMonthlyCostFromEmail = mailPage.openMail().getTotalEstimatedMonthlyCostFromEmail();

        Assert.assertEquals(totalEstimatedMonthlyCost, totalEstimatedMonthlyCostFromEmail);

    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        WebBrowser.closeDriver();
    }

}
