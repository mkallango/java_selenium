package fixtures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ElementActions {
    public static WebElement getElementClickable(WebDriver driver, String xpath){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = driver.findElement(By.xpath(xpath));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public static List<WebElement> getElementsClickable(WebDriver driver, String xpath){
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        return elements;
    }


    public static WebElement getElementVisible(WebDriver driver, String xpath){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = driver.findElement(By.xpath(xpath));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
