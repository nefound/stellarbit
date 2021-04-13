package pages;

import base.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageWithSelectBox {
    private Base base;
    private static final By LAUNCHER = By.id("launcher");
    private static final By PAGE_CONTENT = By.id("page-content");
    private static final By SELECT_BOX = By.id("url-selector");
    private static final String WAITING_TEXT = "Please wait...";

    public PageWithSelectBox(Base base) {
        this.base = base;
    }

    public PageWithSelectBox selectUrlByValue(String value) {
        By by = By.xpath(".//option[text()='" + value + "']");
        base.click(SELECT_BOX);
        base.click(by);
        return this;
    }

    public PageWithSelectBox clickLoad() {
        base.click(LAUNCHER);
        return this;
    }

    public String getMessage() {
        return base.getText(PAGE_CONTENT);
    }

    public PageWithSelectBox waitForResponse(long waitTimeInSeconds, long checkIntervalInSeconds) {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(base.getDriver(), waitTimeInSeconds, checkIntervalInSeconds * 1000);
            webDriverWait.until(ExpectedConditions.invisibilityOfElementWithText(PAGE_CONTENT, WAITING_TEXT));
        } catch (Exception e) {
            Assert.fail("Check is not finished after " + waitTimeInSeconds + " seconds due to " + e.getMessage());
        }
        return this;
    }
}
