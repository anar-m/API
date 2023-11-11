package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C1_Get_ApiSorgulama {
    /*
        C1_Get_ApiSorgulama
        https://restful-booker.herokuapp.com/booking/83 url'ine bir GET request
        gonderdigimizde donen Response'un,
        status code'unun 200,
        ve content type'inin application/json; charset=utf-8, ve Server isimli Header'in degerinin Cowboy,
        ve status Line'in HTTP/1.1 200 OK
        ve response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.
    */

    // 1- url belirleyip url adresine gideceğiz
    // 2- ecpected data veriilmiş ise ecpected data hazırlanır
    // 3- actual data alınacak
    // 4- assertion işlemi
    @Test
    public void get01(){
        // 1- url belirleyip url adresine gideceğiz (Endpoint Hazırlama)
        String url = "https://restful-booker.herokuapp.com/booking/46";

        // 2- ecpected data açıkça verilirse belirlenecek

        // 3- actual data alınır
        Response response = given().when().get(url);

        // response.prettyPrint();
        System.out.println("status code: " + response.getStatusCode());  // 200
        System.out.println("content type: " + response.getContentType()); // application/json; charset=utf-8
        System.out.println("Server Header Değeri: " + response.getHeader("Server")); // Cowboy
        System.out.println("status Line: " + response.getStatusLine()); // HTTP/1.1 200 OK
        System.out.println(" Get time: " + response.getTime()); // least 5 sn

        // 4- assertion işlemi

    }
}
