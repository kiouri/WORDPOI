package com.kiouri;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Page1 {
	
	Params params;
	Random random = new Random();

	public void createPage1(XWPFDocument document, Params params, boolean isDocumentation, String filename){
		this.params = params;
		
		header(document);
		alyaev(document);
		zakl(document, isDocumentation);
		object(document, filename, isDocumentation);
		moscow(document);
	}
	
	private void header(XWPFDocument document){
        XWPFParagraph paragraphOne = document.createParagraph();
        paragraphOne.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun paragraphOneRunOne = paragraphOne.createRun();
        paragraphOneRunOne.setBold(true);
        paragraphOneRunOne.setText("����������� �������������� ����������");
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.setText("������ ������");
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.setText("���������� ����������� �������� � ������������");
        paragraphOneRunOne.addCarriageReturn();
	}
	
	private void alyaev(XWPFDocument document){
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.RIGHT);
        XWPFRun paragrapRun = paragraph.createRun();
        paragrapRun.setText("���������");
        paragrapRun.addCarriageReturn();
        paragrapRun.setText("��������� ���������� �����������");
        paragrapRun.addCarriageReturn();
        paragrapRun.setText("�������� � ������������");
        paragrapRun.addCarriageReturn();
        paragrapRun.setText("___________________�.�. �����");
        paragrapRun.addCarriageReturn();
        paragrapRun.setText("<<____>>_______________201  �.");   
        Utils.addcr(paragrapRun, 5);
        
	}
	
	private void zakl(XWPFDocument document, boolean isDocumentation){
        XWPFParagraph paragraphOne = document.createParagraph();
        paragraphOne.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun paragraphOneRunOne = paragraphOne.createRun();
        paragraphOneRunOne.setBold(true);
        paragraphOneRunOne.setText("������������� ����������");
        paragraphOneRunOne.addCarriageReturn();
        if (isDocumentation){
        	paragraphOneRunOne.setText("� �������� ������������ ������� (������������)");
        } else {
        	paragraphOneRunOne.setText("� �������� ������������ �������");
        }
	}

	private void object(XWPFDocument document, String fileName, boolean isDocumentation){
        XWPFParagraph paragraphOne = document.createParagraph();
        paragraphOne.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun paragraphOneRunOne = paragraphOne.createRun();
        paragraphOneRunOne.setBold(true);
        paragraphOneRunOne.setBold(true);
        paragraphOneRunOne.setText("������ �������");
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.setText(params.getSystemName().trim());
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.setText("��������������� �������� N �� " + params.getContractNumber());
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.addCarriageReturn();
        
//        String contractDate = DateGenerator.getNextDate();
        
        String contractDate = "";  
        if(isDocumentation){
        	contractDate = DateGenerator.getDocDate();
        } else {
        	contractDate = DateGenerator.getAllDate();
        }
        
        paragraphOneRunOne.setText("���� �����������: " + contractDate);
        System.out.println(contractDate + ";" + fileName);
        Utils.addcr(paragraphOneRunOne, 10);
	}

	private void moscow(XWPFDocument document){
        XWPFParagraph paragraphOne = document.createParagraph();
        paragraphOne.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun paragraphOneRunOne = paragraphOne.createRun();
        paragraphOneRunOne.setText("������");
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.setText("2013 �.");
        paragraphOneRunOne.addBreak(BreakType.PAGE);
	}
	
}
