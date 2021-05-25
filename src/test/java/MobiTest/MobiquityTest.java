package MobiTest;

import model.Post;
import org.testng.Assert;
import org.testng.annotations.Test;

import service.PostService;
import service.UserService;

import java.util.List;

public class MobiquityTest {


    UserService userService;
    PostService postService;

    public MobiquityTest(){
        userService=new UserService();
        postService=new PostService();
    }

    @Test
    public void searchForUserWithUsernameDelpine() throws Exception {

            //Get Delphine's Details
            Integer id = userService.getDephineId();
            Assert.assertNotNull(id);
            //Get Dephine's Posts
            List<Post> delphinePosts=postService.getPosts(id);
            System.out.println(delphinePosts);
        }

    }

