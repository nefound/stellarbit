package tests;

import base.Base;
import org.junit.After;

public class TestBase {
    Base base = new Base();

    @After
    public void after(){
        base.closeDriver();
    }
}
