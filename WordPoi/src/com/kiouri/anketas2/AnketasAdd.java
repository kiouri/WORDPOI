package com.kiouri.anketas2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class AnketasAdd {
	
	private static String gsPath = "c:\\hhh\\templates\\GK_List.xls";
	private static SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
	
	public GsAdd getGSByNum(String num, String gsListPath) throws IOException{
		num = num.trim();
		FileInputStream file = new FileInputStream(new File(gsListPath));
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.next();
		while (rowIterator.hasNext()){
			Row row = rowIterator.next();			
			Cell cell   = row.getCell(0);
			String rownum = "";
			try {
				rownum = "" +  (int) Math.round(cell.getNumericCellValue());
			} catch (Exception e){
				continue;
			}
			if (rownum.equalsIgnoreCase(num)){
				String systemName = "";
				try {
					systemName = row.getCell(1).getStringCellValue();
				} catch (Exception e){}
				
				String contractDate = "";
				try {
					contractDate = dt1.format(row.getCell(4).getDateCellValue());
				}catch (Exception e){}					

				
				String destination = "";
				try {
				destination = row.getCell(13).getStringCellValue();
				} catch (Exception e){}
				
				String perpuse = "";
				try {
					perpuse = row.getCell(14).getStringCellValue();
				}  catch (Exception e){}
				
				String gkNum = "";
				try {
					gkNum = row.getCell(2).getStringCellValue();
				}catch (Exception e){}
				
				List<String> gkVersionDates = new ArrayList<String>();
				for (int i = 0; i < 6; i++){
					try {
						String vDate = dt1.format(row.getCell(i + 4).getDateCellValue());
						gkVersionDates.add(vDate);
					}catch (Exception e){}					
				}

				GsAdd gsAdd = new GsAdd();
				gsAdd.setSystemName(systemName);
				gsAdd.setContractDate(contractDate);
				gsAdd.setDestination(destination);
				gsAdd.setPerpuse(perpuse);
				gsAdd.setGkNum(gkNum);
				gsAdd.setGkDates(gkVersionDates);
				file.close();
				return gsAdd;
			}			
		}
		file.close();
		return null;
	}
	
////////////////////////////////////////////////////////////
	public static void main(String[] args) throws IOException{
		AnketasAdd aa = new AnketasAdd();
		GsAdd gsAdd = aa.getGSByNum("1", gsPath);
		System.out.println(gsAdd);
	}
	
}

