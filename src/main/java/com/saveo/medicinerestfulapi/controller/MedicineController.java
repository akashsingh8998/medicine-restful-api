package com.saveo.medicinerestfulapi.controller;

import com.saveo.medicinerestfulapi.service.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MedicineController {

    @Autowired
    private IMedicineService medicineService;

    @PostMapping("/uploadCSV")
    public ResponseEntity<String> uploadMedicines(@RequestParam("file") MultipartFile file) throws IOException {
        return medicineService.uploadCSV(file);
    }

    @GetMapping("/searchMedicine")
    public List<String> searchMedicine(@RequestParam String query) {
        return medicineService.searchMedicine(query);
    }

    @GetMapping("/getMedicineDetails/{id}")
    public ResponseEntity<Object> getMedicineDetails(@PathVariable(value = "id") String id) {
        return medicineService.getMedicineDetails(id);
    }
}
