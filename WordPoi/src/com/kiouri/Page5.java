package com.kiouri;

import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Page5 {

	Params params;
	
	public void createPage5(XWPFDocument document, Params params){
		this.params = params;
	
		Utils.header0(document, "4 Перечень замечаний по результатам проведенного анализа");
		
		Utils.header1(document, "4.1 Существенные замечания");
		Utils.plainCursiv(document,true, "По результатам проведенного анализа к техническим решениям " +
		params.getSystemName() + " имеются следующие существенные замечания:");
		
		List<String> significantRemarks = params.getSignificantRemarks();
		for (int i = 0; i < significantRemarks.size(); i++){
			Utils.plain(document,significantRemarks.get(i));			
		}
		
		Utils.header1(document, "4.2 Прочие замечания");
		Utils.plainCursiv(document, true,  "По результатам проведенного анализа к техническим решениям " +
		params.getSystemName() + " имеются прочие замечания:");
		List<String> nonSignificantRemarks = params.getNonSignificantRemarks();
		for (int i = 0; i < nonSignificantRemarks.size(); i++){
			Utils.plain(document,nonSignificantRemarks.get(i));			
		}

		Utils.addPageBreak(document);
	}
}
