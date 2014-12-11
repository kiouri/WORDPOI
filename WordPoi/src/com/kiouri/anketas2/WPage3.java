package com.kiouri.anketas2;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.kiouri.Utils;

public class WPage3 {
	
	private XWPFDocument document;
	private QwestionReport qwestionReport; 
	private GsAdd gsAdd;
	private int version;

	public WPage3(XWPFDocument document, QwestionReport qwestionReport, GsAdd gsAdd, int version){
		this.document = document;
		this.qwestionReport = qwestionReport;
		this.gsAdd = gsAdd;
		this.version = version;
		p2();
	}

	public void p2(){
		Utils.header0(document, "2 �������� ������, ���������� � ����������, � ������������ � �������� ���������� ������");
		Utils.plain(document,"������ ����������� ������� ���������� �� ��������� ������������:");
		Utils.plain(document,"1) ���������� ����������� �������");
		Utils.plain(document,"2) ����������� ������");

		Utils.header1(document, "2.1 ���������� �����������");
//		if (!isDocumentation){
			Utils.plain(document,"��� ������� ���������� ����������� �� ������ ���� �����: ");		
			Utils.plain(document,"\"������� ����������� ����������\"");
			Utils.plain(document,"\"���������� � ����������\"");
//		}
		Utils.plain(document,"������������ � ����� �����������:");  				
		Utils.plain(document,"   1) �������� ����������� � ���������� ������������ �������");
		Utils.plain(document,"   2) ������������ ��������� ������� �����������, ���������� � �� � ����� �����������");
		Utils.plain(document,"");
		Utils.header1(document, "2.2 ����������� ������");
		Utils.plain(document,"��� ������� ����������� ������ �� ������ ���� ����� " + 
		"\"���������� � ������� ������ ��� IT �������\"");

		Utils.addPageBreak(document);

	}
}
