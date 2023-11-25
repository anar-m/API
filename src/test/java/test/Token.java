package test;

import baseUrl.WWBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Token extends WWBaseUrl {

    @Test
    public void tokenAlma(){

        specWW.pathParams("pp1" ,"/api" ,"pp2" ,"getToken");

        // BsvOkZvUs9tp1yVO2pQ5bwoMyCPoFG

        JSONObject reqBody = new JSONObject();
        reqBody.put("email" ,"teacher@wonderworldcollege.com");
        reqBody.put("password" , "o6*d@fko3PXL1");

        Response response = given().spec(specWW).contentType(ContentType.JSON)
                .when().body(reqBody.toString()).put("/{pp1}/{pp2}");

        response.then().assertThat().statusCode(200);

      }
}
