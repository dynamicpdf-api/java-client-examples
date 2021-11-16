package com.dynamicpdf.api.examples;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.DlexLayout;
import com.dynamicpdf.api.LayoutDataResource;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.util.PrettyPrintUtility;

public class DlexLayoutExample {
	
	
	public static void CreatePDF(String apiKey, String basePath) {
		  LayoutDataResource layoutData = new LayoutDataResource(basePath + "/getting-started-data.json");
		  DlexLayout dlexEndpoint = new DlexLayout("samples/shared/dlex/getting-started.dlex", layoutData);
		  dlexEndpoint.setApiKey(apiKey);
		  PdfResponse response = dlexEndpoint.process();
		  
		  if (response.getIsSuccessful()==true) {
		    try {
		      FileUtils.writeByteArrayToFile(new File(basePath + "/java-dlex-output.pdf"), 
		    		  (byte[])response.getContent());
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  } else {
		      System.out.println(PrettyPrintUtility.prettyPrintJSON(response.getErrorJson()));
		    }
		}

	public static void main(String[] args) {
		DlexLayoutExample.CreatePDF(args[0], args[1]);
	}
}
