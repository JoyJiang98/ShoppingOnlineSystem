package userService.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import userService.model.User;
import userService.service.UserService;

import javax.servlet.http.HttpSession;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserService userService;

    @Autowired
    private DiscoveryClient client;

    @PostMapping(value = "/login")
    public User login(@RequestBody User user){
        User u = userService.findByName(user.getName());
        return u;
    }

    @PostMapping(value = "/insertUser")
    public boolean insertUser(@RequestBody User user){
        try{
            userService.save(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }



}
