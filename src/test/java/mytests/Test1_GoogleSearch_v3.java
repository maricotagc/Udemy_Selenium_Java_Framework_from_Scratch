package mytests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GoogleSearchPage_v2;

public class Test1_GoogleSearch_v3 {

    WebDriver driver = null;

    @BeforeTest
    public void setUp() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chrome/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void googleSearch() {
        GoogleSearchPage_v2 google = new GoogleSearchPage_v2(driver);
        driver.get("https://google.com");
        google.setTextInSearchBox("Automation Step By Step");
        google.clickSearchButton();
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
        System.out.println("Test completed successfully");
    }
}
