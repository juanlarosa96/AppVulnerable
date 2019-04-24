package com.afs.vulnerable.springbreak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsersController {
    @Autowired
    UsersService service;
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<User> getUserInfo(@Param("id") String id) {
        return new ResponseEntity<User>(service.getUser(id), HttpStatus.OK);
    }

}
