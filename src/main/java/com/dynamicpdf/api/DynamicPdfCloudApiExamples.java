package com.dynamicpdf.api;

import com.dynamicpdf.api.examples.AddBookmarks;
import com.dynamicpdf.api.examples.AsyncExample;
import com.dynamicpdf.api.examples.CompletingAcroForm;
import com.dynamicpdf.api.examples.CreatePdfDlex;
import com.dynamicpdf.api.examples.CreatingPdfDlexLayout;
import com.dynamicpdf.api.examples.DesignerReportTemplate;
import com.dynamicpdf.api.examples.DlexLayoutExample;
import com.dynamicpdf.api.examples.DlexLayoutExampleObject;
import com.dynamicpdf.api.examples.DlexLayoutExampleString;
import com.dynamicpdf.api.examples.ExtractText;
import com.dynamicpdf.api.examples.GetImageInfo;
import com.dynamicpdf.api.examples.GetPdfInfo;
import com.dynamicpdf.api.examples.GetXmpMetaData;
import com.dynamicpdf.api.examples.GoogleFontsExample;
import com.dynamicpdf.api.examples.ImageInfoExample;
import com.dynamicpdf.api.examples.MergePdfs;
import com.dynamicpdf.api.examples.PdfExample;
import com.dynamicpdf.api.examples.PdfHtmlCssWorkAroundExample;
import com.dynamicpdf.api.examples.PdfInfoExample;
import com.dynamicpdf.api.examples.PdfTextExample;
import com.dynamicpdf.api.examples.PdfXmpExample;
import com.dynamicpdf.api.examples.SplitPdf;
import com.dynamicpdf.api.examples.instructions.InstructionsExamples;
import com.dynamicpdf.api.examples.solutions.FormFieldFlattenAndRemove;
import com.dynamicpdf.api.examples.solutions.PdfBarcode;
import com.dynamicpdf.api.examples.solutions.SolutionImagesTextRecs;
import com.dynamicpdf.api.gettingStarted.GettingStartedInFive;


public class DynamicPdfCloudApiExamples {

	public static String BASE_DIR = "./src/main/resources";
	public static String OUTPUT_PATH = "./src/main/output";
	public static String API_KEY = "DP--api-key--";
	
    
    public static void main(String[] args) {
    	
    	FormFieldFlattenAndRemove.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/form-field-flatten/");
    	
    	SplitPdf.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/split-pdf/");
    	
    	PdfBarcode.Run(DynamicPdfCloudApiExamples.API_KEY);

    	SolutionImagesTextRecs.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/images-text-recs/");
    	
    	GettingStartedInFive.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/getting-started/");
    	AddBookmarks.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR +"/add-bookmarks/");
    	AsyncExample.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/async-example/");
    	CompletingAcroForm.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/fill-acro-form-pdf-endpoint/");
    	CreatingPdfDlexLayout.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/dlex-layout/");
    	DesignerReportTemplate.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/creating-a-report-template-designer/");
    	DlexLayoutExample.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/dlex-layout/");
    	DlexLayoutExampleObject.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/dlex-layout/");
    	DlexLayoutExampleString.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/dlex-layout/");
    	ExtractText.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/extract-text-pdf-text-endpoint/");
    	GetImageInfo.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/get-image-info-image-info-endpoint/");
    	GetPdfInfo.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/get-pdf-info-pdf-info-endpoint/");
    	GetXmpMetaData.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/get-xmp-metadata-pdf-xmp-endpoint/");
    	GoogleFontsExample.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/google-fonts/");
    	ImageInfoExample.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/image-info/");
    	MergePdfs.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/merge-pdfs-pdf-endpoint/");
    	PdfExample.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/pdf-example/");
    	PdfHtmlCssWorkAroundExample.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/users-guide/", DynamicPdfCloudApiExamples.OUTPUT_PATH);
    	PdfInfoExample.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/pdf-info/");
    	PdfTextExample.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/extract-text-pdf-text-endpoint/");
    	PdfXmpExample.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/get-xmp-metadata-pdf-xmp-endpoint/");
    	InstructionsExamples.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/users-guide/", DynamicPdfCloudApiExamples.OUTPUT_PATH);
    	
    	System.out.println("======= finished running examples ====");
    	
	}
}
