package tests;

import bots.register.PostRegister;
import helpers.ReadFromPropertiesFile;
import helpers.testExtender;
import mapper.postRegister.RegisterResponse;
import org.junit.Assert;
import org.testng.annotations.Test;

public class UnsuccessfulRegister extends testExtender {

    static PostRegister postRegister = new PostRegister();

    @Test
    public void UnsuccessfulRegisterWithWrongEmailOnly() {
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
    public void UnsuccessfulRegisterWithWrongEmailAndWrongUsername() {
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
