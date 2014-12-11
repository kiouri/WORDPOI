package com.kiouri.anketas2;

import java.util.List;

public class GsAdd {
	
	private String systemName;
	private String destination;
	private String perpuse;
	private String gkNum;
	private String contractDate;
	private List<String> gkDates;	
	
	public GsAdd(){}
	
	public GsAdd(String destination, String perpuse){
		this.destination = destination;
		this.perpuse = perpuse;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getPerpuse() {
		return perpuse;
	}

	public void setPerpuse(String perpuse) {
		this.perpuse = perpuse;
	}

	@Override
	public String toString() {		
		String result =  "destination:\t" + destination + "\n" + 
			   "perpuse:\t" + perpuse + "\n" + 
			   "gkDates:\n";
		for (String dateStr :gkDates){
			result = result + "\t"+dateStr + "\n"; 
		}
		return result;
	}

	public String getGkNum() {
		return gkNum;
	}

	public void setGkNum(String gkNum) {
		this.gkNum = gkNum;
	}

	public List<String> getGkDates() {
		return gkDates;
	}

	public void setGkDates(List<String> gkDates) {
		this.gkDates = gkDates;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getContractDate() {
		return contractDate;
	}

	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}

	
	
}
