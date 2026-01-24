package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// ------- Without PageFactory -----------------

public class LoginPage {

    WebDriver driver;

    //Constructor
    LoginPage(WebDriver driver)
    {

        this.driver=driver;

    }

    //Locators

    By txt_username_loc = By.xpath("//input[@placeholder='Username']");
    By txt_password_loc = By.xpath("//input[@placeholder='Password']");
    By btn_login_loc = By.xpath("//button[normalize-space()='Login']");


    //Actions Methods

    public void setUeserName(String user)
    {
        driver.findElement(txt_username_loc).sendKeys(user);
    }

    public void setPassword(String pwd)
    {
        driver.findElement(txt_password_loc).sendKeys(pwd);
    }

    public void clickLoginButton()
    {
        driver.findElement(btn_login_loc).click();
    }
 

    
}
