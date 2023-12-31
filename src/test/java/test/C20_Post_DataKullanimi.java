package test;

import baseUrl.HerOkuAppBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testDatas.TestDataHerOkuApp;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C20_Post_DataKullanimi extends HerOkuAppBaseURL {
            /*
           https://restful-booker.herokuapp.com/booking url'ine asagidaki body'ye sahip
           bir POST request gonderdigimizde donen response'un status kodunun 200 ve id haric
           body'sinin asagidaki gibi oldugunu test edin.



        Expected Body
        {
           "bookingid":24,
           "booking":{
                   "firstname":"Ali",
                   "lastname":"Bak",
                   "totalprice":500,
                   "depositpaid":false,
                   "bookingdates":{
                                   "checkin":"2021-06-01",
                                   "checkout":"2021-06-10"
                                   },
                   "additionalneeds":"wi-fi"
                      }
           }
            */

    @Test
    public void post01(){

        specHerOkuApp.pathParam("pp1","booking");

        TestDataHerOkuApp testDataHerOkuApp = new TestDataHerOkuApp();

        JSONObject reqBody = testDataHerOkuApp.reqBodyOlusturJSON();

        JSONObject expBody = testDataHerOkuApp.expectedBodyOlusturJSON();

        Response response = given().spec(specHerOkuApp).contentType(ContentType.JSON)
                .when().body(reqBody.toString()).post("/{pp1}");

        JsonPath resqJP = response.jsonPath();

        assertEquals(testDataHerOkuApp.okStatuskodu,response.getStatusCode());
        assertEquals(expBody.getJSONObject("booking").get("firstname"),resqJP.get("booking.firstname"));
        assertEquals(expBody.getJSONObject("booking").get("lastname"),resqJP.get("booking.lastname"));
        assertEquals(expBody.getJSONObject("booking").get("totalprice"),resqJP.get("booking.totalprice"));
        assertEquals(expBody.getJSONObject("booking").get("depositpaid"),resqJP.get("booking.depositpaid"));
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),resqJP.get("booking.bookingdates.checkin"));
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),resqJP.get("booking.bookingdates.checkout"));
        assertEquals(expBody.getJSONObject("booking").get("additionalneeds"),resqJP.get("booking.additionalneeds"));





    }

}
