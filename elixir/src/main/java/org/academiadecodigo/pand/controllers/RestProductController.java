package org.academiadecodigo.pand.controllers;

import org.academiadecodigo.pand.App;
import org.academiadecodigo.pand.model.Product;
import org.academiadecodigo.pand.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/product")
public class RestProductController {


    ProductService productService;
    Product activeProduct;


    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<Product>> listProducts(){

        List<Product> productList = productService.getApp().getProducts();

        return new ResponseEntity<>(productList, HttpStatus.OK);

    }


    @RequestMapping(method = RequestMethod.GET, path = "/{name}")
    public ResponseEntity<Product> showProduct(@PathVariable String name){

        Product product = null;

        for (Product p: productService.getApp().getProducts()){
            if (p.getName().equals(name)){
                product = p;
            }
        }

        return new ResponseEntity<>(product, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/setactive/{number}")
    public ResponseEntity setActiveProduct(@PathVariable String number){


        for (Product c : productService.getApp().getProducts()){
            if (c.getId().equals(number)){
                activeProduct = c;
            }
        }

        return new ResponseEntity(HttpStatus.OK);

    }



    @RequestMapping(method = RequestMethod.GET, path = "/addallproducts")
    public ResponseEntity addAllProducts(){

        productService.getApp().addAllProducts();

        return new ResponseEntity(HttpStatus.OK);

    }




    public ProductService getProductService() {
        return productService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public Product getActiveProduct() {
        return activeProduct;
    }

    public void setActiveProduct(Product activeProduct) {
        this.activeProduct = activeProduct;
    }
}
