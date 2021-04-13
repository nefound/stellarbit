package base;

import config.ConfProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
    private WebDriver driver;

    public Base() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("driver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public void click(By by) {
        WebElement foundElem = driver.findElement(by);
        foundElem.click();
    }

    public String getText(By by){
        return driver.findElement(by).getText();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void type(By by, String text) {
        WebElement foundElem = driver.findElement(by);
        foundElem.clear();
        foundElem.sendKeys(text);
    }

    public void closeDriver() {
        driver.close();
    }
}
