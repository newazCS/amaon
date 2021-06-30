package ReusableLibrary;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ReusableActions {
    //Create a reusable method for navigate to a page
    public static WebDriver defineTheDriver() throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static void sendKeysMethod(WebDriver driver, WebElement xpathLocator, String userValue, ExtentTest logger, String elementName){
        // define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);

        //use try catch to locate an element and click on it
        try{
            WebElement element =  wait.until(ExpectedConditions.visibilityOf(xpathLocator));
            element.clear();
            element.sendKeys(userValue);
            logger.log(LogStatus.PASS,"Successfully Send keys ");
        }catch (Exception e){
            System.out.println("Unable to click on element "+elementName+ " "+ e);
        }
    }// end of  sendKeysMethod

    public static void clickOnElement(WebDriver driver, WebElement xpathLocator, ExtentTest logger, String elementName){
        // define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);

        //use try catch to locate an element and click on it
        try{
            wait.until(ExpectedConditions.visibilityOf(xpathLocator)).click();
            logger.log(LogStatus.PASS,"Successfully click on Element"+elementName);
        }catch (Exception e){
            System.out.println("Unable to click on element "+elementName+ " "+ e);
            logger.log(LogStatus.FAIL,"Failure"+elementName);
        }
    }// end of click method

    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver driver,String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTMLReport/Screenshots/";
            snPath = "Screenshots/";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occurred while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method
}
