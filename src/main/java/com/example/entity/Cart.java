package com.example.entity;

import java.util.List;

public class Cart {
    List<Order> cartList;

    public Cart() {
    }

    public Cart(List<Order> cartList) {
        this.cartList = cartList;
    }

    public List<Order> getCartList() {
        return cartList;
    }

    public void setCartList(List<Order> cartList) {
        this.cartList = cartList;
    }
}
