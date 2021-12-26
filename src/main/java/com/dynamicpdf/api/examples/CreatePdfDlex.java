package com.dynamicpdf.api.examples;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.LayoutDataResource;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfResponse;

public class CreatePdfDlex {

	public static void main(String[] args) {
		CreatePdfDlex.Run("DP.F9KH87xzX6JFVE4YGbkLU4nvx7fbnjXOKIr7wPWYPRdaRJe7OlYQ+/cw",
				"C:/temp/dynamicpdf-api-samples/create-pdf-dlex");
	}

    public static void Run(String apiKey, String basePath)
    {
        Pdf pdf = new Pdf();
        pdf.setApiKey(apiKey);
        LayoutDataResource layoutDataResource = new LayoutDataResource(basePath + "/SimpleReportWithCoverPage.json");
        pdf.addDlex("samples/creating-pdf-pdf-endpoint/SimpleReportWithCoverPage.dlex", layoutDataResource);

        PdfResource pdfResource = new PdfResource(basePath + "/DocumentA.pdf");
        pdf.addPdf(pdfResource);


        PdfResponse response = pdf.process();

		if(response.getIsSuccessful())
		{
			try {
				FileUtils.writeByteArrayToFile(new File(basePath + "/create-pdf-dlex-output.pdf"),
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
