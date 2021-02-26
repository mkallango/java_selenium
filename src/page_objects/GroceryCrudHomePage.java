package page_objects;

import fixtures.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GroceryCrudHomePage {
    private WebDriver _driver = null;
    private WebDriverWait _wait = null;

    private String drpSelectorVersionXpath = "//select[@id='switch-version-select']";
    private String btnAddCustomerXpath = "//a[contains(@href,'/add')]";
    private String inputCustomerNameXpath = "//input[@name='customerName']";
    private String chkCustomersXpath = "//table//tbody//input[@type='checkbox']";
    private String btnDeleteXpath = "//a[contains(@class,'delete-selected-button')]";

    public GroceryCrudHomePage(WebDriver driver){
        this._driver = driver;
        _wait = new WebDriverWait(_driver, 20);
    }

    public Select drpSelectVersion(){
        Select drpSelectVersion = new Select(_driver.findElement(By.xpath(drpSelectorVersionXpath)));
        _wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(drpSelectVersion.getWrappedElement())));
        return drpSelectVersion;
    }

    public WebElement btnAddCustomer(){
        return ElementActions.getElementClickable(_driver, btnAddCustomerXpath);
    }

    public WebElement inputSearchName(){
        return ElementActions.getElementClickable(_driver,inputCustomerNameXpath);
    }

    public WebElement btnRefresh(){
        return ElementActions.getElementClickable(_driver, "//a[contains(@class,'gc-refresh')]");
    }

    public List<WebElement> chkCustomersList(){
        return ElementActions.getElementsClickable(_driver,chkCustomersXpath);
    }

    public WebElement btnDelete(){
        return ElementActions.getElementClickable(_driver,btnDeleteXpath);
    }

    public WebElement lblAreYouSureWantDelete(){
        return ElementActions.getElementVisible(_driver,"//div[@class='modal-content']//p[not(contains(@class,'hidden')) and contains(@class,'alert-delete')]");
    }

    public WebElement btnDeletePopup(){
        return ElementActions.getElementClickable(_driver,"//button[contains(@class,'delete-multiple-confirmation-button')]");
    }

    public WebElement alertSuccess(){
        return ElementActions.getElementVisible(_driver,"//div[contains(@class,'alert-success')]");
    }

}
