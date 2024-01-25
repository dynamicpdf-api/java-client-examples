package com.dynamicpdf.api.examples;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.Font;
import com.dynamicpdf.api.PageInput;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfInput;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.RgbColor;
import com.dynamicpdf.api.elements.ElementPlacement;
import com.dynamicpdf.api.elements.PageNumberingElement;

public class SplitPdf {

	 public static void Run(String apiKey, String basePath)
	    {
		 	SplitPdf.Split(apiKey, basePath, 1, 3, "split-one.pdf");
		 	SplitPdf.Split(apiKey, basePath, 6, 2, "split-two.pdf");
	    }
	 
	 private static void Split(String apiKey, String basePath, int startPage, int pageCount, String outputFile) {
		 
	        Pdf pdf = new Pdf();
	        pdf.setApiKey(apiKey);
	       
	        PdfInput pdfInput = pdf.addPdf(new PdfResource(basePath + "pdfnumberedinput.pdf"));
			pdfInput.setStartPage(startPage);
			pdfInput.setPageCount(pageCount);
	        
        
	        PdfResponse pdfResponse = pdf.process();
	        
	        try {
				FileUtils.writeByteArrayToFile(new File(DynamicPdfCloudApiExamples.OUTPUT_PATH + "/" + outputFile), pdfResponse.getContent());
			} catch (IOException e) {
				e.printStackTrace();
			}
	 }
	 
		public static void main(String[] args) {
			SplitPdf.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/split-pdf/");
		}

}
