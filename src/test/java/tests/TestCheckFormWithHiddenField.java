package tests;

import config.ConfProperties;
import org.junit.Assert;
import org.junit.Test;
import pages.PageWithHiddenField;
import pages.PageWithText;

public class TestCheckFormWithHiddenField extends TestBase {
    private static final String URL = ConfProperties.getProperty("pageFirstCase");
    private static final String FIRST_NAME = "First";
    private static final String SECOND_NAME = "Second";
    private static final String HIDDEN = "Hidden";
    private static final String EXPECTED = "Test Passed!";

    @Test
    public void testCheckFormWithHiddenField() {
        base.goToUrl(URL);
        PageWithHiddenField pageWithHiddenField = new PageWithHiddenField(base);
        PageWithText pageWithText = pageWithHiddenField
                .typeFirstName(FIRST_NAME)
                .typeSecondName(SECOND_NAME)
                .typeHidden(HIDDEN)
                .clickSubmit();

        String text = pageWithText.getText();
        Assert.assertEquals("The answer is not correct", EXPECTED, text);
    }
}
