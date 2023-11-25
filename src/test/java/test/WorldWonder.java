package test;

import baseUrl.WWBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class WorldWonder extends WWBaseUrl {

    @Test
    public void WWonder(){

        specWW.pathParams("pp1","/api","pp2","visitorsPurposeList");

        String token ="Bearer 8ChP1RLJKRC3x5FU2nADD4NUIvTfye";

        Response response = given().spec(specWW).header("authorization","Bearer" + token)
                .when().get("/{pp1}/{pp2}");

        response.then().assertThat().statusCode(200);// body("message" , equalTo("Success"));

    }
}
