package com.bkav.bkavcoreca.pdf;


import java.io.File;
import java.io.IOException;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.element.Paragraph;

public class PositionText {
    public static final String DEST = "/home/thangntc/Desktop/createPDF/center_text.pdf";
    
    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new PositionText().manipulatePdf(DEST);
    }
    
    @SuppressWarnings("resource")
	public void manipulatePdf(String dest) throws IOException {
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        
        PdfFont f = PdfFontFactory.createFont(FontConstants.HELVETICA);
        Paragraph pz = new Paragraph("Hello World!").setFont(f).setFixedLeading(20);
        new Canvas(new PdfCanvas(pdfDoc.addNewPage()), pdfDoc, new Rectangle(0, 0, 80, 480))
                .add(pz);
        f = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD, PdfEncodings.CP1252, true);
        pz = new Paragraph("Hello World!").setFont(f).setFontSize(13);
        new Canvas(new PdfCanvas(pdfDoc.getFirstPage()), pdfDoc, new Rectangle(120, 48, 80, 580))
                .add(pz);
 
        pdfDoc.close();
    	
//    	 PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
    	 
    }
}
