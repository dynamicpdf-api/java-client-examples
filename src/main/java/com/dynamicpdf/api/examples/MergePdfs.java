package com.dynamicpdf.api.examples;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfInput;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfResponse;


public class MergePdfs {

	public static void main(String[] args) {
		MergePdfs.Run("DynamicPdfApiKey",
				"C:/temp/dynamicpdf-api-samples/");

	}

	public static void Run(String apiKey, String basePath) {

		// create new pdf instance and set api key
		Pdf pdf = new Pdf();
		pdf.setApiKey(apiKey);

		// add pdf from local file system where specify that only one page
		// from DocumentA is to be merged.

		PdfInput pdfInput = pdf.addPdf(new PdfResource(basePath + "DocumentA.pdf"));
		pdfInput.setStartPage(1);
		pdfInput.setPageCount(1);
		
		// add all of DocumentB to the PDF to be created
		
		pdf.addPdf(new PdfResource(basePath + "DocumentB.pdf"));
		
		// add DocumentC from the cloud in Resource Manager
		
		pdf.addPdf("samples/merge-pdfs-pdf-endpoint/DocumentC.pdf");
		
		// call the endpoint and return the results

		PdfResponse pdfResponse = pdf.process();

		// if the response is successful, save merged pdf to file. if error, then
		// printout JSON error

		if (pdfResponse.getIsSuccessful()) {
			try {
				FileUtils.writeByteArrayToFile(new File(basePath + "merge-pdfs-output.pdf"), 
						pdfResponse.getContent());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(pdfResponse.getErrorJson());
		}
	}
}
