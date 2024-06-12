package com.dynamicpdf.api.examples;

import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.ImageInfo;
import com.dynamicpdf.api.ImageResource;
import com.dynamicpdf.api.ImageResponse;

public class GetImageInfo {
	

	public static void main(String[] args) {
		GetImageInfo.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/get-image-info-image-info-endpoint/");

	}

	public static void Run(String key, String basePath) {
		
        ImageResource imageResource = null;
        imageResource = new ImageResource(basePath + "dynamicpdflogo.png");
        ImageInfo imageInfo = new ImageInfo(imageResource);
        imageInfo.setApiKey(key);
        ImageResponse response = imageInfo.process();

        if(response.getIsSuccessful()) {
            System.out.println(response.getJsonContent());
        } else {
        	System.out.println(response.getErrorJson());
        }
	} 	
}
