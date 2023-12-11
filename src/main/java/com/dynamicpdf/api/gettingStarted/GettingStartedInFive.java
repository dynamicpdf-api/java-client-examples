package com.dynamicpdf.api.gettingStarted;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import com.dynamicpdf.api.DlexLayout;
import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.LayoutDataResource;
import com.dynamicpdf.api.PdfResponse;

public class GettingStartedInFive {
	
	// https://cloud.dynamicpdf.com/docs/getting-started

	public static void main(String[] args) {
		GettingStartedInFive.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/getting-started/");
	}

	public static void Run(String apiKey, String basePath) {
		LayoutDataResource layoutDataResource = new LayoutDataResource(basePath + "getting-started.json");
		DlexLayout dlexLayout = new DlexLayout("samples/getting-started/getting-started.dlex", layoutDataResource);
		dlexLayout.setApiKey(apiKey);
		PdfResponse pdfResponse = dlexLayout.process();

		try {
			FileUtils.writeByteArrayToFile(new File(basePath + "getting-started-java-output.pdf"),
					pdfResponse.getContent());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}