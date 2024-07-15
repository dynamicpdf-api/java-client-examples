package com.dynamicpdf.api.examples.solutions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.ImageResource;
import com.dynamicpdf.api.LineStyle;
import com.dynamicpdf.api.PageInput;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.RgbColor;
import com.dynamicpdf.api.elements.ElementPlacement;
import com.dynamicpdf.api.elements.ImageElement;
import com.dynamicpdf.api.elements.LineElement;
import com.dynamicpdf.api.elements.RectangleElement;
import com.dynamicpdf.api.elements.TextElement;
import com.dynamicpdf.api.util.PrettyPrintUtility;

public class SolutionImagesTextRecs {

	public static void main (String[] args) {
		SolutionImagesTextRecs.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/images-text-recs/");
	}

	public static void Run(String apiKey, String basePath)
	{
		Pdf pdf = new Pdf();
		pdf.setApiKey(apiKey);

		PageInput pageInput = pdf.addPage(1008, 612);
		
		TextElement textElement = new TextElement("Hello PDF", ElementPlacement.TOPCENTER, 50, 100);
		textElement.setColor(RgbColor.getBlue());
		textElement.setFontSize(42);
		pageInput.getElements().add(textElement);
		textElement.setXOffset(-50);
		textElement.setYOffset(100);

		pageInput.getElements().add(textElement);
		
		LineElement element = new LineElement(ElementPlacement.TOPLEFT, 200, 200);
		element.setColor(RgbColor.getRed());
		element.setXOffset(305);
		element.setYOffset(150);
		element.setX2Offset(900);
		element.setY2Offset(150);
		element.setLineStyle(LineStyle.getSolid());
		element.setWidth(4);
		pageInput.getElements().add(element);


		RectangleElement recElement = new RectangleElement(ElementPlacement.TOPCENTER, 100, 500);
		recElement.setXOffset(-250);
		recElement.setYOffset(-10);
		recElement.setCornerRadius(10);
		recElement.setBorderWidth(5);
		recElement.setBorderStyle(LineStyle.getDots());
		recElement.setBorderColor(RgbColor.getBlue());
		recElement.setFillColor(RgbColor.getGreen());
		pageInput.getElements().add(recElement);


		ImageResource imgResource = new ImageResource(basePath + "dynamicpdfLogo.png");
		ImageElement imageElement = new ImageElement(imgResource);
		imageElement.setXOffset(835);
		imageElement.setYOffset(75);
		pageInput.getElements().add(imageElement);
		
		
		System.out.println(PrettyPrintUtility.prettyPrintJSON(pdf.getInstructionsJson()));
		
		PdfResponse response = pdf.process();
		
		if(response.getIsSuccessful())
		{
			try {
				FileUtils.writeByteArrayToFile(new File(DynamicPdfCloudApiExamples.OUTPUT_PATH + "/images-text-rec-java-pdf-output.pdf"),
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