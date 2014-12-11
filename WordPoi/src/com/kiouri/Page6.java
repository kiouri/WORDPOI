package com.kiouri;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Page6 {
	
Params params;
	
	public void createPage6(XWPFDocument document, Params params){
		this.params = params;
		Utils.header0(document, "5 ������������ �� ���������� ���������");
//		if (params.getSignificantRemarks().size() > 0 || params.getNonSignificantRemarks().size() > 0){
		if (params.getSignificantRemarks().size() == 1 & params.getNonSignificantRemarks().size() == 1 & 
				params.getSignificantRemarks().get(0).trim().equalsIgnoreCase("��������� ��������� �����������.") &
				params.getNonSignificantRemarks().get(0).trim().equalsIgnoreCase("������ ��������� �����������.")) {

			Utils.plainCursiv(document,false, "��������� �����������.");

		} else {
			
			Utils.plainCursiv(document,false, "��� ���������� ���������� ��������� �������������:");
			Utils.plainCursiv(document,false, "��������� ���������, ������������� � �������� 4.1 � 4.2");			

		}
		Utils.addPageBreak(document);
	}	

}
