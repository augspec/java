package com.bkav.bkavcoreca.pdf;

import java.io.File;
import java.io.IOException;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
 
public class ColoredText {

    public static final String DEST = "/home/thangntc/Desktop/createPDF/center_text.pdf";

    public static void main(String[] args) throws Exception {
    	

        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new ColoredText().manipulatePdf(DEST);
    }
 
    @SuppressWarnings("resource")
	public void manipulatePdf(String dest) throws IOException {
    	
    	String FONT1 = "./WebContent/res/fontForPDF/vuArial.ttf";
    	String FONT2 = "./WebContent/res/fontForPDF/vuTimes.ttf";
    	
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        Document doc = new Document(pdfDoc);
        
        PdfFont font1 = PdfFontFactory.createFont(FONT1, PdfEncodings.IDENTITY_H);
        PdfFont font2 = PdfFontFactory.createFont(FONT2, PdfEncodings.IDENTITY_H);
        
        
        Text redText = new Text("Đã xử lý xong, ")
                .setFontColor(Color.RED)
                .setFont(font1);
        		
        Text blueText = new Text("Đã xử lý xong. ")
                .setFontColor(Color.BLUE)
                .setFont(font2);
        Text greenText = new Text("Đã xử lý xong. ")
                .setFontColor(Color.GREEN)
                .setFont(PdfFontFactory.createFont());
 
        Paragraph p1 = new Paragraph(redText).setMargin(0);
        doc.add(p1);
        
        Paragraph p2 = new Paragraph().setMargin(0);
        p2.add(blueText);
        p2.add(greenText);
        doc.add(p2);
 
        new Canvas(new PdfCanvas(pdfDoc.getLastPage()), pdfDoc, new Rectangle(36, 600, 208, 160))
                .add(p1)
                .add(p2);
 
        doc.close();
    }
}
