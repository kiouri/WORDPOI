package com.kiouri;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Page3 {
	
	Params params;
	
	public void createPage3(XWPFDocument document, Params params, boolean isDocumentation){
		this.params = params;
		
		Utils.header0(document, "2 �������� ������, ���������� � ����������, � ������������ � �������� ���������� ������");
		Utils.plain(document,"������ ����������� ������� ���������� �� ��������� ������������:");
		Utils.plain(document,"1) ���������� ����������� �������");
		Utils.plain(document,"2) ����������� ������");

		Utils.header1(document, "2.1 ���������� �����������");
		if (!isDocumentation){
			Utils.plain(document,"��� ������� ���������� ����������� �� ������ ���� �����: ");		
			Utils.plain(document,"\"������� ����������� ����������\"");
			Utils.plain(document,"\"���������� � ����������\"");
		}
		Utils.plain(document,"������������ � ����� �����������:");  				
		Utils.plain(document,"   1) �������� �����������");
		Utils.plain(document,"   2) ������������ ��������� ������� �����������, ���������� � �� � ����� �����������");
		Utils.plain(document,"");
		Utils.header1(document, "2.2 ����������� ������");
		Utils.plain(document,"��� ������� ����������� ������ �� ������ ���� ����� " + 
		"\"���������� � ������� ������ ��� IT �������\"");

		Utils.addPageBreak(document);
	}	
}
