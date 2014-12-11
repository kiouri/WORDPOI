package com.kiouri.anketas2;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.kiouri.Utils;

public class WPage6 {
	
	private XWPFDocument document;
	private QwestionReport qwestionReport; 
	private GsAdd gsAdd;
	private int version;

	public WPage6(XWPFDocument document, QwestionReport qwestionReport, GsAdd gsAdd, int version){
		this.document = document;
		this.qwestionReport = qwestionReport;
		this.gsAdd = gsAdd;
		this.version = version;
		p5();
	}

	private void p5(){
		Utils.header0(document, "5 ������������ �� ���������� ���������");
		Utils.plain(document, "��� ���������� ���������� ��������� �������������:");
		Utils.plain(document, "��������� ���������, ������������� � �������� 4.1, 4.2");
	}
}
