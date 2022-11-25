package com.data.tokoonline.service;

import com.data.tokoonline.exception.EmailException;
import com.data.tokoonline.exception.InternalErorException;
import com.data.tokoonline.exception.NotFoundException;
import com.data.tokoonline.model.Order;
import com.data.tokoonline.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServicelmpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order addOrder(Order order) {
        if (orderRepository.findByPemilik(order.getPemilik()).isPresent()) {
            throw new EmailException("Email already exist");
        }
        return orderRepository.save(order);
    }

    @Override
    public Object getOrderById(Long id) {
        var order = orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Id tidak ditemukan"));
        try {
            return orderRepository.findById(id);
        }catch (Exception e) {
            throw new InternalErorException("Kesalahan memunculkan data");
        }
    }

    @Override
    public Object getAllOrder() {
        try {
            return orderRepository.findAll();
        }catch (Exception e) {
            return "Kesalahan memunculkan data";
        }
    }

    @Override
    public Order editOrderById(Long id, String namaBarang, String harga, String pemilik) {
        Order order = orderRepository.findById(id).get();
        order.setNamaBarang(namaBarang);
        order.setHarga(harga);
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrderById(Long Id) {
        orderRepository.deleteById(Id);
    }
}
