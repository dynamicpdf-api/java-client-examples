package com.dynamicpdf.api.examples;

import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.PdfInfo;
import com.dynamicpdf.api.PdfInfoResponse;
import com.dynamicpdf.api.PdfResource;

public class GetPdfInfo {


	public static void main(String[] args) {
		GetPdfInfo.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/get-pdf-info-pdf-info-endpoint/");

	}

	public static void Run(String apiKey, String basePath) {
		PdfResource resource = new PdfResource(basePath + "fw4.pdf");
		PdfInfo pdfInfo = new PdfInfo(resource);
		pdfInfo.setApiKey(apiKey);
		PdfInfoResponse response = pdfInfo.process();
		
		if(response.getIsSuccessful()) {
			System.out.println(response.getJsonContent());
		} else {
			System.out.println(response.getErrorJson());
		}
	} 
}
