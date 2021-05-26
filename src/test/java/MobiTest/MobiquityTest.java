package MobiTest;

import Request.GetComments;
import Request.GetPosts;
import Request.GetUsers;
import org.apache.commons.validator.routines.EmailValidator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import pojo.Comments;
import pojo.Post;
import pojo.User;
import java.io.IOException;

public class MobiquityTest {

    public static final Logger log = Logger.getLogger(MobiquityTest.class);

    String baseURI;
    Integer userId;
    Post[] userPosts;

    @BeforeTest
    public void prepare() {
        baseURI = "https://jsonplaceholder.typicode.com";
    }



    @Test
    public void searchForUserWithUsername() throws IOException {

        GetUsers getUsers = new GetUsers(baseURI);
        getUsers.setUsername("Delphine");
        getUsers.setStatusCode(200);
        getUsers.setup();
        assert (getUsers.getResponseAsString().contains("Delphine"));
        assert (getUsers.getResponseAsString().contains("Chaim_McDermott@dana.io"));
        log.info("Search for Username delphine");
        User[] users = getUsers.getResponseAsClass(User[].class);
        userId = users[0].getId();
        System.out.println("Delphine users id: "+userId);
        log.info("Username delphine was found with details with id" +userId);

    }

    @Test(dependsOnMethods = { "searchForUserWithUsername" })
    public void searchForPostByUser() throws IOException {

        GetPosts getPosts = new GetPosts(baseURI);
        getPosts.setUserId(userId);
        getPosts.setStatusCode(200);
        getPosts.setup();
        log.info("Get all Posts with user details");
        userPosts = getPosts.getResponseAsClass(Post[].class);
        Integer actualid = userPosts[0].getUserId();
        assert actualid.equals(userId);
        assert userPosts.length > 0;
        int size = userPosts.length;
        log.info("Number of Post by user Delphine is: "+size);
        System.out.println("Number of Post by user Delphine is: "+size);
    }


        @Test(dependsOnMethods = { "searchForPostByUser" })
        public void validateEmailsFormatInComments() throws IOException {

            for (Post userPost: userPosts) {

                GetComments getComments = new GetComments(baseURI);
                getComments.setPostId(userPost.getId());
                getComments.setStatusCode(200);
                getComments.setup();
                log.info("Get Comments of User Posts");
                Comments[] comment = getComments.getResponseAsClass(Comments[].class);
                int size = comment.length;
                log.info("Number of Comment under Posts by user Delphine is: "+size);


                for (Comments comments: comment) {
                    String email = comments.getEmail();
                    boolean result = EmailValidator.getInstance().isValid(email);
                    assert result;
                    log.info("Is  " +email+ " a valid email: "+result);
                    System.out.println("Is  " +email+ " a valid email: "+result);



                }
            }
        }

}