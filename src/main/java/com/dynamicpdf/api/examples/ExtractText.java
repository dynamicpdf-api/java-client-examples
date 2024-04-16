package com.dynamicpdf.api.examples;

import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfText;
import com.dynamicpdf.api.PdfTextResponse;
import com.dynamicpdf.api.util.PrettyPrintUtility;

public class ExtractText {
	
	
	public static void main(String[] args) {
		ExtractText.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/extract-text-pdf-text-endpoint/");

	}

	public static void Run(String apiKey, String basePath) {
		
        PdfResource resource = new PdfResource(basePath + "fw4.pdf");
        PdfText pdfText = new PdfText(resource);
        pdfText.setPageCount(2);
        pdfText.setStartPage(1);
        pdfText.setApiKey(apiKey);
        PdfTextResponse response = pdfText.process();
        
        if(response.getIsSuccessful()) {
        	System.out.println(PrettyPrintUtility.prettyPrintJSON(response.getJsonContent()));
        } else {
        	System.out.println(response.getErrorJson());
        }
	}
}
