package com.dynamicpdf.api.gettingstarted;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.FormField;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.util.PrettyPrintUtility;

public class SimpleFormFillExample {

	public static void FormFill(String apiKey, String basePath) {
		Pdf pdf = new Pdf();
		pdf.addPdf("samples/shared/pdf/simple-form-fill.pdf");

		FormField formField = new FormField("nameField", "DynamicPDF");
		FormField formField2 = new FormField("descriptionField", "DynamicPDF CloudAPI. RealTime PDFs, Real FAST!");

		pdf.getFormFields().add(formField);
		pdf.getFormFields().add(formField2);
		pdf.setApiKey(apiKey);
		PdfResponse response = pdf.process();

		if (response.getIsSuccessful() == true) {
			try {
				FileUtils.writeByteArrayToFile(new File(basePath + "/simple-form-fill-output.pdf"),
						(byte[]) response.getContent());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(PrettyPrintUtility.prettyPrintJSON(response.getErrorJson()));
		}
	}

	public static void main(String[] args) {
		SimpleFormFillExample.FormFill(args[0], args[1]);
	}

}
