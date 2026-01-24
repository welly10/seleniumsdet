package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath="//input[@id='input-email']")
    WebElement txt_eamillogin_loc;

    @FindBy(xpath="//input[@id='input-password']")
    WebElement txt_password_loc;

    //input[@id='input-firstname']

    @FindBy(xpath="//input[@value='Login']")
    WebElement btn_login_loc;


    public void enterEmail(String email)
    {
        txt_eamillogin_loc.sendKeys(email);
    }

    public void enterPassword(String pwd)
    {
        txt_password_loc.sendKeys(pwd);
    }

    public void loginButtonClick()
    {
        btn_login_loc.click();
    }




}
