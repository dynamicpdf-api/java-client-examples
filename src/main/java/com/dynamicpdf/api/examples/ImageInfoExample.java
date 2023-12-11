package com.dynamicpdf.api.examples;

import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.ImageInfo;
import com.dynamicpdf.api.ImageResource;
import com.dynamicpdf.api.ImageResponse;
import com.dynamicpdf.api.util.PrettyPrintUtility;


public class ImageInfoExample {

	
	public static void Run(String key, String basePath) {
		ImageInfoExample.RunOne(key, basePath);
		ImageInfoExample.RunTwo(key, basePath);
	}
	
	public static void RunOne(String key, String basePath) {
        ImageResource imageResource = null;
        imageResource = new ImageResource(basePath + "getting-started.png");
        ImageInfo imageInfo = new ImageInfo(imageResource);
        imageInfo.setApiKey(key);
        ImageResponse response = imageInfo.process();
        System.out.println(PrettyPrintUtility.prettyPrintJSON(response.getJsonContent()));
	} 
	
    public static void RunTwo(String apiKey, String basePath)
    {
        String key = apiKey;
        ImageResource imageResource = new ImageResource(basePath + "multipage.tiff");
        ImageInfo imageInfo = new ImageInfo(imageResource);
        imageInfo.setApiKey(apiKey);
         ImageResponse response = imageInfo.process();
        System.out.println(PrettyPrintUtility.prettyPrintJSON(response.getJsonContent()));
    }
	
	public static void main(String[] args) {
		ImageInfoExample.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/image-info/");
	}
}
