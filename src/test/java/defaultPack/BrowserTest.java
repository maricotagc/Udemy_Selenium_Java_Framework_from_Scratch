package defaultPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserTest {

    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chrome/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com/");
        driver.findElement(By.cssSelector(".gLFyf.gsfi")).sendKeys("Lady Gaga");
        driver.close();
    }
}