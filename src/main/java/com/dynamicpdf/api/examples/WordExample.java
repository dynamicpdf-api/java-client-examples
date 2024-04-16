package com.dynamicpdf.api.examples;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.PageOrientation;
import com.dynamicpdf.api.PageSize;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.WordResource;

public class WordExample {

	public static void Run(String apiKey, String basePath)
    {
		Pdf pdf = new Pdf();
		pdf.setApiKey(apiKey);
		WordResource wordResource = new WordResource(basePath + "Doc1.docx");
		pdf.addWord(wordResource, PageSize.LETTER, PageOrientation.PORTRAIT, (float)1.0);
		
		PdfResponse pdfResponse = pdf.process();
		
        try {
			FileUtils.writeByteArrayToFile(new File(DynamicPdfCloudApiExamples.OUTPUT_PATH + "/java-word-example-output.pdf"), pdfResponse.getContent());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    }
	
	public static void main(String[] args) {
		WordExample.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/users-guide/");
	}

}
