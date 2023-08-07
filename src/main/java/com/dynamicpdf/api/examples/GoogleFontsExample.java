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
import com.dynamicpdf.api.util.PrettyPrintUtility;

public class GoogleFontsExample {

    public static void Run(String apiKey, String basePath)
    {
        Pdf pdf = new Pdf();
        pdf.setApiKey(apiKey);
       PageInput pageInput = pdf.addPage(1008, 612);
        PageNumberingElement pageNumberingElement = 
            new PageNumberingElement("Test", ElementPlacement.TOPRIGHT);
        pageNumberingElement.setColor(RgbColor.getRed());
        pageNumberingElement.setFont(Font.google("Borel", false, false));
        pageNumberingElement.setFontSize(42);
        pageInput.getElements().add(pageNumberingElement);
 
        String formattedInstructions = PrettyPrintUtility.prettyPrintJSON(pdf.getInstructionsJson());
        System.out.println("instructions: " + formattedInstructions);
        
        PdfResponse pdfResponse = pdf.process();
        
        
        
        try {
			FileUtils.writeByteArrayToFile(new File(basePath + "java-pdf-page-example-output.pdf"), pdfResponse.getContent());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
	public static void main(String[] args) {
		GoogleFontsExample.Run("DP.---API key---",
				"C:/temp/dynamicpdf-api-usersguide-examples/");
	}

}
