package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class AutomationExerciseBaseUrl {

    public static RequestSpecification spec;


    public static void setUp() {


        spec = new RequestSpecBuilder().setBaseUri("https://automationexercise.com/api").build();
    }
}
