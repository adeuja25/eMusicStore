package com.emusicstore.dao.impl;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Sandeep on 3/9/2017.
 */

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{

    @Autowired
    private SessionFactory sessionfactory;

    public Product getProductById(int id){
        Session session = sessionfactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id);
        session.flush();
        return product;
    }

    public List<Product> getProductList(){
        Session session = sessionfactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> productList = query.list();
        session.flush();
        return productList;
    }

    public void addProduct(Product product){
        Session session = sessionfactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public void editProduct(Product product){
        Session session = sessionfactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public void deleteProduct(Product product){
        Session session = sessionfactory.getCurrentSession();
        session.delete(product);
        session.flush();
    }

}

    /*public void addProduct(Product product){
        Session session = sessionfactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public void editProduct(Product product){
        Session session = sessionfactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public Product getProductById(int id){
        Session session = sessionfactory.getCurrentSession();
        Product product = session.get(Product.class, id);
        return product;
    }

    public List<Product> getAllProducts(){
        Session session = sessionfactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> products = query.list();
        session.flush();
        return products;
    }

    public void deleteProduct(int id){
        Session session = sessionfactory.getCurrentSession();
        session.delete(getProductById(id));
        session.flush();
    }*/

