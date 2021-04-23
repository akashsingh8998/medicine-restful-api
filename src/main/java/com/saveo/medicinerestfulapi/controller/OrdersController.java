package com.saveo.medicinerestfulapi.controller;

import com.saveo.medicinerestfulapi.entity.Orders;
import com.saveo.medicinerestfulapi.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class OrdersController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("/placeOrder")
    public Long placeOrder(@RequestBody Orders orders) {
        return orderService.placeOrder(orders);
    }
}
