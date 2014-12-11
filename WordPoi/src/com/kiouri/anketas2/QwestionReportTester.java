package com.kiouri.anketas2;

public class QwestionReportTester {
	
	public static void main(String[] args){
		Qwestion qw1 = new Qwestion();
		Qwestion qw2 = new Qwestion();
		
		assert(qw1.equals(qw2));
		qw1.setQwest("aaaSSSbbb");
		assert(qw1.equals(qw2) == false);
		qw2.setQwest("aaaSSSbbb");
		assert(qw1.equals(qw2));
		qw2.setQwest("aaasssbbb");
		assert(qw1.equals(qw2));
	}

}
