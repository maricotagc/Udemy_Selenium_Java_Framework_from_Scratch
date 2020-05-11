package mytests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExtendReportsBasicDemo {

    private static WebDriver driver = null;

    public static void main(String[] args) {

        ExtentHtmlReporter htmlReport = new ExtentHtmlReporter("extentReports.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReport);
        ExtentTest test1 = extent.createTest("Google Search Test v3", "this is a test to validate Google Search functionality");

        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chrome/chromedriver.exe");
        driver = new ChromeDriver();

        test1.log(Status.INFO, "Starting execution");
        driver.get("https://google.com");
        test1.pass("Navigated to google.com");
        driver.findElement(By.name("q")).sendKeys("Mariana Moita");
        test1.pass("Entered text in search box");
        driver.findElement(By.id("gsr"));
        test1.pass("Performed search");
        driver.close();
        driver.quit();
        test1.pass("Closed the browser");
        test1.info("Tested completed with success");
        extent.flush();
    }
}
