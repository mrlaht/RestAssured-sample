package MobiTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Request.GetUsers;
import org.testng.log4testng.Logger;
import pojo.User;

import java.io.IOException;

public class MobiquityTest {

    public static final Logger log = Logger.getLogger(MobiquityTest.class);

    String baseURI;

    @BeforeTest
    public void prepare() {
        baseURI = "https://jsonplaceholder.typicode.com";
    }

    Integer userId;


    @Test
    public void searchForUserWithUsername() throws IOException {

        GetUsers getUsers = new GetUsers(baseURI);
        getUsers.setUsername("Delphine");
        getUsers.setStatusCode(200);
        getUsers.setup();
        assert (getUsers.getResponseAsString().contains("Delphine"));
        assert (getUsers.getResponseAsString().contains("Chaim_McDermott@dana.io"));
        log.info("Username delphine was found with details");
        User[] users = getUsers.getResponseAsClass(User[].class);
        userId = users[0].getId();
        System.out.println(userId);

    }
 }

