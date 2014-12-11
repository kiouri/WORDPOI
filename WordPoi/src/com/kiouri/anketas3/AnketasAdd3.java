package com.kiouri.anketas3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.kiouri.anketas2.AnketasAdd;
import com.kiouri.anketas2.GsAdd;

public class AnketasAdd3 {

//	public static String gsPath = "c:\\hh2\\templates\\GK_List_.xls";
	public static String gsPath = "c:\\hh2full\\templates\\GK_List_full.xls";
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
					contractDate = dt1.format(row.getCell(3).getDateCellValue());
				}catch (Exception e){}					

				
				String destination = "";
				try {
				destination = row.getCell(19+6).getStringCellValue();
				} catch (Exception e){}
				
				String perpuse = "";
				try {
					perpuse = row.getCell(20+6).getStringCellValue();
				}  catch (Exception e){}
				
				String gkNum = "";
				try {
					gkNum = row.getCell(2).getStringCellValue();
				}catch (Exception e){}
				
				List<String> gkVersionDates = new ArrayList<String>();
//				for (int i = 0; i < 10; i++){
				for (int i = 0; i < 100; i++){
					try {
						String vDate = dt1.format(row.getCell(i + 5).getDateCellValue());
						gkVersionDates.add(vDate);
					}catch (Exception e){
//						System.out.println("Date error!!!");
					}					
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
		AnketasAdd3 aa = new AnketasAdd3();
		GsAdd gsAdd = aa.getGSByNum("12", gsPath);
		System.out.println(gsAdd);
	}
	
	
}
