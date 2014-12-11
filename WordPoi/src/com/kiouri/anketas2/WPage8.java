package com.kiouri.anketas2;

import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.kiouri.Utils;

public class WPage8 {

	private XWPFDocument document;
	private QwestionReport qwestionReport; 
	private GsAdd gsAdd;
	private int version;

	public WPage8(XWPFDocument document, QwestionReport qwestionReport, GsAdd gsAdd, int version){
		this.document = document;
		this.qwestionReport = qwestionReport;
		this.gsAdd = gsAdd;
		this.version = version;
		p7();
	}
	
	public void p7() {
		boolean isgood = true;
		Utils.header0(
				document,
				"7 Оценка качественных, функциональных, технических характеристик, выявленных в результате анализа");
		List<Qwestion> qwestions = qwestionReport.getQwestions();
		Qwestion lastQwestion = qwestions.get(qwestions.size() - 1);
		if (version == 6) {
			if (lastQwestion.getAnswer() != null
					&& (lastQwestion.getAnswer().trim().length() > 0 && !lastQwestion.getAnswer().trim().equals(";"))) {
				isgood = false;
				Utils.plain(document,
						"В процессе аудита были исправлены следующие разделы ТЗ"
								+ lastQwestion.getAnswer());
			}
		}
		
		if(WPage7.isRecommendationExists){
			isgood = false;
			Utils.plain(document, "Качественные, функциональные и технические решения не соответствуют"
					+ " требованиям заказчика в части замечаний, приведенных в п.4. После устранения "
					+ "замечаний требуется проведение повторного анализа");
		}

		if(isgood){
			Utils.plain(document, "Качественные, функциональные и технические решения соответствуют"
					+ " требованиям заказчика.");
		}
		
		Utils.header0(document, "архитектор: _________________________________________ ");
	}
	
}
