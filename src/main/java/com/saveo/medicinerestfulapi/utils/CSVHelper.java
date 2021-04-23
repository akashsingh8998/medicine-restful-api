package com.saveo.medicinerestfulapi.utils;

import com.saveo.medicinerestfulapi.entity.Medicine;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {

    public static String CSV_TYPE = "text/csv";
    public static String EXCEL_TYPE1 = "application/vnd.ms-excel";
    public static String EXCEL_TYPE2 = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    public static boolean isCSVFile(MultipartFile file) {
        if (CSV_TYPE.equals(file.getContentType())
                || EXCEL_TYPE1.equals(file.getContentType())
                || EXCEL_TYPE2.equals(file.getContentType()) ) {
            return true;
        }
        return false;
    }

    public static List<Medicine> csvToMedicine(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Medicine> medicines = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Medicine medicine = new Medicine();
                medicine.setName(csvRecord.get("c_name"));
                medicine.setBatchNo(csvRecord.get("c_batch_no"));
                medicine.setExpiryDate(new SimpleDateFormat("dd/MM/yyyy").parse(csvRecord.get("d_expiry_date")));
                medicine.setBalanceQty(Integer.parseInt(csvRecord.get("n_balance_qty")));
                medicine.setPackaging(csvRecord.get("c_packaging"));
                medicine.setUniqueCode(csvRecord.get("c_unique_code"));
                medicine.setSchemes(csvRecord.get("c_schemes"));
                medicine.setMrp(Double.parseDouble(csvRecord.get("n_mrp")));
                medicine.setManufacturer(csvRecord.get("c_manufacturer"));
                medicine.setHsnCode(Long.parseLong(csvRecord.get("hsn_code")));
                medicines.add(medicine);
            }

            return medicines;
        } catch (IOException | ParseException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

}

