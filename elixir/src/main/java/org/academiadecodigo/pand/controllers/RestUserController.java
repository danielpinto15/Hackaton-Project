package org.academiadecodigo.pand.controllers;

import org.academiadecodigo.pand.model.Product;
import org.academiadecodigo.pand.model.User;
import org.academiadecodigo.pand.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class RestUserController {

    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<User>> listCustomers() {

        List<User> userList = userService.userList();

        return new ResponseEntity<>(userList, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/current")
    public ResponseEntity<User> getCurrentUser(){

        User user = userService.getApp().getLoggedInUser();

        return new ResponseEntity<User>(user, HttpStatus.OK);

    }

    @RequestMapping(method =  RequestMethod.GET, path = "/{username}")
    public ResponseEntity<User> showUser(@PathVariable String username){

        User user = userService.getUser(username);

        if(user == null){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return  new ResponseEntity<>(user, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public ResponseEntity<User> login(@RequestBody User user){


        if(userService.logIn(user.getUsername(), user.getPassword())){
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }


    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addCustomer(@RequestBody User user) {


        userService.save(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{username}/product")
    public ResponseEntity<List<Product>> getProducts(@PathVariable String username) {

        List<Product> products = userService.getUser(username).getProducts();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/test")
    public ResponseEntity addTestUsers(){

        User user1 = new User();
        user1.setUsername("zenando");
        user1.setPassword("Password");
        user1.setFirstName("Zé");
        user1.setLastName("Nando");
        user1.setEmail("email");
        user1.setAge(20);
        userService.save(user1);

        User user2 = new User();
        user2.setUsername("daniel");
        user2.setPassword("Paaaa");
        user2.setFirstName("Daniel");
        user2.setLastName("Manuel");
        user2.setEmail("sadfg");
        user2.setAge(12);
        userService.save(user2);

        User user3 = new User();
        user3.setUsername("paulosilva");
        user3.setPassword("Passdopaulo");
        user3.setFirstName("Paulo");
        user3.setLastName("Silva");
        user3.setEmail("emaildopaulo");
        user3.setAge(29);
        userService.save(user3);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
