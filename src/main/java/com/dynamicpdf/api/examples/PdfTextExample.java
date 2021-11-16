package com.dynamicpdf.api.examples;

import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfText;
import com.dynamicpdf.api.PdfTextResponse;
import com.dynamicpdf.api.util.PrettyPrintUtility;

public class PdfTextExample {

	
    public static void PdfTextExampleOne (String key, String basePath)
    {
        PdfResource resource = new PdfResource(basePath + "/fw4.pdf");
        PdfText pdfText = new PdfText(resource);
        pdfText.setApiKey(key);
        pdfText.setBaseUrl(CloudApiExamples.BASE_URL);
        PdfTextResponse response = pdfText.process();
        System.out.println(PrettyPrintUtility.prettyPrintJSON(response.getJsonContent()));
    }
    
    public static void main(String[] args) {
    	PdfTextExample.PdfTextExampleOne(args[0], args[1]);
    }
}
