package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import static base_url.AutomationExerciseBaseUrl.spec;
import static io.restassured.RestAssured.given;

public class A09_ApiDelete {

    Response response;
    JsonPath json;

    @Given("H_Url {string}")
    public void h_url(String pathParams) {


        spec.pathParam("1",pathParams);
    }



    @Then("H_Request Method DELETE")
    public void h_requestMethodDELETE() {

      response = given().spec(spec).when().delete("/{1}");
      json=response.jsonPath();

    }

    @Then("H_Response Code {int}")
    public void h_responseCode(int responseCode) {

        Assert.assertEquals(responseCode,json.getInt("responseCode"));
    }

    @And("H_Response Message {string}")
    public void h_responseMessage(String message) {

        Assert.assertEquals(message,json.getString("message"));
    }
}
