package org.academiadecodigo.pand.services;

import org.academiadecodigo.pand.App;
import org.academiadecodigo.pand.controllers.RestUserController;
import org.academiadecodigo.pand.model.Product;
import org.academiadecodigo.pand.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private RestUserController userController;
    private App app;

    public boolean logIn(String username, String password) {

        for (User u : app.getUsers()) {
            if ((u.getUsername().equals(username)) && (u.getPassword().equals(password))) {
                app.setLoggedInUser(u);
                return true;
            }
        }

        return false;

    }

    public void signUp(User user) {

        app.getUsers().add(user);

    }


    @Autowired
    public void setApp(App app) {
        this.app = app;
    }


    public RestUserController getUserController() {
        return userController;
    }

    @Autowired
    public void setUserController(RestUserController userController) {
        this.userController = userController;
    }

    public App getApp() {
        return app;
    }

    public List<User> userList() {
        return app.getUsers();
    }

    public List<Product> productList() {
        return app.getProducts();
    }

    public User save(User user) {
        app.getUsers().add(user);
        return null;
    }

    public User getUser(String username) {

        for (User u : app.getUsers()) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }
}
