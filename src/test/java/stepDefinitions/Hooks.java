package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static base_url.AutomationExerciseBaseUrl.setUp;

public class Hooks {

    @Before
    public void automationSetUp(Scenario scenario){

        setUp();
    }
}
