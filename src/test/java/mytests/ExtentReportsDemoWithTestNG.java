package mytests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class ExtentReportsDemoWithTestNG {

    ExtentHtmlReporter htmlReport = null;
    ExtentReports extent = null;
    WebDriver driver = null;

    @BeforeSuite
    public void setUp() {
        htmlReport = new ExtentHtmlReporter("extentReports.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReport);
    }

    public void beforeTest() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chrome/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test() throws Exception {

        ExtentTest test = extent.createTest("Google Search Test with TestNG", "this is a test to validate Google Search functionality");
        test.log(Status.INFO, "Starting execution");
        driver.get("https://google.com");
        test.pass("Navigated to webpage");

        test.info("This step shows usage of info method");
        test.fail("Detalhes", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        test.addScreenCaptureFromPath("screenshot.png");
    }

    @AfterTest
    public void tearDowntest() {
        driver.close();
        driver.quit();
    }

    @AfterSuite
    public void tearDown() {
        extent.flush();
    }
}
