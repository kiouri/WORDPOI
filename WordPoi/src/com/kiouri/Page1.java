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
        paragraphOneRunOne.setText("Департамент информационных технологий");
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.setText("города Москвы");
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.setText("Управление технической политики и эксплуатации");
        paragraphOneRunOne.addCarriageReturn();
	}
	
	private void alyaev(XWPFDocument document){
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
	
	private void zakl(XWPFDocument document, boolean isDocumentation){
        XWPFParagraph paragraphOne = document.createParagraph();
        paragraphOne.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun paragraphOneRunOne = paragraphOne.createRun();
        paragraphOneRunOne.setBold(true);
        paragraphOneRunOne.setText("АНАЛИТИЧЕСКОЕ ЗАКЛЮЧЕНИЕ");
        paragraphOneRunOne.addCarriageReturn();
        if (isDocumentation){
        	paragraphOneRunOne.setText("О КАЧЕСТВЕ ТЕХНИЧЕСКОГО РЕШЕНИЯ (ДОКУМЕНТАЦИЯ)");
        } else {
        	paragraphOneRunOne.setText("О КАЧЕСТВЕ ТЕХНИЧЕСКОГО РЕШЕНИЯ");
        }
	}

	private void object(XWPFDocument document, String fileName, boolean isDocumentation){
        XWPFParagraph paragraphOne = document.createParagraph();
        paragraphOne.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun paragraphOneRunOne = paragraphOne.createRun();
        paragraphOneRunOne.setBold(true);
        paragraphOneRunOne.setBold(true);
        paragraphOneRunOne.setText("Объект анализа");
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.setText(params.getSystemName().trim());
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.setText("Государственный контракт N ГК " + params.getContractNumber());
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
        
        paragraphOneRunOne.setText("дата составления: " + contractDate);
        System.out.println(contractDate + ";" + fileName);
        Utils.addcr(paragraphOneRunOne, 10);
	}

	private void moscow(XWPFDocument document){
        XWPFParagraph paragraphOne = document.createParagraph();
        paragraphOne.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun paragraphOneRunOne = paragraphOne.createRun();
        paragraphOneRunOne.setText("Москва");
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.setText("2013 г.");
        paragraphOneRunOne.addBreak(BreakType.PAGE);
	}
	
}
