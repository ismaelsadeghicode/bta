package com.mapsa.dao;

import com.mapsa.model.Cart;

import java.util.List;

public interface CartDao {
    Cart getCartById(long id);
    void addCart(Cart cart);
    void editCart(Cart cart);
    void deleteCart(Cart cart);
    List<Cart> FindListCartByAccountId(long id);

}
