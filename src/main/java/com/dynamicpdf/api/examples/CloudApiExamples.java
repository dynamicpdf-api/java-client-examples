package com.dynamicpdf.api.examples;


import com.dynamicpdf.api.util.PrettyPrintUtility;

public class CloudApiExamples {

	public static String BASE_URL = "https://api.dynamicpdf.com/v1.0";
	
	public static void main(String[] args) {
		PdfInfoExample.PdfExampleOne(args[0], args[1]);
		System.out.println(PrettyPrintUtility.DividerLine());
		ImageInfoExample.ImageInfoExampleOne(args[0],  args[1]);
		System.out.println(PrettyPrintUtility.DividerLine());
		ImageInfoExample.ImageInfoExampleTwo(args[0], args[1]);
		System.out.println(PrettyPrintUtility.DividerLine());
		PdfTextExample.PdfTextExampleOne(args[0], args[1]);
		System.out.println(PrettyPrintUtility.DividerLine());
		PdfXmpExample.PdfXmpExampleOne(args[0], args[1]);
		System.out.println(PrettyPrintUtility.DividerLine());
		DlexLayoutExample.DlexLayoutExampleOne(args[0], args[1]);
		PdfExample.PdfExampleOne(args[0], args[1]);
	}

}
