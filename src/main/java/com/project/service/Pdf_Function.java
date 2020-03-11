package com.project.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.RGBColor;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.project.model.AdminBean;
import com.project.model.MedicineBean;
import com.project.service.AdminDao;
import com.project.service.MedicineDao;
@Service
public class Pdf_Function {
	


	@Autowired
	MedicineDao mb;

	public void pdf(String type) {

	// System.out.println(ad.findAdmin("kishor@gmail.com"));
	System.out.println("pdf_generation:" + type);
	Document document = new Document();
	List<MedicineBean> list = null;
	list = mb.findAll();
	int n = list.size();

	if (type.equals("stock"))
	try {

	PdfWriter writer = PdfWriter.getInstance(document,
	new FileOutputStream("C:\\Users\\841266\\Desktop\\pdf\\pharmastock.pdf"));
	document.open();
	Paragraph preface = new Paragraph();
	Font violetFont = FontFactory.getFont(FontFactory.COURIER, 25, Font.BOLD, new CMYKColor(75, 99, 0, 47));
	Font bold = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.BOLD);
	preface.add(new Paragraph("\t"));
	preface.add(new Paragraph("\t          \t\t\t\t\t\t\t\t\t\tSTOCKREPORT", violetFont));
	preface.add(new Paragraph("\n"));

	document.add(preface);

	PdfPTable table = new PdfPTable(3); // 3 columns.
	table.setWidthPercentage(100); // Width 100%
	table.setSpacingBefore(10f); // Space before table
	table.setSpacingAfter(10f); // Space after table

	// Set Column widths
	float[] columnWidths = { 1f, 1f, 1f };
	table.setWidths(columnWidths);

	PdfPCell cell1 = new PdfPCell(new Paragraph("NAME", bold));

	cell1.setPaddingLeft(10);
	cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

	PdfPCell cell2 = new PdfPCell(new Paragraph("BRAND", bold));

	cell2.setPaddingLeft(10);
	cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

	PdfPCell cell3 = new PdfPCell(new Paragraph("STOCK", bold));

	cell3.setPaddingLeft(10);
	cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

	// To avoid having the cell border and the content overlap, if you are having
	// thick cell borders
	// cell1.setUserBorderPadding(true);
	// cell2.setUserBorderPadding(true);
	// cell3.setUserBorderPadding(true);

	table.addCell(cell1);
	table.addCell(cell2);
	table.addCell(cell3);

	for (int i = 0; i < n; i++) {
	cell1 = new PdfPCell(new Paragraph(list.get(i).getName()));

	cell1.setPaddingLeft(10);
	cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

	cell2 = new PdfPCell(new Paragraph(list.get(i).getBrand()));

	cell2.setPaddingLeft(10);
	cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

	cell3 = new PdfPCell(new Paragraph(list.get(i).getStock().toString()));

	cell3.setPaddingLeft(10);
	cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

	// To avoid having the cell border and the content overlap, if you are having
	// thick cell borders
	// cell1.setUserBorderPadding(true);
	// cell2.setUserBorderPadding(true);
	// cell3.setUserBorderPadding(true);

	table.addCell(cell1);
	table.addCell(cell2);
	table.addCell(cell3);
	}

	document.add(table);

	document.close();
	writer.close();

	} catch (DocumentException e) {
	e.printStackTrace();
	} catch (FileNotFoundException e) {
	e.printStackTrace();
	}

	else if (type.equals("brand"))
	{
	try {

	PdfWriter writer = PdfWriter.getInstance(document,
	new FileOutputStream("C:\\Users\\841266\\Desktop\\pdf\\pharmabrand.pdf"));
	document.open();
	Paragraph preface = new Paragraph();
	Font violetFont = FontFactory.getFont(FontFactory.COURIER, 25, Font.BOLD, new CMYKColor(75, 99, 0, 47));
	Font bold = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.BOLD);
	preface.add(new Paragraph("\t"));
	preface.add(new Paragraph("\t          \t\t\t\t\t\t\t\t\t\tBRANDREPORT", violetFont));
	preface.add(new Paragraph("\n"));

	document.add(preface);

	PdfPTable table = new PdfPTable(3); // 3 columns.
	table.setWidthPercentage(100); // Width 100%
	table.setSpacingBefore(20f); // Space before table
	table.setSpacingAfter(20f); // Space after table

	// Set Column widths
	float[] columnWidths = { 2f, 2f, 2f };
	table.setWidths(columnWidths);

	PdfPCell cell1 = new PdfPCell(new Paragraph("BRAND", bold));

	cell1.setPaddingLeft(10);
	cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

	PdfPCell cell2 = new PdfPCell(new Paragraph("NAME", bold));

	cell2.setPaddingLeft(10);
	cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

	PdfPCell cell3 = new PdfPCell(new Paragraph("TYPE", bold));

	cell3.setPaddingLeft(10);
	cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

	// To avoid having the cell border and the content overlap, if you are having
	// thick cell borders
	// cell1.setUserBorderPadding(true);
	// cell2.setUserBorderPadding(true);
	// cell3.setUserBorderPadding(true);

	table.addCell(cell1);
	table.addCell(cell2);
	table.addCell(cell3);

	for (int i = 0; i < n; i++) {
	cell1 = new PdfPCell(new Paragraph(list.get(i).getBrand()));

	cell1.setPaddingLeft(10);
	cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

	cell2 = new PdfPCell(new Paragraph(list.get(i).getName()));

	cell2.setPaddingLeft(10);
	cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

	cell3 = new PdfPCell(new Paragraph(list.get(i).getType()));

	cell3.setPaddingLeft(10);
	cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

	// To avoid having the cell border and the content overlap, if you are having
	// thick cell borders
	// cell1.setUserBorderPadding(true);
	// cell2.setUserBorderPadding(true);
	// cell3.setUserBorderPadding(true);

	table.addCell(cell1);
	table.addCell(cell2);
	table.addCell(cell3);
	}

	document.add(table);

	document.close();
	writer.close();

	} catch (DocumentException e) {
	e.printStackTrace();
	} catch (FileNotFoundException e) {
	e.printStackTrace();
	}

	}


	else if (type.equals("disease"))
	{
	try {

	PdfWriter writer = PdfWriter.getInstance(document,
	new FileOutputStream("C:\\Users\\841266\\Desktop\\pdf\\pharmadisease.pdf"));
	document.open();
	Paragraph preface = new Paragraph();
	Font violetFont = FontFactory.getFont(FontFactory.COURIER, 25, Font.BOLD, new CMYKColor(75, 99, 0, 47));
	Font bold = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.BOLD);
	preface.add(new Paragraph("\t"));
	preface.add(new Paragraph("\t          \t\t\t\t\t\t\t\t\t\tDISEASEREPORT", violetFont));
	preface.add(new Paragraph("\n"));

	document.add(preface);

	PdfPTable table = new PdfPTable(3); // 3 columns.
	table.setWidthPercentage(100); // Width 100%
	table.setSpacingBefore(20f); // Space before table
	table.setSpacingAfter(20f); // Space after table

	// Set Column widths
	float[] columnWidths = { 2f, 2f, 2f };
	table.setWidths(columnWidths);

	PdfPCell cell1 = new PdfPCell(new Paragraph("DISEASE", bold));

	cell1.setPaddingLeft(10);
	cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

	PdfPCell cell2 = new PdfPCell(new Paragraph("BRAND", bold));

	cell2.setPaddingLeft(10);
	cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

	PdfPCell cell3 = new PdfPCell(new Paragraph("NAME", bold));

	cell3.setPaddingLeft(10);
	cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

	// To avoid having the cell border and the content overlap, if you are having
	// thick cell borders
	// cell1.setUserBorderPadding(true);
	// cell2.setUserBorderPadding(true);
	// cell3.setUserBorderPadding(true);

	table.addCell(cell1);
	table.addCell(cell2);
	table.addCell(cell3);

	for (int i = 0; i < n; i++) {
	cell1 = new PdfPCell(new Paragraph(list.get(i).getDisease()));

	cell1.setPaddingLeft(10);
	cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

	cell2 = new PdfPCell(new Paragraph(list.get(i).getBrand()));

	cell2.setPaddingLeft(10);
	cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

	cell3 = new PdfPCell(new Paragraph(list.get(i).getName()));

	cell3.setPaddingLeft(10);
	cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

	// To avoid having the cell border and the content overlap, if you are having
	// thick cell borders
	// cell1.setUserBorderPadding(true);
	// cell2.setUserBorderPadding(true);
	// cell3.setUserBorderPadding(true);

	table.addCell(cell1);
	table.addCell(cell2);
	table.addCell(cell3);
	}

	document.add(table);

	document.close();
	writer.close();

	} catch (DocumentException e) {
	e.printStackTrace();
	} catch (FileNotFoundException e) {
	e.printStackTrace();
	}

	}



	else if (type.equals("sales"))
	{
	try {

	PdfWriter writer = PdfWriter.getInstance(document,
	new FileOutputStream("C:\\Users\\841266\\Desktop\\pdf\\pharmasales.pdf"));
	document.open();
	Paragraph preface = new Paragraph();
	Font violetFont = FontFactory.getFont(FontFactory.COURIER, 25, Font.BOLD, new CMYKColor(75, 99, 0, 47));
	Font bold = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.BOLD);
	preface.add(new Paragraph("\t"));
	preface.add(new Paragraph("\t          \t\t\t\t\t\t\t\t\t\tSALESEREPORT", violetFont));
	preface.add(new Paragraph("\n"));

	document.add(preface);

	PdfPTable table = new PdfPTable(3); // 3 columns.
	table.setWidthPercentage(100); // Width 100%
	table.setSpacingBefore(20f); // Space before table
	table.setSpacingAfter(20f); // Space after table

	// Set Column widths
	float[] columnWidths = { 2f, 2f, 2f };
	table.setWidths(columnWidths);

	PdfPCell cell1 = new PdfPCell(new Paragraph("BRAND", bold));

	cell1.setPaddingLeft(10);
	cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

	PdfPCell cell2 = new PdfPCell(new Paragraph("NAME", bold));

	cell2.setPaddingLeft(10);
	cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

	PdfPCell cell3 = new PdfPCell(new Paragraph("SALES", bold));

	cell3.setPaddingLeft(10);
	cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

	// To avoid having the cell border and the content overlap, if you are having
	// thick cell borders
	// cell1.setUserBorderPadding(true);
	// cell2.setUserBorderPadding(true);
	// cell3.setUserBorderPadding(true);

	table.addCell(cell1);
	table.addCell(cell2);
	table.addCell(cell3);

	for (int i = 0; i < n; i++) {
	cell1 = new PdfPCell(new Paragraph(list.get(i).getBrand()));

	cell1.setPaddingLeft(10);
	cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

	cell2 = new PdfPCell(new Paragraph(list.get(i).getName()));

	cell2.setPaddingLeft(10);
	cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

	cell3 = new PdfPCell(new Paragraph(list.get(i).getSales().toString()));

	cell3.setPaddingLeft(10);
	cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

	// To avoid having the cell border and the content overlap, if you are having
	// thick cell borders
	// cell1.setUserBorderPadding(true);
	// cell2.setUserBorderPadding(true);
	// cell3.setUserBorderPadding(true);

	table.addCell(cell1);
	table.addCell(cell2);
	table.addCell(cell3);
	}

	document.add(table);

	document.close();
	writer.close();

	} catch (DocumentException e) {
	e.printStackTrace();
	} catch (FileNotFoundException e) {
	e.printStackTrace();
	}

	}


	else
	{
	try {

	PdfWriter writer = PdfWriter.getInstance(document,
	new FileOutputStream("C:\\Users\\841266\\Desktop\\pdf\\pharmaexpirydate.pdf"));
	document.open();
	Paragraph preface = new Paragraph();
	Font violetFont = FontFactory.getFont(FontFactory.COURIER, 25, Font.BOLD, new CMYKColor(75, 99, 0, 47));
	Font bold = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.BOLD);
	preface.add(new Paragraph("\t"));
	preface.add(new Paragraph("\t          \t\t\t\t\t\t\t\t\t\tEXPIRYDATEREPORT", violetFont));
	preface.add(new Paragraph("\n"));

	document.add(preface);

	PdfPTable table = new PdfPTable(3); // 3 columns.
	table.setWidthPercentage(100); // Width 100%
	table.setSpacingBefore(20f); // Space before table
	table.setSpacingAfter(20f); // Space after table

	// Set Column widths
	float[] columnWidths = { 2f, 2f, 2f };
	table.setWidths(columnWidths);

	PdfPCell cell1 = new PdfPCell(new Paragraph("BRAND", bold));

	cell1.setPaddingLeft(10);
	cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

	PdfPCell cell2 = new PdfPCell(new Paragraph("NAME", bold));

	cell2.setPaddingLeft(10);
	cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

	PdfPCell cell3 = new PdfPCell(new Paragraph("EXPIRYDATE", bold));

	cell3.setPaddingLeft(10);
	cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

	// To avoid having the cell border and the content overlap, if you are having
	// thick cell borders
	// cell1.setUserBorderPadding(true);
	// cell2.setUserBorderPadding(true);
	// cell3.setUserBorderPadding(true);

	table.addCell(cell1);
	table.addCell(cell2);
	table.addCell(cell3);

	for (int i = 0; i < n; i++) {
	cell1 = new PdfPCell(new Paragraph(list.get(i).getBrand()));

	cell1.setPaddingLeft(10);
	cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

	cell2 = new PdfPCell(new Paragraph(list.get(i).getName()));

	cell2.setPaddingLeft(10);
	cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

	cell3 = new PdfPCell(new Paragraph(list.get(i).getExpiryDate().toString()));

	cell3.setPaddingLeft(10);
	cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

	// To avoid having the cell border and the content overlap, if you are having
	// thick cell borders
	// cell1.setUserBorderPadding(true);
	// cell2.setUserBorderPadding(true);
	// cell3.setUserBorderPadding(true);

	table.addCell(cell1);
	table.addCell(cell2);
	table.addCell(cell3);
	}

	document.add(table);

	document.close();
	writer.close();

	} catch (DocumentException e) {
	e.printStackTrace();
	} catch (FileNotFoundException e) {
	e.printStackTrace();
	}

	}


	}

	}

	

