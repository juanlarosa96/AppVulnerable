package com.afs.vulnerable.springbreak.controllers;

import com.afs.vulnerable.springbreak.models.User;
import com.afs.vulnerable.springbreak.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import org.springframework.ui.Model;

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
    public String index() {
        return "index";
    }

}
