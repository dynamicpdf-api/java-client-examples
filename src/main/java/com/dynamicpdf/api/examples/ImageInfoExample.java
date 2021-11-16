package com.dynamicpdf.api.examples;


import com.dynamicpdf.api.ImageInfo;
import com.dynamicpdf.api.ImageResource;
import com.dynamicpdf.api.ImageResponse;
import com.dynamicpdf.api.util.PrettyPrintUtility;

public class ImageInfoExample {

	public static void ImageInfoExampleOne(String key, String basePath) {
        ImageResource imageResource = null;
        imageResource = new ImageResource(basePath + "/dynamicpdflogo.png");
        ImageInfo imageInfo = new ImageInfo(imageResource);
        imageInfo.setApiKey(key);
        imageInfo.setBaseUrl(CloudApiExamples.BASE_URL);
        ImageResponse response = imageInfo.process();
        System.out.println(PrettyPrintUtility.prettyPrintJSON(response.getJsonContent()));
	} 	
	
	public static void main(String[] args) {
		ImageInfoExample.ImageInfoExampleOne(args[0], args[1]);
	}
}
