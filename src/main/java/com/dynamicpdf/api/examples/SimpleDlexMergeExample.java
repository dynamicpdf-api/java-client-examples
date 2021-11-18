package com.dynamicpdf.api.examples;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.LayoutDataResource;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfResponse;

public class SimpleDlexMergeExample {

	public static void Merge(String api, String basePath) {
		Pdf pdf = new Pdf();
        pdf.setApiKey(api);
        LayoutDataResource layoutDataResource = new LayoutDataResource(basePath + "/SimpleReportData.json");
        pdf.addDlex("samples/shared/dlex/SimpleReportWithCoverPage.dlex", layoutDataResource);
        
        PdfResource pdfResource = new PdfResource(basePath + "/DocumentA100.pdf");
        pdf.addPdf(pdfResource);
        
        PdfResponse response = pdf.process();

        if (!response.getIsSuccessful())
        {
        	System.out.println(response.getErrorJson());
        } else {
        	try {
        		FileUtils.writeByteArrayToFile(new File(basePath + "/simple-report-data.pdf"), response.getContent());
        		} catch (IOException e) {
        			e.printStackTrace();
        			}
        	
        }
	}
	
	public static void main(String[] args) {
		SimpleDlexMergeExample.Merge(args[0], args[1]);
	}   
}