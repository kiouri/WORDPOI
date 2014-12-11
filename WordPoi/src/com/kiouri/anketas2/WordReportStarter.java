package com.kiouri.anketas2;

public class WordReportStarter {

	private static WordReport wordReport = new WordReport();
	
	private static String anketas = "c:\\hh\\out\\"; 
	private static String wrdOut = "c:\\hh\\out\\wrdout\\"; 

	
	public static void main(String[] args) throws Exception{
		wordReport.generateReports(anketas, wrdOut);
	}
}
