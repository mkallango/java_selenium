package page_objects;

import fixtures.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroceryCrudAddCustomerPage{
    private WebDriver _driver = null;
    private WebDriverWait _wait = null;

    private String lblAddCustomerFormXpath = "//div[contains(text(),'Add Customer')]";
    private String inputCustomerNameXpath = "//input[@id='field-customerName']";
    private String inputCustomerLastNameXpath = "//input[@id='field-contactLastName']";
    private String inputCustomerContactFirstNameXpath = "//input[@id='field-contactFirstName']";
    private String inputCustomerPhoneXpath = "//input[@id='field-phone']";
    private String inputCustomerAddrLine1Xpath = "//input[@id='field-addressLine1']";
    private String inputCustomerAddrLine2Xpath = "//input[@id='field-addressLine2']";
    private String inputCustomerCityXpath = "//input[@id='field-city']";
    private String inputCustomerStateXpath = "//input[@id='field-state']";
    private String inputCustomerPostalCodeXpath = "//input[@id='field-postalCode']";
    private String inputCustomerCountryXpath = "//input[@id='field-country']";
    private String selectCustomerSalesRepEmployeeNumberFieldXpath = "//div[contains(@class,'salesRepEmployeeNumber_form_group')]";
    private String inputCustomerCreditLimitXpath = "//input[@id='field-creditLimit']";
    private String btnSaveCustomerXpath = "//button[@id='form-button-save']";
    private String lblReportSuccessXpath = "//div[@id='report-success']";
    private String lnkGoBackToListXpath = "//div[@id='report-success']//a[contains(text(),'Go back to list')]";

    public GroceryCrudAddCustomerPage(WebDriver driver){
        _wait = new WebDriverWait(driver, 20);
        this._driver = driver;
    }

    public WebElement lblAddCustomer(){
        return ElementActions.getElementVisible(_driver, lblAddCustomerFormXpath);
    }

    public WebElement inputName(){
        return ElementActions.getElementClickable(_driver, inputCustomerNameXpath);
    }

    public WebElement inputLastName(){
        return ElementActions.getElementClickable(_driver, inputCustomerLastNameXpath);
    }

    public WebElement inputContactFirstName(){
        return ElementActions.getElementClickable(_driver, inputCustomerContactFirstNameXpath);
    }

    public WebElement inputPhone(){
        return ElementActions.getElementClickable(_driver, inputCustomerPhoneXpath);
    }

    public WebElement inputAddressLine1(){
        return ElementActions.getElementClickable(_driver, inputCustomerAddrLine1Xpath);
    }

    public WebElement inputAddressLine2(){
        return ElementActions.getElementClickable(_driver, inputCustomerAddrLine2Xpath);
    }

    public WebElement inputCity(){
        return ElementActions.getElementClickable(_driver, inputCustomerCityXpath);
    }

    public WebElement inputState(){
        return ElementActions.getElementClickable(_driver,  inputCustomerStateXpath);
    }

    public WebElement inputPostalCode(){
        return ElementActions.getElementClickable(_driver,  inputCustomerPostalCodeXpath);
    }

    public WebElement inputCountry(){
        return ElementActions.getElementClickable(_driver,  inputCustomerCountryXpath);
    }

    public void selectSalesRepEmployeeNumber(String option){
        WebElement field = _driver.findElement(By.xpath(selectCustomerSalesRepEmployeeNumberFieldXpath));
        field.click();

        String optionXpath =(new StringBuilder()).append("//li[contains(text(),'").append(option).append("')]").toString();
        WebElement item = _driver.findElement(By.xpath(optionXpath));
        item.click();
    }

    public WebElement inputCreditLimit(){
        return ElementActions.getElementClickable(_driver,  inputCustomerCreditLimitXpath);
    }

    public WebElement btnSave(){
        return ElementActions.getElementClickable(_driver,  btnSaveCustomerXpath);
    }

    public WebElement lblReportSuccess(){
        return ElementActions.getElementClickable(_driver, lblReportSuccessXpath);
    }

    public WebElement lnkGoBackToList(){
        return ElementActions.getElementClickable(_driver, lnkGoBackToListXpath);
    }

    public void fillForm(){
        this.inputName().sendKeys("Teste Sicredi");
        this.inputLastName().sendKeys("Teste");
        this.inputContactFirstName().sendKeys("Marcello Mello");
        this.inputPhone().sendKeys("51 9999-9999");
        this.inputAddressLine1().sendKeys("Av Assis Brasil, 3970");
        this.inputAddressLine2().sendKeys("Torre D");
        this.inputCity().sendKeys("Porto Alegre");
        this.inputState().sendKeys("RS");
        this.inputPostalCode().sendKeys("91000-000");
        this.inputCountry().sendKeys("Brasil");
        this.selectSalesRepEmployeeNumber("Fixter");
        this.inputCreditLimit().sendKeys("200");

        this.btnSave().click();
    }
}
