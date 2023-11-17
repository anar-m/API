package test;

import baseUrl.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.DummyDataPOJO;
import pojos.DummyExpectedDataPOJO;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class C25_GET_POJOKullanimi extends DummyBaseUrl {
                /*
            http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
            gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
            Response Body --Expected Data
            {
            "status": "success",
            "data": {
                    "id": 3,
                    "employee_name": "Ashton Cox",
                    "employee_salary": 86000,
                    "employee_age": 66,
                    "profile_image": ""
                     },
            "message": "Successfully! Record has been fetched."
            }
             */
    @Test
    public void get01(){
        specDummy.pathParams("first","api","second","v1","third","employee","fourth","3");

        // 2- expected data hazırlama
        DummyDataPOJO data = new DummyDataPOJO(3,"Asthon Cox",86000,66,"");
        DummyExpectedDataPOJO expDataPOJO = new DummyExpectedDataPOJO("success",data,"Successfully! Record has been fetched.");

        Response response = given().spec(specDummy).when().get("/{first}/{second}/{third}/{fourth}");

        // response.prettyPrint();

        DummyExpectedDataPOJO resqPOJO = response.as(DummyExpectedDataPOJO.class);
        assertEquals(expDataPOJO.getStatus(),resqPOJO.getStatus());
        assertEquals(expDataPOJO.getData().getId(),resqPOJO.getData().getId());
        assertEquals(expDataPOJO.getData().getEmployee_name(),resqPOJO.getData().getEmployee_name());
        assertEquals(expDataPOJO.getData().getEmployee_salary(),resqPOJO.getData().getEmployee_salary());
        assertEquals(expDataPOJO.getData().getEmployee_age(),resqPOJO.getData().getEmployee_age());
        assertEquals(expDataPOJO.getData().getProfile_image(),resqPOJO.getData().getProfile_image());
        assertEquals(expDataPOJO.getMessage(),resqPOJO.getMessage());

    }

}
