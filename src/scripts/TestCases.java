package scripts;
 
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.GroceryCrudAddCustomerPage;
import page_objects.GroceryCrudHomePage;

public class TestCases extends DriverClass {

    private WebDriverWait wait = null;

    @Test
    public void desafio_01() throws InterruptedException, IOException {
        WebDriver dr = getDriver();
        GroceryCrudHomePage home = new GroceryCrudHomePage(dr);
        GroceryCrudAddCustomerPage customer = new GroceryCrudAddCustomerPage(dr);


        try{
            home.drpSelectVersion().selectByValue("bootstrap_theme_v4");
            Assert.assertTrue(dr.getCurrentUrl().substring(0).contains("bootstrap_theme_v4"));
            home.btnAddCustomer().click();

            Assert.assertTrue(customer.lblAddCustomer().isDisplayed());

            customer.inputName().sendKeys("Teste Sicredi");
            customer.inputLastName().sendKeys("Teste");
            customer.inputContactFirstName().sendKeys("Marcello Mello");
            customer.inputPhone().sendKeys("51 9999-9999");
            customer.inputAddressLine1().sendKeys("Av Assis Brasil, 3970");
            customer.inputAddressLine2().sendKeys("Torre D");
            customer.inputCity().sendKeys("Porto Alegre");
            customer.inputState().sendKeys("RS");
            customer.inputPostalCode().sendKeys("91000-000");
            customer.inputCountry().sendKeys("Brasil");
            customer.selectSalesRepEmployeeNumber("Fixter");
            customer.inputCreditLimit().sendKeys("200");

            customer.btnSave().click();

            Assert.assertTrue(customer.lblReportSuccess().getText().contains("Your data has been successfully stored into the database. Edit Customer or Go back to list"));
        }
        catch(Exception e){
            printScreen();
        	e.printStackTrace();
            Assert.assertNull(e, "Erro desafio_01!!!");
        }        
    }

    @Test
    public void desafio_02() throws InterruptedException, IOException {
        WebDriver dr = getDriver();
        GroceryCrudHomePage home = new GroceryCrudHomePage(dr);
        GroceryCrudAddCustomerPage customer = new GroceryCrudAddCustomerPage(dr);

        try{
            home.drpSelectVersion().selectByValue("bootstrap_theme_v4");
            Assert.assertTrue(dr.getCurrentUrl().substring(0).contains("bootstrap_theme_v4"));
            home.btnAddCustomer().click();

            Assert.assertTrue(customer.lblAddCustomer().isDisplayed());

            customer.fillForm();

            Assert.assertTrue(customer.lblReportSuccess().getText().contains("Your data has been successfully stored into the database. Edit Customer or Go back to list"));

            customer.lnkGoBackToList().click();

            home.inputSearchName().sendKeys("Teste Sicredi");
            home.btnRefresh().click();
            Thread.sleep(3000);

            home.chkCustomersList().get(0).click();

            home.btnDelete().click();

            Assert.assertEquals(home.lblAreYouSureWantDelete().getText().trim(), "Are you sure that you want to delete this 1 item?");

            home.btnDeletePopup().click();
            Thread.sleep(1000);

            Assert.assertTrue(home.alertSuccess().getText().trim().contains("Your data has been successfully deleted from the database."));
        }
        catch(Exception e){
            printScreen();
            e.printStackTrace();
            Assert.assertNull(e, "Erro desafio_02!!!");
        }
    }
}
