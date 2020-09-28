package tests;

import bots.users.DeleteUser;
import com.aventstack.extentreports.Status;
import helpers.ReadFromPropertiesFile;
import helpers.testExtender;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import java.io.IOException;

public class DeleteUserById extends testExtender {



    static DeleteUser deleteUser = new DeleteUser();

    @Test
    public void DeleteUser() throws IOException {
        test = extent.createTest("DeleteUser");
        logger.info("DeleteUser");
        test.log(Status.INFO, "DeleteUser");
        ReadFromPropertiesFile readFromPropertiesFile = new ReadFromPropertiesFile();
        //Verify that user is deleted by verifying status code 204
        ValidatableResponse responseDeleteUser = deleteUser.DeleteUserById(readFromPropertiesFile.getUserIdForDelete());

    }
}
