package test;

import baseUrl.WWBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class WwonderTeacherGET extends WWBaseUrl {

    @Test
    public void Teacher(){

        specWW.pathParams("pp1","/apiteacher","pp2","homeworkList");

        String token = "Bearer r8VIhAsyBAXq3HeYssgSyw1ifSSd4D";

        Response response = given().spec(specWW).header("authorization" , token )
                .when().get("/{pp1}/{pp2}");

       // response.prettyPeek();

        response.then().assertThat().statusCode(200); //.body("message" ,equalTo("Success"));

    }
}
