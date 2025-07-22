package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {

    private static final String FILE_PATH = "src/test/resources/testdata/testdata.xlsx";

    public static String getDataByTestCaseAndColumn(String sheetName, String testCaseID, String columnHeader) {
        try (FileInputStream fis = new FileInputStream(FILE_PATH)) {
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            Row headerRow = sheet.getRow(0); // first row has headers
            int totalCols = headerRow.getLastCellNum();

            int colIndex = -1;
            for (int i = 0; i < totalCols; i++) {
                if (headerRow.getCell(i).getStringCellValue().trim().equalsIgnoreCase(columnHeader)) {
                    colIndex = i;
                    break;
                }
            }

            if (colIndex == -1) throw new Exception("Column not found: " + columnHeader);

            for (int r = 1; r <= sheet.getLastRowNum(); r++) {
                Row row = sheet.getRow(r);
                if (row.getCell(0).getStringCellValue().equalsIgnoreCase(testCaseID)) {
                    return row.getCell(colIndex).getStringCellValue();
                }
            }

            throw new Exception("Test case ID not found: " + testCaseID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

