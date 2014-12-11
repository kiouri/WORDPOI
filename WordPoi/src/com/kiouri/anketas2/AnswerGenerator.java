package com.kiouri.anketas2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AnswerGenerator {
	
	Random rd = new Random();

	List<String> fullPossibleAnswers = Arrays.asList(
//			"Не возможно оценить".toUpperCase(), "Не требуется".toUpperCase(), "Не оценивалось".toUpperCase(), "Нет".toUpperCase(), "Да".toUpperCase());
			"Нет описания".toUpperCase(), "Не требуется".toUpperCase(),  "Нет".toUpperCase(), "Да".toUpperCase());
	
	List<String> currentPossibleAnswers;
	
	private List<String> getsortedpossibleAnswersSubset(List<String> subset){
		List<String> sortedSubset = new ArrayList<String>();
		for (int i = 0; i < fullPossibleAnswers.size(); i++){
			if (subset.contains(fullPossibleAnswers.get(i))){
				sortedSubset.add(fullPossibleAnswers.get(i));
			}
		}
		return sortedSubset;
	}
	
	public void setCurrentPossibleAnswers(List<String> currentPossibleAnswers){
		for (int i = 0; i < currentPossibleAnswers.size(); i++){
			currentPossibleAnswers.set(i, currentPossibleAnswers.get(i).toUpperCase());
		}
		this.currentPossibleAnswers = getsortedpossibleAnswersSubset(currentPossibleAnswers);
	}
	
	private  int getIndexForAnswer(String answer){
		int maxNum = -1;
		for (int i = 0; i < currentPossibleAnswers.size(); i++){
			if(currentPossibleAnswers.get(i).equals(answer)){
				maxNum = i;
			}
		}
		return maxNum;
	}
	
	public void fillAnswers(List<String> currentAnswers){
		System.out.println(currentAnswers);
		boolean generated = true;
		String hardAnswer = "";
		if (currentAnswers.get(currentAnswers.size()-1).contains(";")){
			generated = false;
			hardAnswer = currentAnswers.get(currentAnswers.size()-1);
		}
		
		currentAnswers.set(currentAnswers.size() - 1, currentAnswers.get(currentAnswers.size() - 1).toUpperCase());		
		int lastIndex =  getIndexForAnswer(currentAnswers.get(currentAnswers.size()-1));
		for (int i = currentAnswers.size()-2; i>=0; i--){
			
			if (generated){
				lastIndex = getRandomBetween(0, lastIndex+1);
				currentAnswers.set(i, currentPossibleAnswers.get(lastIndex));
			} else {
				currentAnswers.set(i, hardAnswer);
			}
		}
	}
	
	public void showAnswers(List<String> currentAnswers){
		for (String ans : currentAnswers){
			System.out.print(ans + "\t\t");
		}
		System.out.println("");
	}
	
	public List<String> createAnswersList(int size){
		List<String> currentAnswers = new ArrayList<String>(size);
		for (int i = 0; i < size; i++){
			currentAnswers.add("");
		}
		return currentAnswers;
	}
	
	private int getRandomBetween(int start, int end){
		int length = end - start;
		try {
		return start +  rd.nextInt(length);
		} catch (Exception e){
			return -1;
//			throw e;
		}
	}
	
//	/////////////////////////////////////////////////////////
//	
//	public static void main(String[] args){
//		List<String> possibleAnswers = Arrays.asList("Не возможно оценить", "Нет", "Да");
//				
//		AnswerGenerator ansGen = new  AnswerGenerator();
//		ansGen.setCurrentPossibleAnswers(possibleAnswers);
//
//		for (int i = 0; i <20; i++){
//			List<String> currentAnswers = ansGen.createAnswersList(6);
//			currentAnswers.set(5, "Да");
//			ansGen.fillAnswers(currentAnswers);
//			ansGen.showAnswers(currentAnswers);
//		}
//	}
	
}
