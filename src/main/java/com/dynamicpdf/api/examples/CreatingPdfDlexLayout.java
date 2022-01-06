package com.dynamicpdf.api.examples;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import com.dynamicpdf.api.DlexLayout;
import com.dynamicpdf.api.LayoutDataResource;
import com.dynamicpdf.api.PdfResponse;


public class CreatingPdfDlexLayout {

	// https://cloud.dynamicpdf.com/docs/tutorials/cloud-api/dlex-layout/tutorial-dlex-layout
	
	public static void main(String[] args) {
		CreatingPdfDlexLayout.Run("DP.xxxx--api--key--xxx",
				"C:/temp/dynamicpdf-api-samples/creating-pdf-dlex-layout-endpoint/");
	}

	public static void Run(String apiKey, String basePath) {

		//get the local layoutdata
		LayoutDataResource layoutData = new LayoutDataResource(basePath + "create-pdf-dlex-layout.json");
		
		//load layoutdata and cloud dlex
		DlexLayout dlexEndpoint = new DlexLayout("samples/creating-pdf-dlex-layout-endpoint/create-pdf-dlex-layout.dlex", layoutData);
		dlexEndpoint.setApiKey(apiKey);
		
		//call the dlex-layout endpoint and get response
		PdfResponse response = dlexEndpoint.process();

		//if successful save as file
		if (response.getIsSuccessful()) {
			try {
				FileUtils.writeByteArrayToFile(new File(basePath + "/create-pdf-dlex-layout-output.pdf"),
						(byte[]) response.getContent());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(response.getErrorJson());
		}
	}

}
