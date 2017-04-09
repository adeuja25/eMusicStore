package com.emusicstore.dao.impl;

import com.emusicstore.dao.CartDao;
import com.emusicstore.model.Cart;
import com.emusicstore.service.CustomerOrderService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Repository
@Transactional
public class CartDaoImpl implements CartDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CustomerOrderService customerOrderService;

    public Cart getCartById(int cartId){
        Session session = sessionFactory.getCurrentSession();
        return (Cart) session.get(Cart.class, cartId);
    }

    public void update(Cart cart){
        int cartId = cart.getCartId();
        double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
        cart.setGrandTotal(grandTotal);

        Session session= sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
    }

    public Cart validate(int cartId) throws IOException{
        Cart cart = getCartById(cartId);

        if(cart!=null|| cart.getCartItems().size()==0){
            throw new IOException(cartId+"");
        }

        update(cart);
        return cart;
    }
}

/*
package com.emusicstore.dao.impl;

import com.emusicstore.dao.CartDao;
import com.emusicstore.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

*/
/**
 * Created by Sandeep on 4/1/2017.
 *//*

@Repository
public class CartDaoImpl implements CartDao {

    private Map<String, Cart> listOfCarts;

    public CartDaoImpl(){
        listOfCarts = new HashMap<String, Cart>();
    }

    public Cart create(Cart cart){
        if(listOfCarts.keySet().contains(cart.getCartId())){
            throw new IllegalArgumentException(String.format("Cannot create a cart. A cart with a given id(%) " +
                    " already " + " exists",cart.getCartId()));
        }
        listOfCarts.put(cart.getCartId(), cart);
        return cart;
    }

    public Cart read(String cartId){
        return listOfCarts.get(cartId);
    }

    public void update(String cartId, Cart cart){
        if(!listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Can not update cart. The cart with the given id(%)" +
                    "does not " + "exist", cart.getCartId()));
        }
        listOfCarts.put(cartId, cart);
    }

    public void delete(String cartId){
        if(!listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Can not delete cart. A cart with a given id(%) " +
                "does not" +"exist", cartId));
        }
        listOfCarts.remove(cartId);
    }
}*/
