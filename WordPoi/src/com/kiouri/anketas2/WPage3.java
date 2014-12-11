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
		Utils.header0(document, "2 Перечень знаний, требований и документов, в соответствии с которыми проводился анализ");
		Utils.plain(document,"Анализ технических решений проводился по следующим направлениям:");
		Utils.plain(document,"1) прикладная архитектура решения");
		Utils.plain(document,"2) архитектура данных");

		Utils.header1(document, "2.1 Прикладная архитектура");
//		if (!isDocumentation){
			Utils.plain(document,"При анализе прикладной архитектуры за основу были взяты: ");		
			Utils.plain(document,"\"Типовая архитектура приложения\"");
			Utils.plain(document,"\"Требования к интеграции\"");
//		}
		Utils.plain(document,"Документация в части архитектуры:");  				
		Utils.plain(document,"   1) описание архитектуры в документах технического проекта");
		Utils.plain(document,"   2) соответствие описанных решений требованиям, изложенным в ТЗ в части архитектуры");
		Utils.plain(document,"");
		Utils.header1(document, "2.2 Архитектура данных");
		Utils.plain(document,"При анализе архитектуры данных за основу были взяты " + 
		"\"Требования к моделям данных для IT решений\"");

		Utils.addPageBreak(document);

	}
}
