package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{


    @Test(groups = {"Regression","Master"})
    public void verify_account_registration()
    {
        logger.info("**** Starting AccountRegistrationTest ******");
        System.out.println("");
        try
        {
        HomePage hp = new HomePage(driver);
        hp.MyAccountClick();
        logger.info("*** Clicked on MyAccount link ****");
        hp.registerLinkClick();
        logger.info("*** Clicked on Register link ****");

        AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
        
        regpage.setFirstName(randomString().toUpperCase());
        regpage.setLastName(randomString().toUpperCase());
        regpage.setEmail(randomString()+"@gmail.com");
        regpage.setTelephoneno(randomNumber());
        regpage.setNewPassword("hiashdfiauhd8998");
        regpage.setConfirmPassword("hiashdfiauhd8998");
        //regpage.CheckBoxBTick();
        regpage.ContinueBtnClick();
        logger.info("*** Validating Expected message ****");
        String confmsg = regpage.confirmationMsg();
        if(confmsg.equals("Your Account Has Been Created!"))
        {
          
            Assert.assertTrue(true);
        }
        else
        {
            logger.error("message failed");
            logger.debug("Debug log...");
            Assert.assertTrue(false);
        }
        Assert.assertEquals(confmsg, "Your Account Has Been Created!");
        }
        catch(Exception e)
        {
        
            Assert.fail();

            logger.info("*** Finished TC001_AccountRegistration Test ****");
        }
    }
    
    
}
