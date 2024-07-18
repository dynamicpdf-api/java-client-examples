package com.dynamicpdf.api.examples.solutions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.WordResource;
import com.dynamicpdf.api.LayoutDataResource;
import com.dynamicpdf.api.PageOrientation;
import com.dynamicpdf.api.PageSize;
import com.dynamicpdf.api.ImageInput;
import com.dynamicpdf.api.ImageResource;
import com.dynamicpdf.api.HtmlResource;

public class MergeSolution {

	public static void main(String[] args) {
		MergeSolution.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR);
	}

	public static void Run(String apiKey, String basePath) {
		Pdf pdf = new Pdf();
		pdf.setApiKey(apiKey);

		pdf.addPdf(new PdfResource(basePath + "/merge-pdfs-pdf-endpoint/DocumentA.pdf"));
		pdf.addPdf(new PdfResource(basePath + "/merge-pdfs-pdf-endpoint/DocumentB.pdf"));
		pdf.addWord(new WordResource(basePath + "/users-guide/Doc1.docx"), PageSize.LETTER, PageOrientation.PORTRAIT,
				(float) 1.0);
		ImageInput input = pdf.addImage(new ImageResource(basePath + "/image-conversion/testimage.tif"));
		input.setScaleX((float) 0.5);
		input.setScaleY((float) 0.5);
		
		String temp = "";
		
		try {
			temp = Files.readString(Paths.get(basePath + "/users-guide/products.html"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		HtmlResource resource = new HtmlResource(temp);
		pdf.addHtml(resource, "", PageSize.LETTER, PageOrientation.PORTRAIT, 1F);

		
		LayoutDataResource layoutData = new LayoutDataResource(
				basePath + "/creating-pdf-dlex-layout-endpoint/creating-pdf-dlex-layout.json");
		pdf.addDlex("samples/creating-pdf-dlex-layout-endpoint/creating-pdf-dlex-layout.dlex", layoutData);


		PdfResponse pdfResponse = pdf.process();
		
		if (pdfResponse.getIsSuccessful()) {
			try {
				FileUtils.writeByteArrayToFile(
						new File(DynamicPdfCloudApiExamples.OUTPUT_PATH + "/merging-solution-java-output.pdf"),
						pdfResponse.getContent());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(pdfResponse.getErrorJson());
		}
	}

}
