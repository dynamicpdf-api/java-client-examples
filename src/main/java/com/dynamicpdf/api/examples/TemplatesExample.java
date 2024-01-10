package com.dynamicpdf.api.examples;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.HtmlInput;
import com.dynamicpdf.api.HtmlResource;
import com.dynamicpdf.api.ImageInput;
import com.dynamicpdf.api.ImageResource;
import com.dynamicpdf.api.LineStyle;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfInput;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.RgbColor;
import com.dynamicpdf.api.Template;
import com.dynamicpdf.api.WordInput;
import com.dynamicpdf.api.WordResource;
import com.dynamicpdf.api.elements.ElementPlacement;
import com.dynamicpdf.api.elements.ImageElement;
import com.dynamicpdf.api.elements.LineElement;
import com.dynamicpdf.api.elements.RectangleElement;
import com.dynamicpdf.api.elements.TextElement;

public class TemplatesExample {

	public static void main(String[] args) {
		TemplatesExample.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/templates/");
	}
	
	static void Run(String apiKey, String basePath)
	{
	    Template template = new Template("Temp1");
	    TextElement textElement = new TextElement("Hello PDF", ElementPlacement.TOPCENTER);
	    textElement.setColor(RgbColor.getBlue());
	    textElement.setFontSize(42);
		textElement.setXOffset(-50);
		textElement.setYOffset(100);
		
		template.getElements().add(textElement);
		
	    RectangleElement recElement = new RectangleElement(ElementPlacement.TOPCENTER, 100, 500);
		recElement.setXOffset(-150);
		recElement.setYOffset(100);
		recElement.setCornerRadius(10);
		recElement.setBorderWidth(5);
		recElement.setBorderStyle(LineStyle.getDots());
		recElement.setBorderColor(RgbColor.getBlue());
		recElement.setFillColor(RgbColor.getGreen());

		template.getElements().add(recElement);
		
		LineElement element = new LineElement(ElementPlacement.TOPLEFT, 500, 150);
		element.setColor(RgbColor.getRed());
		element.setXOffset(105);
		element.setYOffset(50);
		element.setX2Offset(900);
		element.setY2Offset(150);
		element.setLineStyle(LineStyle.getSolid());
		element.setWidth(4);
		
		template.getElements().add(element);
	    
	    ImageResource imgResource = new ImageResource(basePath + "dynamicpdfLogo.png");
	    ImageElement imageElement = new ImageElement(imgResource);
	    imageElement.setPlacement(ElementPlacement.TOPLEFT); 
		imageElement.setXOffset(400);
		imageElement.setYOffset(10);
		
		template.getElements().add(imageElement);

		Pdf pdf = new Pdf();
		pdf.setApiKey(apiKey);

	    PdfInput input = pdf.addPdf(new PdfResource(basePath + "DocumentA.pdf"));
	    input.setTemplate(template);
	    pdf.getInputs().add(input);

	    WordResource wordResource = new WordResource(basePath + "Doc1.docx");
	    WordInput word = new WordInput(wordResource);
	    word.setTemplate(template);
	    pdf.getInputs().add(word);
	    
	    ImageResource ir = new ImageResource(basePath + "testimage.png");
	    ImageInput imageInput = new ImageInput(ir);
	    imageInput.setTemplate(template);
	    pdf.getInputs().add(imageInput);
	    	    
		HtmlResource hr = new HtmlResource(basePath + "products.html");
	    HtmlInput hi = new HtmlInput(hr);
	    hi.setTemplate(template);
	    pdf.getInputs().add(hi);
	    
	    pdf.setApiKey(apiKey);
	    
	    PdfResponse response = pdf.process();
	    
		if(response.getIsSuccessful())
		{
			try {
				FileUtils.writeByteArrayToFile(new File(DynamicPdfCloudApiExamples.OUTPUT_PATH + "/images-text-rec-pdf-output.pdf"),
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
