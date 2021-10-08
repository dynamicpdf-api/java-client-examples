package com.dynamicpdf.api.gettingstarted;

import com.dynamicpdf.api.PdfInfo;
import com.dynamicpdf.api.PdfInfoResponse;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.examples.CloudApiExamples;
import com.dynamicpdf.api.util.PrettyPrintUtility;

public class GettingStarted {

	static String key;
	static String basePath;
	
	
	public static void infoExample() {
		 PdfResource resource = new PdfResource(basePath + "/fw4.pdf");
         PdfInfo pdfInfo = new PdfInfo(resource);
         pdfInfo.setApiKey(key);
         pdfInfo.setBaseUrl(CloudApiExamples.BASE_URL);
         PdfInfoResponse response = pdfInfo.process();
         System.out.println(PrettyPrintUtility.prettyPrintJSON(response.getJsonContent()));
	}
	
	
	public static void main(String[] args) {
		GettingStarted.basePath = args[1];
		GettingStarted.key = args[0];
		GettingStarted.infoExample();

	}

}
