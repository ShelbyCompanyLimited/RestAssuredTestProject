package tests;

import bots.register.PostRegister;
import com.aventstack.extentreports.Status;
import helpers.ReadFromPropertiesFile;
import helpers.testExtender;
import mapper.postRegister.RegisterResponse;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class UnsuccessfulRegister extends testExtender {

    static PostRegister postRegister = new PostRegister();

    @Test
    public void UnsuccessfulRegisterWithWrongEmailOnly() throws IOException {
        test = extent.createTest("UnsuccessfulRegisterWithWrongEmailOnly");
        logger.info("UnsuccessfulRegisterWithWrongEmailOnly");
        test.log(Status.INFO, "UnsuccessfulRegisterWithWrongEmailOnly");
        ReadFromPropertiesFile readFromPropertiesFile = new ReadFromPropertiesFile();
        //Try to do unsuccessful Register and validate the response message
        RegisterResponse responseUnsuccessfulRegister = postRegister.PostRegister(readFromPropertiesFile.getEmail(), "");
//        Assert.assertEquals(String.format("Status Code is %s and should be 200",
//                responseUnsuccessfulRegister.getStatusCode()),
//                responseUnsuccessfulRegister.getStatusCode(),
//                400);
        Assert.assertEquals(String.format("Error Message is not correct, it should be 'Missing password' but found ' %s '",
                responseUnsuccessfulRegister.getError()),
                responseUnsuccessfulRegister.getError(),
                readFromPropertiesFile.getRegisterErrorMessage());

    }


    @Test
    public void UnsuccessfulRegisterWithWrongEmailAndWrongUsername() throws IOException {
        test = extent.createTest("UnsuccessfulRegisterWithWrongEmailAndWrongUsername");
        logger.info("UnsuccessfulRegisterWithWrongEmailAndWrongUsername");
        test.log(Status.INFO, "UnsuccessfulRegisterWithWrongEmailAndWrongUsername");
        ReadFromPropertiesFile readFromPropertiesFile = new ReadFromPropertiesFile();
        //Try to do unsuccessful Register and validate the response message
        RegisterResponse responseUnsuccessfulRegister = postRegister.PostRegister(readFromPropertiesFile.getEmail(), readFromPropertiesFile.getPassword());
//        Assert.assertEquals(String.format("Status Code is %s and should be 200",
//                responseUnsuccessfulRegister.getStatusCode()),
//                responseUnsuccessfulRegister.getStatusCode(),
//                400);
        Assert.assertEquals(String.format("Error Message is not correct, it should be" + readFromPropertiesFile.getRegisterErrorMessageWithPassword() + "but found ' %s '",
                responseUnsuccessfulRegister.getError()),
                responseUnsuccessfulRegister.getError(),
                readFromPropertiesFile.getRegisterErrorMessageWithPassword());

    }




}
