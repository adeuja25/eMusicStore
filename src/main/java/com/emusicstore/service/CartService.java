package com.emusicstore.service;

import com.emusicstore.model.Cart;

/**
 * Created by Sandeep on 4/5/2017.
 */
public interface CartService {

    Cart getCartById(int cartId);

    void update(Cart cart);
}
