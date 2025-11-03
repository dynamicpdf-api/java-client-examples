package com.dynamicpdf.api.examples;

import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.PdfSecurityInfoEndpoint;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfSecurityInfoResponse;
import com.dynamicpdf.api.PdfSecurityInfo;

public class PdfSecurityInfoExample {

	public static void main(String[] args) {
		PdfSecurityInfoExample.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/security-info/");
	}

	public static void Run(String key, String basePath) {
		PdfResource resource = new PdfResource(basePath + "aes256-security.pdf");
		PdfSecurityInfoEndpoint psi = new PdfSecurityInfoEndpoint(resource);
		psi.setApiKey(key);
		PdfSecurityInfoResponse resp = psi.process();
		PdfSecurityInfo info = resp.getContent();
		
		System.out.println(resp.getJsonContent());
		System.out.println("Encryption Type: " + info.getEncryptionTypeString());
	}
}
