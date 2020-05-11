package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage_v2 {

    WebDriver driver = null;

    By textbox_search = By.name("q");
    By button_search = By.id("gsr");

    public GoogleSearchPage_v2(WebDriver driver) {
        this.driver = driver;
    }

    public void setTextInSearchBox(String textToBeInserted) {
        driver.findElement(textbox_search).sendKeys("");
    }

    public void clickSearchButton() {
        driver.findElement(button_search).click();
    }
}
