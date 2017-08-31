package com.bkav.bkavcoreca.pdf;


import java.io.File;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;

public class InsertImage {
    public static final String DEST = "/home/thangntc/Desktop/createPDF/center_text.pdf";
    public static final String IMAGE = 
    		"./WebContent/res/imgs/bkavca.gif";
 
    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new InsertImage().manipulatePdf(DEST);
        
        System.out.println(System.getProperty("user.dir"));

    }
 
    @SuppressWarnings("unused")
	protected void manipulatePdf(String dest) throws Exception {
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        // Note that it is not necessary to create new PageSize object,
        // but for testing reasons (connected to parallelization) we call constructor here
        Document doc = new Document(pdfDoc, new PageSize(PageSize.A4).rotate());
        Image img = new Image(ImageDataFactory.create(IMAGE));
//        img.scaleToFit(770, 523);
        float offsetX = (770 - img.getImageScaledWidth()) / 2;
        float offsetY = (523 - img.getImageScaledHeight()) / 2;
//        img.setFixedPosition(36 + offsetX, 36 + offsetY);
        img.setFixedPosition(10, 400);
        doc.add(img);
        doc.close();
    }
}
