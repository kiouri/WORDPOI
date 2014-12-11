package com.kiouri.anketas2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.kiouri.anketas3.AnketasAdd3;

public class Utils {
	
	public static List<String> getFileNamesFromDir(String path){
		List<String> result = new ArrayList<String>();
		File f = new File(path);
		File[] files = f.listFiles();
		for(File file : files){
			if (file.isDirectory()){
				continue;
			}
			result.add(file.getName());
		}
		return result;
	}

	public static List<String> getFullFileNamesFromDir(String path){
		List<String> result = new ArrayList<String>();
		File f = new File(path);
		File[] files = f.listFiles();
		for(File file : files){
			if (file.isDirectory()){
				continue;
			}
			result.add(path + file.getName());
		}
		return result;
	}


	public static String getShortName(String longName){
		longName = longName.trim();
		if (longName.endsWith("\\")){
			longName = longName.substring(0, longName.length() - 1); 
		}
		String result = longName;
		int lastSleshIndex = longName.lastIndexOf("\\");
		if (lastSleshIndex < 0){
			return result;
		}
		result = longName.substring(lastSleshIndex + 1);
		return result;
	}
	
	private String getFileNameWithoutExt(String shortFName){
		int lastPointPos  = shortFName.lastIndexOf(".");
		String fnameWithoutEx = shortFName.substring(0, lastPointPos);
		return fnameWithoutEx;
	}	
	
	public static String getFileNameWitrhoutExtension(String fName){
		int lastPointIndex = fName.lastIndexOf(".");
		String fileName = fName.substring(0, lastPointIndex);
		return fileName;
	}
	
	public static String createNameWithVersion(String fname, int version){
		String fnameWithoutExt = fname.substring(0, fname.lastIndexOf("."));
		String ext = fname.substring(fname.lastIndexOf(".") + 1);
		String result = fnameWithoutExt + "_" + version + "." + ext;
		return result;
	}

////////////////////////////////////////////////////////////////////////////
	
	public static void addcr(XWPFRun run, int count){
		for (int i = 0; i < count; i++){
			run.addCarriageReturn();
		}		
	}
	
	public static void header0(XWPFDocument document, String text){
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun paragrapRun = paragraph.createRun();
        paragrapRun.setBold(true);
        paragrapRun.setFontSize(14);
        paragrapRun.setText(text);
        paragrapRun.addCarriageReturn();        
	}
	
	public static void header1(XWPFDocument document, String text){
	    XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun paragrapRun = paragraph.createRun();
        paragrapRun.setBold(true);
        paragrapRun.setText(text);
	}

	public static void plain(XWPFDocument document, String text){
		plainCursiv(document,false, text);
	}
	
	public static void plainCursiv(XWPFDocument document, boolean isItalic, String text){
	    XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun paragrapRun = paragraph.createRun();
        if (isItalic){
        	paragrapRun.setItalic(true);
        }
        paragraph.setIndentationFirstLine(10);
        paragrapRun.setText(text);
	}


	public static void addPageBreak(XWPFDocument document){
	    XWPFParagraph paragraph = document.createParagraph();
        XWPFRun paragrapRun = paragraph.createRun();
	    paragrapRun.addBreak(BreakType.PAGE);
	}    
	
	public static String getCheckListNum(String checkListFileName){
		int lastSleshIndex = checkListFileName.lastIndexOf("\\");
		int delimIndex = checkListFileName.indexOf("_");
		return checkListFileName.substring(lastSleshIndex+1, delimIndex);
	}


	public static int getAmmountOfIterationForContract(String contractNum, String gsPath) throws IOException{
		System.out.println(contractNum);
		AnketasAdd3 anketasAdd3 = new AnketasAdd3();
		GsAdd gsAdd = anketasAdd3.getGSByNum(contractNum, gsPath);
		return gsAdd.getGkDates().size();
	}

	
}
