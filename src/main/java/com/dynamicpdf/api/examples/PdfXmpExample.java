package com.dynamicpdf.api.examples;

import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfXmp;
import com.dynamicpdf.api.XmlResponse;
import com.dynamicpdf.api.util.PrettyPrintUtility;

public class PdfXmpExample {
	
    public static void PdfXmpExampleOne(String apiKey, String basePath)
    {
        PdfResource resource = new PdfResource(basePath + "/fw4.pdf");
        PdfXmp pdfXmp = new PdfXmp(resource);
        pdfXmp.setApiKey(apiKey);
        pdfXmp.setBaseUrl(CloudApiExamples.BASE_URL);
        XmlResponse response = pdfXmp.process();
        System.out.println(PrettyPrintUtility.prettyPrintJSON(response.getContent()));
    }

}
