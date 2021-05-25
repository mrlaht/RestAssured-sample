package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;

import java.util.List;
import java.util.Optional;

public class UserService {

    public Integer getDephineId()throws Exception{
        ObjectMapper mapper=new ObjectMapper();
        String resp = ApiService.doGetRequest("https://jsonplaceholder.typicode.com/users").as(String.class);
        List<User> userList = mapper.readValue(resp, new TypeReference<>() {
        });
        // userList.forEach(user -> System.out.println(user.toString()));
        Integer id=null;
        Optional<User> delphine=userList.stream().filter(x->"Delphine".equalsIgnoreCase(x.getUsername())).findFirst();
        return delphine.map(User::getId).orElse(null);
    }
}
