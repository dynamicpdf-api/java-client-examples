package com.dynamicpdf.api.examples;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Base64;

import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.imaging.PdfImage;
import com.dynamicpdf.api.imaging.PdfImageResponse;
import com.dynamicpdf.api.imaging.PdfImageResponse.Image;
import com.dynamicpdf.api.imaging.PngImageFormat;

public class PdfImageExample {

	public static void main(String[] args) {

		PdfImageExample.RunSinglePage(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/pdf-image/",
				DynamicPdfCloudApiExamples.OUTPUT_PATH);
		PdfImageExample.RunMultiPage(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/pdf-image/",
				DynamicPdfCloudApiExamples.OUTPUT_PATH);
	}

	public static void RunSinglePage(String key, String basePath, String outputPath) {

	
		PdfResource resource = new PdfResource(basePath + "onepage.pdf");
		PdfImage pdfImage = new PdfImage(resource);
		pdfImage.setApiKey(key);

		PngImageFormat pngImageFormat = new PngImageFormat();
		pdfImage.setImageFormat(pngImageFormat);

		PdfImageResponse response = pdfImage.process();

		if (response.getIsSuccessful()) {

			for (int i = 0; i < response.getImages().size(); i++) {
				Image img = response.getImages().get(i);
				File file = new File(outputPath + "/image-out_" + i + ".png");
				OutputStream os;
				try {
					os = new FileOutputStream(file);
					os.write(Base64.getDecoder().decode(response.getImages().get(i).getData()));
					os.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		} else {
			System.out.println("errorcode: " + response.getStatusCode());
			System.out.println(response.getErrorMessage());
			System.out.println(response.getErrorJson());
		}
	}
	
	public static void RunMultiPage(String key, String basePath, String outputPath) {

		
		PdfResource resource = new PdfResource(basePath + "pdfnumberedinput.pdf");
		PdfImage pdfImage = new PdfImage(resource);

		PngImageFormat pngImageFormat = new PngImageFormat();
		pdfImage.setImageFormat(pngImageFormat);

		pdfImage.setApiKey(key);
		
		PdfImageResponse response = pdfImage.process();

		if (response.getIsSuccessful()) {

			for (int i = 0; i < response.getImages().size(); i++) {
				Image img = response.getImages().get(i);
				File file = new File(outputPath + "/image-multi-out_" + i + ".png");
				OutputStream os;
				try {
					os = new FileOutputStream(file);
					os.write(Base64.getDecoder().decode(response.getImages().get(i).getData()));
					os.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		} else {
			System.out.println("errorcode: " + response.getStatusCode());
			System.out.println(response.getErrorMessage());
			System.out.println(response.getErrorJson());
		}
	}
}