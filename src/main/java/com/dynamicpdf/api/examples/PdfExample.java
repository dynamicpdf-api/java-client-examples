package com.dynamicpdf.api.examples;
import java.nio.file.Files;

import com.dynamicpdf.api.Font;
import com.dynamicpdf.api.PageInput;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.RgbColor;
import com.dynamicpdf.api.elements.ElementPlacement;
import com.dynamicpdf.api.elements.PageNumberingElement;

public class PdfExample {

    public static void PdfExampleOne(String apiKey, String basePath)
    {
        Pdf pdf = new Pdf();
        pdf.setApiKey(apiKey);
        pdf.setBaseUrl(basePath);
        pdf.setAuthor("John Doe");
        pdf.setTitle("My Blank PDF Page");
        PageInput pageInput = pdf.addPage(1008, 612);
        PageNumberingElement pageNumberingElement = 
            new PageNumberingElement("1", ElementPlacement.TopRight);
        pageNumberingElement.setColor(RgbColor.getRed());
        pageNumberingElement.setFont(Font.getCourier());
        pageNumberingElement.setFontSize(24);
        pageInput.getElements().add(pageNumberingElement);
        PdfResponse pdfResponse = pdf.process();
        Files.wri
        File.(basePath + "/pageExample.pdf", pdfResponse.getContent());


    }
}
