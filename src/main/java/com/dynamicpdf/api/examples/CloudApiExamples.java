package com.dynamicpdf.api.examples;

public class CloudApiExamples {

	public static String BASE_URL = "https://api.dynamicpdf.com/v1.0";
	
	public static void main(String[] args) {
		
		PdfExample.PdfExampleOne(args[0], args[1]);
		PdfTextExample.PdfTextExampleOne(args[0], args[1]);
		PdfXmpExample.PdfXmpExampleOne(args[0], args[1]);
	}

}
