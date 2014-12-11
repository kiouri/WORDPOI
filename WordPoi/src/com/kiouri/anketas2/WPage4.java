package com.kiouri.anketas2;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.kiouri.Utils;

public class WPage4 {

	private XWPFDocument document;
	private QwestionReport qwestionReport; 
	private GsAdd gsAdd;
	private int version;

	public WPage4(XWPFDocument document, QwestionReport qwestionReport, GsAdd gsAdd, int version){
		this.document = document;
		this.qwestionReport = qwestionReport;
		this.gsAdd = gsAdd;
		this.version = version;
		p3();
		p3_1();
		p3_2();
	}
	
	private void p3(){
		Utils.header0(document, "3 –езультаты сопоставлени€ оцениваемых параметров с требовани€ми «аказчика");
//		p3_1();
//		p3_2();
	}
	
	private void p3_1() {
		Utils.header1(document, "3.1 ѕрикладна€ архитектура");
		List<String> negativeAnswers = getNotConsistDocsPriclArc(qwestionReport);
		List<String> partialNegativeAnswers = getPartialNotConsistDocsPriclArc(qwestionReport);
		
		List<String> partialNegativeAnswers2 = new ArrayList<String>();
		for(String nAns : partialNegativeAnswers){
			if (!negativeAnswers.contains(nAns)){
				partialNegativeAnswers2.add(nAns);
			}
		}
		
		if (negativeAnswers.size() > 0) {
			Utils.plainCursiv(document,true,
					"ѕрикладна€ архитектура не соответствует требовани€м, изложенным в документах: ");
			for (String negativeAnswer : negativeAnswers) {
				Utils.plain(document, negativeAnswer);
			}
		}
		
		if (partialNegativeAnswers2.size() > 0) {
			Utils.plainCursiv(document,true,
					"ѕрикладна€ архитектура частично не соответствует требовани€м, изложенным в документах: ");
			for (String pnegativeAnswer2 : partialNegativeAnswers2) {
				Utils.plain(document, pnegativeAnswer2);
			}
		}

		if(negativeAnswers.size() == 0 && partialNegativeAnswers2.size() == 0){
			Utils.plainCursiv(document,true,
					"ѕрикладна€ архитектура соответствует требовани€м, изложенным в документах: ");
			for(String doc: WUtils.docsNoData){
				Utils.plain(document, doc);
			}
			
		}
		
	}

	private void p3_2() {
		Utils.header1(document, "3.2 јрхитектура данных");
		List<String> negativeAnswers = getNotConsistDocsArcData(qwestionReport);
		List<String> partialNegativeAnswers = getPartialNotConsistDocsArcData(qwestionReport);
		
		List<String> partialNegativeAnswers2 = new ArrayList<String>();
		for(String nAns : partialNegativeAnswers){
			if (!negativeAnswers.contains(nAns)){
				partialNegativeAnswers2.add(nAns);
			}
		}

		
		if (negativeAnswers.size() > 0) {
			Utils.plainCursiv(
					document,
					true,
					"јрхитектура данных решени€ не соответствует требовани€м, изложенным в документах: ");
			for (String negativeAnswer : negativeAnswers) {
				Utils.plain(document, negativeAnswer);
			}
		}
		
		
		if (partialNegativeAnswers.size() > 0) {
			Utils.plainCursiv(
					document,
					true,
					"јрхитектура данных решени€ частично соответствует требовани€м, изложенным в документах: ");
			for (String negativeAnswer : negativeAnswers) {
				Utils.plain(document, negativeAnswer);
			}
		}
		
		if(negativeAnswers.size() == 0 && partialNegativeAnswers.size() == 0){
			Utils.plainCursiv(document,true,
					"јрхитектура данных соответствует требовани€м, изложенным в документах: ");
			for(String doc: WUtils.docsData){
				Utils.plain(document, doc);
			}

		}
			
		
		Utils.addPageBreak(document);
	}
	
	private List<String> getNotConsistDocsPriclArc(QwestionReport qwestionReport){
		List<String> result = new ArrayList<String>();
		List<String> nAns = WUtils.getNegativeAnswers();
		for (Qwestion qwestion : qwestionReport.getQwestions()){
			if(nAns.contains(qwestion.getAnswer().toUpperCase()) && qwestion.getEssentiality().equalsIgnoreCase("ƒа")){
				if (qwestion.getDocRequest().equalsIgnoreCase(WUtils.getArcDataItem())){
					continue;
				}
				String docRequest = qwestion.getDocRequest().trim();
				String  negativeItem = WUtils.getDocByDocReq(docRequest);
				if (!result.contains(negativeItem)){
					result.add(negativeItem);
				}
			}			
		}
		return result;
	}

	private List<String> getPartialNotConsistDocsPriclArc(QwestionReport qwestionReport){
		List<String> result = new ArrayList<String>();
		List<String> nAns = WUtils.getNegativeAnswers();
		for (Qwestion qwestion : qwestionReport.getQwestions()){
			if(nAns.contains(qwestion.getAnswer().toUpperCase()) && qwestion.getEssentiality().equalsIgnoreCase("Ќет")){
				if (qwestion.getDocRequest().equalsIgnoreCase(WUtils.getArcDataItem())){
					continue;
				}
				String docRequest = qwestion.getDocRequest().trim();
				String  negativeItem = WUtils.getDocByDocReq(docRequest);
				if (!result.contains(negativeItem)){
					result.add(negativeItem);
				}
			}			
		}
		return result;
	}

	
	// DATA
	private List<String> getNotConsistDocsArcData(QwestionReport qwestionReport){
		List<String> result = new ArrayList<String>();
		List<String> nAns = WUtils.getNegativeAnswers();
		for (Qwestion qwestion : qwestionReport.getQwestions()){
			if(nAns.contains(qwestion.getAnswer().toUpperCase()) && qwestion.getEssentiality().equalsIgnoreCase("ƒа")){
				if (!qwestion.getDocRequest().equalsIgnoreCase(WUtils.getArcDataItem())){
					continue;
				}
				String docRequest = qwestion.getDocRequest();
				String  negativeItem = WUtils.getDocByDocReq(docRequest);
				if (!result.contains(negativeItem)){
					result.add(negativeItem);
				}
			}			
		}
		return result;
	}

	
	private List<String> getPartialNotConsistDocsArcData(QwestionReport qwestionReport){
		List<String> result = new ArrayList<String>();
		List<String> nAns = WUtils.getNegativeAnswers();
		for (Qwestion qwestion : qwestionReport.getQwestions()){
			if(nAns.contains(qwestion.getAnswer().toUpperCase()) && qwestion.getEssentiality().equalsIgnoreCase("Ќет")){
				if (!qwestion.getDocRequest().equalsIgnoreCase(WUtils.getArcDataItem())){
					continue;
				}
				String docRequest = qwestion.getDocRequest();
				String  negativeItem = WUtils.getDocByDocReq(docRequest);
				if (!result.contains(negativeItem)){
					result.add(negativeItem);
				}
			}			
		}
		return result;
	}
	
	
}
