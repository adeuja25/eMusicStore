package com.emusicstore.dao;

import com.emusicstore.model.CustomerOrder;

/**
 * Created by Sandeep on 4/6/2017.
 */
public interface CustomerOrderDao {

    void addCustomerOrder(CustomerOrder customerOrder);

    // double getCustomerOrderTotal(int cartId);
}
