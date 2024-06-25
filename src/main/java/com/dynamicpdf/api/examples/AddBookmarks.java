package com.dynamicpdf.api.examples;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.Outline;
import com.dynamicpdf.api.OutlineStyle;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfInput;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.RgbColor;
import com.dynamicpdf.api.UrlAction;

public class AddBookmarks {
		
	public static void main(String[] args) {
    	AddBookmarks.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR +"/add-bookmarks/");

	}

	public static void Run(String apiKey, String basePath)
	{
		Pdf pdf = new Pdf();
		pdf.setApiKey(apiKey);

		//add three PDF documents as PdfInputs

		PdfResource resource = new PdfResource(basePath + "DocumentA.pdf");
		PdfInput inputA = pdf.addPdf(resource);
		inputA.setId("documentA");

		PdfResource resourceB = new PdfResource(basePath + "DocumentB.pdf");
		PdfInput inputB = pdf.addPdf(resourceB);
		inputB.setId("documentB");

		PdfResource resourceC = new PdfResource(basePath + "DocumentC.pdf");
		PdfInput inputC = pdf.addPdf(resourceC);
		inputC.setId("documentC");

		//create a root outline and then add the three documents as children Outline instances

		Outline rootOutline = pdf.getOutlines().add("Three Bookmarks");
		Outline outlineA = rootOutline.getChildren().add("DocumentA", inputA);
		Outline outlineB = rootOutline.getChildren().add("DocumentB", inputB, 2);
		rootOutline.getChildren().add("DocumentC", inputC).setColor(RgbColor.getPurple());

		//add some color to the outline elements

		rootOutline.setColor(RgbColor.getRed());
		rootOutline.setStyle(OutlineStyle.BOLDITALIC);
		outlineA.setColor(RgbColor.getOrange());
		outlineB.setColor(RgbColor.getGreen());

		//add an outline element that links to a URL

		Outline outlineD = rootOutline.getChildren().add("DynamicPDF Cloud API");
		outlineD.setColor(RgbColor.getBlue());
		outlineD.setAction(new UrlAction("https://cloud.dynamicpdf.com/"));

		rootOutline.setExpanded(true);
		
		PdfResponse response = pdf.process();

		if(response.getIsSuccessful())
		{
			try {
				FileUtils.writeByteArrayToFile(new File(DynamicPdfCloudApiExamples.OUTPUT_PATH + "/add-bookmarks-java-output.pdf"),
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
