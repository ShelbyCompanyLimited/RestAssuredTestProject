package bots.users;

import helpers.ReadFromPom;
import io.restassured.RestAssured;
import mapper.listUsers.GetUsersResponse;

import java.io.IOException;

import static helpers.endpointsPath.USERS_SERVICE;

public class GetUsers {
    public GetUsersResponse GetAllUsers(Integer page, Integer delay) throws IOException {
        ReadFromPom readFromPom = new ReadFromPom();
        RestAssured.baseURI = readFromPom.getPropertyFomPom("BaseURL");
        return RestAssured.given()
                .queryParam("page", page)
                .queryParam("delay", delay)
                .when()
                .get(USERS_SERVICE).then().statusCode(200).extract().as(GetUsersResponse.class);
    }


}
