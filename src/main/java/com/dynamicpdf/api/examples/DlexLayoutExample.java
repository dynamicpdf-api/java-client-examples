package com.dynamicpdf.api.examples;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.DlexLayout;
import com.dynamicpdf.api.DlexResource;
import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.LayoutDataResource;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.util.PrettyPrintUtility;

public class DlexLayoutExample {
	
	public static void Run(String apiKey, String basePath) {
		DlexLayoutExample.RunFromCloud(apiKey, basePath);
		DlexLayoutExample.RunFromLocal(apiKey, basePath);
	}
	
	public static void RunFromCloud(String apiKey, String basePath) {
		  LayoutDataResource layoutData = new LayoutDataResource(basePath + "creating-pdf-dlex-layout.json");
		  DlexLayout dlexEndpoint = new DlexLayout("samples/creating-pdf-dlex-layout-endpoint/creating-pdf-dlex-layout.dlex", layoutData);
		  dlexEndpoint.setApiKey(apiKey);
		  PdfResponse response = dlexEndpoint.process();
		  
		  if (response.getIsSuccessful()==true) {
		    try {
		      FileUtils.writeByteArrayToFile(new File(DynamicPdfCloudApiExamples.OUTPUT_PATH + "/java-dlex-layout-output.pdf"), 
		    		  (byte[])response.getContent());
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  } else {
		      System.out.println(PrettyPrintUtility.prettyPrintJSON(response.getErrorJson()));
		    }
		}

	public static void RunFromLocal(String apiKey, String basePath) {
		  LayoutDataResource layoutData = new LayoutDataResource(basePath + "creating-pdf-dlex-layout.json");
		  DlexResource dlexResource = new DlexResource(basePath + "creating-pdf-dlex-layout.dlex", "creating-pdf-dlex-layout.dlex");
		  DlexLayout dlexEndpoint = new DlexLayout(dlexResource, layoutData);
		  dlexEndpoint.addAdditionalResource(basePath + "creating-pdf-dlex-layout.png", "creating-pdf-dlex-layout.png");
		  
		  dlexEndpoint.setApiKey(apiKey);
		  PdfResponse response = dlexEndpoint.process();
		  
		  if (response.getIsSuccessful()==true) {
		    try {
		      FileUtils.writeByteArrayToFile(new File(DynamicPdfCloudApiExamples.OUTPUT_PATH + "/java-dlex-layout-local-output.pdf"), 
		    		  (byte[])response.getContent());
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  } else {
		      System.out.println(PrettyPrintUtility.prettyPrintJSON(response.getErrorJson()));
		    }
		}
	
	public static void main(String[] args) {
		DlexLayoutExample.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/creating-pdf-dlex-layout/");
	}
}
