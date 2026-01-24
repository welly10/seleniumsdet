package Selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class LoginTest {

    WebDriver driver;

    @BeforeClass
    void setup()
    {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://opensource-demo.orangehrmlive.com/");



    }
    @Test
    void testLogin()
    {
        LoginPageFactory lp = new LoginPageFactory(driver);
        lp.setUeserName("Admin");
        lp.setPassword("admin123");
        lp.clickLoginButton();

        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
        

    }
    @AfterClass
    void tearDown()
    {
        driver.quit();
    }

}
