package com.dynamicpdf.api.gettingstarted;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import com.dynamicpdf.api.DlexLayout;
import com.dynamicpdf.api.LayoutDataResource;
import com.dynamicpdf.api.PdfResponse;

public class GettingStartedInFive {

	public static void main(String[] args) {
		GettingStartedInFive.Run("DP.V9z4rPOYV+b/je9WDNUtED6md3H1i4huSxNoMIXKicf/TYJRxT5H176B",
				"C:/temp/dynamicpdf-api-samples/");
	}

	public static void Run(String apiKey, String basePath) {
		LayoutDataResource layoutDataResource = new LayoutDataResource(basePath + "getting-started.json");
		DlexLayout dlexLayout = new DlexLayout("samples/getting-started/getting-started.dlex", layoutDataResource);
		dlexLayout.setApiKey(apiKey);
		PdfResponse pdfResponse = dlexLayout.process();

		try {
			FileUtils.writeByteArrayToFile(new File(basePath + "getting-started-output.pdf"),
					pdfResponse.getContent());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}