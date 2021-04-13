package pages;

import base.Base;
import org.openqa.selenium.By;

public class PageWithText {
    private Base base;
    private static final By TEXT = By.xpath(".//body");


    public PageWithText(Base base) {
        this.base = base;
    }

    public String getText() {
        return base.getText(TEXT);
    }
}
