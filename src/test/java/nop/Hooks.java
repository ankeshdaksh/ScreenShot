package nop;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.BrowserFactory;

/**
 * Created by Acer on 11/12/2016.
 */
//*****Screen Shot******
public class Hooks {

    public Scenario scenario;

    @Before
    public void setUp() {
        BrowserFactory.openBrowser();
    }

    @After
    public void teaDown(Scenario scenario) {
        this.scenario = scenario;
        if (scenario.isFailed()) {
            BrowserFactory.takeScreenShot(scenario);
        } else {
            BrowserFactory.closeBrowser();
        }
    }
}
