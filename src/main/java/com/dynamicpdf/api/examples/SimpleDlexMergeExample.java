package com.dynamicpdf.api.examples;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.LayoutDataResource;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfResponse;

public class SimpleDlexMergeExample {

	public static void main(String[] args) {
		Pdf pdf = new Pdf();
        pdf.setApiKey(args[0]);
        LayoutDataResource layoutDataResource = new LayoutDataResource(args[1] + "/SimpleReportData.json");
        pdf.addDlex("samples/shared/dlex/SimpleReportWithCoverPage.dlex", layoutDataResource);
        
        PdfResource pdfResource = new PdfResource(args[1] + "/DocumentA100.pdf");
        pdf.addPdf(pdfResource);
        
        PdfResponse response = pdf.process();

        if (!response.getIsSuccessful())
        {
        	System.out.println(response.getErrorJson());
        } else {
        	try {
        		FileUtils.writeByteArrayToFile(new File(args[1] + "/simple-report-data.pdf"), response.getContent());
        		} catch (IOException e) {
        			e.printStackTrace();
        			}
        	
        }
	}   
}