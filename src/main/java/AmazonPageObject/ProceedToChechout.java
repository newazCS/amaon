package AmazonPageObject;

import ReusableLibrary.AbstractClass;
import ReusableLibrary.ReusableActions;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProceedToChechout  extends AbstractClass {
    ExtentTest logger;
    public  ProceedToChechout(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = AbstractClass.logger;
    }

    @FindBy(xpath = "//a[@id='hlb-ptc-btn-native']")
    WebElement proceed;
    public void proceedMethod(){
        ReusableActions.clickOnElement(driver,proceed,logger,"First Book From Search");
    }

}
