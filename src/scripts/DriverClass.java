package scripts;


import java.sql.Time;
import java.sql.Timestamp;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;


public class DriverClass {
 
    public static String DRIVER_PATH = "drivers/chromedriver.exe";
    private RemoteWebDriver driver = null;
    private String url = "";

    @Parameters({ "url" })
    @BeforeTest
    public void beforeTest(String url) {
        this.url = url;
    }

    public WebDriver getDriver() {
    	try{
            if (driver == null){
                System.setProperty("webdriver.chrome.driver",DRIVER_PATH);
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get(url);
            }
            return driver;
    	}
    	catch(Exception e){
    		System.out.println("***** GET DRIVER ERROR *****");
    		e.printStackTrace();
    		return null;
    	}
    }

 
    @AfterMethod
    public void afterTest(){
        if(driver != null){
            driver.quit();
        }
        driver = null;
    }




    public void printScreen() throws IOException {
        String PATH = "screenshots/";
        String directoryName = PATH.concat(this.getClass().getName());
        String fileName = "/" + System.currentTimeMillis() + ".png";

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
// Now you can do whatever you need to do with it, for example copy somewhere
        FileUtils.copyFile(scrFile, new File(directoryName+fileName));
    }

}
//- See more at: http://www.tothenew.com/blog/parallel-execution-with-selenium-grid/#sthash.DvzESL1e.dpuf