package com.kiouri;

public class DateGenerator {

	private static String[] dates = {  "21/11/2013","22/11/2013","23/11/2013","24/11/2013","25/11/2013","26/11/2013",
										"10/12/2013","11/12/2013","12/12/2013","13/12/2013"};
	
	private static String[] docDates = {"21/11/2013","22/11/2013","23/11/2013","24/11/2013","25/11/2013","26/11/2013"};
	private static String[] allDates = {"10/12/2013","11/12/2013","12/12/2013","13/12/2013"};
	
	static int currentDateNum = 0;
	
	static int currentDocDates = 0;
	static int currentAllDates = 0;
	
	public static String getNextDate(){
		String result =  dates[currentDateNum];
		currentDateNum++;
		if (currentDateNum >= dates.length){
			currentDateNum = 0;
		}
		return result;
	}
	
	public static String getDocDate(){
		String result =  docDates[currentDocDates];
		currentDocDates++;
		if (currentDocDates >= docDates.length){
			currentDocDates = 0;
		}
		return result;
	}	

	public static String getAllDate(){
		String result =  allDates[currentAllDates];
		currentAllDates++;
		if (currentAllDates >= allDates.length){
			currentAllDates = 0;
		}
		return result;
	}

}
