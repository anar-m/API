package test;

import baseUrl.JsonPlaceBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testDatas.TestDataJSONPlace;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C18__PUT_TestDataClassKullanimi extends JsonPlaceBaseUrl {
      /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body'e sahip bir PUT
        request yolladigimizda donen response'in
        status kodunun 200, content type'inin "application/json; charset=utf-8",
        Connection header degerinin "keep-alive"
        ve response body'sinin asagida verilen ile ayni oldugunu test ediniz

        Request Body

            {
            "title":"Ali",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }

        Expected Data

            {
            "title":"Ali",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
        */

    @Test
    public void pur01(){
        // 1-Endpoint Hazırlama
        specJsonPlace.pathParams("pp1","posts","pp2",70);

        TestDataJSONPlace testDataJSONPlace = new TestDataJSONPlace();

        JSONObject reqBody = testDataJSONPlace.reqBodyOlusturJSON();

        //2-Expected Data oluştur
        JSONObject expdata = testDataJSONPlace.reqBodyOlusturJSON();

        // 3- Response Kayıt
        Response response = given()
                                    .spec(specJsonPlace)
                                    .contentType(ContentType.JSON)
                                .when()
                                       .body(reqBody.toString())
                                        .put("/{pp1}/{pp2}");
        // 4-Assertion işlemi
        JsonPath respJP = response.jsonPath();

        assertEquals(testDataJSONPlace.okStatusKodu,response.getStatusCode());
        assertEquals(testDataJSONPlace.contentType,response.getContentType());
        assertEquals(testDataJSONPlace.connetionHeader,response.getHeader("Connection"));

        assertEquals(expdata.get("title"),respJP.get("title"));
        assertEquals(expdata.get("body"),respJP.get("body"));
        assertEquals(expdata.get("userId"),respJP.get("userId"));
        assertEquals(expdata.get("id"),respJP.get("id"));



    }
}
