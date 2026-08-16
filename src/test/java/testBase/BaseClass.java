package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

    public static WebDriver driver;
    public Logger logger;   // Log4j
    public Properties p;

     @BeforeClass (groups={"Sanity","Regression","Master"})
     @Parameters({"os","br"})
    public void setup(String os, String br) throws IOException
    {

        // Loading config.properties file

        String userdir = System.getProperty("user.dir");
        System.out.println("User Directory printing: " +userdir);

        System.out.println("**** OS **** " + os);
        System.out.println("**** Browser: ****" + br);

        //FileReader file = new FileReader("/Users/wellington.gonsalves/Documents/SeleniumFrameworkSDET/seleniumsdet/src/test/resources/config.properties");
        FileReader file = new FileReader(userdir+"/src/test/resources/config.properties");
        p= new Properties();
        p.load(file);

        logger = LogManager.getLogger(this.getClass());
        
       

        if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
        {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            //OS
            if (os.equalsIgnoreCase("windows"))
            {
                capabilities.setPlatform(Platform.WIN11);
            }
            else if (os.equalsIgnoreCase("mac"))
            {
                capabilities.setPlatform(Platform.MAC);
            }
             else if (os.equalsIgnoreCase("linux"))
            {
                capabilities.setPlatform(Platform.LINUX);
            }
            else
            {
                System.out.println("No matching OS");
                return;
            }
            
            //Browser

            switch(br.toLowerCase())
            {
                case "chrome": capabilities.setBrowserName("chrome");
                break;
                case "edge": capabilities.setBrowserName("MicrosoftEdge");
                break;
                case "firefox": capabilities.setBrowserName("firefox");
                break;
                default: System.out.println("No matching browser in Remote");
            }
            //driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
            driver = new ChromeDriver();

        }
        if(p.getProperty("execution_env").equalsIgnoreCase("local"))
        {
        switch(br.toLowerCase())
        {
            case "chrome": driver = new ChromeDriver(); break;
            case "firefox": driver = new FirefoxDriver(); break;
            case "safari": driver = new SafariDriver(); break;
            case "edge": driver = new EdgeDriver(); break;
            default: System.out.println("Invalid browser name in Local"); return;
        }
    }

        //driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(p.getProperty("appURL")); // Reading URL from Config.properties file
       // driver.manage().window().maximize();
    }

    @AfterClass (groups={"Sanity","Regression","Master"})
    public void tearDown()
    {
        driver.quit();
    }
    
       public String randomString()
        {
            String generatedString = RandomStringUtils.randomAlphabetic(5);
            return generatedString;  
        }

         public String randomNumber()
        {
            String generatedNumber = RandomStringUtils.randomNumeric(8);
            return generatedNumber;  
        }

        public static String captureScreen(String tname) throws IOException //chatgpt suggestion put static keyword
        {
            String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
// Create screenshots directory if not exists
    String screenshotsDir = System.getProperty("user.dir")+ File.separator + "screenshots";

    File dir = new File(screenshotsDir);
    if (!dir.exists()) {
        dir.mkdirs();
    }

    String targetFilePath = screenshotsDir
            + File.separator + tname + "_" + timeStamp + ".png";
            File targetFile = new File(targetFilePath);

            //sourceFile.renameTo(targetFile);//ChatGPT throws error
            org.apache.commons.io.FileUtils.copyFile(sourceFile, targetFile);

            return targetFilePath;

            
        }

}
