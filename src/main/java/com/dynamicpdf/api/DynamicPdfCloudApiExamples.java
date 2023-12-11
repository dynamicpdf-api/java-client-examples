package com.dynamicpdf.api;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
import com.dynamicpdf.api.examples.instructions.InstructionsExamples;
import com.dynamicpdf.api.gettingStarted.GettingStartedInFive;


public class DynamicPdfCloudApiExamples {

	public static String BASE_DIR = "C://temp/dynamicpdf-api-samples";
	public static String USERS_GUIDE_RESOURCE_PATH = "c:/temp/dynamicpdf-api-samples/users-guide-resources/";
	public static String OUTPUT_PATH = "c:/temp/dynamicpdf-api-samples";
	public static String API_KEY = "DP.Tai26vtanTPXDVJz6Y1u0wOYAP6Mv3U/yOUU4wg1+2DtTJuCnCXz7NB1";

    
    
    public static void main(String[] args) {
  	
    	
    	try {
			URL resource = DynamicPdfCloudApiExamples.class.getClassLoader().getResource("./resources");
			String dir = resource.getPath();
			
			Path src = Paths.get(resource.toURI());
			Path dest = Paths.get(DynamicPdfCloudApiExamples.BASE_DIR);
			
			CopyFolder(src, dest);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

       	
    	
    	GettingStartedInFive.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/getting-started/");
    	AddBookmarks.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR +"/add-bookmarks/");
    	AsyncExample.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/async-example/");
    	CompletingAcroForm.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/fill-acro-form-pdf-endpoint/");
    	CreatePdfDlex.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/creating-pdf-pdf-endpoint/");
    	CreatingPdfDlexLayout.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/dlex-layout/");
    	DesignerReportTemplate.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/creating-a-report-template-designer/");
    	DlexLayoutExample.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/getting-started/");
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
    	PdfHtmlCssWorkAroundExample.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.USERS_GUIDE_RESOURCE_PATH, DynamicPdfCloudApiExamples.OUTPUT_PATH + "/users-guide-output/");
    	PdfInfoExample.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/pdf-info/");
    	PdfTextExample.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/extract-text-pdf-text-endpoint/");
    	PdfXmpExample.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/get-xmp-metadata-pdf-xmp-endpoint/");
    	InstructionsExamples.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.USERS_GUIDE_RESOURCE_PATH, DynamicPdfCloudApiExamples.OUTPUT_PATH + "/users-guide-output/");
    	
    	System.out.println("======= finished running examples ====");
    	
	}
    
    
	private static void CopyFolder(Path src, Path dest) throws Exception {
	    try {
	    	
	    	if(Files.exists(dest)) return;
	    	
	        Files.walk( src ).forEach( s -> {
	            try {
	                Path d = dest.resolve( src.relativize(s) );
	                if( Files.isDirectory( s ) ) {
	                    if( !Files.exists( d ) )
	                        Files.createDirectory( d );
	                    return;
	                }
	                Files.copy( s, d );
	            } catch( Exception e ) {
	                e.printStackTrace();
	            }
	        });
	    } catch( Exception ex ) {
	        ex.printStackTrace();
	        throw ex;
	    }
	}

}
