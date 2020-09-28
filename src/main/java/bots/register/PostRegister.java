package bots.register;

import helpers.ReadFromPom;
import io.restassured.RestAssured;
import mapper.postRegister.RegisterRequest;
import mapper.postRegister.RegisterResponse;
import static helpers.endpointsPath.REGISTER_SERVICE;

import java.io.IOException;

public class PostRegister {

    public RegisterRequest registerRequest(String email, String password) {
        return RegisterRequest.builder().withEmail(email).withPassword(password).createInstance();
    }

    public RegisterResponse PostRegister(String email, String password) throws IOException {

        ReadFromPom readFromPom = new ReadFromPom();
        final RegisterRequest request = registerRequest(email,password);
        RestAssured.baseURI = readFromPom.getPropertyFomPom("BaseURL");
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(request)
                .when()
                .post(REGISTER_SERVICE).then().extract().as(RegisterResponse.class);

    }

}
