package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.xml.XmlClass;

public class ReadTestdata {

	public static List<Map<String, String>> readTestData() {
		List<Map<String, String>> testData = new ArrayList<>();
		try (FileInputStream fis = new FileInputStream(new File(Base.filePathXLS));
				Workbook workbook = WorkbookFactory.create(fis)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = sheet.getRow(0);

			int rowCount = sheet.getPhysicalNumberOfRows();
			int columnCount = headerRow.getLastCellNum();

			for (int i = 1; i < rowCount; i++) {
				Row row = sheet.getRow(i);
				Map<String, String> rowData = new HashMap<>();
				for (int j = 0; j < columnCount; j++) {
					Cell cell = row.getCell(j);
					String columnHeader = getCellValue(headerRow.getCell(j));
					String cellValue = getCellValue(cell);
					rowData.put(columnHeader, cellValue);
				}
				testData.add(rowData);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return testData;
	}

	private static String getCellValue(Cell cell) {
		if (cell == null) {
			return "";
		}
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		default:
			return "";
		}
	}
	
	public static List<XmlClass> XmlClassesFromTestngXml() {
        List<XmlClass> xmlClasses = new ArrayList<>();
        
        xmlClasses.add(new XmlClass("testcases.HomePageTest"));

        return xmlClasses;
    }
	
}
