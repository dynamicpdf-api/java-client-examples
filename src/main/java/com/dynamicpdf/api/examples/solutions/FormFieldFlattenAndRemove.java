package com.dynamicpdf.api.examples.solutions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.FormField;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfInput;
import com.dynamicpdf.api.PdfResource;


public class FormFieldFlattenAndRemove {

	public static void main(String[] args) {
		FormFieldFlattenAndRemove.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/form-field-flatten/");
	}

	public static void Run(String apiKey, String basePath)
	{
	    Pdf pdf = new Pdf();
	    pdf.setApiKey(apiKey);

	    PdfResource resource = new PdfResource(basePath + "fw9AcroForm_14.pdf");
	    PdfInput input = new PdfInput(resource);
	    pdf.getInputs().add(input);

	    FormField field = new FormField("topmostSubform[0].Page1[0].f1_1[0]", "Any Company, Inc.");
	    field.setFlatten(true);
	    pdf.getFormFields().add(field);

	    FormField field1 = new FormField("topmostSubform[0].Page1[0].f1_2[0]", "Any Company");
	    field1.setRemove(true);
	    pdf.getFormFields().add(field1);

	    FormField field2 = new FormField("topmostSubform[0].Page1[0].FederalClassification[0].c1_1[0]", "1");
	    field2.setFlatten(true);
	    pdf.getFormFields().add(field2);

	    FormField field3 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_7[0]", "123 Main Street");
	    field3.setFlatten(false);
	    pdf.getFormFields().add(field3);

	    FormField field4 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_8[0]", "Washington, DC  22222");
	    field4.setRemove(true);
	    pdf.getFormFields().add(field4);

	    FormField field5 = new FormField("topmostSubform[0].Page1[0].f1_9[0]", "Any Requester");
	    field5.setRemove(true);
	    pdf.getFormFields().add(field5);

		PdfResponse response = pdf.process();
		
		if(response.getIsSuccessful())
		{
			try {
				FileUtils.writeByteArrayToFile(new File(DynamicPdfCloudApiExamples.OUTPUT_PATH + "/form-flatten-delete-output.pdf"),
						response.getContent());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else
		{
			System.out.println(response.getErrorJson());
		}
	}
}
