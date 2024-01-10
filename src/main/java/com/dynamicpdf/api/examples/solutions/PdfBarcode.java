package com.dynamicpdf.api.examples.solutions;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.PageInput;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.RgbColor;
import com.dynamicpdf.api.elements.Code11BarcodeElement;
import com.dynamicpdf.api.elements.ElementPlacement;

public class PdfBarcode {

	public static void main(String[] args) {
		PdfBarcode.Run(DynamicPdfCloudApiExamples.API_KEY);
	}

	public static void Run(String apiKey)
	{
		Pdf pdf = new Pdf();
		pdf.setApiKey(apiKey);
		PageInput pageInput = pdf.addPage(1008, 612);
		pdf.getInputs().add(pageInput);

		Code11BarcodeElement code11BarcodeElement = new Code11BarcodeElement("12345678", ElementPlacement.TOPCENTER, 200, 50, 50);
		code11BarcodeElement.setColor(RgbColor.getRed());
		pageInput.getElements().add(code11BarcodeElement);

		PdfResponse pdfResponse = pdf.process();

		if(pdfResponse.getIsSuccessful())
		{
			try {
				FileUtils.writeByteArrayToFile(new File(DynamicPdfCloudApiExamples.OUTPUT_PATH + "/barcode-createpdf-output.pdf"),
						pdfResponse.getContent());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else
		{
			System.out.println(pdfResponse.getErrorJson());
		}
	}
}
