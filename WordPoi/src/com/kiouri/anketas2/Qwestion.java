package com.kiouri.anketas2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Qwestion implements Serializable{

	private int numPP;
	private String document;
	private String docRequest;
	private String qwest;
	private String upperQwest;
	private List<String> answerVariants  = new ArrayList<String>();
	private String answer;
	private String essentiality;
	private String textToAct;
	private String recommendation;
	private String def;
	private List<String> iterations = new ArrayList<String>();
	private String razdelNums;
	
	public int getNumPP() {
		return numPP;
	}
	public void setNumPP(int numPP) {
		this.numPP = numPP;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public String getDocRequest() {
		return docRequest;
	}
	public void setDocRequest(String docRequest) {
		this.docRequest = docRequest;
	}
	public String getQwest() {
		return qwest;
	}
	public void setQwest(String qwest) {
		this.qwest = qwest;
		if(qwest != null){
			this.upperQwest = qwest.toUpperCase();
		}
	}
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) throws Exception {
//		if (answer == null || answerVariants == null || !answerVariants.contains(answer)){
		if(answerVariants.get(0).equalsIgnoreCase("Перечислить")){
			this.answer = answer;
			return;
		}
		if (answer == null || answerVariants == null || !answerVariants.contains(answer.toUpperCase())){
			throw new Exception("Error: answer not in answers list - '" + qwest + " --- "+ answer + "'");
		}	
		this.answer = answer;
	}
	
	public String getEssentiality() {
		return essentiality;
	}
	public void setEssentiality(String essentiality) {
		this.essentiality = essentiality;
	}
	public String getTextToAct() {
		return textToAct;
	}
	public void setTextToAct(String textToAct) {
		this.textToAct = textToAct;
	}
	public String getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
	public String getDef() {
		return def;
	}
	public void setDef(String def) {
		this.def = def;
	}	
	
	public void addIteration(String iteration){
		if (iteration == null || iteration.trim().length() == 0){
			return;
		}
		if (iterations.contains(iteration)){
			return;
		}
		iterations.add(iteration);
	}
	
	public void addAnswerVariant(String answerVariant){
		if (answerVariant == null || answerVariant.trim().length() == 0){
			return;
		}		
		answerVariant = answerVariant.trim().toUpperCase();
		answerVariant  = answerVariant.replaceAll("  ", " ");
		if(answerVariants.contains(answerVariant)){
			return;
		} else {
			answerVariants.add(answerVariant);
		}
	}
	
	public List<String> getAnswerVariants() {
		return answerVariants;
	}
	
	public String getAnswerWariantsAsString(){
		String result = "";
		for (String answervariant : answerVariants){
			result  = result + " " + answervariant + "\n";
		}
		return result.substring(0, result.length() - 1);
	}
	
	@Override
	public boolean equals(final Object other) {
		if (this == other){
			return true;
		}	
		if (!(other instanceof Qwestion)){
			return false;
		}
		Qwestion castOther = (Qwestion) other;
		return new EqualsBuilder().append(upperQwest, castOther.upperQwest).isEquals();
	}	
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(1450207409, -1692382659)
		.append(upperQwest).toHashCode();
	}
	@Override
	public String toString() {
		return "" + numPP + "\t" + document + "\t" + docRequest + "\t" + qwest + "\t" + answerVariants + "\t" + answer + "\t" + essentiality;    
	}
	
	
	
}
