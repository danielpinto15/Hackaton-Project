package org.academiadecodigo.pand;

import org.academiadecodigo.pand.model.Product;
import org.academiadecodigo.pand.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class App {


    private User loggedInUser;

    private List<User> users = new LinkedList<>();
    private List<Product> products = new LinkedList<>();



    public List<User> getUsers() {

        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void addAllProducts() {

        Product product1 = new Product("1", ProductsInfo.PRODUCT_1_NAME, ProductsInfo.PRODUCT_1_SMALL_DESCRIPTION, ProductsInfo.PRODUCT_1_BIG_DESCRIPTION, ProductsInfo.PRODUCT_1_URL, null);
        Product product2 = new Product("2", ProductsInfo.PRODUCT_2_NAME, ProductsInfo.PRODUCT_2_SMALL_DESCRIPTION, ProductsInfo.PRODUCT_2_BIG_DESCRIPTION, ProductsInfo.PRODUCT_2_URL, null);
        Product product3 = new Product("3", ProductsInfo.PRODUCT_3_NAME, ProductsInfo.PRODUCT_3_SMALL_DESCRIPTION, ProductsInfo.PRODUCT_3_BIG_DESCRIPTION, ProductsInfo.PRODUCT_3_URL, null);
        Product product4 = new Product("4", ProductsInfo.PRODUCT_4_NAME, ProductsInfo.PRODUCT_4_SMALL_DESCRIPTION, ProductsInfo.PRODUCT_4_BIG_DESCRIPTION, ProductsInfo.PRODUCT_4_URL, null);
        Product product5 = new Product("5", ProductsInfo.PRODUCT_5_NAME, ProductsInfo.PRODUCT_5_SMALL_DESCRIPTION, ProductsInfo.PRODUCT_5_BIG_DESCRIPTION, ProductsInfo.PRODUCT_5_URL, null);
        Product product6 = new Product("6", ProductsInfo.PRODUCT_6_NAME, ProductsInfo.PRODUCT_6_SMALL_DESCRIPTION, ProductsInfo.PRODUCT_6_BIG_DESCRIPTION, ProductsInfo.PRODUCT_6_URL, null);

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);


    }
}
