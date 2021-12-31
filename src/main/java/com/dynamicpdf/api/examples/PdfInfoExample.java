package com.dynamicpdf.api.examples;

import com.dynamicpdf.api.PdfInfo;
import com.dynamicpdf.api.PdfInfoResponse;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.util.PrettyPrintUtility;

public class PdfInfoExample {

	public static void Run(String key, String basePath) {
		PdfResource resource = new PdfResource(basePath + "DocumentA.pdf");
        PdfInfo pdfInfo = new PdfInfo(resource);
        pdfInfo.setApiKey(key);
        PdfInfoResponse response = pdfInfo.process();
        System.out.println(PrettyPrintUtility.prettyPrintJSON(response.getJsonContent()));
	} 
	
	public static void main(String[] args) {
		PdfInfoExample.Run("DP.TrJj2UBRFfrxiLYYD9xQryHXnFoSRKVPTBYH0LRpVWWnTZPOmgRO6yX6",
				"C:/temp/dynamicpdf-api-usersguide-examples/");
	}

}
