package com.saveo.medicinerestfulapi.service;

import com.saveo.medicinerestfulapi.dao.IMedicineDao;
import com.saveo.medicinerestfulapi.entity.Medicine;
import com.saveo.medicinerestfulapi.utils.CSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
public class MedicineService implements IMedicineService{

    @Autowired
    private IMedicineDao medicineDao;

    @Override
    public ResponseEntity<String> uploadCSV(MultipartFile file) throws IOException {
        if(CSVHelper.isCSVFile(file)){
            medicineDao.saveAll(CSVHelper.csvToMedicine(file.getInputStream()));
            return ResponseEntity.ok().body("File uploaded successfully in Database!");
        }
        return ResponseEntity.badRequest().body("Not a CSV file, Please upload CSV file to continue!");
    }

    @Override
    public List<String> searchMedicine(String query) {
        return medicineDao.findByC_name('%'+query+'%');
    }

    @Override
    public ResponseEntity<Object> getMedicineDetails(String id) {
        Medicine medicine = medicineDao.findByC_unique_code(id);
        if(Objects.nonNull(medicine)){
            return ResponseEntity.ok().body(medicine);
        }else{
            return ResponseEntity.status(404).body("Medicine not found!");
        }
    }
}
