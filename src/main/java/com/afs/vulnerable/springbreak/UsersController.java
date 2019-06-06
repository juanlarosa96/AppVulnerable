package com.afs.vulnerable.springbreak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsersController {
    @Autowired
    UsersService service;

    @RequestMapping(value = "/users/{token}", method = RequestMethod.GET)
    @CrossOrigin(origins = "*")
    public ResponseEntity getUserInfo(@Param("id") String id, @PathVariable("token") String token) {
        if(!token.equals("123")) return new ResponseEntity("Invalid token", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<User>(service.getUser(id), HttpStatus.OK);
    }

    // /users?id=1&token=123

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @CrossOrigin(origins = "*")
    public ResponseEntity getInfo() {
        return new ResponseEntity("{\n" +
                "  \"_links\" : {\n" +
                "    \"entity\" : {\n" +
                "      \"href\" : \"http://192.168.0.75:8080/entity{?page,size,sort}\",\n" +
                "      \"templated\" : true\n" +
                "    },\n" +
                "    \"users\" : {\n" +
                "      \"href\" : \"http://192.168.0.75:8080/users{?id,token}\"\n" +
                "    }\n" +
                "  }\n" +
                "}", HttpStatus.OK);
    }

}
