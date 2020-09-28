package bots.users;

import bots.BaseServiceExtender;
import io.restassured.RestAssured;
import mapper.listUsers.GetUsersResponse;

import static helpers.endpointsPath.ACCOUNTS_TRANSACTIONS_POLICY;

public class GetUsers extends BaseServiceExtender {
    public GetUsersResponse GetAllUsers(Integer page, Integer delay) {

        RestAssured.baseURI = getHostname();
        return RestAssured.given()
                .queryParam("page", page)
                .queryParam("delay", delay)
                .when()
                .get(ACCOUNTS_TRANSACTIONS_POLICY).then().statusCode(200).extract().as(GetUsersResponse.class);
    }


}
