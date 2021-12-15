package com.dynamicpdf.api.examples;

import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfText;
import com.dynamicpdf.api.PdfTextResponse;

public class ExtractingText {

	public static void main(String[] args) {
		ExtractingText.Run("DP.NKSoPxiwOgZoypSVYaXyEARo2cO9Kk5BRgY2ZRC0jF/KQq4pDzhfK8yO",
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
