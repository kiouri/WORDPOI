package com.kiouri.anketas2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomReportsGenerator {

	private int totalGenerated = 6;
	
	private AnswerGenerator ansGen = new  AnswerGenerator();

	
	public RandomReportsGenerator(QwestionReport qwestionReport, int totalGenerated){
		this.totalGenerated = totalGenerated; 
	}
	
	public List<List<String>> prepareAnswers2(QwestionReport qwestionReport){
		List<List<String>> result = new ArrayList<List<String>>();
		List<Qwestion> qwestions = qwestionReport.getQwestions();
		for(Qwestion qwestion : qwestions){
			List<String> possibleAnswers = qwestion.getAnswerVariants();
			ansGen.setCurrentPossibleAnswers(possibleAnswers);
			List<String> currentAnswers = ansGen.createAnswersList(totalGenerated);
			currentAnswers.set(totalGenerated - 1, qwestion.getAnswer());
System.out.println(qwestion.getQwest());
			ansGen.fillAnswers(currentAnswers);
			result.add(currentAnswers);
		}	
		return result;
	}
	
	
	public void showAnswers(List<List<String>> answers){
		for (List<String> lst : answers){
			ansGen.showAnswers(lst);
		}
	}
	
	
}
