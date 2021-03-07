package com.heena.ec.Excel;


public class StudentData

{
  public static void main(String[] args) 
  {
      
      XSSFWorkbook workbook = new XSSFWorkbook(); 
       
     
      XSSFSheet sheet = workbook.createSheet("Employee Data");
        
      
      Map<String, Object[]> data = new TreeMap<String, Object[]>();
      data.put("1", new Object[] {"SrNo", "StudentName", "LastName","RollNo","DOB","Contact","Email"});
      data.put("2", new Object[] {1, " ", " "," "," "," "," "});
      data.put("3", new Object[] {2, " ", " "," "," "," "," "});
      data.put("4", new Object[] {3, " ", " "," "," "," "," "});
      data.put("5", new Object[] {4, " ", " "," "," "," "," "});
        
      
      Set<String> keyset = data.keySet();
      int rownum = 0;
      for (String key : keyset)
      {
          Row row = sheet.createRow(rownum++);
          Object [] objArr = data.get(key);
          int cellnum = 0;
          for (Object obj : objArr)
          {
             Cell cell = row.createCell(cellnum++);
             if(obj instanceof String)
                  cell.setCellValue((String)obj);
              else if(obj instanceof Integer)
                  cell.setCellValue((Integer)obj);
          }
      }
      try
      {
          
          FileOutputStream out = new FileOutputStream(new File("Data.xlsx"));
          workbook.write(out);
          out.close();
          System.out.println("Data Enter Sucessfully");
      } 
      catch (Exception e) 
      {
          e.printStackTrace();
      }
  }
}