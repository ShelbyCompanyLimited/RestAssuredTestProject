package tests;

import bots.users.DeleteUser;
import helpers.ReadFromPropertiesFile;
import helpers.testExtender;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

public class DeleteUserById extends testExtender {



    static DeleteUser deleteUser = new DeleteUser();

    @Test
    public void DeleteUser() {

        ReadFromPropertiesFile readFromPropertiesFile = new ReadFromPropertiesFile();
        //Verify that user is deleted by verifying status code 204
        ValidatableResponse responseDeleteUser = deleteUser.DeleteUserById(readFromPropertiesFile.getUserIdForDelete());

    }


}
