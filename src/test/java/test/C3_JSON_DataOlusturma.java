package test;

import org.json.JSONObject;
import org.junit.Test;

public class C3_JSON_DataOlusturma {
        /*
        Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":1
    }
        */
    @Test
    public void JSONData(){
        JSONObject jsondata = new JSONObject();

        jsondata.put("title", "Ahmet");
        jsondata.put("body", "Merhaba");
        jsondata.put("userId", 1);

        System.out.println("İlk oluşturduğum jsondata =  " + jsondata);

    }
    @Test
    public void innerJson(){
        /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.

    {
    "firstname":"Jim",
    "additionalneeds":"Breakfast",
    "bookingdates":{
                "checkin":"2018-01-01",
                "checkout":"2019-01-01"
                },
    "totalprice":111,
    "depositpaid":true,
    "lastname":"Brown"
       }
 */
        JSONObject innerJSONobj = new JSONObject();
        innerJSONobj.put("checkin", "2018-01-01");
        innerJSONobj.put("checkout", "2019-01-01");

        JSONObject jsonData = new JSONObject();
        jsonData.put("firstname", "Jim");
        jsonData.put("additionalneeds","Breakfast");
        jsonData.put("bookingdates", innerJSONobj);
        jsonData.put("totalprice", "111");
        jsonData.put("depositpaid",true);
        jsonData.put("lastname", "Brown");

        System.out.println("JSONData = " + jsonData);
        /*
        JSONData = {"firstname":"Jim",
        "additionalneeds":"Breakfast",
        "bookingdates":
        {"checkin":"2018-01-01","checkout":"2019-01-01"},
        "totalprice":"111",
        "depositpaid":true,
        "lastname":"Brown"}
         */
    }

}
