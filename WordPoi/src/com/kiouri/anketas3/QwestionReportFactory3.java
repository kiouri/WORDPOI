package com.kiouri.anketas3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;














//import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet; 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import com.kiouri.anketas2.Qwestion;
import com.kiouri.anketas2.QwestionReport;
import com.kiouri.anketas2.RandomReportsGenerator;
import com.kiouri.anketas2.Utils;
import com.kiouri.anketas2.WbFO;

public class QwestionReportFactory3 implements Serializable{

	private final static int COL_DOCNUM 		= 1;
	private final static int COL_GK 			= 2;
	
	private final static int COL_NUMBER_PP 		= 0;
	private final static int COL_DOCUMEN 		= 1;
	private final static int COL_DOCREQ 		= 2;
	private final static int COL_QWEST 			= 3;
	private final static int COL_ANSWER_KIND 	= 4;
	private final static int COL_ESSENTIALITY 	= 5;
	private final static int COL_ANSWER 		= 6;
	
	private int totalVersions = 5;
	
	public QwestionReport pase(String fileUrl) throws Exception {
		
		QwestionReport qwestionReport = new QwestionReport(); 
		
		boolean isLineBad = false;
		
		FileInputStream file = new FileInputStream(new File(fileUrl));
		// Get the workbook instance for XLS file
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		// Get first sheet from the workbook
		HSSFSheet sheet = workbook.getSheetAt(0);
		// Get iterator to all the rows in current sheet
		Iterator<Row> rowIterator = sheet.iterator();
		int rowNum = 0;
		
		
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			if (rowNum == 0) {
				Iterator<Cell> cellIterator = row.cellIterator();
				try {
				    cellIterator.next();
				} catch (Exception e){
					continue;
				}
				Cell cell = cellIterator.next();
				qwestionReport.setDocnum("" + getStringValFromCell(cell));
				rowNum++;
			}
			
			isLineBad = false;
			
			Qwestion qwestion = new Qwestion();
			String rowText = "";
			qwestion.setNumPP(rowNum);
			rowNum++;
			// Get iterator to all cells of current row
			Iterator<Cell> cellIterator = row.cellIterator();
			int j = 0;
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					rowText = cell.getStringCellValue();
				} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					rowText = "" + new Double(cell.getNumericCellValue()).intValue();
				}
				
				switch (j) {
					case COL_NUMBER_PP: 
						try{
						Integer.parseInt(rowText);
						}catch(Exception e){
							isLineBad = true;
							break;
						}
						break;
					case COL_DOCUMEN: 
						qwestion.setDocument(rowText);
						break;
					case COL_DOCREQ:
						qwestion.setDocRequest(rowText);
						break;
					case COL_QWEST: 
						qwestion.setQwest(rowText);
						break;
					case COL_ANSWER_KIND:
						placeAnswers(qwestion, parseAnswers(rowText));
						break;
					case COL_ESSENTIALITY:
						qwestion.setEssentiality(rowText);
						break;
					case COL_ANSWER:
					    qwestion.setAnswer(rowText);
					    break;
				}
				if(isLineBad){
					rowNum--;
					break;
				}
				j++;				
			}
			if(!isLineBad){
				qwestionReport.addQwesion(qwestion);
			}
		}		
		return qwestionReport;

	}
	
	private String getStringValFromCell(Cell cell){
		try{
			Double dvalue = cell.getNumericCellValue();
			return "" + dvalue.intValue();
		}catch(Exception e){
			String svalue = cell.getStringCellValue();
			Double dvalue = Double.parseDouble(svalue);
			return "" + dvalue.intValue();
		}
	}
	
	private void placeAnswers(Qwestion qwestion, String[] answers){
		if (answers[0].startsWith("Перечислить")){
			qwestion.addAnswerVariant("Перечислить");
			return;
		}
		for(String answer : answers){
			qwestion.addAnswerVariant(answer);
		}		
	}
	
	private String[] parseAnswers(String answers){
		answers.replaceAll("\r", "\n");
		answers.replaceAll("\n\n", "\n");
		return answers.split("\n");
	}
	
	
	public void serializeQwestionReport(QwestionReport qwestionReport, String path, String name) throws IOException{
		 if (path == null){
			 path = "";
		 }
		 path = path.trim();
		 if (path.length() > 0 && !path.endsWith("\\")){
			 path = path + ("\\");
		 }
		 if (name == null || name.trim().length() == 0){
			 name = qwestionReport.getDocnum();
		 }
		 name = name.trim();
	     OutputStream file = new FileOutputStream(path + name);
	     OutputStream buffer = new BufferedOutputStream(file);
	     ObjectOutput output = new ObjectOutputStream(buffer);
	     output.writeObject(qwestionReport);
	     output.close();		
	}
	
	public QwestionReport deSerializeObject(String path) throws IOException, ClassNotFoundException{
		path = path.trim();
		InputStream file = new FileInputStream(path);
	    InputStream buffer = new BufferedInputStream(file);
	    ObjectInput input = new ObjectInputStream (buffer);
	    QwestionReport qwestionReport = (QwestionReport)input.readObject();
	    input.close();
	    return qwestionReport;
	}
	
	public SortedSet<String> getUnicAnswerVariants(QwestionReport qwestReport){
		List<Qwestion> qwestions = qwestReport.getQwestions();
		SortedSet<String> result = new  TreeSet<String>();
		for(Qwestion qwestion : qwestions){
			List<String> answerVariants = qwestion.getAnswerVariants();
			for(String answervariant : answerVariants){
				result.add(answervariant);
			}
		}
		return result;
	}
	
	////////////////////////////////////////////// create excel from report ////////////////////////////////////
	
	public WbFO createWorkBook(String fileName) throws IOException{
		Workbook wb = new HSSFWorkbook();
	    FileOutputStream fileOut = new FileOutputStream(fileName);
	    WbFO wbFO = new  WbFO(wb, fileOut);
	    return wbFO;
	}
	
	public Sheet createSheet(Workbook wb, String name){
		Sheet sheet = wb.createSheet(name);
		return sheet;
	}
	
	private Row createRow(Sheet sheet, int rowNum){
		Row row = sheet.createRow(rowNum);
		return row;
	}
	
	private void writeCell(Row row, int cellNymber, String text){
		Cell cell = row.createCell(cellNymber);
	    cell.setCellValue(text);
	}
	
	private void writeCell(Row row, int cellNymber, int num){
		Cell cell = row.createCell(cellNymber);
	    cell.setCellValue(num);
	}
	
	private void writeQwestion(Sheet sheet, Row row, Qwestion qwestion, String generatedAnswer){
		int cellNumber = 1;
		writeCell(row, cellNumber++, qwestion.getNumPP());
		writeCell(row, cellNumber++, qwestion.getDocument());		
		writeCell(row, cellNumber++, qwestion.getDocRequest());
		writeCell(row, cellNumber++, qwestion.getQwest());
		writeCell(row, cellNumber++, qwestion.getAnswerWariantsAsString());
		writeCell(row, cellNumber++, qwestion.getEssentiality());
		writeCell(row, cellNumber++, generatedAnswer);
	}
	
	public void writeQwestionReportVersion(Sheet sheet, String num, String dognum,List<Qwestion> qwestions, List<String> answersList){
		int rowNum  = 0;
		Row row = createRow(sheet, rowNum++);
		row = createRow(sheet, rowNum++);
		writeCell(row, 0, "Номер"); writeCell(row, 1, num); writeCell(row, 2, dognum);
		row = createRow(sheet, rowNum++);
		// table header
		writeCell(row, 1, "Номер"); 
		writeCell(row, 2, "Рассматриваемый документ");
		writeCell(row, 3, "Документ требований"); 
		writeCell(row, 4, "Вопрос");
		writeCell(row, 5, "Ответ"); 
		writeCell(row, 6, "Существенность");
		writeCell(row, 7, "Ответ");
		
		int i = 0;
		for (Qwestion qwestion : qwestions){
			writeQwestion(sheet, createRow(sheet, rowNum++), qwestion, answersList.get(i));
			i++;
		}
	}
	
	public void generateAnketasForDir(String inPath, String outPath, int totalVersions ) throws Exception{
		this.totalVersions = totalVersions;
		List<String> fileNames = Utils.getFileNamesFromDir(inPath);
		for (String fileName : fileNames){
			System.out.println(fileName);
			generateVersions(outPath, inPath + fileName);
		}
	}
	
	public void generateAnketasForDir3(String inPath, String outPath) throws Exception{
		List<String> fileNames = Utils.getFileNamesFromDir(inPath);
		for (String fileName : fileNames){
			this.totalVersions = Utils.getAmmountOfIterationForContract(Utils.getCheckListNum(fileName), AnketasAdd3.gsPath) - 1;			
			System.out.println(fileName);
			generateVersions(outPath, inPath + fileName);
		}
	}
	

	public void generateVersions(String outPath, String originAnketaName ) throws Exception{ 
		QwestionReportFactory3 qwestionReportFactory = new QwestionReportFactory3();
		QwestionReport qwestionReport = qwestionReportFactory.pase(originAnketaName);
//		RandomReportsGenerator randomReportsGenerator = new RandomReportsGenerator(qwestionReport, 5);
		RandomReportsGenerator randomReportsGenerator = new RandomReportsGenerator(qwestionReport, this.totalVersions);		
		List<List<String>> results = randomReportsGenerator.prepareAnswers2(qwestionReport);
//		for (int i = 0; i < 5; i++) {
		for (int i = 0; i < this.totalVersions; i++) {
			System.out.println("Processing " + originAnketaName + " v." + (i+1));
			WbFO wbfo = createWorkBook(getDocName(outPath,  Utils.getShortName(originAnketaName), i+1));
			Sheet sheet = createSheet(wbfo.getWb(), "Версия_" + (i+1));
			writeQwestionReportVersion(sheet, qwestionReport.getDocnum(), qwestionReport.getGk(), qwestionReport.getQwestions(), getAnsversForVersion(i, results));
		    this.formate(sheet, 8);
			wbfo.getWb().write(wbfo.getFileOut());
			wbfo.getFileOut().close();
		}
		
	}
		
		
	private String getDocName(String path, String docName, int version){
		if (path == null || path.trim().length() == 0){
			path = "";
		} else {
			path = path.trim();
			if (!path.endsWith("\\")){
				path = path + "\\";
		    }
		}
		int lastPointIndex = docName.lastIndexOf(".");
		String fileName = docName.substring(0, lastPointIndex);
		String extension  = docName.substring(lastPointIndex + 1);
		fileName = path + fileName + "_" + version + "." + extension;
		return fileName;
	}
	
	private List<String> getAnsversForVersion(int ver, List<List<String>> results){
		List<String> result = new ArrayList<String>();
		for (List<String> ans : results){
			result.add(ans.get(ver));
		}
		return result;
	}
	
	private void formate(Sheet sheet, int maxNum){
		for (int i = 0; i < maxNum; i++){
			sheet.autoSizeColumn(i);
		}
	}
		
///////////////////////////////////
	public static void main(String[] args){
		List<String> filenames = Utils.getFileNamesFromDir("c:\\hhh\\");
	}
}

///////////////////////////////////////////////////////////////////
