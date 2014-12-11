package com.kiouri.analize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Parser64 {
	
	public static void main(String[] args) throws IOException{
		Parser64 parser64 = new Parser64();
		List<PODescriptor64> poDescriptors = parser64.parse("C:/myWork/64/64.xls");
		System.out.println("poDescriptors.size() = " + poDescriptors.size());
	}
	

	public static List<PODescriptor64> parse(String url) throws IOException {
		FileInputStream file = new FileInputStream(new File(url));
		// Get the workbook instance for XLS file
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		// Get first sheet from the workbook
		HSSFSheet sheet = workbook.getSheetAt(0);
		// Get iterator to all the rows in current sheet 
		Iterator<Row> rowIterator = sheet.iterator();
		List<PODescriptor64> poDescriptors = new ArrayList<PODescriptor64>();
		int i = 0;
		while (rowIterator.hasNext()) {
			if (i == 0) {
				i++;
				rowIterator.next();
				continue;
			}
			Row row = rowIterator.next();
			PODescriptor64 poDescriptor = new PODescriptor64();
			Iterator<Cell> cellIterator = row.cellIterator();
			String rowText = "";
			int j = 0;
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					rowText = cell.getStringCellValue();
				} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					rowText = "" + new Double(cell.getNumericCellValue()).intValue();
				}
				
//				int pointPosition = rowText.indexOf("."); 
//				rowText = rowText.substring(0, pointPosition);
				
				rowText = rowText.trim();
				
				if (j == 0) {
					poDescriptor.setNn(rowText);
				} else if (j == 1) {			
					poDescriptor.setName(rowText);
				} else if (j == 2){
					poDescriptor.setServiceObject(rowText);					
				} else if (j == 3){
					poDescriptor.setServiceName(rowText);
				} else if (j == 4){
					poDescriptor.setUnit(rowText);
				} else if (j == 6){
					poDescriptor.setContractNumber("6401/13-" + rowText.trim());
				} else if (j == 7){
					poDescriptor.setNaznach(rowText);
				} else if (j == 8){
					poDescriptor.setZel(rowText);
				}
				j++;
			}
			if (poDescriptor.getNn().indexOf(".") > 0){
				String nn = poDescriptor.getNn();
				int pointPosition = nn.indexOf("."); 
				nn = nn.substring(0, pointPosition);
				poDescriptor.setNn(nn);
				poDescriptors.add(poDescriptor);
			}
		}
		return poDescriptors;
	}

	public static PODescriptor64 getpoDescriptorByID(String id,List<PODescriptor64> poDescriptors ){
		for (PODescriptor64 poDescriptor : poDescriptors){
			if (poDescriptor.getNn().equalsIgnoreCase(id)){
				return poDescriptor;
			}
		}
		return null;
	}
}
