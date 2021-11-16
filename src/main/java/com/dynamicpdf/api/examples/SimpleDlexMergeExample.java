package com.dynamicpdf.api.examples;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.LayoutDataResource;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResponse;

public class SimpleDlexMergeExample {

	public static void main(String[] args) {
		Pdf pdf = new Pdf();
        pdf.setApiKey("DP.JCR8ItHnzFelvaWUiPp4Bo27hYc+Nb2IYP0u2JPyxergTqspK1xjig4V");
        LayoutDataResource layoutDataResource = new LayoutDataResource("c:/holding/SimpleReportData.json");
        pdf.addDlex("samples/shared/dlex/SimpleReportWithCoverPage.dlex", layoutDataResource);
        PdfResponse response = pdf.process();

        if (!response.getIsSuccessful())
        {
        	System.out.println(response.getErrorJson());
        } else {
        	try {
        		FileUtils.writeByteArrayToFile(new File("c:/holding/simple-report-data.pdf"), response.getContent());
        		} catch (IOException e) {
        			e.printStackTrace();
        			}
        	
        }
	}   
}