package helpers;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class testExtender {


    @BeforeSuite
    public void createReqSpec() {

        RestAssured.authentication = RestAssured.preemptive().basic("","");
        System.out.println("THis is happening before test");

    }
}
