package com.dynamicpdf.api.examples;

import com.dynamicpdf.api.ImageInfo;
import com.dynamicpdf.api.ImageResource;
import com.dynamicpdf.api.ImageResponse;
import com.dynamicpdf.api.util.PrettyPrintUtility;


public class ImageInfoExample {

	public static void RunOne(String key, String basePath) {
        ImageResource imageResource = null;
        imageResource = new ImageResource(basePath + "/getting-started.png");
        ImageInfo imageInfo = new ImageInfo(imageResource);
        imageInfo.setApiKey(key);
        ImageResponse response = imageInfo.process();
        System.out.println(PrettyPrintUtility.prettyPrintJSON(response.getJsonContent()));
	} 
	
    public static void RunTwo(String apiKey, String basePath)
    {
        String key = apiKey;
        ImageResource imageResource = new ImageResource(basePath + "/multipage.tiff");
        ImageInfo imageInfo = new ImageInfo(imageResource);
        imageInfo.setApiKey(apiKey);
         ImageResponse response = imageInfo.process();
        System.out.println(PrettyPrintUtility.prettyPrintJSON(response.getJsonContent()));
    }
	
	public static void main(String[] args) {
		ImageInfoExample.RunOne("DP.TrJj2UBRFfrxiLYYD9xQryHXnFoSRKVPTBYH0LRpVWWnTZPOmgRO6yX6",
				"C:/temp/dynamicpdf-api-usersguide-examples/");
		ImageInfoExample.RunTwo("DP.TrJj2UBRFfrxiLYYD9xQryHXnFoSRKVPTBYH0LRpVWWnTZPOmgRO6yX6",
				"C:/temp/dynamicpdf-api-usersguide-examples/");
	}
}
