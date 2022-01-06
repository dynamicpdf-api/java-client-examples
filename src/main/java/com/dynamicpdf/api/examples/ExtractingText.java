package com.dynamicpdf.api.examples;

import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfText;
import com.dynamicpdf.api.PdfTextResponse;

public class ExtractingText {
	
	// https://cloud.dynamicpdf.com/docs/tutorials/cloud-api/pdf-text/tutorial-pdf-text

	public static void main(String[] args) {
		ExtractingText.Run("DP.xxxx--api--key--xxx",
				"C:/temp/dynamicpdf-api-samples/extract-text/");

	}

	public static void Run(String apiKey, String basePath) {
		
        PdfResource resource = new PdfResource(basePath + "fw4.pdf");
        PdfText pdfText = new PdfText(resource);
        pdfText.setApiKey(apiKey);
        PdfTextResponse response = pdfText.process();
        
        if(response.getIsSuccessful()) {
        	System.out.println(response.getJsonContent());
        } else {
        	System.out.println(response.getErrorJson());
        }
	}
}
