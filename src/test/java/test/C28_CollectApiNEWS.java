package test;

import baseUrl.CollectAPIBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C28_CollectApiNEWS extends CollectAPIBaseUrl {

    @Test
    public void haberler(){

        specCollectApi.pathParams("pp1","news","pp2","getNews")
                .queryParams("country","tr","tag","general");

        String token = "0RXn6diTLLdzcZkwbnojRH:2FFns0Uy85lQ2JSmbqIOXo";
        Response response = given().spec(specCollectApi)
                .headers("authorization","apikey "+token)
                .when()
                .get("/{pp1}/{pp2}");

        response.prettyPrint();

    }
}
