package multipleexecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultipleExecution {

    WebDriver driver = null;
    String projectPath = System.getProperty("user.dir");

    @BeforeTest
    @Parameters("browserName")
    public void setUp(String browserName) {
        System.out.println("Browser is " + browserName);

        if (browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chrome/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/firefox/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", projectPath + "/drivers/ie/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
    }

    @Test
    public void test1() throws Exception{
        driver.get("https://google.com");
        Thread.sleep(4000);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        System.out.println("Test completed successfully");
    }

}
