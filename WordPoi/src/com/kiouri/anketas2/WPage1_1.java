package com.kiouri.anketas2;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.kiouri.Utils;

public class WPage1_1 {

	private XWPFDocument document;
	private QwestionReport qwestionReport; 
	private GsAdd gsAdd;
	private int version;
	
	public WPage1_1(XWPFDocument document, QwestionReport qwestionReport, GsAdd gsAdd, int version) {
		this.document = document;
		this.qwestionReport = qwestionReport;
		this.gsAdd = gsAdd;
		this.version = version;
		header();
//		alyaev();
		zakl();
		object();
		xxx();
		footer();
	}
	
	private void header(){
        XWPFParagraph paragraphOne = document.createParagraph();
        paragraphOne.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun paragraphOneRunOne = paragraphOne.createRun();
        paragraphOneRunOne.setBold(true);
//        paragraphOneRunOne.setText("����������� �������������� ����������");
        paragraphOneRunOne.setText("���������                                                                                                     �����������");
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.setText("����������� ��������                                                                                 ����������� ��������");
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.setText("��� ��������� ���������� 98�                                                          ��� ���� �л");
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.setText("_______________________ �.�. �����                                                     ______________ �.�. ��������");
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.setText("� ___ � _____________ 2014   �.                                                                    � ___ � _____________ 2014   �.");
        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.setText("���������� ����������� �������� � ������������");
//        paragraphOneRunOne.addCarriageReturn();
	}
	
//	private void alyaev(){
//        XWPFParagraph paragraph = document.createParagraph();
//        paragraph.setAlignment(ParagraphAlignment.RIGHT);
//        XWPFRun paragrapRun = paragraph.createRun();
//        paragrapRun.setText("���������");
//        paragrapRun.addCarriageReturn();
//        paragrapRun.setText("��������� ���������� �����������");
//        paragrapRun.addCarriageReturn();
//        paragrapRun.setText("�������� � ������������");
//        paragrapRun.addCarriageReturn();
//        paragrapRun.setText("___________________�.�. �����");
//        paragrapRun.addCarriageReturn();
//        paragrapRun.setText("<<____>>_______________201  �.");   
//        Utils.addcr(paragrapRun, 5);        
//	}

	private void zakl(){
        XWPFParagraph paragraphOne = document.createParagraph();
        paragraphOne.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun paragraphOneRunOne = paragraphOne.createRun();
        paragraphOneRunOne.setBold(true);
        paragraphOneRunOne.setText("������������� ����������");
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.setText("� �������� ������������ �������");
	}
	
	private void object(){
        XWPFParagraph paragraphOne = document.createParagraph();
        paragraphOne.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun paragraphOneRunOne = paragraphOne.createRun();
        paragraphOneRunOne.setBold(true);
        paragraphOneRunOne.setBold(true);
        paragraphOneRunOne.setText("������ �������");
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.setText(gsAdd.getSystemName().trim());
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.addCarriageReturn();
////        paragraphOneRunOne.setText("��������������� �������� N �� " + gsAdd.getGkNum());
//        paragraphOneRunOne.setText("� ������ �� N �� " + gsAdd.getGkNum() + " �� "  + gsAdd.getContractDate() + " �� " + gsAdd.getContractDate() + " �� ����������");
//        paragraphOneRunOne.setText("�����/�������� ����� �� ����������� �������� � ������������� ");
//        paragraphOneRunOne.setText("������������ �� ���������� � ���������� ����������� ������� � ������");
//        paragraphOneRunOne.setText("���������� ��������������� ��������� ������ ������ ���������������");
//        paragraphOneRunOne.setText("����� (2012-2016 ����)� � ����� ����������� �� ������������ �����������");
//        paragraphOneRunOne.setText("�������� ������ ������ � ����� �������������-����������������");
//        paragraphOneRunOne.setText("����������, ����������� ����������, ������������ ���������� � ������");
//        paragraphOneRunOne.setText("����������� ����������, ������������ ������������ � �������");
//        paragraphOneRunOne.setText("�������������-���������������� ����������.");
////        paragraphOneRunOne.setText("�� " + gsAdd.getContractDate());
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.addCarriageReturn();
//        String contractDate = gsAdd.getGkDates().get(version-1);  
//        paragraphOneRunOne.setText("���� �����������: " + contractDate);
//        Utils.addcr(paragraphOneRunOne, 10);
//        paragraphOneRunOne.setText("������ 2014");
//        Utils.addPageBreak(document);
	}
	
	private void xxx(){
        XWPFParagraph paragraphOne = document.createParagraph();
        paragraphOne.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun paragraphOneRunOne = paragraphOne.createRun();
        paragraphOneRunOne.setBold(true);
        
//        paragraphOneRunOne.setText("�����/�������� ����� �� ����������� �������� � ������������� ");
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.setText("������������ �� ���������� � ���������� ����������� ������� � ������");
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.setText("���������� ��������������� ��������� ������ ������ ���������������");
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.setText("����� (2012-2016 ����)� � ����� ����������� �� ������������ �����������");
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.setText("�������� ������ ������ � ����� �������������-����������������");
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.setText("����������, ����������� ����������, ������������ ���������� � ������");
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.setText("����������� ����������, ������������ ������������ � �������");
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.setText("�������������-���������������� ����������.");
//        paragraphOneRunOne.addCarriageReturn();
        
        paragraphOneRunOne.setText(
        "� ������ �� N " + gsAdd.getGkNum() + " �� "  + gsAdd.getContractDate() + " �� " + gsAdd.getContractDate() + " �� ���������� " +		
        "�����/�������� ����� �� ����������� �������� � ������������� " +
        "������������ �� ���������� � ���������� ����������� ������� � ������ " +
        "���������� ��������������� ��������� ������ ������ ��������������� "+
        "����� (2012-2016 ����)� � ����� ����������� �� ������������ ����������� "+
        "�������� ������ ������ � ����� �������������-���������������� "+
        "����������, ����������� ����������, ������������ ���������� � ������ "+
        "����������� ����������, ������������ ������������ � ������� "+
        "�������������-���������������� ����������.");
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.addCarriageReturn();
	}

	private void footer(){
        XWPFParagraph paragraphOne = document.createParagraph();
        paragraphOne.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun paragraphOneRunOne = paragraphOne.createRun();
        paragraphOneRunOne.setBold(true);
        String contractDate = gsAdd.getGkDates().get(version-1);  
        paragraphOneRunOne.setText("���� �����������: " + contractDate);
        Utils.addcr(paragraphOneRunOne, 10);
        paragraphOneRunOne.setText("������ 2014");
        Utils.addPageBreak(document);
	}
	
	
}
