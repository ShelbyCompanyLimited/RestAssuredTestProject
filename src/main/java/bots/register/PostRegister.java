package bots.register;

import bots.BaseServiceExtender;
import io.restassured.RestAssured;
import mapper.postRegister.RegisterRequest;
import mapper.postRegister.RegisterResponse;

public class PostRegister extends BaseServiceExtender {

    public RegisterRequest registerRequest(String email, String password) {
        return RegisterRequest.builder().withEmail(email).withPassword(password).createInstance();
    }

    public RegisterResponse PostRegister(String email, String password) {
        final RegisterRequest request = registerRequest(email,password);
        RestAssured.baseURI = getHostname();
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(request)
                .when()
                .post(getRegisterService()).then().extract().as(RegisterResponse.class);

    }

}
