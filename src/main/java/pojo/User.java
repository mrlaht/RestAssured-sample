package pojo;


import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "id",
            "name",
            "username",
            "email",

    })
    public class User {


        @JsonProperty("id")
        private Integer id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("username")
        private String username;
        @JsonProperty("email")
        private String email;

        @JsonIgnore
        private Map<String, Object> otherObject = new HashMap<>();


        public User() {
        }


        public User(Integer id, String name, String username, String email
                    ) {

            this.id = id;
            this.name = name;
            this.username = username;
            this.email = email;

        }



        @JsonProperty("id")
        public Integer getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(Integer id) {
            this.id = id;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String name) {
            this.name = name;
        }

        @JsonProperty("username")
        public String getUsername() {
            return username;
        }

        @JsonProperty("username")
        public void setUsername(String username) {
            this.username = username;
        }

        @JsonProperty("email")
        public String getEmail() {
            return email;
        }

        @JsonProperty("email")
        public void setEmail(String email) {
            this.email = email;
        }


       @JsonAnySetter
        public void otherObject(String name, Object value) {
            this.otherObject.put(name, value);
        }
}
