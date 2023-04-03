package com.dynamicpdf.api.examples;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import com.dynamicpdf.api.PageOrientation;
import com.dynamicpdf.api.PageSize;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.HtmlResource;

public class PdfHtmlExample {

    public static void Run(String apiKey, String basePath)
    {
        Pdf pdf = new Pdf();
        pdf.setApiKey(apiKey);

        pdf.AddHtml("<html><p>This is a test.</p></html>", null, PageSize.A4, PageOrientation.LANDSCAPE, 10f);
        String htmlString = null;
        try {
            htmlString = Files.lines(Paths.get(basePath + "HtmlWithAllTags.html"), StandardCharsets.UTF_8)
                      .collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException ex) {
            System.out.println("Exception: " + ex);
        }

        HtmlResource resource = new HtmlResource(htmlString);
        //HtmlResource resource = new HtmlResource(FileUtils.readFileToString(new File(basePath + "HtmlWithAllTags.html"), "UTF_8"));
        pdf.AddHtml(resource, null, PageSize.A4, PageOrientation.PORTRAIT, 10f);

        pdf.AddHtml("<html><img src='./images/logo.png'></img></html>", "https://www.dynamicpdf.com", PageSize.A4, PageOrientation.PORTRAIT, 0f);

		PdfResponse response = pdf.process();
        try {
			FileUtils.writeByteArrayToFile(new File(basePath + "html-output-java.pdf"), response.getContent());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
	public static void main(String[] args) {
		PdfHtmlExample.Run("DP.xxx-api-key-xxx",
		"C:/temp/dynamicpdf-api-samples/html-pdf/");
	}

}
