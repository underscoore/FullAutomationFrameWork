package com.common;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader extends MainLogger {

	public static String data(String KEY) throws Exception {
		String filePath = CommonUtil.getProperyData("TestDataFile");
		String sheetName = CommonUtil.getProperyData("SheetName");
		Sheet sheet;
		String value = null;

		try

		{
			FileInputStream fileInputStream = new FileInputStream(filePath);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			sheet = workbook.getSheet(sheetName);

			// Assuming the first column contains the keys and the second column contains
			// the values
			int keyColumnIndex = 0;
			int valueColumnIndex = 1;

			// Iterate over the rows to find the matching key-value pair
			for (Row row : sheet) {
				Cell keyCell = row.getCell(keyColumnIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				Cell valueCell = row.getCell(valueColumnIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

				String key = getStringCellValue(keyCell);
				value = getStringCellValue(valueCell);

				if (key.equals(KEY)) {
					logger.info(String.format("Key: " + key + ", Value: " + value));
					break; // Stop searching once a match is found
				}
			}

			workbook.close();
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return value;
	}

	private static String getStringCellValue(Cell cell) {
		if (cell.getCellType() == CellType.STRING) {
			return cell.getStringCellValue();
		} else if (cell.getCellType() == CellType.NUMERIC) {
			return String.valueOf(cell.getNumericCellValue());
		} else if (cell.getCellType() == CellType.BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		} else {
			return "";
		}

	}
}
