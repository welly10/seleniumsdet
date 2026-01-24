package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

    public AccountRegistrationPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath="//input[@id='input-firstname']")
    WebElement txt_FirstNameField_loc;

    @FindBy(xpath="//input[@id='input-lastname']")
    WebElement txt_LastNameField_loc;

    @FindBy(xpath="//input[@id='input-email']")
    WebElement txt_EmailField_loc;

    @FindBy(xpath="//input[@id='input-telephone']")
    WebElement txt_TelephoneField_loc;

    @FindBy(xpath="//input[@id='input-password']")
    WebElement txt_NewPasswordField_loc;

    @FindBy(xpath="//input[@id='input-confirm']")
    WebElement txt_ConfirmPasswordField_loc;

    @FindBy(xpath="//input[@value='Continue']")
    WebElement btn_Continue_loc;
    

     @FindBy(xpath="//input[@name='agree']")
    WebElement chkbx_checkBox_loc;

    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement txt_SuccessConfirmation_loc;

    @FindBy(xpath="//a[normalize-space()='Continue']")
    WebElement btn_ContinueSuccess_loc;
   

    

    



    public void setFirstName(String fname)
    {
        txt_FirstNameField_loc.sendKeys(fname);
    }

    public void setLastName(String lname)
    {
        txt_LastNameField_loc.sendKeys(lname);
    }

    public void setEmail(String email)
    {
        txt_EmailField_loc.sendKeys(email);
    }

    public void setTelephoneno(String tel)
    {
        txt_TelephoneField_loc.sendKeys(tel);
    }

    public void setNewPassword(String pwd)
    {
    txt_NewPasswordField_loc.sendKeys(pwd);
    }

    public void setConfirmPassword(String pwd)
    {
        txt_ConfirmPasswordField_loc.sendKeys(pwd);
    }

    public void ContinueBtnClick()
    {
        btn_Continue_loc.click();
    }

     public void CheckBoxBTick()
    {
        chkbx_checkBox_loc.click();
    }

    public String confirmationMsg()
    {
       try{
        return(txt_SuccessConfirmation_loc.getText());
       }
       catch(Exception e)
       {
        return (e.getMessage());
       }
        
    }

     public void ClickContinueBtn()
    {
        btn_ContinueSuccess_loc.click();
    }
    
}