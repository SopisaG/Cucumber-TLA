package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.WebDriverUtils;

import java.nio.channels.SelectionKey;

public class Hooks {

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

        WebDriverUtils.quitDriver();
    }
}
