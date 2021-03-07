package com.heena.ec.Assignment7;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 

public class DynamicData {
 
    private static final String FILE_PATH = "C:\\Document\\Assignment7\\studentData.xlsx";
    String apiUrl = "https://api.npoint.io/c9c01ee094f7dcb1ef63";
	String json_response = getJsonResponse(apiUrl);
    public static void main(String args[]) {
 
        List studentList = getStudentsListFromExcel();
 
        System.out.println(studentList);
    }
 
    private static List getStudentsListFromExcel() {
    	String apiUrl = " https://api.npoint.io/e2bf17efd9061da5c8f9";
		String json_response = getJsonResponse(apiUrl);
        List studentList = new ArrayList();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(FILE_PATH);
 
            
            Workbook workbook = new XSSFWorkbook(fis);
 
            int numberOfSheets = workbook.getNumberOfSheets();
 
            
            for (int i = 0; i < numberOfSheets; i++) {
                Sheet sheet = workbook.getSheetAt(i);
                Iterator rowIterator = sheet.iterator();
 
                
                while (rowIterator.hasNext()) {
 
                    Student student = new Student();
                    Row row = rowIterator.next();
                   
                    while (cellIterator.hasNext()) {
 
                        Cell cell = cellIterator.next();
                        
                        if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
                            student.setName(cell.getStringCellValue());
 
                            
                        } else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
 
                            
                            if (cell.getColumnIndex() == 1) {
                                student.setMaths(String.valueOf(cell.getNumericCellValue()));
                            }
                            
                            else if (cell.getColumnIndex() == 2) {
                                student.setScience(String.valueOf(cell.getNumericCellValue()));
                            }
                            
                            else if (cell.getColumnIndex() == 3) {
                                student.setEnglish(String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                    }
                    
                    studentList.add(student);
                }
            }
 
            fis.close();
            String apiUrl = "https://api.npoint.io/2b5dd68d882f772ca037\r\n";
    		String json_response = getJsonResponse(apiUrl);
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentList;
    }
 
 
}
