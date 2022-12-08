package com.elmolinar.elmolinar.rentals;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.elmolinar.elmolinar.rentals.projections.RentalsWithCostumeAndClient;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class RentalsPdfGeneratorService {
    public void export(HttpServletResponse response, RentalsWithCostumeAndClient rental) throws DocumentException, IOException{
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontTitle.setSize(12);

        Paragraph paragraph = new Paragraph("CONTRATO ALQUILER DE TRAJES", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Paragraph paragraph1 = new Paragraph("EL MOLINAR \n Telf. 611624411", fontParagraph);
        paragraph1.setAlignment(Paragraph.ALIGN_RIGHT);

        Paragraph paragraph7 = new Paragraph("******************************************************************************************************");
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Paragraph paragraph2 = new Paragraph("Cliente: " + rental.getClient().getName() + "\n", fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

        Paragraph paragraph3 = new Paragraph("Traje: " + rental.getCostume().getName() + "\n", fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

        Paragraph paragraph4 = new Paragraph("Precio/Traje: " + rental.getPrice() + "€ \n" , fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

        Paragraph paragraph5 = new Paragraph("Cantidad: " + rental.getQuantity() + "\n", fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

        Paragraph paragraph6 = new Paragraph("Total: " + rental.getTotalPrice() + "€ \n", fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

        document.add(paragraph1);
        document.add(paragraph);
        document.add(paragraph7);
        document.add(paragraph2);
        document.add(paragraph3);
        document.add(paragraph4);
        document.add(paragraph5);
        document.add(paragraph6);
        document.close();
    }
}
