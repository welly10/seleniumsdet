package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
    WebElement txt_registerlink_loc;

    @FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
    WebElement txt_Loginlink_loc;

     @FindBy(xpath="//a[@title='My Account']")
    WebElement btn_MyAccount;

      public void MyAccountClick()
    {
        btn_MyAccount.click();
    }

    public void registerLinkClick()
    {
        txt_registerlink_loc.click();
    }

    public void loginLinkClick()
    {
        txt_Loginlink_loc.click();
    }

  




}
