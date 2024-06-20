package utilities;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelDataReader {
    private static String filePath;
    private static Workbook workbook;
    private static Sheet sheet;
    private static Map<String, Integer> headers;

    static {
        initialize();
    }

    private static void initialize() {
        filePath = Base.filePathXLS;
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            workbook = WorkbookFactory.create(fileInputStream);
            sheet = workbook.getSheetAt(0);
            readHeaders();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readHeaders() {
        headers = new HashMap<>();
        Row headerRow = sheet.getRow(0);
        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            Cell cell = headerRow.getCell(i);
            if (cell != null) {
                headers.put(cell.getStringCellValue().trim(), i);
            }
        }
    }

    public static String getData(String testCaseName, String columnName) {
        int testCaseColumnIndex = headers.get("testCaseName");
        int columnIndex = headers.get(columnName);

        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            if (row != null) {
                Cell testCaseCell = row.getCell(testCaseColumnIndex);
                if (testCaseCell != null && testCaseCell.getStringCellValue().trim().equals(testCaseName)) {
                    Cell dataCell = row.getCell(columnIndex);
                    if (dataCell != null) {
                        dataCell.setCellType(CellType.STRING);
                        return dataCell.getStringCellValue();
                    }
                }
            }
        }
        return null;
    }

    public static boolean getExecutionRequired(String testCaseName) {
        int testCaseColumnIndex = headers.get("testCaseName");
        int executionRequiredIndex = headers.get("executionRequired");

        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            if (row != null) {
                Cell testCaseCell = row.getCell(testCaseColumnIndex);
                if (testCaseCell != null && testCaseCell.getStringCellValue().trim().equals(testCaseName)) {
                    Cell executionRequiredCell = row.getCell(executionRequiredIndex);
                    if (executionRequiredCell != null) {
                        return !executionRequiredCell.getBooleanCellValue();
                    }
                }
            }
        }
        return false;
    }

    public static void close() throws IOException {
        workbook.close();
    }

    public static void main(String[] args) {
        // Example usage:
        String testCaseName = "testEmptyCart";
        String input = ExcelDataReader.getData(testCaseName, "input");
        String additionalInput = ExcelDataReader.getData(testCaseName, "additionalInput");
        boolean executionRequired = ExcelDataReader.getExecutionRequired(testCaseName);

        System.out.println("Test Case Name: " + testCaseName);
        System.out.println("Input: " + input);
        System.out.println("Additional Input: " + additionalInput);
        System.out.println("Execution Required: " + executionRequired);

        try {
            ExcelDataReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
