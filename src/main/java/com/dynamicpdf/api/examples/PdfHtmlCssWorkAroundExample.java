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
import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.HtmlResource;

public class PdfHtmlCssWorkAroundExample {

	public static void Run(String apiKey, String basePath, String outPath) {
		Pdf pdf = new Pdf();
		pdf.setApiKey(apiKey);

		// add html from a path on local drive
		String tempHtml = null;
		String tempCss = null;

		try {
			tempHtml = Files.readString(Paths.get(basePath + "example.html"));
			tempCss = Files.readString(Paths.get(basePath + "example.css"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		StringBuilder sb = new StringBuilder();
		sb.append(tempHtml.substring(0, tempHtml.indexOf("<link")));
		sb.append("<style>" + tempCss + "</style>");

		tempHtml = tempHtml.substring(tempHtml.indexOf("<link"), tempHtml.length());
		sb.append(tempHtml.substring(tempHtml.indexOf("/>") + 2));


		HtmlResource resource = new HtmlResource(sb.toString());
		pdf.addHtml(resource, null, PageSize.LETTER, PageOrientation.PORTRAIT, 1F);

		PdfResponse pdfResponse = pdf.process();

		try {
			FileUtils.writeByteArrayToFile(new File(DynamicPdfCloudApiExamples.OUTPUT_PATH + "/java-pdf-html-workaround-example-output.pdf"),
					pdfResponse.getContent());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		PdfHtmlCssWorkAroundExample.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR, DynamicPdfCloudApiExamples.OUTPUT_PATH);
	}

}
