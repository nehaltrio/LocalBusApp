package com.example.projectbusv2.DataManagers;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;

@Service
public class dataFetch {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public String path = "src/main/java/com/example/projectbusv2/DataManagers/DataOfBus.xlsx";

    public dataFetch() {
        try {
            workbook = new XSSFWorkbook(path);
            sheet = workbook.getSheet("Sheet1");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<String> getCellData(String placeFrom, String placeTo) {
        int rowNum = sheet.getPhysicalNumberOfRows();

        ArrayList<String> buses = new ArrayList<>();
        for (int i = 1; i < rowNum; i++) {
            String placeToFind = sheet.getRow(i).getCell(1).getStringCellValue();
            if (placeToFind.toLowerCase().contains(placeFrom.toLowerCase()) &&
                    placeToFind.toLowerCase().contains(placeTo.toLowerCase())) {
                buses.add(sheet.getRow(i).getCell(0).getStringCellValue());
            }
        }
        return buses;
    }

    public HashSet<String> allLocation() {

        String pathTO = "src/main/java/com/example/projectbusv2/DataManagers/Locations.xlsx";

        XSSFWorkbook workbook2;
        XSSFSheet sheet2;
        HashSet<String> location = new HashSet<>();

        try {
            workbook2 = new XSSFWorkbook(pathTO);
            sheet2 = workbook2.getSheet("Sheet1");

            int rowNum = sheet2.getPhysicalNumberOfRows();

            for (int i = 1; i < rowNum; i++) {
                String adr = sheet2.getRow(i).getCell(0).getStringCellValue();
                location.add(adr);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return location;
    }

    public ArrayList<String> searchLoc(String term){
       ArrayList<String> list1 = new ArrayList<>(allLocation());
       ArrayList<String> list2 = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).toLowerCase().contains(term.toLowerCase())){
                list2.add(list1.get(i));
            }
        }

        return list2;
    }



}

