package com.kiouri;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Page8 {

	Params params;

	public void createPage8(XWPFDocument document, Params params) {
		this.params = params;
		Utils.header0(
				document,
				"7 	������ ������������, ��������������, ����������� �������������, ���������� � ���������� �������");
		// Utils.plain(document,
		// "�� �������������� ������������, ��������� ������ ������ �� �������������� ���������.");
		if (params.getSignificantRemarks().size() == 1
				& params.getNonSignificantRemarks().size() == 1
				& params.getSignificantRemarks().get(0).trim()
						.equalsIgnoreCase("��������� ��������� �����������.")
				& params.getNonSignificantRemarks().get(0).trim()
						.equalsIgnoreCase("������ ��������� �����������.")) {

			Utils.plain(
					document,
					"������������, �������������� � ����������� �������������� ������� ������������� ����������� ���������.");
		} else {
			Utils.plain(
					document,
					"������������, �������������� � ����������� �������������� ������� �� ������������� ����������� ��������� � ����� ���������, ����������� � �.4. ����� ���������� ��������� ��������� ���������� ���������� �������.");
		}
		Utils.addPageBreak(document);
	}

}
