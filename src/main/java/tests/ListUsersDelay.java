package tests;

import bots.users.GetUsers;
import com.aventstack.extentreports.Status;
import helpers.ReadFromPropertiesFile;
import helpers.testExtender;
import mapper.listUsers.GetUsersResponse;
import org.testng.annotations.Test;

import java.io.IOException;

public class ListUsersDelay extends testExtender {


    static GetUsers getUsers = new GetUsers();

    @Test
    public void GetDelayedResponsePositiveNumber() throws IOException {
        test = extent.createTest("GetDelayedResponsePositiveNumber");
        logger.info("GetDelayedResponsePositiveNumber");
        test.log(Status.INFO, "GetDelayedResponsePositiveNumber");
        ReadFromPropertiesFile readFromPropertiesFile = new ReadFromPropertiesFile();
        //Get Users List with postivie query parameter as Delay
        GetUsersResponse responseGetUsersQueryparm = getUsers.GetAllUsers(null,readFromPropertiesFile.getPositiveDelay());
        System.out.println("OVA E RESPONSE");
        System.out.println(responseGetUsersQueryparm.getPage().toString());

    }



}
