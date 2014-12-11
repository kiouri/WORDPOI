package com.kiouri;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Page6 {
	
Params params;
	
	public void createPage6(XWPFDocument document, Params params){
		this.params = params;
		Utils.header0(document, "5 –екомендации по устранению замечаний");
//		if (params.getSignificantRemarks().size() > 0 || params.getNonSignificantRemarks().size() > 0){
		if (params.getSignificantRemarks().size() == 1 & params.getNonSignificantRemarks().size() == 1 & 
				params.getSignificantRemarks().get(0).trim().equalsIgnoreCase("—ерьезные замечани€ отсутствуют.") &
				params.getNonSignificantRemarks().get(0).trim().equalsIgnoreCase("ѕрочие замечани€ отсутствуют.")) {

			Utils.plainCursiv(document,false, "«амечани€ отсутствуют.");

		} else {
			
			Utils.plainCursiv(document,false, "ƒл€ устранени€ вы€вленных замечаний рекомендуетс€:");
			Utils.plainCursiv(document,false, "”странить замечани€, перечисленные в разделах 4.1 и 4.2");			

		}
		Utils.addPageBreak(document);
	}	

}
