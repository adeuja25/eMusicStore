package com.emusicstore.dao;

import com.emusicstore.model.Product;

import java.util.List;

/**
 * Created by Sandeep on 3/9/2017.
 */
public interface ProductDao {

    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);

/*    void addProduct(Product product);

    void editProduct(Product product);

    Product getProductById(int id);

    List<Product> getAllProducts();

    void deleteProduct(Product product);*/


}
