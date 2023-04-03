package com.dynamicpdf.api.examples;

import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfXmp;
import com.dynamicpdf.api.XmlResponse;

public class GetXmpMetaData {
	
	// https://cloud.dynamicpdf.com/docs/tutorials/cloud-api/pdf-xmp/tutorial-pdf-xmp

	public static void main(String[] args) {
		GetXmpMetaData.Run("DP.xxx-api-key-xxx",
				"C:/temp/dynamicpdf-api-samples/get-xmp-metadata/");
	}

	public static void Run(String apiKey, String basePath) {
		PdfResource resource = new PdfResource(basePath + "/fw4.pdf");
		PdfXmp pdfXmp = new PdfXmp(resource);
		pdfXmp.setApiKey(apiKey);
		XmlResponse response = pdfXmp.process();

		if (response.getIsSuccessful()) {
			System.out.println(response.getContent());
		} else {
			System.out.println(response.getErrorJson());
		}
	}
}
