package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class PageWithHiddenField {
    private Base base;
    private static final By FIRST_NAME_FIELD = By.id("firstname");
    private static final By SECOND_NAME_FIELD = By.id("lastname");
    private static final By SUBMIT_BUTTON = By.xpath(".//input[@type='submit']");

    public PageWithHiddenField(Base base) {
        this.base = base;
    }

    public PageWithHiddenField typeFirstName(String text) {
        base.type(FIRST_NAME_FIELD, text);
        return this;
    }

    public PageWithHiddenField typeSecondName(String text) {
        base.type(SECOND_NAME_FIELD, text);
        return this;
    }

    public PageWithHiddenField typeHidden(String text) {
        JavascriptExecutor javascript = (JavascriptExecutor) base.getDriver();
        javascript.executeScript("var element = document.getElementById('hiddenfield'); element.value = '" + text + "';");
        return this;
    }

    public PageWithText clickSubmit() {
        base.click(SUBMIT_BUTTON);
        return new PageWithText(base);
    }
}
