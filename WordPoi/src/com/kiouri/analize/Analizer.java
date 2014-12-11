package com.kiouri.analize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.kiouri.CreateTechResum;
import com.kiouri.Params;

public class Analizer {
	
	private String[] documents = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "37"};
	
	private boolean isItemForDocumentation(String docNum){
		docNum = docNum.trim();
		for (int i = 0; i < documents.length; i++){
			if (docNum.equals(documents[i])){
				return true;
			}
		}
		return false;
	}

	public Params parceExcel(String url, Params params, boolean isDocs) throws IOException {
		Answers answers = new Answers();
		List<String> significantList = new ArrayList<String>();
		List<String> unSignificantList = new ArrayList<String>();
		
		List<String> significantDataList = new ArrayList<String>();
		List<String> unSignificantDataList = new ArrayList<String>();
		
		List<String> significantRecomendationList = new ArrayList<String>();
		List<String> unSignificantRecomendationList = new ArrayList<String>();
		
		List<String> significantDataRecomendationList = new ArrayList<String>();
		List<String> unSignificantDataRecomendationList = new ArrayList<String>();
		
		
		FileInputStream file = new FileInputStream(new File(url));
		// Get the workbook instance for XLS file
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		// Get first sheet from the workbook
		HSSFSheet sheet = workbook.getSheetAt(0);
		// Get iterator to all the rows in current sheet
		Iterator<Row> rowIterator = sheet.iterator();
		String num = "";
		int rowNum = 0;
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			if (rowNum < 1) {
				String docNum = getNum(row);
				params.setSystemId(docNum);
				rowNum++;
				rowIterator.next();
				continue;
			}
			
			String docNum = getNum(row);
			if (isDocs){
				if (!isItemForDocumentation(docNum)){
					continue;	
				}				
			}
						
			rowNum++;
			// Get iterator to all cells of current row
			Iterator<Cell> cellIterator = row.cellIterator();
			int i = 0;
			boolean significant = false;
			String answer = "";
			String document = "";
			String reqdoc = "";
			boolean skip = false;

			String rowText = "";
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					rowText = cell.getStringCellValue();
				} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					rowText = "" + new Double(cell.getNumericCellValue()).intValue();
				}
				if (i == 0) {
					num = rowText;
				} else if (i == 1) {
					document = rowText;
				} else if (i == 2) {
					reqdoc = rowText;
				} else if (i == 4) {
					String significantStr = cell.getStringCellValue();
					if (significantStr.equalsIgnoreCase("��")) {
						significant = true;
					} else {
						significant = false;
					}
				} else if (i == 6) {
					answer = cell.getStringCellValue();
					if (answer == null | answer.trim().length() == 0 | answer.equalsIgnoreCase("�����")) {
						skip = true;
					}
				}
				i++;
			}

			if (num.trim().length() > 0 & num.trim().length() < 4) {
				int numInt = Integer.parseInt(num);
				boolean haveRemarks = false;
	
//if (numInt == 34){
//	System.out.println("34");
//}
				
				if (answer.equalsIgnoreCase("���")) {					
					if (answers.getSignificantRemarkById(numInt) != null) {
						haveRemarks = true;
						significantList.add(answers.getSignificantRemarkById(numInt));
						significantRecomendationList.add(answers.getSignificantRecomendationById(numInt));
					} else if (answers.getUnSignificantRemarkById(numInt) != null) {
						haveRemarks = true;
						unSignificantList.add(answers.getUnSignificantRemarkById(numInt));
						unSignificantRecomendationList.add(answers.getUnSignificantRecomendationById(numInt));
					}
					
					if (answers.getSignificantDataRemarkById(numInt) != null){
						significantDataList.add(answers.getSignificantDataRemarkById(numInt));						
					} else if (answers.getUnSignificantDataRemarkById(numInt) != null ){
						unSignificantDataList.add(answers.getUnSignificantDataRemarkById(numInt));
					}
					
					if (haveRemarks){
						params.putDOCtype(docNum);
					}
				}
			}
		}

		if (significantList == null || significantList.size() == 0){
			significantList.add("��������� ��������� �����������.");
			if (isDocs){
				Stat.totalDocsWithSignificantRemarks++;
			}

		}
		if (unSignificantList == null || unSignificantList.size() == 0){
			unSignificantList.add("������ ��������� �����������.");
		}
		
		if (significantRecomendationList.size() == 0 && unSignificantRecomendationList.size() == 0){
			significantRecomendationList.add("������������ �� ���������� ��������� �����������.");
		}

		params.setSignificantRemarks(significantList);
		params.setNonSignificantRemarks(unSignificantList);
		
		params.setSignificantDataRemarks(significantDataList);
		params.setNonSignificantDataRemarks(unSignificantDataList);
		
		params.setSignificantRecomendations(significantRecomendationList);
		params.setNonSignificantRecomendations(unSignificantRecomendationList);
		
		params.setSignificantDataRecomendations(significantDataRecomendationList);
		params.setNonSignificantDataRecomendations(unSignificantDataRecomendationList);		

		file.close();

		if (isDocs){
			System.out.println("Docs with Significant remarks:" + Stat.totalDocsWithSignificantRemarks);
		}	
		
		return params;
	}

	private String getNum(Row row){
		return getStringValueFromRowCell(row, 1);
	}
	
	private String getStringValueFromRowCell(Row row, int cellNumber){
		Cell cell = row.getCell(cellNumber);
		return getSringValueFromCell(cell);

	}
	
	private String getSringValueFromCell(Cell cell){
		String result = "";
		if (cell == null){
			return result;
		}
		if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
			result = cell.getStringCellValue();
		} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			result = "" + new Double(cell.getNumericCellValue()).intValue();
		}	
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		Analizer analizer = new Analizer();
//		String inputPath = "c:/myWork/anketas/";
//		String outputPath = "c:/myWork/anketas/output/";
		
		String inputPath = "c:/myWork/anketas2/";
		String outputPath = "c:/myWork/anketas2/output_stat/";
		
//		List<PODescriptor64> poDescriptor64s  = Parser64.parse("C:/myWork/64/64.xls");
		List<PODescriptor64> poDescriptor64s  = Parser64.parse("c:/myWork/64_all/64.xls");
		parseAnketa(analizer, inputPath, outputPath, poDescriptor64s, false);
		parseAnketa(analizer, inputPath, outputPath, poDescriptor64s, true);
		
	}
	
	private static void parseAnketa(Analizer analizer, String inputPath,	String outputPath, List<PODescriptor64> poDescriptor64s, boolean isDocumentation) throws IOException{
		List<String> files = listFilesForFolder(new File(inputPath));
		for(String fileName : files){
			Params params = new Params();
			params = analizer.parceExcel(inputPath + fileName, params, isDocumentation);
			String systemId = params.getSystemId();
			PODescriptor64 poDescriptor64 = Parser64.getpoDescriptorByID(systemId, poDescriptor64s);
			params.setSystemName(" \"" +poDescriptor64.getName() + "\" ");
			params.setContractNumber(poDescriptor64.getContractNumber());
			params.setSystemDestination(poDescriptor64.getNaznach());
			params.setCreationPurpose(poDescriptor64.getZel());
			
			CreateTechResum cds = new CreateTechResum();			
			String simpleFileNameWithoutExtension = getSimpleFileName(fileName);
			cds.createDocument(params, outputPath +  simpleFileNameWithoutExtension, isDocumentation);
		}		
		
	}


	private static String getSimpleFileName(String fileName){
		String result = fileName.substring(0, fileName.lastIndexOf("."));
		return result;
	}
	
	private static List<String> listFilesForFolder(final File folder) {
		List<String> files = new ArrayList<String>();
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	        } else {
	        	files.add(fileEntry.getName());
	        }
	    }
		return files;
	}
	
	/////////////////////////  Remarks /////////////////////////////
	
	class Remarks {
		List<String> significant;
		List<String> unsignificant;

		public List<String> getSignificant() {
			return significant;
		}

		public void setSignificant(List<String> significant) {
			this.significant = significant;
		}

		public List<String> getUnsignificant() {
			return unsignificant;
		}

		public void setUnsignificant(List<String> unsignificant) {
			this.unsignificant = unsignificant;
		}
	}

	// ///////////////////// answers ///////////////////////
	class Answers {

		HashMap<Integer, String> significantRemarks = new HashMap<Integer, String>();
		HashMap<Integer, String> significantDataRemarks = new HashMap<Integer, String>();
		HashMap<Integer, String> unSignificantRemarks = new HashMap<Integer, String>();
		HashMap<Integer, String> unSignificantDataRemarks = new HashMap<Integer, String>();
		
		
		HashMap<Integer, String> significantRecomendations = new HashMap<Integer, String>();
		HashMap<Integer, String> significantDataRecomendations = new HashMap<Integer, String>();
		HashMap<Integer, String> unSignificantRecomendations = new HashMap<Integer, String>();
		HashMap<Integer, String> unSignificantDataRecomendations = new HashMap<Integer, String>();


		public Answers() {
			initSignificantRemarks();
			initUnSignificantRemarks();
			initSignificantRecomendations();
			initUnSignificantRecomendations();
			

			initSignificantDataRemarks();
			initUnSignificantDataRemarks();
			initSignificantDataRecomendations();
			initUnSignificantDataRecomendations();
			
		}

		public String getSignificantRemarkById(int id) {
			return significantRemarks.get(id);
		}
		
		public String getSignificantDataRemarkById(int id) {
			return significantDataRemarks.get(id);
		}
		
		
		public String getSignificantRecomendationById(int id) {
			return significantRecomendations.get(id);
		}
		
		public String getSignificantDataRecomendationById(int id) {
			return significantDataRecomendations.get(id);
		}
		

		public String getUnSignificantRecomendationById(int id) {
			return significantRecomendations.get(id);
		}		
		
		public String getUnSignificantDataRecomendationById(int id) {
			return unSignificantDataRecomendations.get(id);
		}
	
		public String getUnSignificantRemarkById(int id) {
			return unSignificantRemarks.get(id);
		}
		
		public String getUnSignificantDataRemarkById(int id) {
			return unSignificantDataRemarks.get(id);
		}
		

		private void initSignificantRemarks() {
			significantRemarks.put(1,"� ��������� ����������� ������ ���������� � �����������");
			significantRemarks.put(4,"C������� ������, ������� ������ ���������������� ��������������� ������� �� �������");
			significantRemarks.put(5,"������������� ������� �� �������� �������� ����������� ���������� �� ������� ����������������� �������� ������ ");
			significantRemarks.put(8,"� �������� ������������ ��� �������� ����������� �������");
			significantRemarks.put(9,"����������� ������� �� ����������� � ������������� ���");
			significantRemarks.put(11,"���������� ����������� �� ������������� �������� ������������� ���������");
			significantRemarks.put(12,"���������� ����������� �� ������������� ��������� ������� �����������");
			significantRemarks.put(13,"� ����������� ����������, �������������� � �������, �� ���������� ��������������� ����, ���� ������ ������, ���� �������� ������ �� ������ ����������� ����������");
			significantRemarks.put(14,"�� ����������� ���������� ������������� �����");
			significantRemarks.put(15,"�� ����������� ���������� ������������� �����");
			significantRemarks.put(20,"�� ��������� ����������, ������������� � ����������� ���������������� ���� ����������");
			significantRemarks.put(21,"�� ��������� ����������, ������������� � ����������� ���� ������ ������ ����������");
			significantRemarks.put(22,"�� ��������� ����������, ������������� � ����������� ���� �������� ������ ����������");
			significantRemarks.put(23,"� ������� �� ���������� ����������� �������");
			significantRemarks.put(25,"�� ������� ���������, ����������� API � ����������");
			significantRemarks.put(26,"�� ���������� �������� API ���������� � ��������� ���������� � ���");
			significantRemarks.put(26,"�� ���������� �������� API ���������� � ��������� ���������� � ���");
			significantRemarks.put(27,"�� ������� ���������, ����������� ������� � �� ��������� ������.");
			significantRemarks.put(32,"�� ������� ���������� ��������� ���������� � �������� ���������");
			significantRemarks.put(33,"���������� �� ������������� ����������� � ����������  ��� ���");
			significantRemarks.put(34,"������ ������ ������� �� ����������� � ������������� ���");
			significantRemarks.put(35,"�� ������� ������ ������ �������");
			significantRemarks.put(35,"������������� ������� �� ������������� �������� �����������");
		}
		
		private void initSignificantDataRemarks(){
			significantDataRemarks.put(34,"������ ������ ������� �� ����������� � ������������� ���");
			significantDataRemarks.put(35,"�� ������� ������ ������ �������");
			
		}
		
		private void initSignificantRecomendations() { 
			significantRecomendations.put(1,"������� � ��������� ������ ���������� � �����������");
			significantRecomendations.put(4,"������� �������� ������, ������� ������ ���������������� ��������������� �������");
			significantRecomendations.put(5,"� ������������� ������� ������� ����������� ���������� �� ������� ����������������� �������� ������ ");
			significantRecomendations.put(8,"� �������� ������������ ������� ����������� �������");
			significantRecomendations.put(9,"����������� ����������� ������� � ������������� ���");
			significantRecomendations.put(11,"�������� ���������� ����������� � ������������ � �������� ������������� ���������");
			significantRecomendations.put(12,"�������� ���������� ����������� � ������������ � ���������� ������� �����������");
			significantRecomendations.put(13,"� ����������� ����������, �������������� � �������, �������� ��������������� ����, ���� ������ ������, ���� �������� ������ �� ������ ����������� ����������");
			significantRecomendations.put(14,"����������� ���������� ������������� �����");
			significantRecomendations.put(15,"����������� ���������� ������������� �����");
			significantRecomendations.put(20,"��������� ����������, ������������� � ����������� ���������������� ���� ����������");
			significantRecomendations.put(21,"��������� ����������, ������������� � ����������� ���� ������ ������ ����������");
			significantRecomendations.put(22,"��������� ����������, ������������� � ����������� ���� �������� ������ ����������");
			significantRecomendations.put(23,"������������ � ������� ����������� �������");
			significantRecomendations.put(25,"�������� ���������, ����������� API � ����������");
			significantRecomendations.put(26,"������� API ���������� � ��������� ���������� � ���");
			significantRecomendations.put(27,"�������� ���������, ����������� ������� � �� ��������� ������.");
			significantRecomendations.put(32,"������� ���������� ��������� ���������� � �������� ���������");
			significantRecomendations.put(33,"�������� ���������� � ������������ � ����������� � ���������� ��� ���");
			significantRecomendations.put(34,"����������� ������ ������ ������� � ������������� ���");
			significantRecomendations.put(35,"������� ������ ������ �������");
			significantRecomendations.put(35,"�������� ������������� ������� � ������������ � ��������� �����������");
		}

		private void initSignificantDataRecomendations() {
			significantDataRecomendations.put(34,"����������� ������ ������ ������� � ������������� ���");
			significantDataRecomendations.put(35,"������� ������ ������ �������");			
		}

		
		private void initUnSignificantRemarks() {
			unSignificantRemarks.put(2,"� ��������� ����������� ������ ����������  � ���������� � �������� ���������");
			unSignificantRemarks.put(3,"� ������� ����������� ���������� � ��������� SSO");
			unSignificantRemarks.put(6,"� ������������� ������� ����������� �������� ������������ ������� ���������� ���������� � ��.");
			unSignificantRemarks.put(7,"� ������������� ������� ����������� ������ ����������� ����� ����������� ���������� �� � ��������� ������������ ������� ����� ����������.");
			unSignificantRemarks.put(10,"�������� �� ����������� ������� �� ������������� ����������� ���, ��������� � ����������� � ���������� ������� �������� ����������� �������.");
			unSignificantRemarks.put(16,"�� ������������ ���������� ��� ����������� ������ �������� � ��������.");
			unSignificantRemarks.put(17,"�� ������������ �� ���������� ��� ����������� ������������ ����������");
			unSignificantRemarks.put(18,"�� �������� ������������� ���������� ���������� ��������� ���������� ���������� ��� ��������������� ���������������� ����������.");
			unSignificantRemarks.put(19,"�� �������� ����������� ������������� ���������� �� ������ ����");
			unSignificantRemarks.put(24,"��� ���������� ������������ ������� ������������ ���������� ������� ������ ������������� ������� ������� ��� ������������� ������� ������� ����������");
			unSignificantRemarks.put(28,"�� �������� ����������, �������� �� ��������������� � ���� ������-������, ������������� �� ���������������� ������� �������.");
			unSignificantRemarks.put(29,"�� ������������ ��� ����������� ���� ������� ������� ������ �� ������ LDAP");
			unSignificantRemarks.put(30,"�� �������������� ������������� ������ ������������ � ����������� LDAP ��������� �� ������ �����");
			unSignificantRemarks.put(31, "���������� �� ����������� SSO");
			unSignificantRemarks.put(36,"�� �������������� ������������� ������������ ������� � ������ ������� �� ������� ���");
		}

		private void initUnSignificantDataRemarks() {
			unSignificantDataRemarks.put(36,"�� �������������� ������������� ������������ ������� � ������ ������� �� ������� ���");			
		}
				
		private void initUnSignificantRecomendations() {
			unSignificantRecomendations.put(2,"������� � �������� ������ ����������  � ���������� � �������� ���������");
			unSignificantRecomendations.put(3,"�������� ���������� � ��������� SSO");
			unSignificantRecomendations.put(6,"� ������������� ������� ������� ����������� ������� ���������� ���������� � ��.");
			unSignificantRecomendations.put(7,"� ������������� ������� ������� ������ ����������� ����� ����������� ���������� �� � ��������� ������������ ������� ����� ����������.");
			unSignificantRecomendations.put(10,"�������� �������� �� ����������� ������� � ������������ � ������������ ���, ��������� � ����������� � ���������� ������� �������� ����������� �������.");
			unSignificantRecomendations.put(16,"������������ ���������� ��� ����������� ������ �������� � ��������.");
			unSignificantRecomendations.put(17,"������������ ���������� ��� ����������� ������������ ����������");
			unSignificantRecomendations.put(18,"���������� ����������� ������������� ���������� ���������� ��������� ���������� ���������� ��� ��������������� ���������������� ����������.");
			unSignificantRecomendations.put(19,"���������� ����������� �� ������������� ���������� ���������� �� ������ ����");
			unSignificantRecomendations.put(24,"����������� ����������� ������� ������������ ���������� ������� ������ ������������� ������� ������� ��� ������������� ������� ������� ����������");
			unSignificantRecomendations.put(28,"�������� ����������, �������� �� ��������������� � ���� ������-������, ������������� �� ���������������� ������� �������.");
			unSignificantRecomendations.put(29,"������������ ��� ����������� ���� ������� ������� ������ �� ������ LDAP");
			unSignificantRecomendations.put(30,"���������� ������������� ������ ������������ � ����������� LDAP ��������� �� ������ �����");
			unSignificantRecomendations.put(31,"���������� ���������� ��������� SSO");
			unSignificantRecomendations.put(36,"����������� ������������� ������������ ������� � ������ ������� �� ������� ���");
		}
		
		private void initUnSignificantDataRecomendations() {
			unSignificantDataRecomendations.put(36,"����������� ������������� ������������ ������� � ������ ������� �� ������� ���");
		}
		
	}	
}
