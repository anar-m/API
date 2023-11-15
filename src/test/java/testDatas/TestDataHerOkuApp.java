package testDatas;

import org.json.JSONObject;

public class TestDataHerOkuApp {

    public int okStatuskodu = 200;
    /*
    Request body
              {
              "firstname" : "Ali",
              "lastname" : "Bak",
              "totalprice" : 500,
              "depositpaid" : false,
              "bookingdates" : {
                             "checkin" : "2021-06-01",
                             "checkout" : "2021-06-10"
                               },
              "additionalneeds" : "wi-fi"
               }
     */
    JSONObject bookingDatasOlusturJSON(){

        JSONObject bookingDatas = new JSONObject();
        bookingDatas.put("checkin","2021-06-01" );
        bookingDatas.put("checkout","2021-06-10" );
        return bookingDatas;
    }

    public JSONObject reqBodyOlusturJSON(){
        JSONObject booking = new JSONObject();
        booking.put("firstname","Ali");
         booking.put("lastname","Bak");
         booking.put("totalprice", 500);
         booking.put("depositpaid",false);
         booking.put("bookingdates",bookingDatasOlusturJSON());
         booking.put("additionalneeds","wi-fi");
         return booking;
    }

    public JSONObject expectedBodyOlusturJSON(){
        /*
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
        JSONObject expData = new JSONObject();
        expData.put("bookingid", 24);
        expData.put("bookingid", reqBodyOlusturJSON());
        return expData;

    }




}
