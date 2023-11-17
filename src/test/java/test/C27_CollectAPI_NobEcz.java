package test;

import baseUrl.CollectAPIBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C27_CollectAPI_NobEcz extends CollectAPIBaseUrl {

    @Test
    public void NobetciEcz(){

        specCollectApi.pathParams("pp1","health","pp2","dutyPharmacy")
                        .queryParams("ilce","Üsküdar","il","İstanbul");

        String token = "0RXn6diTLLdzcZkwbnojRH:2FFns0Uy85lQ2JSmbqIOXo";
        Response response = given().spec(specCollectApi)
                .headers("authorization","apikey "+token)
                .when()
                .get("/{pp1}/{pp2}");

        System.out.println("status code = " + response.statusCode());
        response.prettyPrint();
    }
}
