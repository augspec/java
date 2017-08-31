package com.bkav.bkavcoreca.pdf;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Random;

import com.bkav.bkavcoreca.filter.AuthenticationFilter;
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
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

public class BankReceiptPDF {
	
	public static final String PATH_IMAGE = AuthenticationFilter.pathProject + "res/imgs/bkavca.gif";
	
	public static final String PATH_FONT_TIMES = AuthenticationFilter.pathProject + 
			"res/fontForPDF/vuTimes.ttf";
	public static final String PATH_FONT_TIMESBOLD = AuthenticationFilter.pathProject + 
			"res/fontForPDF/vuTimesBold.ttf";
	public static final String PATH_FONT_TIMESBOLDITALIC = AuthenticationFilter.pathProject + 
			"res/fontForPDF/vuTimesBoldItalic.ttf";
	public static final String PATH_FONT_TIMEITALIC = AuthenticationFilter.pathProject + 
			"res/fontForPDF/vuTimesItalic.ttf";

	
	public static void main(String[] args) throws IOException {
		URL a = BankReceiptPDF.class.getClass().getResource("/");
		
		System.out.println(a.getPath());
        BankReceipt bankReceipt = new BankReceipt();
		bankReceipt.setAccountNumberOriginal(
				"3232DFSF5435G");
		bankReceipt.setAccountNumberBeneficiary(
				"34234GSDGSGD");
		bankReceipt.setNameBeneficiary(
				"Ngo Thien Thang");
		bankReceipt.setNameBankBeneficiary(
				"Viettin Bank");
		bankReceipt.setNameBranchBankBeneficiary(
				"Dai La");
		bankReceipt.setCostBearer(
				"Nguoi Nhan Chiu");
		bankReceipt.setNumberMoney(
				"342432 VND");
		bankReceipt.setDateTransaction(
				new Date());
		bankReceipt.setCodeOTP(
				"342423");
		bankReceipt.setDescription(
				"Thich thi chuyen");
        BankReceiptPDF.createBankReceiptPDF(bankReceipt ,"S://Ban HTCA/Temp/CodeThangNTc/CodeThangNTc/center_text.pdf");
	}
	
	
	@SuppressWarnings({ "resource", "deprecation" })
	public static boolean createBankReceiptPDF(BankReceipt bankReceipt , String dest) throws IOException {
		
	    PdfFont pdfFontTimes = PdfFontFactory.createFont(PATH_FONT_TIMES, PdfEncodings.IDENTITY_H);
	    PdfFont pdfFontTimesBold = PdfFontFactory.createFont(PATH_FONT_TIMESBOLD, PdfEncodings.IDENTITY_H);
	    PdfFont pdfFontTimesBoldItalic = PdfFontFactory.createFont(PATH_FONT_TIMESBOLDITALIC, PdfEncodings.IDENTITY_H);
	    PdfFont pdfFontTimesItalic = PdfFontFactory.createFont(PATH_FONT_TIMEITALIC, PdfEncodings.IDENTITY_H);
		
		try {
			PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
	        Document doc = new Document(pdfDoc, new PageSize(PageSize.A4).rotate());

	        /**
	         * Level 1
	         */
	        //Image
	        Image img = new Image(ImageDataFactory.create(PATH_IMAGE));
	        img.scaleToFit(140, 110);
	        img.setFixedPosition(70, 470);
	        doc.add(img);
	                
	        Paragraph p1 = new Paragraph("BIÊN LAI GIAO DỊCH").setMargin(0).setFontColor(Color.RED)
	              .setFontSize(25).setFont(pdfFontTimesBold);
	        new Canvas(new PdfCanvas(pdfDoc.getFirstPage()), pdfDoc, new Rectangle(300, 320, 300, 200))
	        .add(p1);
	        
	        Random random = new Random();
	        Paragraph p11 = new Paragraph("Số: " + 100000 + (int)(random.nextFloat() * 899900))
	        		.setMargin(0).setFontColor(Color.RED)
		             .setFontSize(17).setFont(pdfFontTimesItalic);
	        new Canvas(new PdfCanvas(pdfDoc.getFirstPage()), pdfDoc, new Rectangle(640, 350, 300, 200))
	        .add(p11);
	        
	        Paragraph p12 = new Paragraph("MDGD001-2/10/2010").setMargin(0).setFontColor(Color.RED)
		              .setFontSize(17).setFont(pdfFontTimesItalic);
	        new Canvas(new PdfCanvas(pdfDoc.getFirstPage()), pdfDoc, new Rectangle(640, 370, 300, 200))
        	.add(p12);
	        
	        /**
	         * Level 2
	         */
	        
	        Table table = new Table(2).setMarginLeft(140);
	        
	        Cell c211 = new Cell().setBorder(Border.NO_BORDER).setFont(pdfFontTimesBoldItalic)
	        		.add("Tài khoản chuyển tiền:").setFontSize(17).setFontColor(Color.RED);
	        Cell c212 = new Cell().setBorder(Border.NO_BORDER).setFont(pdfFontTimes).setMarginLeft(50)
	        		.add(bankReceipt.getAccountNumberOriginal()).setFontSize(17).setFontColor(Color.BLUE);

	        Cell c221 = new Cell().setBorder(Border.NO_BORDER).setFont(pdfFontTimesBoldItalic)
	        		.add("Tài khoản thụ hưởng:").setFontSize(17).setFontColor(Color.RED);
	        Cell c222 = new Cell().setBorder(Border.NO_BORDER).setFont(pdfFontTimes).setMarginLeft(50)
	        		.add(bankReceipt.getAccountNumberBeneficiary()).setFontSize(17).setFontColor(Color.BLUE);
	        
	        Cell c231 = new Cell().setBorder(Border.NO_BORDER).setFont(pdfFontTimesBoldItalic)
	        		.add("Tên người thụ hưởng:").setFontSize(17).setFontColor(Color.RED);
	        Cell c232 = new Cell().setBorder(Border.NO_BORDER).setFont(pdfFontTimes).setMarginLeft(50)
	        		.add(bankReceipt.getNameBeneficiary()).setFontSize(17).setFontColor(Color.BLUE);
	        
	        Cell c241 = new Cell().setBorder(Border.NO_BORDER).setFont(pdfFontTimesBoldItalic)
	        		.add("Ngân hàng thụ hưởng").setFontSize(17).setFontColor(Color.RED);
	        Cell c242 = new Cell().setBorder(Border.NO_BORDER).setFont(pdfFontTimes).setMarginLeft(50)
	        		.add(bankReceipt.getNameBankBeneficiary()).setFontSize(17).setFontColor(Color.BLUE);
	        
	        Cell c251 = new Cell().setBorder(Border.NO_BORDER).setFont(pdfFontTimesBoldItalic)
	        		.add("Chi nhánh ngân hàng thụ hưởng:").setFontSize(17).setFontColor(Color.RED);
	        Cell c252 = new Cell().setBorder(Border.NO_BORDER).setFont(pdfFontTimes).setMarginLeft(50)
	        		.add(bankReceipt.getNameBranchBankBeneficiary()).setFontSize(17).setFontColor(Color.BLUE);
	        
	        Cell c261 = new Cell().setBorder(Border.NO_BORDER).setFont(pdfFontTimesBoldItalic)
	        		.add("Số tiền thụ hưởng:").setFontSize(17).setFontColor(Color.RED);
	        Cell c262 = new Cell().setBorder(Border.NO_BORDER).setFont(pdfFontTimes).setMarginLeft(50)
	        		.add(bankReceipt.getNumberMoney()).setFontSize(17).setFontColor(Color.BLUE);
	        
	        Cell c271 = new Cell().setBorder(Border.NO_BORDER).setFont(pdfFontTimesBoldItalic)
	        		.add("Người chịu phí:").setFontSize(17).setFontColor(Color.RED);
	        Cell c272 = new Cell().setBorder(Border.NO_BORDER).setFont(pdfFontTimes).setMarginLeft(50)
	        		.add(bankReceipt.getCostBearer()).setFontSize(17).setFontColor(Color.BLUE);
	        
	        Cell c281 = new Cell().setBorder(Border.NO_BORDER).setFont(pdfFontTimesBoldItalic)
	        		.add("Nội dung:").setFontSize(17).setFontColor(Color.RED);
	        Cell c282 = new Cell().setBorder(Border.NO_BORDER).setFont(pdfFontTimes).setMarginLeft(50)
	        		.add(bankReceipt.getDescription()).setFontSize(17).setFontColor(Color.BLUE);
	        
//	        Cell c291 = new Cell().setBorder(Border.NO_BORDER).setFont(pdfFontTimesBoldItalic)
//	        		.add("Mã OTP:").setFontSize(17).setFontColor(Color.RED);
//	        Cell c292 = new Cell().setBorder(Border.NO_BORDER).setFont(pdfFontTimes).setMarginLeft(50)
//	        		.add(bankReceipt.getCodeOTP()).setFontSize(17).setFontColor(Color.BLUE);
	        
	        Cell c2101 = new Cell().setBorder(Border.NO_BORDER).setFont(pdfFontTimesBoldItalic)
	        		.add("Thời gian giao dịch:").setFontSize(17).setFontColor(Color.RED);
	        Cell c2102 = new Cell().setBorder(Border.NO_BORDER).setFont(pdfFontTimes).setMarginLeft(50)
	        		.add("" + bankReceipt.getDateTransaction()).setFontSize(17).setFontColor(Color.BLUE);
	        

	        table.addCell(c211);
	        table.addCell(c212);
	        table.addCell(c221);
	        table.addCell(c222);
	        table.addCell(c231);
	        table.addCell(c232);
	        table.addCell(c241);
	        table.addCell(c242);
	        table.addCell(c251);
	        table.addCell(c252);
	        table.addCell(c261);
	        table.addCell(c262);
	        table.addCell(c271);
	        table.addCell(c272);
	        table.addCell(c281);
	        table.addCell(c282);
//	        table.addCell(c291);
//	        table.addCell(c292);
	        table.addCell(c2101);
	        table.addCell(c2102);
	        
	        new Canvas(new PdfCanvas(pdfDoc.getFirstPage()), pdfDoc, new Rectangle(0, 40, 680, 400))
	        .add(table);
	        
	        


	        
	        /**
	         * Level 3
	         */
	        
//	        Text text31 = new Text("Chá»¯ kÃ½: ").setFontSize(17);
//	        
//	        Text text32 = new Text("PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz4KPHN0b2NrVHJhbnNhY3Rpb24+PHRyYW5UeXBlPkJBTjwvdHJhblR5cGU+PHdlaWd0aD4xMDwvd2VpZ3RoPjxzdG9ja05hbWU+QUZDIDwvc3RvY2tOYW1lPjxwcmljZT40NDAwPC9wcmljZT48ZGF0ZVRyYW5zYWN0aW9uPlNhdCBKYW4gMjggMjAxNyAwODozMDo1OCBHTVQrMDcwMCAoU0UgQXNpYSBTdGFuZGFyZCBUaW1lKTwvZGF0ZVRyYW5zYWN0aW9uPjxkczpTaWduYXR1cmUgeG1sbnM6ZHM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyMiPjxkczpTaWduZWRJbmZvPjxkczpDYW5vbmljYWxpemF0aW9uTWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvVFIvMjAwMS9SRUMteG1sLWMxNG4tMjAwMTAzMTUjV2l0aENvbW1lbnRzIj48L2RzOkNhbm9uaWNhbGl6YXRpb25NZXRob2Q+PGRzOlNpZ25hdHVyZU1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyNyc2Etc2hhMSI+PC9kczpTaWduYXR1cmVNZXRob2Q+PGRzOlJlZmVyZW5jZSBVUkk9IiI+PGRzOlRyYW5zZm9ybXM+PGRzOlRyYW5zZm9ybSBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyNlbnZlbG9wZWQtc2lnbmF0dXJlIj48L2RzOlRyYW5zZm9ybT48L2RzOlRyYW5zZm9ybXM+PGRzOkRpZ2VzdE1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyNzaGExIj48L2RzOkRpZ2VzdE1ldGhvZD48ZHM6RGlnZXN0VmFsdWU+aEtDTFo5QllNSHpMa2xOMjVyaW5FM1FkOGNRPTwvZHM6RGlnZXN0VmFsdWU+PC9kczpSZWZlcmVuY2U+PC9kczpTaWduZWRJbmZvPjxkczpTaWduYXR1cmVWYWx1ZT5DRmpGRC9CcnI5MzF4S29yd2N6aGdudWJ2QnRXV3B0emVTbS81S0ZOV0UxdVpod2w1YVh4UE0ydm1EckQzTDZtaDFBb0sydDY0d29nY1lPTnRna2tUN2p1UWNydlRWSkZXYktkZERNdHYrTEFUSnJlZW83S3dabG9wSmRFNE1OVW95aGJiWFlKWUZ5NUx4eVRTRVh0aUVhbzlqdmt5ZTc3SSttd3YydUsrcm89PC9kczpTaWduYXR1cmVWYWx1ZT48ZHM6S2V5SW5mbz48ZHM6S2V5VmFsdWU+PGRzOlJTQUtleVZhbHVlPjxkczpNb2R1bHVzPmd0SmdGa1BvWCtGWVFUUVBqb3RTV1Y4a0tzMFY5dHgxMGQ0eWs4K3BYRDFkSGpQTHlRZkdJdGVsZXhUUXVQYXY3dlFrbmdKM1lPQWRiaDNCdWJ2WnNjeWdsTmdNcTZPeVdRQ0c3c2J0ZFhmQ1lwcXJrQ3IrazMrREtiYzRZblJvSnA4TWRQcnhYV29IaEE1T0MxUENjcUdvZy9zczdBZktqd2JQTlI1VXcwYz08L2RzOk1vZHVsdXM+PGRzOkV4cG9uZW50PkFRQUI8L2RzOkV4cG9uZW50PjwvZHM6UlNBS2V5VmFsdWU+PC9kczpLZXlWYWx1ZT48ZHM6WDUwOURhdGE+PGRzOlg1MDlJc3N1ZXJTZXJpYWw+PGRzOlg1MDlJc3N1ZXJOYW1lPkNOPUJrYXZDQSwgTz1Ca2F2IENvcnBvcmF0aW9uLCBMPUhhbm9pLCBDPVZOPC9kczpYNTA5SXNzdWVyTmFtZT48ZHM6WDUwOVNlcmlhbE51bWJlcj4xMTE2NzI5NDc3NzIyNjk0NjIwNjQ1MDAzNTQxNjE4NTU1MDMyODE8L2RzOlg1MDlTZXJpYWxOdW1iZXI+PC9kczpYNTA5SXNzdWVyU2VyaWFsPjxkczpYNTA5U3ViamVjdE5hbWU+Qz1WTiwgU1Q9SMOgIE7hu5lpLCBMPUPhuqd1IEdp4bqleSwgQ049QW5OViwgVUlEPUNNTkQ6MDEzNTg3MDM2PC9kczpYNTA5U3ViamVjdE5hbWU+PGRzOlg1MDlDZXJ0aWZpY2F0ZT5NSUlFQnpDQ0F1K2dBd0lCQWdJUVZBTnRhckY4SHZRV0MvNlB1Z2tic1RBTkJna3Foa2lHOXcwQkFRVUZBREJKTVFzd0NRWURWUVFHRXdKV1RqRU9NQXdHQTFVRUJ4TUZTR0Z1YjJreEdUQVhCZ05WQkFvVEVFSnJZWFlnUTI5eWNHOXlZWFJwYjI0eER6QU5CZ05WQkFNVEJrSnJZWFpEUVRBZUZ3MHhOakEzTVRrd09EVXpORGRhRncweE9UQTNNVGt3T0RVek5EZGFNR2N4SGpBY0Jnb0praWFKay9Jc1pBRUJEQTVEVFU1RU9qQXhNelU0TnpBek5qRU5NQXNHQTFVRUF3d0VRVzVPVmpFVk1CTUdBMVVFQnd3TVErRzZwM1VnUjJuaHVxVjVNUkl3RUFZRFZRUUlEQWxJdzZBZ1R1RzdtV2t4Q3pBSkJnTlZCQVlUQWxaT01JR2ZNQTBHQ1NxR1NJYjNEUUVCQVFVQUE0R05BRENCaVFLQmdRQ0MwbUFXUStoZjRWaEJOQStPaTFKWlh5UXF6UlgyM0hYUjNqS1R6NmxjUFYwZU04dkpCOFlpMTZWN0ZOQzQ5cS91OUNTZUFuZGc0QjF1SGNHNXU5bXh6S0NVMkF5cm83SlpBSWJ1eHUxMWQ4SmltcXVRS3Y2VGY0TXB0emhpZEdnbW53eDArdkZkYWdlRURrNExVOEp5b2FpRCt5enNCOHFQQnM4MUhsVERSd0lEQVFBQm80SUJUekNDQVVzd01RWUlLd1lCQlFVSEFRRUVKVEFqTUNFR0NDc0dBUVVGQnpBQmhoVm9kSFJ3T2k4dmIyTnpjQzVpYTJGMlkyRXVkbTR3SFFZRFZSME9CQllFRlBoWE1mYk02eVlBOUtlamMwVTZCR1AyRXh1T01Bd0dBMVVkRXdFQi93UUNNQUF3SHdZRFZSMGpCQmd3Rm9BVUhyQVBTSmZmME1ObnAwYUVPMWc3aUExVGxJWXdmd1lEVlIwZkJIZ3dkakIwb0NPZ0lZWWZhSFIwY0RvdkwyTnliQzVpYTJGMlkyRXVkbTR2UW10aGRrTkJMbU55YktKTnBFc3dTVEVQTUEwR0ExVUVBd3dHUW10aGRrTkJNUmt3RndZRFZRUUtEQkJDYTJGMklFTnZjbkJ2Y21GMGFXOXVNUTR3REFZRFZRUUhEQVZJWVc1dmFURUxNQWtHQTFVRUJoTUNWazR3RGdZRFZSMFBBUUgvQkFRREFnV2dNQjBHQTFVZEpRUVdNQlFHQ0NzR0FRVUZCd01CQmdnckJnRUZCUWNEQWpBWUJnTlZIUkVFRVRBUGdRMWhiblp1UUdKcllYWXVZMjl0TUEwR0NTcUdTSWIzRFFFQkJRVUFBNElCQVFCdWU2WGVxOEpXYzFxTHE1ZDhvdTRlMjRTLzdFeGJjVzk0ZFd0enY1YzlaNytQVWdyNUZsTTVOYnFPWnFzN0lXVkFyWmhoRzdHbWtRZEhxWEFSbmN6cS9aOVQ3b3NGQ3ZUenJkeWlVTjFBVXRTWnVic2ZNVjJpeWxQbWpyaGdGczRWeTEyeEFqbzRyN3NQVkJUTG1jU0dPZUQyQlAzMHlYSitudHgrdFNnNmJ1L3BzSkVpdzU3YWZQTGFyaDNrblNmMnJSbXl4TUxTOWRIakJiSjdpbjRmcldLVGF5YkhkVTBjQ2JTVWJuS08yVm5KSTV5NWp3b1FGZDd2T0VYV3JMMGlpMncrY0ZrQ0p4cUE3dXBRQUtsc25HS0xMZXZSeU52Y05nbGFjbzJPdXo1ckFOeGtiSVVUNzVXRlphOWRVZjdyaW5yM3kvMC9jYkdWTjdCZjkxN3g8L2RzOlg1MDlDZXJ0aWZpY2F0ZT48L2RzOlg1MDlEYXRhPjwvZHM6S2V5SW5mbz48L2RzOlNpZ25hdHVyZT48L3N0b2NrVHJhbnNhY3Rpb24+")
//	                .setFontColor(Color.RED)
//	                .setFont(PdfFontFactory.createFont(FontConstants.HELVETICA)).setFontSize(9);
//	        
//	        Paragraph p3 = new Paragraph()
//	        		.setMarginLeft(60);    
//	        p3.add(text31).add(text32);
//	        
//	        new Canvas(new PdfCanvas(pdfDoc.addNewPage()), pdfDoc, new Rectangle(570, 800))
//	        .add(p3);   
	        
	        doc.close();
	        
		} catch (IOException e) {
			e.printStackTrace();			
			return false;
		}
		
		return true;
	}
}
