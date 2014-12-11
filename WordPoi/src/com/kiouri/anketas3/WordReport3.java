package com.kiouri.anketas3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.kiouri.Page1;
import com.kiouri.Page2;
import com.kiouri.Page3;
import com.kiouri.Page4;
import com.kiouri.Page5;
import com.kiouri.Page6;
import com.kiouri.Page7;
import com.kiouri.Page8;
import com.kiouri.Page9;
import com.kiouri.Params;
import com.kiouri.anketas2.GsAdd;
import com.kiouri.anketas2.QwestionReport;
import com.kiouri.anketas2.QwestionReportFactory;
import com.kiouri.anketas2.Utils;
import com.kiouri.anketas2.WPage1;
import com.kiouri.anketas2.WPage1_1;
import com.kiouri.anketas2.WPage2;
import com.kiouri.anketas2.WPage3;
import com.kiouri.anketas2.WPage4;
import com.kiouri.anketas2.WPage5;
import com.kiouri.anketas2.WPage6;
import com.kiouri.anketas2.WPage7;
import com.kiouri.anketas2.WPage8;
import com.kiouri.anketas3.AnketasAdd3;

public class WordReport3 {
	
	private QwestionReportFactory qwestionReportFactory = new QwestionReportFactory();
	private AnketasAdd3 anketasAdd3 = new AnketasAdd3();
//	private String gsPath = "c:\\hh2\\templates\\GK_List_.xls";
	private String gsPath = "c:\\hh2full\\templates\\GK_List_full.xls";
	private int version;
	private GsAdd gsAdd;
	
	public void generateReports(String anketasPath, String wordsPath) throws Exception{
//		List<String> anketaFilenames = Utils.getFullFileNamesFromDir("c:\\hhh\\out\\");
		List<String> anketaFilenames = Utils.getFullFileNamesFromDir(anketasPath);
		for(String anketaFileName : anketaFilenames){
			System.out.println(anketaFileName);
//			creataRepotByAnketa(anketaFileName, wrdOut, getVersionFromName(anketaFileName));
			creataRepotByAnketa(anketaFileName, wordsPath, getVersionFromName(anketaFileName));
		}
	}
	
	public void creataRepotByAnketa(String anketaPath, String outputPath, int version) throws Exception{
		this.version = version;
		QwestionReport qwestionReport = qwestionReportFactory.pase(anketaPath);
		gsAdd = anketasAdd3.getGSByNum(qwestionReport.getDocnum(), gsPath);
		String docNum = qwestionReport.getDocnum();
		anketasAdd3.getGSByNum(docNum, gsPath);
//		String anketaName = Utils.getShortName(anketaPath);
		WordDocumentDescriptor wordDocumentDescriptor = createWordDocument(outputPath, anketaPath);
		
//		WPage1 wpage1 = new WPage1(wordDocumentDescriptor.getDocument(),qwestionReport,  gsAdd, this.version);
		WPage1_1 wpage1 = new WPage1_1(wordDocumentDescriptor.getDocument(),qwestionReport,  gsAdd, this.version);
		WPage2 wpage2 = new WPage2(wordDocumentDescriptor.getDocument(),qwestionReport,  gsAdd, this.version);
		WPage3 wpage3 = new WPage3(wordDocumentDescriptor.getDocument(),qwestionReport,  gsAdd, this.version);
		WPage4 wpage4 = new WPage4(wordDocumentDescriptor.getDocument(),qwestionReport,  gsAdd, this.version);
		WPage5 wpage5 = new WPage5(wordDocumentDescriptor.getDocument(),qwestionReport,  gsAdd, this.version);
		WPage6 wpage6 = new WPage6(wordDocumentDescriptor.getDocument(),qwestionReport,  gsAdd, this.version);
		WPage7 wpage7 = new WPage7(wordDocumentDescriptor.getDocument(),qwestionReport,  gsAdd, this.version);
		WPage8 wpage8 = new WPage8(wordDocumentDescriptor.getDocument(),qwestionReport,  gsAdd, this.version);
		
        try {
        	wordDocumentDescriptor.getDocument().write(wordDocumentDescriptor.getOutStream());
        	wordDocumentDescriptor.getOutStream().close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

	}

    private int getVersionFromName(String excelFName){
    	String shortFName = Utils.getShortName(excelFName);
    	int subPosition = shortFName.lastIndexOf("_");
    	int pointPosition = shortFName.lastIndexOf(".");
    	String strVer = shortFName.substring(subPosition + 1, pointPosition);
    	return Integer.parseInt(strVer);
    }
		
	private WordDocumentDescriptor createWordDocument(String wordPath, String anketaFname) throws FileNotFoundException{
		wordPath = wordPath.trim();
		if(!wordPath.endsWith("\\")){
			wordPath = wordPath + "\\"; 
		}
		String anketaShortFname = Utils.getShortName(anketaFname);
		FileOutputStream outStream = new FileOutputStream(wordPath + getWordDocNameByAnketaShortName(anketaShortFname));
		XWPFDocument document = new XWPFDocument();
		return new WordDocumentDescriptor(document, outStream);
	}
	
	private String getWordDocNameByAnketaShortName(String anketaShortName){
		int lastPointPos  = anketaShortName.lastIndexOf(".");
		String fnameWithoutEx = anketaShortName.substring(0, lastPointPos);
		return fnameWithoutEx + ".docx";
	}
}

class WordDocumentDescriptor {
	
	private XWPFDocument document;
	private FileOutputStream outStream;
	
	public WordDocumentDescriptor(){}
	
	public WordDocumentDescriptor(XWPFDocument document, FileOutputStream outStream){
		this.document = document;
		this.outStream = outStream; 
	}

	public XWPFDocument getDocument() {
		return document;
	}

	public void setDocument(XWPFDocument document) {
		this.document = document;
	}

	public FileOutputStream getOutStream() {
		return outStream;
	}

	public void setOutStream(FileOutputStream outStream) {
		this.outStream = outStream;
	}
		
}
