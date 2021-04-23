package com.saveo.medicinerestfulapi.service;

import com.saveo.medicinerestfulapi.entity.Orders;

public interface IOrderService {
    Long placeOrder(Orders order);
}
