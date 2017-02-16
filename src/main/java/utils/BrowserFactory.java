package utils;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Acer on 11/12/2016.
 */
public class BrowserFactory {
    public static WebDriver driver;

    public static void openBrowser() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.get(AutomationConstant.URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static void closeBrowser() {
        driver.quit();
    }

    public static void takeScreenShot(Scenario scenario) {
        try{
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot,new File(System.getProperty("user.dir")+"/target/"+scenario.getName()+".png"));
        }catch(Exception e){
            System.out.println("Failure to take screenshot "+e);
        }
    }
}

