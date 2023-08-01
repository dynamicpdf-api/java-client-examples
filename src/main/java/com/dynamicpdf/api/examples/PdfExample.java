package com.dynamicpdf.api.examples;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import com.dynamicpdf.api.Font;
import com.dynamicpdf.api.PageInput;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.RgbColor;
import com.dynamicpdf.api.elements.ElementPlacement;
import com.dynamicpdf.api.elements.PageNumberingElement;

public class PdfExample {

    public static void Run(String apiKey, String basePath)
    {
        Pdf pdf = new Pdf();
        pdf.setApiKey(apiKey);
        pdf.setAuthor("John Doe");
        pdf.setTitle("My Blank PDF Page");
        PageInput pageInput = pdf.addPage(1008, 612);
        PageNumberingElement pageNumberingElement = 
            new PageNumberingElement("1", ElementPlacement.TOPRIGHT);
        pageNumberingElement.setColor(RgbColor.getRed());
        pageNumberingElement.setFont(Font.getCourier());
        pageNumberingElement.setFontSize(24);
        pageInput.getElements().add(pageNumberingElement);
        PdfResponse pdfResponse = pdf.process();
        try {
			FileUtils.writeByteArrayToFile(new File(basePath + "java-pdf-page-example-output.pdf"), pdfResponse.getContent());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
	public static void main(String[] args) {
		PdfExample.Run("DP.xxx-api-key-xxx",
				"C:/temp/dynamicpdf-api-usersguide-examples/");
	}

}
