package com.saveo.medicinerestfulapi.dao;

import com.saveo.medicinerestfulapi.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdersDao extends JpaRepository<Orders,Long> {
}
