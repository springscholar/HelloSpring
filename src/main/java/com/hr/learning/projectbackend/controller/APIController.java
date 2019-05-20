package com.hr.learning.projectbackend.controller;

import com.hr.learning.projectbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.learning.projectbackend.model.User;

import java.security.Principal;

/**
 * @Request mapping alone will try to find view instead of producing JSON reponse, unless we anotate on method level using @ResponseBody,
 * or at class level using @RestController
 */
@RestController
public class APIController {

    @Autowired
    UserRepository userRepo;

    @RequestMapping(value="/api/getUserName",produces="application/json")
    public Object getUserName(Principal principal){

        User user = new User();
        user.setId(1L);
        user.setName(principal.getName());

        return user;
    }
}
