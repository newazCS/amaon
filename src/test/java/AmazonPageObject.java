import ReusableLibrary.AbstractClass;
import AmazonPageObject.BaseClass;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AmazonPageObject extends AbstractClass {
    @Test
    public void amazonSearchBox() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        BaseClass.homePage().SearchBoxMethod("qa testing for beginners");
        BaseClass.homePage().ClickOnButtonMethod();
        BaseClass.firstItem().FirstBookMethod();
        String BookPrice = driver.findElement(By.xpath("//span[contains(text(),'$47.49')]")).getText();
        logger.log(LogStatus.PASS,"Original book price "+BookPrice);
        BaseClass.firstItem().CartButtonMethod();
        String CartPrice = driver.findElement(By.xpath("//span[contains(text(),'$47.49')]")).getText();
        logger.log(LogStatus.PASS,"After book added to the cart "+CartPrice);
        Assert.assertEquals(BookPrice,CartPrice);
        BaseClass.proceedToChechout().proceedMethod();





    }
}
