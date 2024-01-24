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

public class DeletePages {

	 public static void Run(String apiKey, String basePath)
	    {
	        Pdf pdf = new Pdf();
	        pdf.setApiKey(apiKey);
	        pdf.setAuthor("John Doe");
	        pdf.setTitle("My Blank PDF Page");
	        pdf.setCreator("Test Creator");
	        pdf.setTag(false);
	       
	        PdfInput pdfInput = pdf.addPdf(new PdfResource(basePath + "pdfnumberedinput.pdf"));
			pdfInput.setStartPage(1);
			pdfInput.setPageCount(3);
	        
			
	        PdfInput pdfInput2 = pdf.addPdf(new PdfResource(basePath + "pdfnumberedinput.pdf"));
			pdfInput2.setStartPage(6);
			pdfInput2.setPageCount(2);
	        
	        PdfResponse pdfResponse = pdf.process();
	        
	        try {
				FileUtils.writeByteArrayToFile(new File(DynamicPdfCloudApiExamples.OUTPUT_PATH + "/delete-pages-output.pdf"), pdfResponse.getContent());
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	    
		public static void main(String[] args) {
			DeletePages.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/delete-pages/");
		}

}
