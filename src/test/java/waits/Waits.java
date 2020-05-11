package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waits {

    public static void toWait() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("por do sol");
        driver.findElement(By.id("gsr")).click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("abcd")));

        driver.findElement(By.name("abcd")).click();

        driver.close();
        driver.quit();
    }

    public static void main(String[] args) {
        Waits.toWait();
    }
}
