package com.saveo.medicinerestfulapi.dao;

import com.saveo.medicinerestfulapi.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMedicineDao  extends JpaRepository<Medicine,Long> {

    @Query(value = "select m.name from Medicine m where m.name like ?1")
    List<String> findByC_name(String name);

    @Query(value = "select m from Medicine m where m.uniqueCode = ?1")
    Medicine findByC_unique_code(String c_unique_code);
}
