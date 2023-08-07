package com.dynamicpdf.api.examples;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.DlexLayout;
import com.dynamicpdf.api.LayoutDataResource;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.examples.reportobjects.SimpleReport;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DlexLayoutExampleObject {

	public static void CreatePDF(String apiKey, String basePath, SimpleReport simpleReport) {

		LayoutDataResource layoutData = new LayoutDataResource(simpleReport);
		DlexLayout dlexEndpoint = new DlexLayout("samples/dlex-layout/SimpleReportWithCoverPage.dlex", layoutData);
		dlexEndpoint.setApiKey(apiKey);
		PdfResponse response = dlexEndpoint.process();

		if (response.getIsSuccessful() == true) {
			try {
				FileUtils.writeByteArrayToFile(new File(basePath + "/java-dlex-object-output.pdf"),
						(byte[]) response.getContent());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(response.getErrorJson());
		}
	}

	public static void main(String[] args) {
		SimpleReport simpleReport = DlexLayoutExampleObject
				.testJsonParsingAndReturnObject("c:/temp/dlex-layout-example");
		DlexLayoutExampleObject.CreatePDF("DP.xxxx--api--key--xxx", "c:/temp/dlex-layout-example", simpleReport);
	}

	public static SimpleReport testJsonParsingAndReturnObject(String basePath) {

		String jsonText = null;
		SimpleReport simpleReport = null;

		try {
			jsonText = Files.readString(Paths.get(basePath + "/SimpleReportWithCoverPage.json"));
			jsonText = jsonText.trim().replaceAll("[\uFEFF-\uFFFF]", "");

			// ObjectMapper instantiation
			ObjectMapper objectMapper = new ObjectMapper();

			// Deserialization into the `SimpleReport` class

			simpleReport = objectMapper.readValue(jsonText, SimpleReport.class);

			ObjectMapper basicMapper = new ObjectMapper();

			System.out.println(basicMapper.writerWithDefaultPrettyPrinter().writeValueAsString(simpleReport));

			jsonText = basicMapper.writeValueAsString(simpleReport);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return simpleReport;

	}

}
