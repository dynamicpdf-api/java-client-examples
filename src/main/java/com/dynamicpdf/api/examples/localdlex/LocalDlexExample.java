package com.dynamicpdf.api.examples.localdlex;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.dynamicpdf.api.DlexLayout;
import com.dynamicpdf.api.DlexResource;
import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.LayoutDataResource;
import com.dynamicpdf.api.PdfResponse;

public class LocalDlexExample {

	public static void main(String[] args) {
		LocalDlexExample.RunFromLocalWithFiles(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/local-dlex/",
				DynamicPdfCloudApiExamples.OUTPUT_PATH);
	}
	
	public static void RunFromLocalWithFiles(String apiKey, String basePath, String outputPath) {
        try {
            
            LayoutDataResource layoutData = new LayoutDataResource(basePath + "ExampleTemplate.json");
            DlexResource dlexResource = new DlexResource(basePath + "ExampleTemplate.dlex", "ExampleTemplate.dlex");

            DlexLayout dlexEndpoint = new DlexLayout(dlexResource, layoutData);
            dlexEndpoint.addAdditionalResource(basePath + "template_example.pdf", "template_example.pdf");
            dlexEndpoint.addAdditionalResource(basePath + "signature-one.png", "signature-one.png");

            dlexEndpoint.setApiKey(apiKey);
            PdfResponse response = dlexEndpoint.process();

            if (response.getIsSuccessful()) {
                File outputFile = new File(outputPath + "local-template-example-output.pdf");
                try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                    fos.write(response.getContent());
                }
                System.out.println("PDF generated successfully: " + outputFile.getAbsolutePath());
            } else {
                System.err.println("Error: " + response.getErrorJson());
            }
        } catch (IOException e) {
            System.err.println("File handling error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
	}
}
