package com.kiouri;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Params {

	String systemId = "";
	String systemName = "<<Система>>";									//наименование системы 
	String contractNumber = "<<____/__-____>>";							//N гос контракта
	String contractDate = "<<__>>____________ 201 г.";					//дата гос контракта
//	String functionCustomer = "<<Функциональный заказчик>>";			//функциональный заказчик
	String functionCustomer = "";										//функциональный заказчик
	String systemDestination = "<<Назначение системы>>";  				//назначение системы
	String creationPurpose = "<<Цель создания системы>>";				//цель создания системы
	String systemClass = "<<Класс системы>>";							//класс системы
	String performerName = "<<Наименование исполнителя>>";				//наименование исполнителя
	String performerAddress = "<<Юридический адрес исполнителя>>";		//адрес исполнителя
	String analizFoundation = " отчетные документы технического проекта "; //основания для проведения анализа
	
	String mainPrinzips 		= "Основные архитектурные принципы";
	String concept 				= "Концепция целевой архитектуры";
	String typicalArchitecture 	= "Типовая архитектура приложения";
	String integrationRec 		= "Требования к интеграции";
	String dataRec = "Требования к моделям данных для IT решений";
	
	List<String> correspondsIn    = new ArrayList<String>();
	List<String> notCorrespondsIn = new ArrayList<String>();
	List<String> significantRemarks    = new ArrayList<String>();
	List<String> nonSignificantRemarks = new ArrayList<String>();
	List<String> significantRecomendations    = new ArrayList<String>();
	List<String> nonSignificantRecomendations = new ArrayList<String>();
	
	List<String> significantDataRemarks    = new ArrayList<String>();
	List<String> nonSignificantDataRemarks = new ArrayList<String>();
	List<String> significantDataRecomendations    = new ArrayList<String>();
	List<String> nonSignificantDataRecomendations = new ArrayList<String>();
	
	HashSet<String> docset = new HashSet<String>();
	
	static String[] documentation = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "37"};
	static String[] prinzips =      {"11"};
	static String[] conzept =       {"12"};
	static String[] arhpril =       {"13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	static String[] integro =       {"32","33"};
	static String[] arhdata =       {"34","35","36"};
	
	
	
	public void putDOCtype(String num){
		if (Arrays.asList(documentation).contains(num)){
			docset.add("Документы технического проекта в части описания архитектуры");
		} else if (Arrays.asList(prinzips).contains(num)){
			docset.add("Архитектурные принципы");
		} else if (Arrays.asList(conzept).contains(num)){
			docset.add("Концепция целевой архитектуры");
		} else if (Arrays.asList(arhpril).contains(num)){
			docset.add("Типовая архитектура приложения");
		}  else if (Arrays.asList(integro).contains(num)){
			docset.add("Требования к интеграции");
		}   else if (Arrays.asList(arhdata).contains(num)){
			docset.add("Требования к архитектуре данных");
		}		
	}

	public List<String> getNonValidDocs(){
		List<String> result = new ArrayList<String>();
		Iterator<String> iterator = docset.iterator();
		while (iterator.hasNext()){
			result.add(iterator.next());
		}
		return result;
	}
	
	public String getSystemId() {
		return systemId;
	}
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getContractNumber() {
		return contractNumber;
	}
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	public String getContractDate() {
		return contractDate;
	}
	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}
	public String getFunctionCustomer() {
		return functionCustomer;
	}
	public void setFunctionCustomer(String functionCustomer) {
		this.functionCustomer = functionCustomer;
	}
	public String getSystemDestination() {
		return systemDestination;
	}
	public void setSystemDestination(String systemDestination) {
		this.systemDestination = systemDestination;
	}
	public String getCreationPurpose() {
		return creationPurpose;
	}
	public void setCreationPurpose(String creationPurpose) {
		this.creationPurpose = creationPurpose;
	}
	public String getSystemClass() {
		return systemClass;
	}
	public void setSystemClass(String systemClass) {
		this.systemClass = systemClass;
	}
	public String getPerformerName() {
		return performerName;
	}
	public void setPerformerName(String performerName) {
		this.performerName = performerName;
	}
	public String getPerformerAddress() {
		return performerAddress;
	}
	public void setPerformerAddress(String performerAddress) {
		this.performerAddress = performerAddress;
	}
	public String getAnalizFoundation() {
		return analizFoundation;
	}
	public void setAnalizFoundation(String analizFoundation) {
		this.analizFoundation = analizFoundation;
	}
	
	public void addCorrespondsIn(String docName){
		if (!correspondsIn.contains(docName)){
			this.correspondsIn.add(docName);
		}	
	}
	
	public void addNotCorrespondsIn(String docName){
		if (!this.notCorrespondsIn.contains(docName)){
			this.notCorrespondsIn.add(docName);
		}	
	}
	
	public List<String> getCorrespondsIn() {	
		/////// for testing only ///////
		this.correspondsIn.add(mainPrinzips);
		this.correspondsIn.add(concept);
		this.correspondsIn.add(typicalArchitecture);
		this.correspondsIn.add(integrationRec);
		
		return correspondsIn;
	}
	public void setCorrespondsIn(List<String> correspondsIn) {
		this.correspondsIn = correspondsIn;
	}
	public List<String> getNotCcorrespondsIn() {
	/////// for testing only ///////
		this.notCorrespondsIn.add(dataRec);
		return notCorrespondsIn;
	}
	public void setNotCcorrespondsIn(List<String> notCorrespondsIn) {
		this.notCorrespondsIn = notCorrespondsIn;
	}
	
	public List<String> getSignificantRemarks() {
		return significantRemarks;
	}
	public void setSignificantRemarks(List<String> significantRemarks) {
		this.significantRemarks = significantRemarks;
	}
	public void addSignificantRemark(String remark){
		if (!significantRemarks.contains(remark)){
			significantRemarks.add(remark);
		}
	}
	
	public List<String> getNonSignificantRemarks() {
		return nonSignificantRemarks;
	}
	public void setNonSignificantRemarks(List<String> nonSignificantRemarks) {
		this.nonSignificantRemarks = nonSignificantRemarks;
	}
	public void addNonSignificantRemark(String remark){
		if (!nonSignificantRemarks.contains(remark)){
			nonSignificantRemarks.add(remark);
		}
	}
	
	public void setNonSignificantRecomendations(List<String> nonSignificantRecomendations) {
		this.nonSignificantRecomendations = nonSignificantRecomendations;
	}
	public List<String> getNonSignificantRecomendations() {
		return this.nonSignificantRecomendations;
	}

	public void addNonSignificantRecomendation(String recomendation){
		if (!nonSignificantRecomendations.contains(recomendation)){
			nonSignificantRecomendations.add(recomendation);
		}
	}


	public void setSignificantRecomendations(List<String> significantRecomendations) {
		this.significantRecomendations = significantRecomendations;
	}
	public List<String> getSignificantRecomendations() {
		return this.significantRecomendations;
	}
	
	
	public void addSignificantRecomendation(String recomendation){
		if (!significantRecomendations.contains(recomendation)){
			significantRecomendations.add(recomendation);
		}
	}

	
	////////////////////////////////////////////////////////////////////////////////////
	public List<String> getSignificantDataRemarks() {
		return significantDataRemarks;
	}

	public void setSignificantDataRemarks(List<String> significantDataRemarks) {
		this.significantDataRemarks = significantDataRemarks;
	}

	public List<String> getNonSignificantDataRemarks() {
		return nonSignificantDataRemarks;
	}

	public void setNonSignificantDataRemarks(List<String> nonSignificantDataRemarks) {
		this.nonSignificantDataRemarks = nonSignificantDataRemarks;
	}

	public List<String> getSignificantDataRecomendations() {
		return significantDataRecomendations;
	}

	public void setSignificantDataRecomendations(
			List<String> significantDataRecomendations) {
		this.significantDataRecomendations = significantDataRecomendations;
	}

	public List<String> getNonSignificantDataRecomendations() {
		return nonSignificantDataRecomendations;
	}

	public void setNonSignificantDataRecomendations(
			List<String> nonSignificantDataRecomendations) {
		this.nonSignificantDataRecomendations = nonSignificantDataRecomendations;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
}
