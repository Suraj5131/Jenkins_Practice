package utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    static {
        try {
            FileInputStream fis =new FileInputStream("src/test/resources/data.xlsx");
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet("Sheet1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getData(String key) {
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String excelKey = row.getCell(0).getStringCellValue();
            if (excelKey.equalsIgnoreCase(key)) {
                return row.getCell(1).getStringCellValue();
            }
        }
        return null;
    }
}