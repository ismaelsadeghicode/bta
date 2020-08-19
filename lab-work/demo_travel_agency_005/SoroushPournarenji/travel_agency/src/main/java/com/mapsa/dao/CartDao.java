package com.mapsa.dao;

import com.mapsa.model.Cart;

public interface CartDao {
    Cart getCartById(long id);
    void addCart(Cart cart);
    void editCart(Cart cart);
    void deleteCart(Cart cart);

}
