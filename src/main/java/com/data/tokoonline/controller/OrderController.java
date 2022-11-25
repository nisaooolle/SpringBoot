package com.data.tokoonline.controller;

import com.data.tokoonline.dto.OrderDTO;
import com.data.tokoonline.model.Order;
import com.data.tokoonline.response.ResponseHelper;
import com.data.tokoonline.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/all")
    public Object getAllOrder() {
        return ResponseHelper.ok(orderService.getAllOrder());
    }

    @GetMapping("/{id}")
    public Object getOrderById(@PathVariable("id")Long id) {
        return ResponseHelper.ok(orderService.getOrderById(id)) ;
    }

    @PostMapping
    public Object addOrder(@RequestBody OrderDTO orderDTO) {
        return ResponseHelper.ok(orderService.addOrder(modelMapper.map(orderDTO,Order.class)));
    }

    @PutMapping("/{id}")
    public Object editOrderById(@PathVariable("id") Long id, @RequestBody Order order) {
        return ResponseHelper.ok(orderService.editOrderById(id,order.getNamaBarang(),order.getHarga(),order.getPemilik()));
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable("id") Long id) { orderService.deleteOrderById(id);}
}
