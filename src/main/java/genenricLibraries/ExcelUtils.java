package genenricLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;


public class ExcelUtils {
	
	/**
	 * read data from excel
	 * @param SheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Exception
	 */
	public String readDataFromExcel(String SheetName,int rowNo, int cellNo ) throws Exception {
		FileInputStream fis=new FileInputStream(IPathConstants.excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		String value = sh.getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
	
	/**
	 * read multiple data from excel
	 * @param SheetName
	 * @return
	 * @throws Exception
	 */
	public ArrayList<String> readMultipleDataFromExcel(String SheetName ) throws Exception {
		FileInputStream fis=new FileInputStream(IPathConstants.excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int rowCount = sh.getLastRowNum();
		int cellCount = sh.getRow(0).getLastCellNum();
		
		ArrayList<String> list= new ArrayList<String>();
		
		for(int i=0;i<=rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				String value=sh.getRow(i).getCell(j).getStringCellValue();
				list.add(value);
			}
		}
		
		return list;
}
	/**
	 * getting the row count
	 * @param SheetName
	 * @return
	 * @throws Exception
	 */
	public int getRowCount(String SheetName) throws Exception {
		FileInputStream fis=new FileInputStream(IPathConstants.excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int rowCount = sh.getLastRowNum();
		return rowCount;
	}
	
	/**
	 * getting cell count
	 * @param SheetName
	 * @return
	 * @throws Exception
	 */
	public int getCellCount(String SheetName) throws Exception {
		FileInputStream fis=new FileInputStream(IPathConstants.excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int cellCount = sh.getRow(0).getLastCellNum();
		return cellCount;
	}
	
	
	/**
	 * write data into excel
	 * @param SheetName
	 * @param value
	 * @throws Exception
	 */
	public void writeDataIntoExcel(String SheetName,String value,int rowNo,int cellNo) throws Exception {
		FileInputStream fis=new FileInputStream(IPathConstants.excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		 int row = sh.getLastRowNum();
		Cell cel = sh.getRow(0).createCell(cellNo);
		cel.setCellType(CellType.STRING);
		cel.setCellValue(value);
		FileOutputStream fos=new FileOutputStream(IPathConstants.excelPath);
		wb.write(fos);
		wb.close();	
	}
	
	public Object[][] excelData(String SheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IPathConstants.excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		int rowCount = sh.getPhysicalNumberOfRows();//instead of taking this the getLastRowNum()+1 
		int cellCount = sh.getRow(0).getLastCellNum();


		Object[][] obj=new Object[rowCount][cellCount];
		for(int i=0;i<rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
	
	
	 public void writemultipleDataIntoExcel(
	            String sheetName,
	            String header1,
	            String header2,
	            int startRow,
	            int col1,
	            int col2,
	            List<WebElement> column1Data,
	            List<WebElement> column2Data) throws Exception {

	        FileInputStream fis = new FileInputStream(IPathConstants.excelPath);
	        Workbook wb = WorkbookFactory.create(fis);

	        Sheet sheet = wb.getSheet(sheetName);
	        if (sheet == null) {
	            sheet = wb.createSheet(sheetName);
	        }

	        // Header
	        Row headerRow = sheet.getRow(0);
	        if (headerRow == null) {
	            headerRow = sheet.createRow(0);
	        }
	        headerRow.createCell(col1).setCellValue(header1);
	        headerRow.createCell(col2).setCellValue(header2);

	        int rowIndex = startRow;

	        for (int i = 0; i < column1Data.size() && i < column2Data.size(); i++) {

	            String data1 = column1Data.get(i).getText().trim();
	            String data2 = column2Data.get(i).getText().trim();

	            if (data1.isEmpty() || data2.isEmpty()) continue;

	            Row row = sheet.getRow(rowIndex);
	            if (row == null) {
	                row = sheet.createRow(rowIndex);
	            }

	            row.createCell(col1).setCellValue(data1);
	            row.createCell(col2).setCellValue(data2);

	            rowIndex++;
	        }

	        FileOutputStream fos = new FileOutputStream(IPathConstants.excelPath);
	        wb.write(fos);

	        wb.close();
	    }
}

