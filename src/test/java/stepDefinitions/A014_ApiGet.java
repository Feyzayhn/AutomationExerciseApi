package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static base_url.AutomationExerciseBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class A014_ApiGet {


    Response response;
    JsonPath json;

    @Given("Z_API URL {string} {string}")
    public void z_apiURL(String pathParam, String query) {

        spec.pathParams("1", pathParam).queryParam("email", "exercise@gmail.com");
    }

    @When("Z_Request Method GET")
    public void z_requestMethodGET() {

        response = given().spec(spec).when().get("/{1}");
        json = response.jsonPath();
    }

    @Then("Z_Response Code {int}")
    public void z_responseCode(int responseCode) {

        assertEquals(200, response.getStatusCode());

        assertEquals(responseCode, json.getInt("responseCode"));
    }

    @And("Z_Response JSON User Detail")
    public void z_responseJSONUserDetail() {

        json.prettyPrint();

        assertEquals("Automation", json.getString("user.name"));
        assertEquals("exercise@gmail.com", json.getString("user.email"));
        assertEquals("Mrs", json.getString("user.title"));
        assertEquals("7", json.getString("user.birth_day"));
        assertEquals("1", json.getString("user.birth_month"));
        assertEquals("1993", json.getString("user.birth_year"));
        assertEquals("Automation", json.getString("user.first_name"));
        assertEquals("Exercise", json.getString("user.last_name"));
        assertEquals("Free", json.getString("user.company"));
        assertEquals("Hollanda state", json.getString("user.address1"));
        assertEquals("most beautiful street in holland", json.getString("user.address2"));
        assertEquals("Canada", json.getString("user.country"));
        assertEquals("Jordaan state", json.getString("user.state"));
        assertEquals("Jordaan city", json.getString("user.city"));
        assertEquals("857595", json.getString("user.zipcode"));
    }
}



