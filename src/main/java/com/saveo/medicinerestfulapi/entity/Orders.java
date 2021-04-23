package com.saveo.medicinerestfulapi.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "c_unique_id")
    private String uniqueId;

    @Column(name = "c_name")
    private String name;

    @Column(name = "quantity")
    private Integer quantity;
}
