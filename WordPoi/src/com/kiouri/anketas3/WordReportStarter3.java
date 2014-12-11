package com.kiouri.anketas3;

import com.kiouri.anketas2.WordReport;

public class WordReportStarter3 {

private static WordReport3 wordReport3 = new WordReport3();
	
//	private static String anketas = "c:\\hh2\\out\\"; 
//	private static String wrdOut = "c:\\hh2\\out\\wrdout\\"; 

private static String anketas = "c:\\hh2full\\out\\"; 
private static String wrdOut = "c:\\hh2full\\out\\wrdout\\"; 



	public static void main(String[] args) throws Exception{
		wordReport3.generateReports(anketas, wrdOut);
	}
	
}
