package com.data.tokoonline.service;

import com.data.tokoonline.model.Order;

public interface OrderService {

    Order  addOrder (Order order);

    Object getOrderById (Long id);

    Object getAllOrder();

    Object editOrderById(Long id,String namaBarang, String harga, String pemilik);

    void deleteOrderById(Long Id);
}
