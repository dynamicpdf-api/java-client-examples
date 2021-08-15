package com.dynamicpdf.api.examples;

import com.dynamicpdf.api.PdfInfo;
import com.dynamicpdf.api.PdfInfoResponse;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.util.PrettyPrintUtility;

public class PdfInfoExample {
	

	public static void PdfExampleOne(String key, String basePath) {
		 PdfResource resource = new PdfResource(basePath + "/fw4.pdf");
         PdfInfo pdfInfo = new PdfInfo(resource);
         pdfInfo.setApiKey(key);
         pdfInfo.setBaseUrl(CloudApiExamples.BASE_URL);
         PdfInfoResponse response = pdfInfo.process();
         System.out.println(PrettyPrintUtility.prettyPrintJSON(response.getJsonContent()));
	} 
}
