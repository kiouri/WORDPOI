package com.kiouri.anketas2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;


public class QwestionReportStarter {
	
	private static int TOTAL_VERSIONS = 6;
	
//	private static String inDirectory = "c:\\hhh\\";
//	private static String outDirectory = "c:\\hhh\\out\\";
	
	private static String inDirectory = "c:\\hh\\";
	private static String outDirectory = "c:\\hh\\out\\";
	
	
	public static void main(String[] args) throws Exception {
		copyLastVersion(inDirectory, outDirectory, TOTAL_VERSIONS);
		QwestionReportFactory qwestionReportFactory = new QwestionReportFactory();
		qwestionReportFactory.generateAnketasForDir(inDirectory, outDirectory, TOTAL_VERSIONS - 1);
    }
	
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
	

//////////////////////////////////////////////////////////////////////////////////
//	public static void main(String[] args){
//		System.out.println(createNameWithVersion("xxx.txt", 6));
//	}
//////////////////////////////////////////////////////////////////////////////////	
	
}
