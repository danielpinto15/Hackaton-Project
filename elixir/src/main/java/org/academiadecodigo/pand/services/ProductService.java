package org.academiadecodigo.pand.services;

import org.academiadecodigo.pand.App;
import org.academiadecodigo.pand.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private App app;

    public void addProduct(Product product){

        product.setUser(app.getLoggedInUser());
        app.getProducts().add(product);
        app.getLoggedInUser().getProducts().add(product);

    }

    public App getApp() {
        return app;
    }
    @Autowired
    public void setApp(App app) {
        this.app = app;
    }
}
