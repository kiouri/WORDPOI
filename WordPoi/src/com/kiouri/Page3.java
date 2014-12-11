package com.kiouri;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Page3 {
	
	Params params;
	
	public void createPage3(XWPFDocument document, Params params, boolean isDocumentation){
		this.params = params;
		
		Utils.header0(document, "2 ѕеречень знаний, требований и документов, в соответствии с которыми проводилс€ анализ");
		Utils.plain(document,"јнализ технических решений проводилс€ по следующим направлени€м:");
		Utils.plain(document,"1) прикладна€ архитектура решени€");
		Utils.plain(document,"2) архитектура данных");

		Utils.header1(document, "2.1 ѕрикладна€ архитектура");
		if (!isDocumentation){
			Utils.plain(document,"ѕри анализе прикладной архитектуры за основу были вз€ты: ");		
			Utils.plain(document,"\"“ипова€ архитектура приложени€\"");
			Utils.plain(document,"\"“ребовани€ к интеграции\"");
		}
		Utils.plain(document,"ƒокументаци€ в части архитектуры:");  				
		Utils.plain(document,"   1) описание архитектуры");
		Utils.plain(document,"   2) соответствие описанных решений требовани€м, изложенным в “« в части архитектуры");
		Utils.plain(document,"");
		Utils.header1(document, "2.2 јрхитектура данных");
		Utils.plain(document,"ѕри анализе архитектуры данных за основу были вз€ты " + 
		"\"“ребовани€ к модел€м данных дл€ IT решений\"");

		Utils.addPageBreak(document);
	}	
}
