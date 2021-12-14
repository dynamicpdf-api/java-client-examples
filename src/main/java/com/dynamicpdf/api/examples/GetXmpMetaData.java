package com.dynamicpdf.api.examples;

import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfXmp;
import com.dynamicpdf.api.XmlResponse;

public class GetXmpMetaData {

	public static void main(String[] args) {
		GetXmpMetaData.Run("DP.7vATWolKJ4xdaefbf/pTgSW7uGWofsZAKctZ1J/hzV9yTrzDvmDI1lwT",
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