package com.dynamicpdf.api.examples;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import com.dynamicpdf.api.util.PrettyPrintUtility;

import com.dynamicpdf.api.Outline;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfInput;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfResponse;

public class OutlineTutorialExample {
	
	public static void AddOutlinesExistingPdf(String key, String basePath) {
		
		Pdf pdf = new Pdf();
		pdf.setAuthor("John Doe");
		pdf.setTitle("Existing Pdf Example");

		pdf.setApiKey(key);
		
		PdfResource resource = new PdfResource(basePath + "/AllPageElements.pdf");
		PdfInput input = pdf.addPdf(resource);
		input.setId("AllPageElements");
		pdf.getInputs().add(input);

		PdfResource resource1 = new PdfResource(basePath + "/outline-existing.pdf");
		PdfInput input1 = pdf.addPdf(resource1);
		input1.setId("outlineDoc1");
		pdf.getInputs().add(input1);

		Outline rootOutline = pdf.getOutlines().add("Imported Outline");
		rootOutline.setExpanded(true);

		rootOutline.getChildren().addPdfOutlines(input);
		rootOutline.getChildren().addPdfOutlines(input1);
		
		 PdfResponse response = pdf.process();

		  if (response.getIsSuccessful()==true) {
			    try {
			      FileUtils.writeByteArrayToFile(new File(basePath + "/java-dlex-output.pdf"), 
			    		  (byte[])response.getContent());
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
			  } else {
			      System.out.println(PrettyPrintUtility.prettyPrintJSON(response.getErrorJson()));
			    }
	}
	
	public static void main(String[] args) {
		OutlineTutorialExample.AddOutlinesExistingPdf(args[0], args[1]);
	}

}
