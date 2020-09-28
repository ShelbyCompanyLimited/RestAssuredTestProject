package tests;

import bots.users.GetUsers;
import com.aventstack.extentreports.Status;
import helpers.ReadFromPom;
import helpers.testExtender;
import mapper.listUsers.GetUsersResponse;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class ListUsers extends testExtender{

    static GetUsers getUsers = new GetUsers();

    @Test
    public void ListAllUsers() throws IOException  {
        test = extent.createTest("ListAllUsers");
        logger.info("ListAllUsers");
        test.log(Status.INFO, "ListAllUsers");
        //Those functions will call Get users and do simple assertions
        GetUsersResponse responseGetUsers = getUsers.GetAllUsers(null,null);
//        Assert.assertEquals(String.format("Status Code is %s and should be 200", responseGetUsers.getStatusCode()), responseGetUsers.getStatusCode(), 200);
        Assert.assertEquals(String.format("Page should be with value 1 but found  %s", responseGetUsers.getPage().toString()), responseGetUsers.getPage().toString(), "1");
        Assert.assertEquals(String.format("Items Per Page should be with value 6 but found  %s", responseGetUsers.getPerPage().toString()), responseGetUsers.getPerPage().toString(), "6");

        ReadFromPom reader = new ReadFromPom();
        String property = reader.getPropertyFomPom("testIvan");
        System.out.println(property);
        //This will loop is to call all List Pages, In our case there are 2 Pages and it will loop it for Page 2 and more if they exist
        if (responseGetUsers.getPerPage() > 1) {
            Integer counter = 2;
            while (counter < responseGetUsers.getTotalPages()) {

                GetUsersResponse responseGetUsersByPage = getUsers.GetAllUsers(counter,null);
                Assert.assertEquals(String.format("Page should be with value 1 but found  %s", responseGetUsers.getPage()), responseGetUsers.getPage(), counter);
                counter++;
            }


        }

    }
}
