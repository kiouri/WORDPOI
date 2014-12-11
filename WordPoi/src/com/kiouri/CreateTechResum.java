package com.kiouri;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.VerticalAlign;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class CreateTechResum {
	
//	Params params = new Params();
	
	
	private String getSimpleFileName(String fullName){
		String simpleName = fullName.substring(fullName.lastIndexOf("/") + 1);
		return simpleName;
	}
	
	public void createDocument(Params params, String outputFileName, boolean isDocumentation){
		
		String fnm = "";
		
		FileOutputStream outStream = null;
        try {
        	if(isDocumentation){
        		fnm = outputFileName + "_documentation.docx";
        		outStream = new FileOutputStream(outputFileName + "_documentation.docx");
        	} else {
        		fnm = outputFileName + ".docx";
        		outStream = new FileOutputStream(outputFileName + ".docx");
        	}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		
		
		XWPFDocument document = new XWPFDocument();
		Page1 page1 = new Page1();
		page1.createPage1(document, params, isDocumentation, getSimpleFileName(fnm));
		Page2 page2 = new Page2();
		page2.createPage2(document, params);
		Page3 page3 = new Page3();
		page3.createPage3(document,params, isDocumentation);
		Page4 page4 = new Page4();
		page4.createPage4(document,params, isDocumentation);
		Page5 page5 = new Page5();
		page5.createPage5(document,params);
		Page6 page6 = new Page6();
		page6.createPage6(document,params);
		Page7 page7 = new Page7();
		page7.createPage7(document,params);
		Page8 page8 = new Page8();
		page8.createPage8(document,params);
		Page9 page9 = new Page9();
		page9.createPage9(document,params);

		
//		FileOutputStream outStream = null;
//        try {
//        	if(isDocumentation){
//        		outStream = new FileOutputStream(outputFileName + "_documentation.docx");
//        	} else {
//        		outStream = new FileOutputStream(outputFileName + ".docx");
//        	}
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
 
        try {
            document.write(outStream);
            outStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args ){
		CreateTechResum cds = new CreateTechResum();
		// Заполнить параметры
//		Params params = cds.getParams();
		Params params = new Params();
//!!		cds.createDocument(params);
	}

//	public Params getParams() {
//		return params;
//	}
//
//	public void setParams(Params params) {
//		this.params = params;
//	}
	
	

//	private void header(XWPFDocument document){
//        XWPFParagraph paragraphOne = document.createParagraph();
//        paragraphOne.setAlignment(ParagraphAlignment.CENTER);
//        XWPFRun paragraphOneRunOne = paragraphOne.createRun();
//        paragraphOneRunOne.setBold(true);
//        paragraphOneRunOne.setText("Департамент информационных технологий");
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.setText("города Москвы");
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.setText("Управление технической политики и эксплуатации");
//        paragraphOneRunOne.addCarriageReturn();
//	}
//	
//	private void alyaev(XWPFDocument document){
//        XWPFParagraph paragraph = document.createParagraph();
//        paragraph.setAlignment(ParagraphAlignment.RIGHT);
//        XWPFRun paragrapRun = paragraph.createRun();
//        paragrapRun.setText("УТВЕРЖДАЮ");
//        paragrapRun.addCarriageReturn();
//        paragrapRun.setText("Начальник управления технической");
//        paragrapRun.addCarriageReturn();
//        paragrapRun.setText("политики и эксплуатации");
//        paragrapRun.addCarriageReturn();
//        paragrapRun.setText("___________________А.В. Аляев");
//        paragrapRun.addCarriageReturn();
//        paragrapRun.setText("<<____>>_______________201  г.");   
//        addcr(paragrapRun, 5);
//        
//	}
//	
//	private void zakl(XWPFDocument document){
//        XWPFParagraph paragraphOne = document.createParagraph();
//        paragraphOne.setAlignment(ParagraphAlignment.CENTER);
//        XWPFRun paragraphOneRunOne = paragraphOne.createRun();
//        paragraphOneRunOne.setBold(true);
//        paragraphOneRunOne.setText("АНАЛИТИЧЕСКОЕ ЗАКЛЮЧЕНИЕ");
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.setText("О КАЧЕСТВЕ ТЕХНИЧЕСКОГО РЕШЕНИЯ");
//	}
//
//	private void object(XWPFDocument document){
//        XWPFParagraph paragraphOne = document.createParagraph();
//        paragraphOne.setAlignment(ParagraphAlignment.CENTER);
//        XWPFRun paragraphOneRunOne = paragraphOne.createRun();
//        paragraphOneRunOne.setBold(true);
//        paragraphOneRunOne.setBold(true);
//        paragraphOneRunOne.setText("Объект анализа");
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.setText("Наименование ИС");
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.setText("Государственный контракт N ГК____/__-____ от <<____>>_______________201  г. на");
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.setText("выполнение работ по XXX");
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.setText("дата составления:");
//        addcr(paragraphOneRunOne, 18);
//	}
//
//	private void moscow(XWPFDocument document){
//        XWPFParagraph paragraphOne = document.createParagraph();
//        paragraphOne.setAlignment(ParagraphAlignment.CENTER);
//        XWPFRun paragraphOneRunOne = paragraphOne.createRun();
//        paragraphOneRunOne.setText("Москва");
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.setText("201  г.");
//	}
	

//	
//	 public static void main(String[] args) {
//	        XWPFDocument document = new XWPFDocument();
//	 
//	        XWPFParagraph paragraphOne = document.createParagraph();
//	        paragraphOne.setAlignment(ParagraphAlignment.CENTER);
//	        paragraphOne.setBorderBottom(Borders.SINGLE);
//	        paragraphOne.setBorderTop(Borders.SINGLE);
//	        paragraphOne.setBorderRight(Borders.SINGLE);
//	        paragraphOne.setBorderLeft(Borders.SINGLE);
//	        paragraphOne.setBorderBetween(Borders.SINGLE);
//	 
//	        XWPFRun paragraphOneRunOne = paragraphOne.createRun();
//	        paragraphOneRunOne.setBold(true);
//	        paragraphOneRunOne.setItalic(true);
//	        paragraphOneRunOne.setText("Hello world! This is paragraph one!");
//	        paragraphOneRunOne.addBreak();
//	 
//	        XWPFRun paragraphOneRunTwo = paragraphOne.createRun();
//	        paragraphOneRunTwo.setText("Run two!");
//	        paragraphOneRunTwo.setTextPosition(100);
//	 
//	        XWPFRun paragraphOneRunThree = paragraphOne.createRun();
//	        paragraphOneRunThree.setStrike(true);
//	        paragraphOneRunThree.setFontSize(20);
//	        paragraphOneRunThree.setSubscript(VerticalAlign.SUBSCRIPT);
//	        paragraphOneRunThree.setText(" More text in paragraph one...");
//	 
//	        XWPFParagraph paragraphTwo = document.createParagraph();
//	        paragraphTwo.setAlignment(ParagraphAlignment.DISTRIBUTE);
//	        paragraphTwo.setIndentationRight(200);
//	        XWPFRun paragraphTwoRunOne = paragraphTwo.createRun();
//	        paragraphTwoRunOne.setText("And this is paragraph two.");
//	 
//	        FileOutputStream outStream = null;
//	        try {
////	            outStream = new FileOutputStream(args[0]);
//	            outStream = new FileOutputStream("test1.docx");
//	        } catch (FileNotFoundException e) {
//	            e.printStackTrace();
//	        }
//	 
//	        try {
//	            document.write(outStream);
//	            outStream.close();
//	        } catch (FileNotFoundException e) {
//	            e.printStackTrace();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	    }	
	
//	public static void main(String[] args) {
//        XWPFDocument document = new XWPFDocument();
// 
//        XWPFParagraph paragraphOne = document.createParagraph();
//        XWPFRun paragraphOneRunOne = paragraphOne.createRun();
//        paragraphOneRunOne.setText("Hello world! This is paragraph one!");
//        XWPFRun paragraphOneRunTwo = paragraphOne.createRun();
//        paragraphOneRunTwo.setText(" More text in paragraph one...");
// 
//        XWPFParagraph paragraphTwo = document.createParagraph();
//        XWPFRun paragraphTwoRunOne = paragraphTwo.createRun();
//        paragraphTwoRunOne.setText("And this is paragraph two.");
// 
//        FileOutputStream outStream = null;
//        try {
////            outStream = new FileOutputStream(args[0]);
//            outStream = new FileOutputStream("test1.docx");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
// 
//        try {
//            document.write(outStream);
//            outStream.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
