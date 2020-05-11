package mytests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage_v2;


public class Test1_GoogleSearch_v2 {

    private static WebDriver driver = null;

    public static void main(String[] args) {
        googleSearch();
    }

    public static void googleSearch() {

        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        GoogleSearchPage_v2 google = new GoogleSearchPage_v2(driver);

        driver.get("https://google.com");
        google.setTextInSearchBox("Automation Step By Step");
        google.clickSearchButton();
        driver.close();
        System.out.println("Test completed successfully");
    }
}
