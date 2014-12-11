package com.kiouri;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Page9 {

Params params;
	
	public void createPage9(XWPFDocument document, Params params){
		this.params = params;
		Utils.header0(document, "8 	Иные рекомендации и предложения");
		Utils.plain(document, "Согласовать архитектуру решения с УТП до начала разработки решения.");
		Utils.header0(document, "архитектор ");
	}	
	
	
}
