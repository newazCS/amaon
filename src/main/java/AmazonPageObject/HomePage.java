package AmazonPageObject;

import ReusableLibrary.AbstractClass;
import ReusableLibrary.ReusableActions;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractClass {
    ExtentTest logger;
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = AbstractClass.logger;
    }
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement SearchBox;
    public void SearchBoxMethod(String searchValue){
        ReusableActions.sendKeysMethod(driver,SearchBox,searchValue,logger,"Search box");
    }
    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    WebElement ClickOnButton;

    public void ClickOnButtonMethod(){
        ReusableActions.clickOnElement(driver,ClickOnButton,logger,"Click on search Button");
    }

}
