package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.awt.Desktop;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener{

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    String repName;

    public void onStart(ITestContext testContext)
    {
        /* 
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        Date dt = new Date();
        String currentdatetimestamp = df.format(dt);
        */ 
       //same code is written in below single like

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //time stamp

        repName = "Test-Report-" + timeStamp + ".html";
        //sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName); //Location of the report
        sparkReporter = new ExtentSparkReporter(
        System.getProperty("user.dir") + File.separator + "reports" + File.separator + repName);

        sparkReporter.config().setDocumentTitle("Open Automation report");
        sparkReporter.config().setReportName("Opencasr Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "opencart");
        extent.setSystemInfo("Module", "Admin");
        extent.setSystemInfo("Sub Module", "Customers");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");

        String os = testContext.getCurrentXmlTest().getParameter("os");
        extent.setSystemInfo("Operating System", os);

        String browser = testContext.getCurrentXmlTest().getParameter("br");
        extent.setSystemInfo("Browser", browser);

        List<String> includeGroups = testContext.getCurrentXmlTest().getIncludedGroups();
        if(!includeGroups.isEmpty())
        {
            extent.setSystemInfo("Groups", includeGroups.toString());
        }
    }

    public void onTestSuccess(ITestResult result)
    {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());//To display groups in report
        test.log(Status.PASS,result.getName()+ "got successfully executed");
    }

    public void onTestFailure(ITestResult result)
    {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());

        test.log(Status.FAIL,result.getName()+"got failed");
        test.log(Status.INFO,result.getThrowable().getMessage());

        try{
            //String imgPath = new BaseClass().captureScreen(result.getName());//chatgpt suggestion
            String imgPath = BaseClass.captureScreen(result.getName());
            test.addScreenCaptureFromPath(imgPath);
        }
        catch(IOException e1)
        {
            e1.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result)
    {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, result.getName()+"got skipped");
        test.log(Status.INFO, result.getThrowable().getMessage());
    }

    public void onFinish(ITestContext testContext)
    {
        extent.flush();

       // String pathofExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
       String pathofExtentReport = System.getProperty("user.dir") + File.separator + "reports" + File.separator + repName;
        System.out.println("**** FILE PATH for Screenshot"+pathofExtentReport);
        File ExtentReport = new File(pathofExtentReport);

       try {
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(ExtentReport.toURI());
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    }
    


}
