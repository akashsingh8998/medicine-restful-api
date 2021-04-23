package com.saveo.medicinerestfulapi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IMedicineService {
    ResponseEntity<String> uploadCSV(MultipartFile file) throws IOException;
    List<String> searchMedicine(String query);
    ResponseEntity<Object> getMedicineDetails(String id);
}
