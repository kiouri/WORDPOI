package com.kiouri;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Page9 {

Params params;
	
	public void createPage9(XWPFDocument document, Params params){
		this.params = params;
		Utils.header0(document, "8 	���� ������������ � �����������");
		Utils.plain(document, "����������� ����������� ������� � ��� �� ������ ���������� �������.");
		Utils.header0(document, "���������� ");
	}	
	
	
}
