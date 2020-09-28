package bots.users;

import helpers.ReadFromPom;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import java.io.IOException;

import static helpers.endpointsPath.USERS_SERVICE;

public class DeleteUser {

    public ValidatableResponse DeleteUserById(int userId) throws IOException {
        ReadFromPom readFromPom = new ReadFromPom();
        RestAssured.baseURI = readFromPom.getPropertyFomPom("BaseURL");
        return RestAssured.given()
                .when()
                .delete(USERS_SERVICE + "/" + userId).then().assertThat().statusCode(204);
    }
}
