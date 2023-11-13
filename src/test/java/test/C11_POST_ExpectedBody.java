package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C11_POST_ExpectedBody {
    /*
    https://restful-booker.herokuapp.com/booking url'ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response'un id disinda asagidaki gibi oldugunu test edin.
                        Request body
                   {
                        "firstname" : "Ahmet",
                        "lastname" : "Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                 "checkin" : "2021-06-01",
                                 "checkout" : "2021-06-10"
                                          },
                        "additionalneeds" : "wi-fi"
                    }


                       Response Body - Expected Body
                   {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                             }
                    }
*/

    @Test
    public void postEx(){
        // 1-
        String url = " https://restful-booker.herokuapp.com/booking";


        JSONObject innerDate= new JSONObject();
        innerDate.put("checkin" ,"2021-06-01" );
        innerDate.put("checkout","2021-06-10" );

        JSONObject reqBody = new JSONObject();
        reqBody.put("firstname", "Ahmet");
        reqBody.put("lastname", "Bulut");
        reqBody.put("totalprice", 500);
        reqBody.put("depositpaid", false);
        reqBody.put("bookingdates", innerDate);
        reqBody.put("additionalneeds", "wi-fi");

        // 2- expexted body oluştur

       // JSONObject innerDates= new JSONObject();
       // innerDates.put("checkin" ,"2021-06-01" );
       // innerDates.put("checkout","2021-06-10" );
       // JSONObject innerPers = new JSONObject();
       // innerPers.put("firstname", "Ahmet");
       // innerPers.put("lastname", "Bulut");
       // innerPers.put("totalprice", 500);
       // innerPers.put("depositpaid", false);
       // innerPers.put("bookingdates", innerDates);
       // innerPers.put("additionalneeds", "wi-fi");

        JSONObject expBody = new JSONObject();
        expBody.put("bookingid", 24);
        expBody.put("booking",reqBody); // beklentimin gönderdiğim ile gelenin aynısı olması olduğu için expData= resBody

        //3- Response kaydet
        Response response = given()
                                    .contentType(ContentType.JSON)
                            .when()
                                    .body(reqBody.toString()).post(url);

        // 4- Assertion işlemi
        JsonPath resJP = response.jsonPath();

        Assert.assertEquals(expBody.getJSONObject("booking").get("firstname"),resJP.get("booking.firstname"));
        Assert.assertEquals(expBody.getJSONObject("booking").get("lastname"),resJP.get("booking.lastname"));
        Assert.assertEquals(expBody.getJSONObject("booking").get("totalprice"),resJP.get("booking.totalprice"));
        Assert.assertEquals(expBody.getJSONObject("booking").get("depositpaid"),resJP.get("booking.depositpaid"));
        Assert.assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),resJP.get("booking.bookingdates.checkin"));
        Assert.assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),resJP.get("booking.bookingdates.checkout"));
        Assert.assertEquals(expBody.getJSONObject("booking").get("additionalneeds"),resJP.get("booking.additionalneeds"));

    }
}



