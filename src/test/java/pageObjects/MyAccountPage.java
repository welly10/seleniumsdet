package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

    public MyAccountPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath="//h2[normalize-space()='My Account']")
    WebElement txt_MyAccountheading_loc;

    @FindBy(xpath="  //ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
    WebElement btn_logout_loc;



    public boolean MyAccountHeading()
    {
        try
        {
        return txt_MyAccountheading_loc.isDisplayed();
        }
        catch(Exception e)
        {
            return false;
        }
    }



    public void logoutClick()
    {
        btn_logout_loc.click();
    }

    //ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']



}
