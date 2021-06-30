package AmazonPageObject;

import ReusableLibrary.AbstractClass;

public class BaseClass extends AbstractClass {
    //Home Page
    public static HomePage homePage(){
        HomePage homePage = new HomePage(driver);
        return homePage;
    }
    //First Iteam
    public static FirstItem firstItem(){
        FirstItem firstItem= new FirstItem(driver);
        return firstItem;
    }
    // Proceed To checkout
    public static ProceedToChechout proceedToChechout(){
        ProceedToChechout proceedToChechout = new ProceedToChechout(driver);
        return proceedToChechout;
    }
}
