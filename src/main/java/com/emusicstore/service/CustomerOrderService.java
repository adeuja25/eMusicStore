package com.emusicstore.service;

import com.emusicstore.model.CustomerOrder;

/**
 * Created by Sandeep on 4/6/2017.
 */
public interface CustomerOrderService {

    void addCustomerOrder(CustomerOrder customerOrder);

    double getCustomerOrderGrandTotal(int cartId);
}
