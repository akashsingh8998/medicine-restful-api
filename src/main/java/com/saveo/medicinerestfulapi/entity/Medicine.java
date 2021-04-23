package com.saveo.medicinerestfulapi.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "c_name")
    private String name;

    @Column(name = "c_batch_no")
    private String batchNo;

    @Column(name = "d_expiry_date")
    private Date expiryDate;

    @Column(name = "n_balance_qty")
    private Integer balanceQty;

    @Column(name = "c_packaging")
    private String packaging;

    @Column(name = "c_unique_code")
    private String uniqueCode;

    @Column(name = "c_schemes")
    private String schemes;

    @Column(name = "n_mrp")
    private Double mrp;

    @Column(name = "c_manufacturer")
    private String manufacturer;

    @Column(name = "hsn_code")
    private Long hsnCode;
}
