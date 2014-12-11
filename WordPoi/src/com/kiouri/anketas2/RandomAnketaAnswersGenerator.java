package com.kiouri.anketas2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;

public class RandomAnketaAnswersGenerator {
	
//	static HashMap<String,String> fnames = new HashMap<String, String>();
//	
//	static {
//		fnames.put("1", "1_Доступ сотрудников транспорта");
//		fnames.put("9", "9_Сопровождение СПУ");
//		fnames.put("17", "17_Тех. поддержка АИС 'Типовой портал'");
//		fnames.put("18", "18_Тех. поддержка АСГУФ");
//		fnames.put("31", "31_Автоматизация хоздеятельности Деп.Обр.");		
//	}
	
	private AnketasAdd anketasAdd = new AnketasAdd();
	
	private static String templateQwestionsUrl = "c:\\hh\\templates\\Qwestion_template.xls";
	private static String gkListPath = "c:\\hh\\templates\\GK_List.xls";
	private Random rd = new Random();
	
	public RandomAnketaAnswersGenerator(){}
	
	public void generateRandomAnketas(String...nums) throws Exception{
		for (String num : nums){
			GsAdd gsAdd = parseGKList(num, gkListPath);
			writeRandomQwestionReport("", num, gsAdd.getGkNum());
		}		
	}
	
	public GsAdd parseGKList(String num,  String gkPath) throws IOException{
		GsAdd gsAdd = anketasAdd.getGSByNum(num, gkPath);
		String name = gsAdd.getSystemName();
		String dest    = gsAdd.getDestination();
		String perpuse = gsAdd.getPerpuse();
		if (dest == null || dest.trim().length() == 0){
			dest = name;
		}
		if (perpuse == null || perpuse.trim().length() == 0){
			perpuse = name;
		}
		return gsAdd;
	}

	public void writeRandomQwestionReport(String filename, String num, String dogNum) throws Exception{
		QwestionReportFactory qrf = new QwestionReportFactory();
		QwestionReport qwestionReportTemplate = qrf.pase(templateQwestionsUrl);
		QwestionReport qwestionReport = geterateRandomQwestionReport(qwestionReportTemplate);
		WbFO wbfo = qrf.createWorkBook(filename);
		Sheet sheet = qrf.createSheet(wbfo.getWb(), "Версия_6");
		qrf.writeQwestionReportVersion(sheet, num, dogNum, qwestionReport.getQwestions(), getAnswers(qwestionReport));
		
	}

	private List<String> getAnswers(QwestionReport qwestionReport){
		List<String> result = new ArrayList<String>();
		for (Qwestion qwestion : qwestionReport.getQwestions()){
			result.add(qwestion.getAnswer());
		}
		return result;
	}
	
	private QwestionReport geterateRandomQwestionReport(QwestionReport qwestionReportTemplate) throws Exception{
		QwestionReport result = new QwestionReport(); 
		for (Qwestion qwestion : qwestionReportTemplate.getQwestions()){
			 result.addQwesion(generateRandomAnswerForQwestion(qwestion));
		}
		return result;
		
	}
	
	private static QwestionReport getQwestionReport() throws Exception{
		QwestionReportFactory qrf = new QwestionReportFactory();
		return qrf.pase(templateQwestionsUrl);		
	}
	
	private String getRandomAnswer(List<String> answerVariants){
		int index = rd.nextInt(answerVariants.size());
		return answerVariants.get(index);
	}
	
	private Qwestion generateRandomAnswerForQwestion(Qwestion qwestion) throws Exception{
		List<String> answerVariants = qwestion.getAnswerVariants();
		String answer = getRandomAnswer(answerVariants);
		qwestion.setAnswer(answer);
		return qwestion;
	}
	
////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) throws Exception{
		QwestionReport qwestionReport = getQwestionReport();
		
	}
}

class GkList {
	
}
