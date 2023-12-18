package com.dynamicpdf.api.examples;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.FormField;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResponse;

public class CompletingAcroForm {

	public static void main(String[] args) {
		CompletingAcroForm.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR + "/fill-acro-form-pdf-endpoint/");
	}
	
	public static void Run(String apiKey, String basePath) {
		
		Pdf pdf = new Pdf();
		pdf.setApiKey(apiKey);
		pdf.addPdf("samples/fill-acro-form-pdf-endpoint/fw9AcroForm_18.pdf");
		
		FormField formField = new FormField("topmostSubform[0].Page1[0].f1_1[0]", "Any Company, Inc.");
        FormField formField1 = new FormField("topmostSubform[0].Page1[0].f1_2[0]", "Any Company");
        FormField formField2 = new FormField("topmostSubform[0].Page1[0].FederalClassification[0].c1_1[0]", "1");
        FormField formField3 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_7[0]", "123 Main Street");
        FormField formField4 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_8[0]", "Washington, DC  22222");
        FormField formField5 = new FormField("topmostSubform[0].Page1[0].f1_9[0]", "Any Requester");
        FormField formField6 = new FormField("topmostSubform[0].Page1[0].f1_10[0]", "17288825617");
        FormField formField7 = new FormField("topmostSubform[0].Page1[0].EmployerID[0].f1_14[0]", "52");
        FormField formField8 = new FormField("topmostSubform[0].Page1[0].EmployerID[0].f1_15[0]", "1234567");
		
        pdf.getFormFields().add(formField);
        pdf.getFormFields().add(formField1);
        pdf.getFormFields().add(formField2);
        pdf.getFormFields().add(formField3);
        pdf.getFormFields().add(formField4);
        pdf.getFormFields().add(formField5);
        pdf.getFormFields().add(formField6);
        pdf.getFormFields().add(formField7);
        pdf.getFormFields().add(formField8);
        
        PdfResponse response = pdf.process();
        
        if(response.getIsSuccessful()) {
        	try {
				FileUtils.writeByteArrayToFile(new File(DynamicPdfCloudApiExamples.OUTPUT_PATH + "/fill-acro-form-java-output.pdf"), response.getContent());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else {
        	System.out.println(response.getErrorJson());
        }
        
	}

}
