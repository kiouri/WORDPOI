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
					if (significantStr.equalsIgnoreCase("Да")) {
						significant = true;
					} else {
						significant = false;
					}
				} else if (i == 6) {
					answer = cell.getStringCellValue();
					if (answer == null | answer.trim().length() == 0 | answer.equalsIgnoreCase("Ответ")) {
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
				
				if (answer.equalsIgnoreCase("Нет")) {					
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
			significantList.add("Серьезные замечания отсутствуют.");
			if (isDocs){
				Stat.totalDocsWithSignificantRemarks++;
			}

		}
		if (unSignificantList == null || unSignificantList.size() == 0){
			unSignificantList.add("Прочие замечания отсутствуют.");
		}
		
		if (significantRecomendationList.size() == 0 && unSignificantRecomendationList.size() == 0){
			significantRecomendationList.add("Рекомендации по устранению замечаний отсутствуют.");
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
			significantRemarks.put(1,"В документе отсутствует раздел требований к архитектуре");
			significantRemarks.put(4,"Cценарии работы, которые должно автоматизировать разрабатываемое решение не описаны");
			significantRemarks.put(5,"Пояснительная записка не содержит описания технической реализации по каждому автоматизируемому сценарию работы ");
			significantRemarks.put(8,"В отчетной документации нет описания архитектуры системы");
			significantRemarks.put(9,"Архитектура решения не согласована с архитекторами УТП");
			significantRemarks.put(11,"Прикладная архитектура не соответствует основным архитектурным принципам");
			significantRemarks.put(12,"Прикладная архитектура не соответствует концепции целевой архитектуры");
			significantRemarks.put(13,"В архитектуре приложения, разработанного в решении, не выделяется презентационный слой, слой бизнес логики, слой хранения данных на уровне компонентов приложения");
			significantRemarks.put(14,"Не реализована логическая независимость слоев");
			significantRemarks.put(15,"Не реализована физическая независимость слоев");
			significantRemarks.put(20,"Не выполнены требования, предъявляемые к компонентам презентационного слоя приложения");
			significantRemarks.put(21,"Не выполнены требования, предъявляемые к компонентам слоя бизнес логики приложения");
			significantRemarks.put(22,"Не выполнены требования, предъявляемые к компонентам слоя хранения данных приложения");
			significantRemarks.put(23,"в решении не реализован конструктор отчетов");
			significantRemarks.put(25,"Не выделен компонент, реализующий API к приложению");
			significantRemarks.put(26,"Не существует описание API приложения с примерами интеграции с ним");
			significantRemarks.put(26,"Не существует описание API приложения с примерами интеграции с ним");
			significantRemarks.put(27,"Не выделен компонент, реализующий адаптер к ИТ ландшафту Москвы.");
			significantRemarks.put(32,"Не описана реализация сценариев интеграции с внешними системами");
			significantRemarks.put(33,"Реализация не соответствует требованиям к интеграции  УТП ДИТ");
			significantRemarks.put(34,"Модель данных решения не согласована с архитекторами УТП");
			significantRemarks.put(35,"Не описана модель данных решения");
			significantRemarks.put(35,"Разработанное решение не соответствует описанию архитектуры");
		}
		
		private void initSignificantDataRemarks(){
			significantDataRemarks.put(34,"Модель данных решения не согласована с архитекторами УТП");
			significantDataRemarks.put(35,"Не описана модель данных решения");
			
		}
		
		private void initSignificantRecomendations() { 
			significantRecomendations.put(1,"Создать в документе раздел требований к архитектуре");
			significantRecomendations.put(4,"Описать сценарии работы, которые должно автоматизировать разрабатываемое решение");
			significantRecomendations.put(5,"В пояснительной записке описать техническую реализацию по каждому автоматизируемому сценарию работы ");
			significantRecomendations.put(8,"В отчетной документации описать архитектуры системы");
			significantRecomendations.put(9,"Согласовать архитектуру решения с архитекторами УТП");
			significantRecomendations.put(11,"Привести прикладную архитектуру в соответствие с основным архитектурным принципам");
			significantRecomendations.put(12,"Привести прикладную архитектуру в соответствие с концепцией целевой архитектуры");
			significantRecomendations.put(13,"В архитектуре приложения, разработанного в решении, выделить презентационный слой, слой бизнес логики, слой хранения данных на уровне компонентов приложения");
			significantRecomendations.put(14,"Реализовать логическую независимость слоев");
			significantRecomendations.put(15,"Реализовать физическую независимость слоев");
			significantRecomendations.put(20,"Выполнить требования, предъявляемые к компонентам презентационного слоя приложения");
			significantRecomendations.put(21,"Выполнить требования, предъявляемые к компонентам слоя бизнес логики приложения");
			significantRecomendations.put(22,"Выполнить требования, предъявляемые к компонентам слоя хранения данных приложения");
			significantRecomendations.put(23,"Рееализовать в решении конструктор отчетов");
			significantRecomendations.put(25,"Выделить компонент, реализующий API к приложению");
			significantRecomendations.put(26,"Описать API приложения с примерами интеграции с ним");
			significantRecomendations.put(27,"Выделить компонент, реализующий адаптер к ИТ ландшафту Москвы.");
			significantRecomendations.put(32,"Описать реализация сценариев интеграции с внешними системами");
			significantRecomendations.put(33,"Привести реализацию в соответствие с требованиям к интеграции УТП ДИТ");
			significantRecomendations.put(34,"Согласовать модель данных решения с архитекторами УТП");
			significantRecomendations.put(35,"Описать модель данных решения");
			significantRecomendations.put(35,"Привести разработанное решение в соответствие с описанием архитектуры");
		}

		private void initSignificantDataRecomendations() {
			significantDataRecomendations.put(34,"Согласовать модель данных решения с архитекторами УТП");
			significantDataRecomendations.put(35,"Описать модель данных решения");			
		}

		
		private void initUnSignificantRemarks() {
			unSignificantRemarks.put(2,"В документе отсутствует раздел требований  к интеграции с внешними системами");
			unSignificantRemarks.put(3,"В системе отсутствуют требования к поддержке SSO");
			unSignificantRemarks.put(6,"В пояснительной записке отсутствует описание технического решения требований заявленных в ТЗ.");
			unSignificantRemarks.put(7,"В пояснительной записке отсутствует раздел описывающий связь конкретного требования ТЗ с описанием технического решения этого требования.");
			unSignificantRemarks.put(10,"Документ по архитектуре системы не соответствует требованиям УТП, указанным в разъяснении к заполнению шаблона описания архитектуры системы.");
			unSignificantRemarks.put(16,"Не использована технология для кэширования данных запросов и контента.");
			unSignificantRemarks.put(17,"Не использована ли технология для кэширования справочников приложения");
			unSignificantRemarks.put(18,"Не возможна кластеризация приложения средствами платформы размещения приложения без дополнительного программирования приложения.");
			unSignificantRemarks.put(19,"Не возможна независимая кластеризация приложения на каждом слое");
			unSignificantRemarks.put(24,"Для реализации конструктора отчетов использовано самописное решения вместо использования сервера отчетов или промышленного плагина сервера отчетности");
			unSignificantRemarks.put(28,"Не выделены компоненты, отдельно на презентационном и слое бизнес-логике, ответственные за административные функции системы.");
			unSignificantRemarks.put(29,"Не использована для организации прав доступа ролевая модель на основе LDAP");
			unSignificantRemarks.put(30,"Не обеспечивается синхронизация данных пользователя с центральным LDAP каталогом на основе СУДИР");
			unSignificantRemarks.put(31, "Приложение не поддерживат SSO");
			unSignificantRemarks.put(36,"Не осуществляется синхронизация справочников системы с мастер данными из сервера НСИ");
		}

		private void initUnSignificantDataRemarks() {
			unSignificantDataRemarks.put(36,"Не осуществляется синхронизация справочников системы с мастер данными из сервера НСИ");			
		}
				
		private void initUnSignificantRecomendations() {
			unSignificantRecomendations.put(2,"Ввнести в документ раздел требований  к интеграции с внешними системами");
			unSignificantRecomendations.put(3,"Добавить требования к поддержке SSO");
			unSignificantRecomendations.put(6,"В пояснительной записке описать техническое решение требований заявленных в ТЗ.");
			unSignificantRecomendations.put(7,"В пояснительной записке создать раздел описывающий связь конкретного требования ТЗ с описанием технического решения этого требования.");
			unSignificantRecomendations.put(10,"Привести документ по архитектуре системы в соответствие с требованиями УТП, указанным в разъяснении к заполнению шаблона описания архитектуры системы.");
			unSignificantRecomendations.put(16,"Использовать технологию для кэширования данных запросов и контента.");
			unSignificantRecomendations.put(17,"Использовать технологию для кэширования справочников приложения");
			unSignificantRecomendations.put(18,"Обеспечить возможность кластеризация приложения средствами платформы размещения приложения без дополнительного программирования приложения.");
			unSignificantRecomendations.put(19,"Обеспечить возможность ли кластеризация приложения независимо на каждом слое");
			unSignificantRecomendations.put(24,"Реализовать конструктор отчетов использовано самописное решения вместо использования сервера отчетов или промышленного плагина сервера отчетности");
			unSignificantRecomendations.put(28,"Выделить компоненты, отдельно на презентационном и слое бизнес-логике, ответственные за административные функции системы.");
			unSignificantRecomendations.put(29,"Использовать для организации прав доступа ролевая модель на основе LDAP");
			unSignificantRecomendations.put(30,"Обеспечить синхронизацию данных пользователя с центральным LDAP каталогом на основе СУДИР");
			unSignificantRecomendations.put(31,"Обеспечить приложению поддержку SSO");
			unSignificantRecomendations.put(36,"Осуществить синхронизацию справочников системы с мастер данными из сервера НСИ");
		}
		
		private void initUnSignificantDataRecomendations() {
			unSignificantDataRecomendations.put(36,"Осуществить синхронизацию справочников системы с мастер данными из сервера НСИ");
		}
		
	}	
}
