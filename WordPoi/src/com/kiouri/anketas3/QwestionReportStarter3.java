package com.kiouri.anketas3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.kiouri.anketas2.GsAdd;
import com.kiouri.anketas2.QwestionReportFactory;
import com.kiouri.anketas2.Utils;


public class QwestionReportStarter3 {
	
//	private static int TOTAL_VERSIONS = 6;
	
//	private static String inDirectory = "c:\\hhh\\";
//	private static String outDirectory = "c:\\hhh\\out\\";
	
	private static String inDirectory = "c:\\hh2full\\";
	private static String outDirectory = "c:\\hh2full\\out\\";
	
	
//	public static void main(String[] args) throws Exception {
//		copyLastVersion(inDirectory, outDirectory, TOTAL_VERSIONS);
//		QwestionReportFactory qwestionReportFactory = new QwestionReportFactory();
//		qwestionReportFactory.generateAnketasForDir(inDirectory, outDirectory, TOTAL_VERSIONS - 1);
//    }
	
	private static void copyLastVersion(String inDirectory, String outDirectory, int version){
		if (!outDirectory.endsWith("\\")){
			outDirectory = outDirectory + "\\";
		}
		List<String> fileNames = getFileNamesFromDir1(inDirectory);
		for (String fileName : fileNames){
			String destFileName = outDirectory +  Utils.createNameWithVersion(Utils.getShortName(fileName), version);
			copyFile(fileName, destFileName);
		}		
	}
	
	private static void copyLastVersion3(String inDirectory, String outDirectory) throws IOException{
		if (!outDirectory.endsWith("\\")){
			outDirectory = outDirectory + "\\";
		}
		List<String> fileNames = getFileNamesFromDir1(inDirectory);
		for (String fileName : fileNames){
			try {
//				int finalVersion = getAmmountOfIterationForContract(getCheckListNum(fileName));
				int finalVersion = Utils.getAmmountOfIterationForContract(Utils.getCheckListNum(fileName), AnketasAdd3.gsPath);
				String destFileName = outDirectory + Utils.createNameWithVersion(Utils.getShortName(fileName), finalVersion);
				System.out.println(destFileName);
				 copyFile(fileName, destFileName);
			} catch (Exception e) {

			}
		}		
	}
	
	
	private static List<String> getFileNamesFromDir1(String path){
		List<String> result = new ArrayList<String>();
		File f = new File(path);
		File[] files = f.listFiles();
		for(File file : files){
			if (file.isDirectory()){
				continue;
			}
			result.add(file.getAbsolutePath());
		}
		return result;
	}
	
	private static void copyFile(String sourceFileName, String destFileName){
		File source = new File(sourceFileName);
		File dest = new File(destFileName);
		try {
		    FileUtils.copyFile(source, dest);
		} catch (IOException e) {
		    e.printStackTrace();
		}	
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	private static String getCheckListNum(String checkListFileName){
//		int lastSleshIndex = checkListFileName.lastIndexOf("\\");
//		int delimIndex = checkListFileName.indexOf("_");
//		return checkListFileName.substring(lastSleshIndex+1, delimIndex);
//	}
	
//	public static int getAmmountOfIterationForContract(String contractNum) throws IOException{
//		System.out.println(contractNum);
//		AnketasAdd3 anketasAdd3 = new AnketasAdd3();
//		GsAdd gsAdd = anketasAdd3.getGSByNum(contractNum, AnketasAdd3.gsPath);
//		return gsAdd.getGkDates().size();
//	}
	

//////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) throws Exception{
////		System.out.println(createNameWithVersion("xxx.txt", 6));
////		System.out.println(QwestionReportStarter3.getCheckListNum("11_Учет потребностей бюджетных учреждений.xls"));
//		
//		List<String> fileNames = getFileNamesFromDir1(inDirectory);
//		for (String fileName : fileNames){
//			System.out.println(QwestionReportStarter3.getCheckListNum(fileName));
//		}
//		System.out.println("Ammount of iteration = " + getAmmountOfIterationForContract("16"));
//		System.out.println("Ammount of iteration = " + getAmmountOfIterationForContract("22"));
		copyLastVersion3(inDirectory, outDirectory);
		QwestionReportFactory3 qwestionReportFactory3 = new QwestionReportFactory3();
		qwestionReportFactory3.generateAnketasForDir3(inDirectory, outDirectory);
	}
//////////////////////////////////////////////////////////////////////////////////	
	
}