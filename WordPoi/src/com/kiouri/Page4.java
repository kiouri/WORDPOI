package com.kiouri;

import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Page4 {

	Params params;
	
	public void createPage4(XWPFDocument document, Params params, boolean isDocumentation){
		this.params = params;
		
		Utils.header0(document, "3 –езультаты сопоставлени€ оцениваемых параметров с требовани€ми «аказчика");
		Utils.header1(document, "3.1 ѕрикладна€ архитектура");

		if (params.getSignificantRemarks().size() == 1 & params.getNonSignificantRemarks().size() == 1 & 
			params.getSignificantRemarks().get(0).trim().equalsIgnoreCase("—ерьезные замечани€ отсутствуют.") &
			params.getNonSignificantRemarks().get(0).trim().equalsIgnoreCase("ѕрочие замечани€ отсутствуют.")) {
			Utils.plainCursiv(document,true,"ѕрикладна€ архитектура решений в целом соответствует требовани€м");
		} else if(params.getSignificantRemarks().size() == 0 & params.getNonSignificantRemarks().size() > 0 ) {
			Utils.plainCursiv(document,true,"ѕрикладна€ архитектура решений частично соответствует требовани€м, изложенным в документах: ");
		} else {
			Utils.plainCursiv(document,true,"ѕрикладна€ архитектура решений не соответствует требовани€м, изложенным в документах: ");
		}
		
		for (String nonValidoc : params.getNonValidDocs()){
			Utils.plain(document, nonValidoc);
		}
		
		if (!isDocumentation) {
			Utils.header1(document, "3.2 јрхитектура данных");
			if (params.getSignificantDataRemarks().size() > 0) {
				Utils.plainCursiv(
						document,
						true,
						"јрхитектура данных решени€ не соответствует требовани€м, изложенным в документ:");
			} else if (params.getSignificantDataRemarks().size() == 0
					& params.getNonSignificantDataRemarks().size() > 0) {
				Utils.plainCursiv(
						document,
						true,
						"јрхитектура данных решени€ частично соответствует требовани€м, изложенным в документ:");
			} else if (params.getSignificantDataRemarks().size() == 0
					& params.getNonSignificantDataRemarks().size() == 0) {
				Utils.plainCursiv(document, true,
						"јрхитектура данных решени€ соответствует требовани€м, изложенным в документ:");
			}
			Utils.plainCursiv(document, true, "“ребовани€ к архитектуре данных");
		}
		Utils.addPageBreak(document);
	}	
}
