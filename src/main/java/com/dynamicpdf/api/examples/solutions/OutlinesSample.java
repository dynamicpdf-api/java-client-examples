package com.dynamicpdf.api.examples.solutions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.Outline;
import com.dynamicpdf.api.PageInput;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfInput;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.elements.ElementPlacement;
import com.dynamicpdf.api.elements.TextElement;

public class OutlinesSample {

	public static void main(String[] args) {
		OutlinesSample.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/outlines/");
	}
	
	public static void Run(String apiKey, String basePath) {
		
		Pdf pdf = new Pdf();
		pdf.setApiKey(apiKey);

		PageInput pageInput = pdf.addPage();
		TextElement element = new TextElement("Hello World 1", ElementPlacement.TOPCENTER);
		pageInput.getElements().add(element);

		PageInput pageInput1 = pdf.addPage();
		TextElement element1 = new TextElement("Hello World 2", ElementPlacement.TOPCENTER);
		pageInput1.getElements().add(element1);

		PageInput pageInput2 = pdf.addPage();
		TextElement element2 = new TextElement("Hello World 3", ElementPlacement.TOPCENTER);
		pageInput2.getElements().add(element2);


		PdfInput inputA = pdf.addPdf(new PdfResource(basePath + "PdfOutlineInput.pdf"));
		inputA.setId("pdfoutlineinput");


		Outline rootOutline = pdf.getOutlines().add("Root Outline");

		rootOutline.getChildren().add("Page 1", pageInput);
		rootOutline.getChildren().add("Page 2", pageInput1);
		rootOutline.getChildren().add("Page 3", pageInput2);
		rootOutline.getChildren().addPdfOutlines(inputA);


		PdfResponse response = pdf.process();

		if(response.getIsSuccessful())
		{
			try {
				FileUtils.writeByteArrayToFile(new File(DynamicPdfCloudApiExamples.OUTPUT_PATH + "/outlines-output.pdf"),
						response.getContent());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else
		{
			System.out.println(response.getErrorJson());
		}
	}

}
