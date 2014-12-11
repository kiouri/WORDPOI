package com.kiouri.anketas2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WUtils {

	private static Map<String, String> docRequestDoc = new HashMap<String, String>();
	private static List<String> negativeAnswers = Arrays.asList("НЕТ");
	private static String BD_ARC_ITEM = "Архитектура данных";
	public static List<String> docsNoData = new ArrayList<String>();
	public static List<String> docsData = new ArrayList<String>();
	
	static {
		docRequestDoc.put("Архитектура данных", "Требования к архитектуре данных");
		docRequestDoc.put("Архитектура приложения", "Типовая архитектура приложения");
		docRequestDoc.put("Документирование", "Требования к документированию");
		docRequestDoc.put("Интеграция", "Требования к интеграции");
		docRequestDoc.put("Концепция", "Концепция целевой архитектуры");
		docRequestDoc.put("Принципы", "Основные архитектурные принципы");
		
		docsNoData.add("Типовая архитектура приложения");
		docsNoData.add("Требования к документированию");
		docsNoData.add("Требования к интеграции");
		docsNoData.add("Концепция целевой архитектуры");
		docsNoData.add("Основные архитектурные принципы");

		docsData.add("Требования к архитектуре данных");
		
		////////////////
//		docRequestDoc.put("Соответствие целевой архитектуре","?");
//		docRequestDoc.put("Полнота и достоверность данных","?");
//		docRequestDoc.put("Единое информационное пространство","?");
//		docRequestDoc.put("Разграничение доступа и защита информации","?");
//		docRequestDoc.put("Ориентация на бизнес-процессы","?");
//		docRequestDoc.put("Открытая архитектура","?");
//		docRequestDoc.put("Реализация единой интеграционной среды","?");
//		docRequestDoc.put("Независимость от платформ и поставщиков","?");
	}

	public static Map<String, String> getDocRequestDoc() {
		return docRequestDoc;
	}
	
	public static String getDocByDocReq(String docReq){
		return docRequestDoc.get(docReq);
	}

	public static List<String> getNegativeAnswers() {
		return negativeAnswers;
	}
	
	public static String getArcDataItem(){
		return BD_ARC_ITEM;
	}
	
	
	
}
