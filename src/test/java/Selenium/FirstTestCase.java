package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {
    public static void main(String[] args)
    {
        //ChromeDriver driver = new ChromeDriver();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        String actual_title = driver.getTitle();
        if(actual_title.equals("OrangeHRM"))
        {
        System.out.println("Test Passed");
        }
        else
        {
            System.err.println("Test Failed");
        }
       // driver.quit();



    }
    
}
