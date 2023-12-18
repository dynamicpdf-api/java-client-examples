package com.dynamicpdf.api.examples;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.DlexLayout;
import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.LayoutDataResource;
import com.dynamicpdf.api.PdfResponse;

public class DlexLayoutExampleString {

	public static void Run(String apiKey, String basePath) {

		String jsonData = null;

		try {
			jsonData = new String(Files.readAllBytes(Paths.get(basePath + "/SimpleReportWithCoverPage.json")));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		LayoutDataResource layoutData = new LayoutDataResource(jsonData);
		DlexLayout dlexEndpoint = new DlexLayout("samples/dlex-layout/SimpleReportWithCoverPage.dlex", layoutData);
		dlexEndpoint.setApiKey(apiKey);
		PdfResponse response = dlexEndpoint.process();

		if (response.getIsSuccessful() == true) {
			try {
				FileUtils.writeByteArrayToFile(new File(DynamicPdfCloudApiExamples.OUTPUT_PATH + "/java-dlex-output_string.pdf"),
						(byte[]) response.getContent());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(response.getErrorJson());
		}
	}

	public static void main(String[] args) {
		DlexLayoutExampleString.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/dlex-layout/");
	}
}
