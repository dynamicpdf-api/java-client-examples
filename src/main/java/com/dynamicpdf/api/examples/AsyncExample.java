package com.dynamicpdf.api.examples;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.DlexLayout;
import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.LayoutDataResource;
import com.dynamicpdf.api.PdfResponse;

public class AsyncExample {

	public static void main(String[] args) {
	   	AsyncExample.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/async-example/");
	}

	public static void Run(String apiKey, String basePath) {

		LayoutDataResource layoutData = new LayoutDataResource(basePath + "report-with-cover-page.json");
		

		DlexLayout dlexEndpoint = new DlexLayout("samples/report-with-cover-page/report-with-cover-page.dlex", layoutData);
		
		dlexEndpoint.setApiKey(apiKey);
		CompletableFuture<?>[] cf = new CompletableFuture[20];
		
		for(int i = 0; i < 20; i++) {
			
			String userId = "user" + i;
			
			cf[i] = (dlexEndpoint.processAsync().thenAccept(
					s->AsyncExample.SaveResult(s, basePath, userId)));
			
			System.out.println("Processing: " + userId);
			
		}
		
		CompletableFuture.allOf(cf).join();
		
		System.out.println("Finished");

	}

	public static void SaveResult(PdfResponse response, String basePath, String userId) {
		
		System.out.println("Saving: " + userId);
		
		if (response.getIsSuccessful()) {
			try {
				FileUtils.writeByteArrayToFile(new File(basePath + "/" + userId + "-output.pdf"), (byte[]) response.getContent());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(response.getErrorJson());
		}
	}
	
}
