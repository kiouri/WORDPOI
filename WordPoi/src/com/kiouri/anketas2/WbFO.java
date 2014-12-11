package com.kiouri.anketas2;

import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Workbook;

public class WbFO {

	 private Workbook wb;
	 private FileOutputStream fileOut;
	 
	 public WbFO(Workbook wb, FileOutputStream fileOut){
		 this.wb = wb;
		 this.fileOut = fileOut;
	 }

	public Workbook getWb() {
		return wb;
	}

	public FileOutputStream getFileOut() {
		return fileOut;
	}
	 	 
}