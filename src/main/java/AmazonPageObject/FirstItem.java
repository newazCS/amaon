package AmazonPageObject;

import ReusableLibrary.AbstractClass;
import ReusableLibrary.ReusableActions;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstItem  extends AbstractClass {
    ExtentTest logger;
    public FirstItem(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = AbstractClass.logger;
    }

    @FindBy(xpath = "(//img[@class='s-image'])[3]")
    WebElement FirstBook;
    public void FirstBookMethod(){
        ReusableActions.clickOnElement(driver,FirstBook,logger,"First Book From Search");
    }

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    WebElement CartButton;
    public void CartButtonMethod(){
        ReusableActions.clickOnElement(driver,CartButton,logger,"First Book From Search");
    }

}
