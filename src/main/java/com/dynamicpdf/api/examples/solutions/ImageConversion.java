package com.dynamicpdf.api.examples.solutions;

import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.VAlign;
import com.dynamicpdf.api.ImageResource;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import com.dynamicpdf.api.Align;
import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.ImageInput;

public class ImageConversion {

	public static void main(String[] args) {
		ImageConversion.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/image-conversion/");
	}

	public static void Run(String apiKey, String basePath)
	{
		Pdf pdf = new Pdf();
		pdf.setApiKey(apiKey);

		ImageResource imageResource = new ImageResource(basePath + "testimage.tif");
		ImageInput imageInput = pdf.addImage(imageResource);
		imageInput.setAlign(Align.CENTER);
		imageInput.setVAlign(VAlign.CENTER);
		imageInput.setExpandToFit(false);
		imageInput.setPageHeight(1008);
		imageInput.setPageWidth(612);


		ImageResource imageResource2 = new ImageResource(basePath + "dynamicpdfLogo.png");
		ImageInput imageInput2 = pdf.addImage(imageResource2);
		imageInput2.setAlign(Align.CENTER);
		imageInput2.setVAlign(VAlign.CENTER);
		imageInput2.setExpandToFit(true);
		imageInput2.setPageHeight(612);
		imageInput2.setPageWidth(1008);


		pdf.setApiKey(apiKey);

		PdfResponse response = pdf.process();

		if(response.getIsSuccessful())
		{
			try {
				FileUtils.writeByteArrayToFile(new File(DynamicPdfCloudApiExamples.OUTPUT_PATH + "/images-convert-pdf-output.pdf"),
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
