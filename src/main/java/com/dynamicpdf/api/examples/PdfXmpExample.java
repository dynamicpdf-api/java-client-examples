package com.dynamicpdf.api.examples;

import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfXmp;
import com.dynamicpdf.api.XmlResponse;
import com.dynamicpdf.api.util.PrettyPrintUtility;

public class PdfXmpExample {
	
    public static void Run(String apiKey, String basePath)
    {
        PdfResource resource = new PdfResource(basePath + "fw4.pdf");
        PdfXmp pdfXmp = new PdfXmp(resource);
        pdfXmp.setApiKey(apiKey);
        XmlResponse response = pdfXmp.process();
        System.out.println(PrettyPrintUtility.prettyPrintJSON(response.getContent()));
    }
    
	public static void main(String[] args) {
		PdfXmpExample.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/get-xmp-metadata-pdf-xmp-endpoint/");
	}

}
