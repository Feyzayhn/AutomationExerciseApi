package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Brand;

import static base_url.AutomationExerciseBaseUrl.spec;
import static io.restassured.RestAssured.given;

public class A04_ApiPut {

    Response response;

    JsonPath json;

    @Given("D_Url {string}")
    public void d_url(String pathParams) {

        spec.pathParam("1", pathParams);

    }

    @Then("D_Request Method PUT")
    public void d_requestMethodPUT() {

        Brand expectedData = new Brand(35, "Gucci");

        response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().put("/{1}");

        json = response.jsonPath();

        json.prettyPrint();
    }

    @Then("D_Response Code {int}")
    public void d_responseCode(int responseCode) {

        Assert.assertEquals(responseCode,json.getInt("responseCode"));
    }

    @And("Response Message {string}")
    public void responseMessage(String message) {

        Assert.assertEquals(message,json.getString("message"));
    }
}
