package testCases;

import testBase.BaseClass;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass{

   // @Test(groups = "Sanity")
   @Test(groups={"Sanity","Master"})
    public void verify_login() throws InterruptedException
    {
        logger.info("*******  Starting TC002_LoginTest  ***********");
        //driver.wait(5000);

        try
        {
          logger.info("**** After Try ******");
        HomePage hp = new HomePage(driver);

        logger.info("**** My Accoubt click ******");
        hp.MyAccountClick();
        //hp.registerLinkClick();
         logger.info("**** Login link click ******");
        hp.loginLinkClick();
        logger.info("**** Cliked on Login linl******");
        

        LoginPage lp = new LoginPage(driver);
        logger.info("**** Login page landed ******");
        lp.enterEmail(p.getProperty("email"));
        logger.info("**** LEmail inserted******");
        lp.enterPassword(p.getProperty("password"));
        lp.loginButtonClick();

        MyAccountPage mp = new MyAccountPage(driver);

        boolean targetPage= mp.MyAccountHeading();
        Assert.assertEquals(targetPage, true, "Login FAILED");
        Assert.assertTrue(targetPage);
         }
        catch(Exception e)
        {

        Assert.fail();
        }
        

        logger.info("*******  Ending TC002_LoginTest  ***********");
    }
}


