package tests;

import config.ConfProperties;
import org.junit.Assert;
import org.junit.Test;
import pages.PageWithSelectBox;

public class TestCheckFormWithSelectBox extends TestBase {
    private static final String URL = ConfProperties.getProperty("pageSecondCase");
    private static final String NOT_SELECTED = "Please select";
    private static final String WRONG = "Wrong";
    private static final String CORRECT = "Correct";
    private static final String SUCCESS_NOT_SELECTED = "WRONG URL";
    private static final String SUCCESS_WRONG = "FAILURE";
    private static final String SUCCESS_CORRECT = "Nice! Great success!";

    @Test
    public void testNotSelected() {
        testCommon(NOT_SELECTED, SUCCESS_NOT_SELECTED);
    }

    @Test
    public void testWrong() {
        testCommon(WRONG, SUCCESS_WRONG);
    }

    @Test
    public void testCorrect() {
        testCommon(CORRECT, SUCCESS_CORRECT);
    }

    private void testCommon(String value, String success) {
        base.goToUrl(URL);
        PageWithSelectBox pageWithSelectBox = new PageWithSelectBox(base);
        pageWithSelectBox
                .selectUrlByValue(value)
                .clickLoad()
                .waitForText(120, 5);
        String text = pageWithSelectBox.getMessage();
        Assert.assertEquals("Message doesn't respond to expected", text, success);
    }
}
