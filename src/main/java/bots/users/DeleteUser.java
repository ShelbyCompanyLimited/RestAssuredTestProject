package bots.users;

import bots.BaseServiceExtender;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import static helpers.endpointsPath.ACCOUNTS_TRANSACTIONS_POLICY;

public class DeleteUser extends BaseServiceExtender {

    public ValidatableResponse DeleteUserById(int userId) {

        RestAssured.baseURI = getHostname();
        return RestAssured.given()
                .when()
                .delete(ACCOUNTS_TRANSACTIONS_POLICY + "/" + userId).then().assertThat().statusCode(204);
    }
}
