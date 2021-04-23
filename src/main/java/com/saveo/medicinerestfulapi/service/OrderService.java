package com.saveo.medicinerestfulapi.service;

import com.saveo.medicinerestfulapi.dao.IOrdersDao;
import com.saveo.medicinerestfulapi.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService{

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public Long placeOrder(Orders order) {
        Orders placedOrder = ordersDao.save(order);
        return placedOrder.getOrderId();
    }
}
