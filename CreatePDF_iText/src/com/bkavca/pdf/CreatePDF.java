package com.bkavca.pdf;

import java.io.File;
import java.io.IOException;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

public class CreatePDF {
	
	private static final String FILE_PATH = "E:\\iText_PDF.pdf";
	
	private static final String ROOT_FONTS_PATH = System.getProperty("user.dir") +  File.separator + "src" + File.separator + "fonts";
	private static final String ROOT_BACKGROUND_PATH = System.getProperty("user.dir") +  File.separator + "src" + File.separator + "background";
	private static final String TIMES_REGULAR_FONT_PATH = ROOT_FONTS_PATH + File.separator + "timesNewRomanRegular.ttf";
	private static final String TIMES_BOLD_FONT_PATH = ROOT_FONTS_PATH + File.separator + "timesNewRomanBold.ttf";
	private static final String TAHOMA_REGULAR_FONT_PATH = ROOT_FONTS_PATH + File.separator + "tahomaRegular.ttf";
	private static final String TAHOMA_BOLD_FONT_PATH = ROOT_FONTS_PATH + File.separator + "tahomaBold.ttf";
	private static final String TAHOMA_FAUX_ITALIC_FONT_PATH = ROOT_FONTS_PATH + File.separator + "tahomaItalic.ttf";
	private static final String BACKGROUND_IMAGE_PATH = ROOT_BACKGROUND_PATH + File.separator + "background.jpg";
	
	private class Label {
		public static final String NUMBER = "Số: ";
		public static final String COMMON_NAME = "Thuộc tổ chức, doanh nghiệp: ";
		public static final String INFO = "Sử dụng chữ ký số với thông tin như sau: ";
		public static final String SERIAL = "Serial Number";
		public static final String SUBJECT_DN = "Subject DN";
		public static final String ISSUER_DN = "Issuer DN";
		public static final String PAIR_OF_KEYS_LENGTH = "Độ dài cặp khóa";
		public static final String PROPERTIES = "Thuộc tính";
		public static final String START_END_DATE = "Hạn dùng";
		public static final String PUBLISH_DATE = "Hà nội, ngày ";
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		try {
			PdfFont timesRegular = PdfFontFactory.createFont(TIMES_REGULAR_FONT_PATH, PdfEncodings.IDENTITY_H);
			PdfFont timesBold = PdfFontFactory.createFont(TIMES_BOLD_FONT_PATH, PdfEncodings.IDENTITY_H);
			PdfFont tahomaRegular = PdfFontFactory.createFont(TAHOMA_REGULAR_FONT_PATH, PdfEncodings.IDENTITY_H);
			PdfFont tahomaBold = PdfFontFactory.createFont(TAHOMA_BOLD_FONT_PATH, PdfEncodings.IDENTITY_H);
			//PdfFont tahomaItalic = PdfFontFactory.createFont(TAHOMA_FAUX_ITALIC_FONT_PATH, PdfEncodings.IDENTITY_H);

			PageSize pageSize = new PageSize(PageSize.A4).clone();
			
	        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(FILE_PATH));
	        Document doc = new Document(pdfDoc, pageSize);
	        
	        PdfCanvas canvas = new PdfCanvas(pdfDoc.addNewPage());
	        canvas.addImage(ImageDataFactory.create(BACKGROUND_IMAGE_PATH), pageSize, false);
	        doc.add(new Paragraph());
	        
	        Paragraph p1 = new Paragraph("BIÊN LAI GIAO DỊCH");
	        p1.setMargin(0);
	        p1.setFontSize(25);
	        p1.setFontColor(Color.RED);
	        p1.setFont(tahomaBold);
	        
		    new Canvas(new PdfCanvas(pdfDoc.getFirstPage()), pdfDoc, new Rectangle(150, 400, 300, 200)).add(p1);
		    doc.close();
		    System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
