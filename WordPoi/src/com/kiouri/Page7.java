package com.kiouri;

import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Page7 {
	
Params params;
	
	public void createPage7(XWPFDocument document, Params params){
		this.params = params;
		Utils.header0(document, "6 ѕредложени€ по улучшению и повышению качества анализируемых технических решений");
		Utils.plainCursiv(document,false, "ƒл€ дальнейшего повышени€ качества технических решений "+ params.getSystemName() + " рекомендуетс€:");

		List<String> significantRecomendations = params.getSignificantRecomendations();
		for (int i = 0; i < significantRecomendations.size(); i++){
			Utils.plain(document,significantRecomendations.get(i));			
		}
		
		List<String> nonSignificantRecomendations = params.getNonSignificantRecomendations();
		for (int i = 0; i < nonSignificantRecomendations.size(); i++){
			Utils.plain(document,nonSignificantRecomendations.get(i));			
		}

		
		Utils.addPageBreak(document);
	}	
	

}
