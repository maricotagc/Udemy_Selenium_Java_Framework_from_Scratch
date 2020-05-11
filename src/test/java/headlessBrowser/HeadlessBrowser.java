package headlessBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.GoogleSearchPage_v1;


public class HeadlessBrowser {

    private static WebDriver driver = null;

    public static void main(String[] args) {
        googleSearch();
    }

    public static void googleSearch() {

        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chrome/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://google.com");
        GoogleSearchPage_v1.textBox_search(driver).sendKeys("Automation Step By Step");
        GoogleSearchPage_v1.button_search(driver).click();
        driver.close();
        System.out.println("Test completed successfully");
    }
}
