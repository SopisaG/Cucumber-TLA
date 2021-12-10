package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CucumberLogUtils;
import utils.WebDriverUtils;

import java.nio.channels.SelectionKey;
import java.util.concurrent.Callable;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
       // System.out.println(scenario.getName());
        CucumberLogUtils.initScenario(scenario);


    }

    @After
    public void tearDown(Scenario scenario) {

        if(scenario.isFailed())
            CucumberLogUtils.logFail("Scenario: " + scenario.getName() + " FAILED", true);
        WebDriverUtils.quitDriver();
    }
}
