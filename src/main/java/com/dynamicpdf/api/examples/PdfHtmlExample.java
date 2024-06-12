package com.dynamicpdf.api.examples;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.HtmlResource;
import com.dynamicpdf.api.PageOrientation;
import com.dynamicpdf.api.PageSize;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResponse;

public class PdfHtmlExample {

	public static void main(String[] args) {

		PdfHtmlExample.Run(DynamicPdfCloudApiExamples.API_KEY,
				DynamicPdfCloudApiExamples.BASE_DIR + "/converting-html-pdf-endpoint/",
				DynamicPdfCloudApiExamples.OUTPUT_PATH);
	}

	public static void Run(String key, String basePath, String outputPath) {

		Pdf pdf = new Pdf();
		pdf.setApiKey(key);

		pdf.addHtml("<html>An example HTML fragment.</html>", null, PageSize.LETTER, PageOrientation.PORTRAIT, 1F);

		// use basepath in an HTML string
		pdf.addHtml("<html><p>HTML with basePath.</p><img src='./images/logo.png'></img></html>",
				"https://www.dynamicpdf.com", PageSize.LETTER, PageOrientation.PORTRAIT, 1F);

		// add html from a path on local drive
		String temp = null;

		try {
			temp = Files.readString(Paths.get(basePath + "products.html"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		HtmlResource resource = new HtmlResource(temp);
		pdf.addHtml(resource, null, PageSize.LETTER, PageOrientation.PORTRAIT, 1F);

		PdfResponse pdfResponse = pdf.process();

		// if the response is successful, save merged pdf to file. if error, then
		// printout JSON error

		if (pdfResponse.getIsSuccessful()) {
			try {
				FileUtils.writeByteArrayToFile(
						new File(DynamicPdfCloudApiExamples.OUTPUT_PATH + "/converting-html-java-output.pdf"),
						pdfResponse.getContent());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(pdfResponse.getErrorJson());
		}

	}

}
