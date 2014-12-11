package com.kiouri.anketas2;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.kiouri.Utils;

public class WPage7 {
	
	private XWPFDocument document;
	private QwestionReport qwestionReport; 
	private GsAdd gsAdd;
	private int version;
	
	public static boolean isRecommendationExists = false;
	
	private static List<String> recommends = new ArrayList<String>();	
	
	static {
	recommends.add("�������������� ���������� � SSO");
	recommends.add("������� �������� ������, ������� ������ ���������������� ��������������� �������");
	recommends.add("������� � ������������� ������� ����������� ������� �� ���������� ���������� ���������� � ��");
	recommends.add("�������� � ������������� ������� ������, ����������� ����� ����������� ���������� �� � ��������� ������������ ������� ����� ����������");
	recommends.add("� �������� ������������ ����������� �������� ����������� �������");
	recommends.add("����������� ��������������� ������������ ����������� ������� � ������������� ��� �� ������ ����������");
	recommends.add("������� ����������� ������� �� ������������� ����������� ���, ��������� � ����������� � ���������� ������� �������� ����������� �������");
	recommends.add("�������� ������� � ������������ � ��������� ������������� ���������");
	recommends.add("�������� ���������� ����������� � ������������ � ���������� ������� �����������");
	recommends.add("�������� � ����������� ����������, �������������� � ������� ��������������� ����, ���� ������ ������, ���� �������� ������ �� ������ ����������� ����������");
	
	recommends.add("����������� ���������� ������������� �����");
	recommends.add("����������� ���������� ������������� �����");
	recommends.add("������������ ���������� ��� ����������� ������ �������� � ��������");
	recommends.add("������������ ���������� ��� ����������� ������������ ����������");
	recommends.add("���������� ������������� ���������� ���������� ��������� ���������� ���������� ��� ��������������� ���������������� ����������.");
	recommends.add("���������� ����������� ������������� ���������� ���������� �� ������ ����");		
	recommends.add("���������� ������������ ���������� ������������� � ����������� ���������������� ���� ����������");
	recommends.add("���������� ������������ ���������� ������������� � ����������� ���� ������ ������ ����������");
	recommends.add("���������� ������������ ���������� � ����������� ���� �������� ������ ����������");
	recommends.add("����������� � ������� ����������� �������");

	recommends.add("������������ ������������ ����������� �������");
	recommends.add("������� ���������, ����������� API � ����������");
	recommends.add("������������ �������� API ���������� � ��������� ��� ���������� � ���");
	recommends.add("�������� ���������, ����������� ������� � �� ��������� ������");
	recommends.add("�������� ����������, �������� �� ��������������� � ���� ������-������, ������������� �� ���������������� ������� �������");
	recommends.add("������������ ��� ����������� ���� ������� ������� ������ �� ������ LDAP");
	recommends.add("����������� ������������� ������ ������������ � ����������� LDAP ��������� �� ������ �����");
	recommends.add("���������� � ���������� ��������� SSO");
	recommends.add("������� �������� ���������� � �������� ���������");
	recommends.add("���������� ���������� ���������� � ������������ � ����������� ��� ���");

	recommends.add("����������� ������ ������ ������� � ������������� ���");
	recommends.add("������� ������ ������ �������");
	recommends.add("���������� ������������� ������������ ������� � ������ ������� �� ������� ���");
	recommends.add("�������� �������� � �� � ������������ � ������������� ��������");
	recommends.add("�������� ����������� ������� � ������������ � ������� ������������");
	recommends.add("����������� � ����������� ������� ��������� ��������� �������� � ������������ ������");
	recommends.add("����������� � ����������� ������� ��������� ������������� �  ������ ������");
	recommends.add("��������� �� ������������ ������� ������������ ������, ������������ � ������ ��������");
	recommends.add("����������� � ������������ ������ �����, ������������� � ������������ �������");
	recommends.add("����������� � ������������ �������� ���������� ������ �� �����, ������������� � ������������ �������");
	
	recommends.add("���������� ���������� ������������ �������  �� ������������� ������-��������, � �� ��������� �������");
	recommends.add("���������� ���������� �������������� API / �������� ��� ������� � �������� ����������");
	recommends.add("���������� ��������� ������������� ������������� API ������������ �������");
	recommends.add("���������� ���������� �������� ������ ����������� ��� ���������� � ������� ���������");
	recommends.add("���������� ������������� ������������ ������� �� ������ ���������� �� (vendor lock-in)");
	recommends.add("��������� �������� �������� (������) ������������ ������� �� ����������� ��");
	recommends.add("��������� �� ������������ ������� ���� ����������, ����������� ������������ �������");
	recommends.add("�� ������������ ���� � �� �� ����������� �� ��� ���������� ������������, ������������ � ���������������� �������");
	recommends.add("��������� � ����������� ������������ ������� ������������ � �������� �������");
	recommends.add("����������� �������������� ����������� ������� ����� �������, ��� �� ���������� ��������������� �� �������, ��������� � ������������������ ������������� ������");

	recommends.add("������������� ���������� ������� ��������������� �������� � �������������� �����������");
	recommends.add("������������� � �������������� ����������� ���������� ��������� ������������� ������");
	recommends.add("����������� ���������� �� ��������������� ���������� ��������� �� ��������������� ������� ");
	recommends.add("���������� � ����������� ����������� ������� ���������� ���������� �� ��������");
	recommends.add("���������� � ����������� ����������� ������� ���������� ���������� �� ����������� �  ������������������");
	recommends.add("�������� � �� �������� ����������� ���������� ���������� � ���������������� �������� �����");	
	}

	public WPage7(XWPFDocument document, QwestionReport qwestionReport, GsAdd gsAdd, int version){
		isRecommendationExists = false;
		this.document = document;
		this.qwestionReport = qwestionReport;
		this.gsAdd = gsAdd;
		this.version = version;
		p6();
	}
	
	private void p6() {
		List<String> significantRecommendations = getSignificantRecommendations();
		List<String> nonSignificantRecommendations = getNonSignificantRecomendations();
		if (significantRecommendations.size() > 0
				|| nonSignificantRecommendations.size() > 0) {

			isRecommendationExists = true;
			
			Utils.header0(document,
					"6 ����������� �� ��������� �������� ������������� ����������� �������");
			Utils.plain(document,
					"��� ����������� ��������� �������� ������������ ������� "
							+ gsAdd.getSystemName() + " �������������:");
			for (String recomendation : significantRecommendations) {
				Utils.plain(document, recomendation);
			}

			for (String recomendation : nonSignificantRecommendations) {
				Utils.plain(document, recomendation);
			}
		} else {
			Utils.plain(document, "�������� ������������ ������� ������������� ������������� �����������");
		}
	}
	
	private List<String> getSignificantRecommendations(){
		List<String> result = new ArrayList<String>();
		for(int i = 0; i < qwestionReport.getQwestions().size() - 1; i++){
			if(qwestionReport.getQwestions().get(i).getEssentiality().equalsIgnoreCase("��")){
				if (qwestionReport.getQwestions().get(i).getAnswer().equalsIgnoreCase("���")){
					result.add(recommends.get(i));
				}
			}			
		}
		return result;
	}
	
	private List<String> getNonSignificantRecomendations(){
		List<String> result = new ArrayList<String>();
		for(int i = 0; i < qwestionReport.getQwestions().size() - 1; i++){
			if(qwestionReport.getQwestions().get(i).getEssentiality().equalsIgnoreCase("���")){
				if (qwestionReport.getQwestions().get(i).getAnswer().equalsIgnoreCase("���")){
					result.add(recommends.get(i));
				}
			}			
		}
		return result;
	}

}
