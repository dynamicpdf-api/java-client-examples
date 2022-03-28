package com.dynamicpdf.api.examples;

import com.dynamicpdf.api.PdfInfo;
import com.dynamicpdf.api.PdfInfoResponse;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.util.PrettyPrintUtility;

public class GetPdfInfo {
	
	// https://cloud.dynamicpdf.com/docs/tutorials/cloud-api/pdf-info/tutorial-pdf-info
	
	public static void main(String[] args) {
		GetPdfInfo.Run("DP---API KEY---",
				"C:/temp/dynamicpdf-api-samples/get-pdf-info/");

	}

	public static void Run(String apiKey, String basePath) {
		 PdfResource resource = new PdfResource(basePath + "fw4.pdf");
         PdfInfo pdfInfo = new PdfInfo(resource);
         pdfInfo.setApiKey(apiKey);
         PdfInfoResponse response = pdfInfo.process();
         if(response.getIsSuccessful()) {
        	 System.out.println(PrettyPrintUtility.prettyPrintJSON(response.getJsonContent()));
         } else {
        	 System.out.println(response.getErrorJson());
         }
	} 
}
