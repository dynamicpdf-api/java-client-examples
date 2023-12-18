package com.dynamicpdf.api.examples;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.DlexLayout;
import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.LayoutDataResource;
import com.dynamicpdf.api.PdfResponse;

public class DesignerReportTemplate {

	public static void main(String[] args) {
		DesignerReportTemplate.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/creating-a-report-template-designer/");
		}
	
	   public static void Run(String apiKey, String basePath)
	    {
		   
		    LayoutDataResource layoutDataResource = new LayoutDataResource(basePath + "invoice.json");
	        DlexLayout dlexLayout = new DlexLayout("samples/creating-a-report-template-designer/invoice.dlex", 
	        		layoutDataResource);
	        dlexLayout.setApiKey(apiKey);
	        
	        PdfResponse response = dlexLayout.process();

			if(response.getIsSuccessful())
			{
				try {
					FileUtils.writeByteArrayToFile(new File(DynamicPdfCloudApiExamples.OUTPUT_PATH + "/invoice-java-output.pdf"),
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
