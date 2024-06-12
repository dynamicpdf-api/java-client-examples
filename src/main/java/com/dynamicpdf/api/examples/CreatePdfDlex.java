package com.dynamicpdf.api.examples;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.LayoutDataResource;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.DlexResource;

public class CreatePdfDlex {
	
	
	public static void main(String[] args) {
		CreatePdfDlex.RunLocal(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/creating-pdf-pdf-endpoint/");
		CreatePdfDlex.RunRemote(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/creating-pdf-pdf-endpoint/");
	}

    public static void RunLocal(String apiKey, String basePath)
    {
        Pdf pdf = new Pdf();
        pdf.setApiKey(apiKey);
        LayoutDataResource layoutDataResource = new LayoutDataResource(basePath + "SimpleReportWithCoverPage.json");
        DlexResource dlexResource = new DlexResource(basePath + "SimpleReportWithCoverPage.dlex");
        pdf.addDlex(dlexResource, layoutDataResource);
        pdf.addAdditionalResource(basePath + "Northwind Logo.gif");

        PdfResponse response = pdf.process();

		if(response.getIsSuccessful())
		{
			try {
				FileUtils.writeByteArrayToFile(new File(DynamicPdfCloudApiExamples.OUTPUT_PATH + "/create-pdf-dlex-java-local-output.pdf"),
						response.getContent());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else
		{
			System.out.println(response.getErrorJson());
		}
    }
    
    public static void RunRemote(String apiKey, String basePath)
    {
        Pdf pdf = new Pdf();
        pdf.setApiKey(apiKey);
        LayoutDataResource layoutDataResource = new LayoutDataResource(basePath + "SimpleReportWithCoverPage.json");
        pdf.addDlex("samples/creating-pdf-pdf-endpoint/SimpleReportWithCoverPage.dlex", layoutDataResource);

        PdfResponse response = pdf.process();

		if(response.getIsSuccessful())
		{
			try {
				FileUtils.writeByteArrayToFile(new File(DynamicPdfCloudApiExamples.OUTPUT_PATH + "/create-pdf-dlex-java-remote-output.pdf"),
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
