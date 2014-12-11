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
//        paragraphOneRunOne.setText("Департамент информационных технологий");
        paragraphOneRunOne.setText("УТВЕРЖДАЮ                                                                                                     СОГЛАСОВАНО");
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.setText("Генеральный директор                                                                                 Генеральный директор");
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.setText("ЗАО «ОТКРЫТЫЕ ТЕХНОЛОГИИ 98»                                                          ГУП «ИАЦ ПР»");
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.setText("_______________________ Н.В. Рыжов                                                     ______________ О.А. Богданов");
        paragraphOneRunOne.addCarriageReturn();
        paragraphOneRunOne.setText("« ___ » _____________ 2014   г.                                                                    « ___ » _____________ 2014   г.");
        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.setText("Управление технической политики и эксплуатации");
//        paragraphOneRunOne.addCarriageReturn();
	}
	
//	private void alyaev(){
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
//        Utils.addcr(paragrapRun, 5);        
//	}

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
////        paragraphOneRunOne.setText("Государственный контракт N ГК " + gsAdd.getGkNum());
//        paragraphOneRunOne.setText("В рамках ГК N ГК " + gsAdd.getGkNum() + " от "  + gsAdd.getContractDate() + " от " + gsAdd.getContractDate() + " на выполнение");
//        paragraphOneRunOne.setText("работ/оказание услуг по обеспечению контроля и регулирования ");
//        paragraphOneRunOne.setText("деятельности по разработке и применению технических решений в рамках");
//        paragraphOneRunOne.setText("реализации государственной программы города Москвы «Информационный");
//        paragraphOneRunOne.setText("город (2012-2016 годы)» в целях обеспечения их соответствия технической");
//        paragraphOneRunOne.setText("политике города Москвы в сфере информационно-коммуникационных");
//        paragraphOneRunOne.setText("технологий, федеральным стандартам, региональным стандартам и другим");
//        paragraphOneRunOne.setText("нормативным документам, регулирующим деятельность в области");
//        paragraphOneRunOne.setText("информационно-коммуникационных технологий.");
////        paragraphOneRunOne.setText("от " + gsAdd.getContractDate());
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.addCarriageReturn();
//        String contractDate = gsAdd.getGkDates().get(version-1);  
//        paragraphOneRunOne.setText("дата составления: " + contractDate);
//        Utils.addcr(paragraphOneRunOne, 10);
//        paragraphOneRunOne.setText("Москва 2014");
//        Utils.addPageBreak(document);
	}
	
	private void xxx(){
        XWPFParagraph paragraphOne = document.createParagraph();
        paragraphOne.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun paragraphOneRunOne = paragraphOne.createRun();
        paragraphOneRunOne.setBold(true);
        
//        paragraphOneRunOne.setText("работ/оказание услуг по обеспечению контроля и регулирования ");
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.setText("деятельности по разработке и применению технических решений в рамках");
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.setText("реализации государственной программы города Москвы «Информационный");
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.setText("город (2012-2016 годы)» в целях обеспечения их соответствия технической");
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.setText("политике города Москвы в сфере информационно-коммуникационных");
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.setText("технологий, федеральным стандартам, региональным стандартам и другим");
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.setText("нормативным документам, регулирующим деятельность в области");
//        paragraphOneRunOne.addCarriageReturn();
//        paragraphOneRunOne.setText("информационно-коммуникационных технологий.");
//        paragraphOneRunOne.addCarriageReturn();
        
        paragraphOneRunOne.setText(
        "В рамках ГК N " + gsAdd.getGkNum() + " от "  + gsAdd.getContractDate() + " от " + gsAdd.getContractDate() + " на выполнение " +		
        "работ/оказание услуг по обеспечению контроля и регулирования " +
        "деятельности по разработке и применению технических решений в рамках " +
        "реализации государственной программы города Москвы «Информационный "+
        "город (2012-2016 годы)» в целях обеспечения их соответствия технической "+
        "политике города Москвы в сфере информационно-коммуникационных "+
        "технологий, федеральным стандартам, региональным стандартам и другим "+
        "нормативным документам, регулирующим деятельность в области "+
        "информационно-коммуникационных технологий.");
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
        paragraphOneRunOne.setText("дата составления: " + contractDate);
        Utils.addcr(paragraphOneRunOne, 10);
        paragraphOneRunOne.setText("Москва 2014");
        Utils.addPageBreak(document);
	}
	
	
}
