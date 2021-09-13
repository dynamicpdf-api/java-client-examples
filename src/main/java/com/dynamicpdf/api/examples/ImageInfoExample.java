package com.dynamicpdf.api.examples;


import com.dynamicpdf.api.ImageInfo;
import com.dynamicpdf.api.ImageResource;
import com.dynamicpdf.api.ImageResponse;
import com.dynamicpdf.api.util.PrettyPrintUtility;

public class ImageInfoExample {

	public static void ImageInfoExampleOne(String key, String basePath) {
        ImageResource imageResource = null;
        imageResource = new ImageResource(basePath + "/getting-started.png");
        ImageInfo imageInfo = new ImageInfo(imageResource);
        imageInfo.setApiKey(key);
        imageInfo.setBaseUrl(CloudApiExamples.BASE_URL);
        ImageResponse response = imageInfo.process();
        System.out.println(PrettyPrintUtility.prettyPrintJSON(response.getJsonContent()));
	} 
	
    public static void ImageInfoExampleTwo(String apiKey, String basePath)
    {
        String key = apiKey;
        ImageResource imageResource = new ImageResource(basePath + "/multipage.tiff");
        ImageInfo imageInfo = new ImageInfo(imageResource);
        imageInfo.setApiKey(apiKey);
        imageInfo.setBaseUrl(CloudApiExamples.BASE_URL);
        ImageResponse response = imageInfo.process();
        System.out.println(PrettyPrintUtility.prettyPrintJSON(response.getJsonContent()));
    }
	
}
