package com.bkavca.pdf;

import java.io.File;
import java.util.Date;

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
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.renderer.DrawContext;
import com.itextpdf.layout.renderer.ParagraphRenderer;

public class CreatePDF {
	
	private static final String FILE_PATH = "E:\\iText_PDF.pdf";
	
	private static final String ROOT_FONTS_PATH = System.getProperty("user.dir") +  File.separator + "src" + File.separator + "fonts";
	private static final String ROOT_BACKGROUND_PATH = System.getProperty("user.dir") +  File.separator + "src" + File.separator + "background";
	private static final String TIMES_REGULAR_FONT_PATH = ROOT_FONTS_PATH + File.separator + "timesNewRomanRegular.ttf";
	private static final String TIMES_BOLD_FONT_PATH = ROOT_FONTS_PATH + File.separator + "timesNewRomanBold.ttf";
	private static final String TAHOMA_REGULAR_FONT_PATH = ROOT_FONTS_PATH + File.separator + "tahomaRegular.ttf";
	private static final String TAHOMA_BOLD_FONT_PATH = ROOT_FONTS_PATH + File.separator + "tahomaBold.ttf";
	private static final String BACKGROUND_IMAGE_PATH = ROOT_BACKGROUND_PATH + File.separator + "background.jpg";
	
	/**
	 * Khoảng cách so với viền trái của tài liệu
	 */
	private static final float LABEL_MARGIN_LEFT = 60;
	
	/**
	 * Khoảng cách so với viền trái của tài liệu
	 */
	private static final float VALUE_FIELD_MARGIN_LEFT = 180;
	
	/**
	 * Khoảng cách so với viền trái của tài liệu
	 */
	private static final float VALUE_FIELD_WIDTH = 350;
	
	/**
	 * Kích thước chữ cho các label
	 */
	private static final int LABEL_FONT_SIZE = 12;
	
	/**
	 * Góc bo tròn của hình chữ nhật
	 */
	private static final int ROUNDED_CORNERS = 5;
	
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

	public static void main(String[] args) {
		
		Data data = new Data();
		data.setNumberId(1789);
		data.setCommonName("CÔNG TY CỔ PHẦN KỸ THUẬT CÔNG NGHIỆP Á CHÂU");
		data.setCertSerial("54034e89d5dd6a6afab24d656a3a93bd");

		SubjectDN sjDn = new SubjectDN();
		sjDn.setcN("CÔNG TY CỔ PHẦN KỸ THUẬT CÔNG NGHIỆP Á CHÂU");
		sjDn.setuId("MST: 0102073536");
		sjDn.setC("VN");
		sjDn.setL("Ba Đình");
		sjDn.setS("Hà Nội");
		
		data.setSubjectDn(sjDn);
		
		IssuerDN isDn = new IssuerDN();
		isDn.setcN("BkavCA");
		isDn.setO("Bkav Corporation");
		isDn.setL("Hanoi");
		isDn.setC("VN");
		
		data.setIssuerDn(isDn);
		data.setPairOfKeysLength(1024);
		data.setProperties("Documents Signing");
		data.setStartEndDate(new Date(), new Date());
		data.setPublishDate(new Date());
		
		boolean created = createPDF(FILE_PATH, data);
		System.out.println("Create file " + (created ? "done" : "failed!"));
	}
	
	@SuppressWarnings("resource")
	public static boolean createPDF(String destPath, Data data) {
		try {
			PdfFont timesRegular = PdfFontFactory.createFont(TIMES_REGULAR_FONT_PATH, PdfEncodings.IDENTITY_H);
			PdfFont timesBold = PdfFontFactory.createFont(TIMES_BOLD_FONT_PATH, PdfEncodings.IDENTITY_H);
			PdfFont tahomaRegular = PdfFontFactory.createFont(TAHOMA_REGULAR_FONT_PATH, PdfEncodings.IDENTITY_H);
			PdfFont tahomaBold = PdfFontFactory.createFont(TAHOMA_BOLD_FONT_PATH, PdfEncodings.IDENTITY_H);

			PageSize pageSize = new PageSize(PageSize.A4).clone();
			
			PdfWriter pdfWriter = new PdfWriter(destPath);
	        PdfDocument pdfDoc = new PdfDocument(pdfWriter);
	        Document doc = new Document(pdfDoc, pageSize);
	        
	        PdfCanvas canvas = new PdfCanvas(pdfDoc.addNewPage());
	        canvas.addImage(ImageDataFactory.create(BACKGROUND_IMAGE_PATH), pageSize, false);
	        
	        // Number document
	        _appendSingleText(Label.NUMBER + data.getNumberId(), 0, LABEL_FONT_SIZE, Color.DARK_GRAY, tahomaRegular, new Rectangle(405, 525, 300, 200), pdfDoc);
	        
		    // Common name
	        _appendSingleText(Label.COMMON_NAME, 0, LABEL_FONT_SIZE, Color.DARK_GRAY, tahomaRegular, new Rectangle(LABEL_MARGIN_LEFT, 400, 300, 200), pdfDoc);
	        
	        Paragraph paragraph = new Paragraph(data.getCommonName());
			paragraph.setMargin(0);
			paragraph.setFontSize(14);
			paragraph.setFontColor(Color.BLACK);
			paragraph.setFont(timesBold);
			paragraph.setTextAlignment(TextAlignment.CENTER);
			new Canvas(new PdfCanvas(pdfDoc.getFirstPage()), pdfDoc, new Rectangle(60, 380, 480, 200)).add(paragraph);
		    
		    // Head info
	        _appendSingleText(Label.INFO, 0, LABEL_FONT_SIZE, Color.DARK_GRAY, tahomaRegular, new Rectangle(LABEL_MARGIN_LEFT, 350, 300, 200), pdfDoc);
		    
		    // Serial number
	        _appendSingleText(Label.SERIAL, 0, LABEL_FONT_SIZE, Color.BLACK, tahomaBold, new Rectangle(LABEL_MARGIN_LEFT, 320, 300, 200), pdfDoc);
	        
		    Paragraph pCertSerialValue = new Paragraph(data.getCertSerial());
		    pCertSerialValue.setFont(timesBold);
		    pCertSerialValue.setHeight(20);
		    _appendTextWithRoundedBorder(pCertSerialValue, new Rectangle(VALUE_FIELD_MARGIN_LEFT, 320, 360, 200), pdfDoc);
	        
		    // SubjectDN
	        _appendSingleText(Label.SUBJECT_DN, 0, LABEL_FONT_SIZE, Color.BLACK, tahomaBold, new Rectangle(LABEL_MARGIN_LEFT, 240, 300, 200), pdfDoc);
	        
		    Paragraph pSubjectDnValue = new Paragraph("");
		    SubjectDN subjectDn = data.getSubjectDn();
		    if (subjectDn != null) {
		    	if (subjectDn.getcN() != null)
		    		pSubjectDnValue.add("CN = " + subjectDn.getcN() + "\n");
		    	if (subjectDn.getuId() != null)
		    		pSubjectDnValue.add("UID = " + subjectDn.getuId() + "\n");
		    	if (subjectDn.getL() != null)
		    		pSubjectDnValue.add("L = " + subjectDn.getL() + "\n");
		    	if (subjectDn.getS() != null)
		    		pSubjectDnValue.add("S = " + subjectDn.getS() + "\n");
		    	if (subjectDn.getC() != null)
		    		pSubjectDnValue.add("C = " + subjectDn.getC());
		    }
		    
		    pSubjectDnValue.setHeight(110);
		    pSubjectDnValue.setFont(timesRegular);
		    _appendTextWithRoundedBorder(pSubjectDnValue, new Rectangle(VALUE_FIELD_MARGIN_LEFT, 290, 360, 200), pdfDoc);
	        
		    // IssuerDN
	        _appendSingleText(Label.ISSUER_DN, 0, LABEL_FONT_SIZE, Color.BLACK, tahomaBold, new Rectangle(LABEL_MARGIN_LEFT, 140, 300, 200), pdfDoc);
		    
	        Paragraph pIssuerDnValue = new Paragraph();
	        IssuerDN isserDn = data.getIssuerDn();
		    if (isserDn != null) {
		    	if (isserDn.getcN() != null)
		    		pIssuerDnValue.add("CN = " + isserDn.getcN() + "\n");
		    	if (isserDn.getO() != null)
		    		pIssuerDnValue.add("O = " + isserDn.getO() + "\n");
		    	if (isserDn.getL() != null)
		    		pIssuerDnValue.add("L = " + isserDn.getL() + "\n");
		    	if (isserDn.getC() != null)
		    		pIssuerDnValue.add("C = " + isserDn.getC());
		    }
		    
		    pIssuerDnValue.setFont(timesRegular);
		    pIssuerDnValue.setHeight(75);
		    _appendTextWithRoundedBorder(pIssuerDnValue, new Rectangle(VALUE_FIELD_MARGIN_LEFT, 170, 360, 200), pdfDoc);
	        
		    // Pair of keys length
	        _appendSingleText(Label.PAIR_OF_KEYS_LENGTH, 0, LABEL_FONT_SIZE, Color.BLACK, tahomaBold, new Rectangle(LABEL_MARGIN_LEFT, 80, 300, 200), pdfDoc);
		    
	        Paragraph pPairOfKeysLengthValue = new Paragraph(data.getPairOfKeysLength());
		    pPairOfKeysLengthValue.setFont(timesRegular);
		    pPairOfKeysLengthValue.setHeight(20);
		    _appendTextWithRoundedBorder(pPairOfKeysLengthValue, new Rectangle(VALUE_FIELD_MARGIN_LEFT, 85, 360, 200), pdfDoc);
	        
		    // Properties
	        _appendSingleText(Label.PROPERTIES, 0, LABEL_FONT_SIZE, Color.BLACK, tahomaBold, new Rectangle(LABEL_MARGIN_LEFT, 50, 300, 200), pdfDoc);
		    
	        Paragraph pPropertiesValue = new Paragraph(data.getProperties());
		    pPropertiesValue.setFont(timesRegular);
		    pPropertiesValue.setHeight(20);
		    _appendTextWithRoundedBorder(pPropertiesValue, new Rectangle(VALUE_FIELD_MARGIN_LEFT, 55, 360, 200), pdfDoc);
	        
		    // Start - end date
	        _appendSingleText(Label.START_END_DATE, 0, LABEL_FONT_SIZE, Color.BLACK, tahomaBold, new Rectangle(LABEL_MARGIN_LEFT, 20, 300, 200), pdfDoc);
		    
	        Paragraph pStartEndDateValue = new Paragraph(data.getStartEndDate());
		    pStartEndDateValue.setFont(timesRegular);
		    pStartEndDateValue.setHeight(20);
		    _appendTextWithRoundedBorder(pStartEndDateValue, new Rectangle(VALUE_FIELD_MARGIN_LEFT, 25, 360, 200), pdfDoc);
	        
		    // Publish date
	        //_appendSingleText(Label.PUBLISH_DATE, 0, LABEL_FONT_SIZE, Color.BLACK, tahomaRegular, new Rectangle(380, -20, 300, 200), pdfDoc);
	        Paragraph pPublishDate = new Paragraph(Label.PUBLISH_DATE + data.getPublishDate());
			pPublishDate.setMargin(0);
			pPublishDate.setFontSize(LABEL_FONT_SIZE);
			pPublishDate.setFontColor(Color.DARK_GRAY);
			pPublishDate.setFont(tahomaRegular);
			pPublishDate.setItalic();
			
			new Canvas(new PdfCanvas(pdfDoc.getFirstPage()), pdfDoc, new Rectangle(380, -20, 300, 200)).add(pPublishDate);
		    
	        pdfDoc.close();
		    doc.close();
		    
		    return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	@SuppressWarnings("resource")
	private static void _appendSingleText(String content, int margin, int fontSize, 
			Color color, PdfFont font, Rectangle rectangle, PdfDocument pdfDoc) {
		Paragraph paragraph = new Paragraph(content);
		paragraph.setMargin(margin);
		paragraph.setFontSize(fontSize);
		paragraph.setFontColor(color);
		paragraph.setFont(font);
		
		new Canvas(new PdfCanvas(pdfDoc.getFirstPage()), pdfDoc, rectangle).add(paragraph);
	}
	
	@SuppressWarnings("resource")
	private static void _appendTextWithRoundedBorder(Paragraph pg, Rectangle rectangle, PdfDocument pdfDoc) {
		pg.setPaddings(3, 10, 3, 10);
		pg.setMargin(0);
		pg.setFontSize(12);
		pg.setFontColor(Color.BLACK);
		pg.setWidth(VALUE_FIELD_WIDTH);
		pg.setNextRenderer(new BorderParagraphRenderer(pg));
		
		new Canvas(new PdfCanvas(pdfDoc.getFirstPage()), pdfDoc, rectangle).add(pg);
	}
	
	private static class BorderParagraphRenderer extends ParagraphRenderer {
        public BorderParagraphRenderer(Paragraph modelElement) {
            super(modelElement);
        }
 
        @Override
        public void drawBorder(DrawContext drawContext) {
            super.drawBorder(drawContext);
            Rectangle rect = getOccupiedAreaBBox();
            drawContext.getCanvas().roundRectangle(rect.getLeft(), rect.getBottom(), 
            		rect.getWidth(), rect.getHeight(), ROUNDED_CORNERS);
            
            drawContext.getCanvas().stroke();
        }
    }
}
