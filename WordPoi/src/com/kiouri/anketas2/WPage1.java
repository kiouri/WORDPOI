package com.kiouri.anketas2;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.kiouri.Utils;

public class WPage1 {
	
	private XWPFDocument document;
	private QwestionReport qwestionReport; 
	private GsAdd gsAdd;
	private int version;
	
	public WPage1(XWPFDocument document, QwestionReport qwestionReport, GsAdd gsAdd, int version){
		this.document = document;
		this.qwestionReport = qwestionReport;
		this.gsAdd = gsAdd;
		this.version = version;
		header();
		alyaev();
		zakl();
		object();		
	}

	private void header(){
        XWPFParagraph paragraphOne = document.createParagraph();
        paragraphOne.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun paragraphOneRunOne = paragraphOne.createRun();
        paragraphOneRunOne.setBold(true);
        paragraphOneRunOne.setText("Департамент информационных технологий");
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.setText("города Москвы");
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.setText("Управление технической политики и эксплуатации");
        paragraphOneRunOne.addCarriageReturn();
	}
	
	private void alyaev(){
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.RIGHT);
        XWPFRun paragrapRun = paragraph.createRun();
        paragrapRun.setText("УТВЕРЖДАЮ");
        paragrapRun.addCarriageReturn();
        paragrapRun.setText("Начальник управления технической");
        paragrapRun.addCarriageReturn();
        paragrapRun.setText("политики и эксплуатации");
        paragrapRun.addCarriageReturn();
        paragrapRun.setText("___________________А.В. Аляев");
        paragrapRun.addCarriageReturn();
        paragrapRun.setText("<<____>>_______________201  г.");   
        Utils.addcr(paragrapRun, 5);        
	}

	private void zakl(){
        XWPFParagraph paragraphOne = document.createParagraph();
        paragraphOne.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun paragraphOneRunOne = paragraphOne.createRun();
        paragraphOneRunOne.setBold(true);
        paragraphOneRunOne.setText("АНАЛИТИЧЕСКОЕ ЗАКЛЮЧЕНИЕ");
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.setText("О КАЧЕСТВЕ ТЕХНИЧЕСКОГО РЕШЕНИЯ");
	}
	
	private void object(){
        XWPFParagraph paragraphOne = document.createParagraph();
        paragraphOne.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun paragraphOneRunOne = paragraphOne.createRun();
        paragraphOneRunOne.setBold(true);
        paragraphOneRunOne.setBold(true);
        paragraphOneRunOne.setText("Объект анализа");
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.setText(gsAdd.getSystemName().trim());
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.setText("Государственный контракт N ГК " + gsAdd.getGkNum());
        paragraphOneRunOne.setText("от " + gsAdd.getContractDate());
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.addCarriageReturn();
        String contractDate = gsAdd.getGkDates().get(version-1);  
        paragraphOneRunOne.setText("дата составления: " + contractDate);
        Utils.addcr(paragraphOneRunOne, 10);
        Utils.addPageBreak(document);
	}

	

}
