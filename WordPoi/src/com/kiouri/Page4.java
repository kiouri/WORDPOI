package com.kiouri;

import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Page4 {

	Params params;
	
	public void createPage4(XWPFDocument document, Params params, boolean isDocumentation){
		this.params = params;
		
		Utils.header0(document, "3 ���������� ������������� ����������� ���������� � ������������ ���������");
		Utils.header1(document, "3.1 ���������� �����������");

		if (params.getSignificantRemarks().size() == 1 & params.getNonSignificantRemarks().size() == 1 & 
			params.getSignificantRemarks().get(0).trim().equalsIgnoreCase("��������� ��������� �����������.") &
			params.getNonSignificantRemarks().get(0).trim().equalsIgnoreCase("������ ��������� �����������.")) {
			Utils.plainCursiv(document,true,"���������� ����������� ������� � ����� ������������� �����������");
		} else if(params.getSignificantRemarks().size() == 0 & params.getNonSignificantRemarks().size() > 0 ) {
			Utils.plainCursiv(document,true,"���������� ����������� ������� �������� ������������� �����������, ���������� � ����������: ");
		} else {
			Utils.plainCursiv(document,true,"���������� ����������� ������� �� ������������� �����������, ���������� � ����������: ");
		}
		
		for (String nonValidoc : params.getNonValidDocs()){
			Utils.plain(document, nonValidoc);
		}
		
		if (!isDocumentation) {
			Utils.header1(document, "3.2 ����������� ������");
			if (params.getSignificantDataRemarks().size() > 0) {
				Utils.plainCursiv(
						document,
						true,
						"����������� ������ ������� �� ������������� �����������, ���������� � ��������:");
			} else if (params.getSignificantDataRemarks().size() == 0
					& params.getNonSignificantDataRemarks().size() > 0) {
				Utils.plainCursiv(
						document,
						true,
						"����������� ������ ������� �������� ������������� �����������, ���������� � ��������:");
			} else if (params.getSignificantDataRemarks().size() == 0
					& params.getNonSignificantDataRemarks().size() == 0) {
				Utils.plainCursiv(document, true,
						"����������� ������ ������� ������������� �����������, ���������� � ��������:");
			}
			Utils.plainCursiv(document, true, "���������� � ����������� ������");
		}
		Utils.addPageBreak(document);
	}	
}
