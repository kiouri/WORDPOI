package com.kiouri.anketas2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WUtils {

	private static Map<String, String> docRequestDoc = new HashMap<String, String>();
	private static List<String> negativeAnswers = Arrays.asList("���");
	private static String BD_ARC_ITEM = "����������� ������";
	public static List<String> docsNoData = new ArrayList<String>();
	public static List<String> docsData = new ArrayList<String>();
	
	static {
		docRequestDoc.put("����������� ������", "���������� � ����������� ������");
		docRequestDoc.put("����������� ����������", "������� ����������� ����������");
		docRequestDoc.put("����������������", "���������� � ����������������");
		docRequestDoc.put("����������", "���������� � ����������");
		docRequestDoc.put("���������", "��������� ������� �����������");
		docRequestDoc.put("��������", "�������� ������������� ��������");
		
		docsNoData.add("������� ����������� ����������");
		docsNoData.add("���������� � ����������������");
		docsNoData.add("���������� � ����������");
		docsNoData.add("��������� ������� �����������");
		docsNoData.add("�������� ������������� ��������");

		docsData.add("���������� � ����������� ������");
		
		////////////////
//		docRequestDoc.put("������������ ������� �����������","?");
//		docRequestDoc.put("������� � ������������� ������","?");
//		docRequestDoc.put("������ �������������� ������������","?");
//		docRequestDoc.put("������������� ������� � ������ ����������","?");
//		docRequestDoc.put("���������� �� ������-��������","?");
//		docRequestDoc.put("�������� �����������","?");
//		docRequestDoc.put("���������� ������ �������������� �����","?");
//		docRequestDoc.put("������������� �� �������� � �����������","?");
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
