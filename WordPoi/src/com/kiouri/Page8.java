package com.kiouri;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Page8 {

	Params params;

	public void createPage8(XWPFDocument document, Params params) {
		this.params = params;
		Utils.header0(
				document,
				"7 	ќценка качественных, функциональных, технических характеристик, вы€вленных в результате анализа");
		// Utils.plain(document,
		// "ѕо представленной документации, выполнить данную оценку не представл€етс€ возможным.");
		if (params.getSignificantRemarks().size() == 1
				& params.getNonSignificantRemarks().size() == 1
				& params.getSignificantRemarks().get(0).trim()
						.equalsIgnoreCase("—ерьезные замечани€ отсутствуют.")
				& params.getNonSignificantRemarks().get(0).trim()
						.equalsIgnoreCase("ѕрочие замечани€ отсутствуют.")) {

			Utils.plain(
					document,
					" ачественные, функциональные и технические характеристики решени€ соответствуют требовани€м заказчика.");
		} else {
			Utils.plain(
					document,
					" ачественные, функциональные и технические характеристики решени€ не соответствуют требовани€м заказчика в части замечаний, приведенных в п.4. ѕосле устранени€ замечани€ требуетс€ проведение повторного анализа.");
		}
		Utils.addPageBreak(document);
	}

}
