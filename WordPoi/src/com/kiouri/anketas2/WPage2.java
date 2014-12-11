package com.kiouri.anketas2;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.kiouri.Utils;

public class WPage2 {
	
	private XWPFDocument document;
	private QwestionReport qwestionReport; 
	private GsAdd gsAdd;
	private int version;


	public WPage2(XWPFDocument document, QwestionReport qwestionReport, GsAdd gsAdd, int version){
		this.document = document;
		this.qwestionReport = qwestionReport;
		this.gsAdd = gsAdd;
		this.version = version;
		header();
		p1_1();
		p1_2();
	}
	
	private void header(){
		Utils.header0(document, "1 Краткое описание объекта анализа");
	}
	
	private void p1_1(){
//		Utils.header1(document,"1.1 Наименование объекта анализа");		
//		Utils.plain(document, 
//		"Предметом анализа являются технические решения информационной системы, "+
//		gsAdd.getSystemName() + ", разрабатываемой (модернизируемой) в рамках " +
//		"государственного контракта " + gsAdd.getGkNum() + ".");
		
		Utils.header1(document,"1.1 Наименование объекта анализа");		
		Utils.plain(document, 
		"Предметом анализа являются технические решения, выполненные в рамках государственного контракта "+ 
		gsAdd.getGkNum() + " \"" + gsAdd.getSystemName() + "\".");  
		
	}
	
	public void p1_2(){
		Utils.header1(document,"1.2 Описание объекта анализа");
		String parText = 
		gsAdd.getSystemName() + " осуществляется в интересах ДИТ ";
		parText += ".";
		Utils.plain(document, parText);
		Utils.plainCursiv(document, true, "Основным назначением системы является: ");
		String destination = gsAdd.getDestination();
		destination = destination.replaceAll("", "-");
		Utils.plain(document, destination);

		Utils.plainCursiv(document, true, "Целью создания (модернизации) системы является: ");
		String purpose = gsAdd.getPerpuse();
		
		purpose = purpose.replaceAll("", "-");
		Utils.plain(document, purpose);

		Utils.header1(document,"1.4 Основания для проведения анализа");
		
		Utils.plain(document, 
		"Анализ проводился на основании документов технического проекта.");
		
//		 Utils.addPageBreak(document);


	}
}
