package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.Post;
import model.User;

import java.util.List;
import java.util.Optional;

public class PostService {




    public List<Post> getPosts(Integer userId)throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        String resp = ApiService.doGetRequestWithParam("https://jsonplaceholder.typicode.com/posts", "userId", userId ).as(String.class);
        List<Post> postList = mapper.readValue(resp, new TypeReference<>() {
        });
        return postList;
        }

    }
