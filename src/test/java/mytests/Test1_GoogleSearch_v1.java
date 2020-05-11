package mytests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage_v1;


public class Test1_GoogleSearch_v1 {

    private static WebDriver driver = null;

    public static void main(String[] args) {
        googleSearch();
    }

    public static void googleSearch() {

        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
        GoogleSearchPage_v1.textBox_search(driver).sendKeys("Automation Step By Step");
        GoogleSearchPage_v1.button_search(driver).click();
        driver.close();
        System.out.println("Test completed successfully");
    }
}
