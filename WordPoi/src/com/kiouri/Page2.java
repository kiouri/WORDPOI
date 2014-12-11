package com.kiouri;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Page2 {
	
	Params params;
	
	public void createPage2(XWPFDocument document, Params params){
		this.params = params;
		
		Utils.header0(document, "1 Краткое описание объекта анализа");
		
		Utils.header1(document,"1.1 Наименование объекта анализа");
		
		Utils.plain(document, 
		"Предметом анализа являются технические решения информационной системы, "+
		 params.getSystemName().trim() + ", разрабатываемой (модернизируемой) в рамках " +
		"государственного контракта " + params.getContractNumber() + ".");
		
		Utils.header1(document,"1.2 Описание объекта анализа");
		
		String parText = 
		params.systemName + " разрабатывается (модернизируется) в интересах ДИТ ";
		if (params.getFunctionCustomer().trim().length() > 0){		
			parText += " и " +params.getFunctionCustomer() + " ";
		}
		parText += ".";
		
		Utils.plain(document, parText);
		Utils.plainCursiv(document, true, "Основным назначением системы является: ");
		String destination = params.getSystemDestination();
		destination = destination.replaceAll("", "-");
		Utils.plain(document, destination);
		Utils.plainCursiv(document, true, "Целью создания (модернизации) системы является: ");
		String purpose = params.getCreationPurpose();
//		System.out.println(purpose.indexOf(""));
//		System.out.println(purpose.indexOf("?"));
//		System.out.println(purpose.charAt(37));
//		System.out.println(purpose.charAt(38));
//		System.out.println(purpose.charAt(39));
//		System.out.println(purpose.charAt(40));
		purpose = purpose.replaceAll("", "-");
		Utils.plain(document, purpose);
		
		Utils.header1(document,"1.4 Основания для проведения анализа");
		
		Utils.plain(document, 
		"Анализ проводился на основании документов технического проекта.");
		
		 Utils.addPageBreak(document);
	}

	
}
