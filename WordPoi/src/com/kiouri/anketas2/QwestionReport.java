package com.kiouri.anketas2;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class QwestionReport implements Serializable {
	
	private String docnum;
	private String gk;
	
	private List<Qwestion> qwestions = new ArrayList<Qwestion>();
	
	public void addQwesion(Qwestion qwestion){
		qwestions.add(qwestion);
	}

	public List<Qwestion> getQwestions() {
		return qwestions;
	}

	public void setQwestions(List<Qwestion> qwestions) {
		this.qwestions = qwestions;
	}
	
	public void addQwest(Qwestion qwestion){
		if (!qwestions.contains(qwestion)){
			qwestions.add(qwestion);
		}	
	}
	
	public String getDocnum() {
		return docnum;
	}

	public void setDocnum(String docnum) {
		this.docnum = docnum;
	}

	public String getGk() {
		return gk;
	}

	public void setGk(String gk) {
		this.gk = gk;
	}

	@Override
	public String toString() {
		String result = docnum + "\t" + gk + "\n";
		for(Qwestion qwestion : qwestions){
			result = result + qwestion + "\n"; 
		}
			
		return result;
	}
	
	
}
