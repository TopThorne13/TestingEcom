package utilities;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    public static List<TestCase> readTestCases() throws IOException {
        List<TestCase> testCases = new ArrayList<>();
        FileInputStream fis = new FileInputStream(Base.filePathXLS);
        Workbook workbook = new HSSFWorkbook(fis); 
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue; // Skip header row
            }
            TestCase testCase = new TestCase();
            testCase.setTestClass(getCellValue(row.getCell(0)));
            testCase.setTestCaseName(getCellValue(row.getCell(1)));
            testCase.setInput(getCellValue(row.getCell(2)));
            testCase.setAdditionalInput(getCellValue(row.getCell(3)));
            testCase.setExecutionRequired("Yes".equalsIgnoreCase(getCellValue(row.getCell(4))));
            testCases.add(testCase);
        }

        workbook.close();
        fis.close();
        return testCases;
    }

    private static String getCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                switch (cell.getCachedFormulaResultType()) {
                    case STRING:
                        return cell.getRichStringCellValue().getString();
                    case NUMERIC:
                        return String.valueOf(cell.getNumericCellValue());
                    case BOOLEAN:
                        return String.valueOf(cell.getBooleanCellValue());
                    default:
                        return "";
                }
            case BLANK:
                return "";
            default:
                return "";
        }
    }
}
