package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


// ------ With Page FaCtory -------

public class LoginPageFactory {

    WebDriver driver;

    //Constructor
    LoginPageFactory(WebDriver driver)
    {

        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    //Locators

    @FindBy(xpath="//input[@placeholder='Username']") 
    WebElement txt_username_loc;

    @FindBy(xpath="//input[@placeholder='Password']")
    WebElement txt_password_loc;

    @FindBy(xpath="//button[normalize-space()='Login']")
    WebElement btn_login_loc;


    /* 
    By txt_username_loc = By.xpath("//input[@placeholder='Username']");
    By txt_password_loc = By.xpath("//input[@placeholder='Password']");
    By btn_login_loc = By.xpath("//button[normalize-space()='Login']");
    */

    //Actions Methods

    
    public void setUeserName(String user)
    {
        txt_username_loc.sendKeys(user);
    }

    public void setPassword(String pwd)
    {
        txt_password_loc.sendKeys(pwd);
    }

    public void clickLoginButton()
    {
        btn_login_loc.click();
    }
        
 

    
}
