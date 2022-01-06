package com.dynamicpdf.api.examples;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.FormField;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResponse;

public class CompletingAcroForm {

	//https://cloud.dynamicpdf.com/docs/tutorials/cloud-api/pdf-tutorial-form-completion
	
	public static void main(String[] args) {
		CompletingAcroForm.Run("DP.xxxx--api--key--xxx",
				"C:/temp/dynamicpdf-api-samples/fill-acro-form/");

	}

    public static void Run(String apiKey, String basePath)
    {
        // create new pdf instance and set api key
        Pdf pdf = new Pdf();
        pdf.setApiKey(apiKey);
        
        //add the uncompleted form as a resource from Resource Manager
        pdf.addPdf("samples/fill-acro-form-pdf-endpoint/fw9AcroForm_18.pdf");

        //fill out the form fields
        FormField formField = new FormField("topmostSubform[0].Page1[0].f1_1[0]", "Any Company, Inc.");
        FormField formField2 = new FormField("topmostSubform[0].Page1[0].f1_2[0]", "Any Company");
        FormField formField3 = new FormField("topmostSubform[0].Page1[0].FederalClassification[0].c1_1[0]", "1");
        FormField formField4 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_7[0]", "123 Main Street");
        FormField formField5 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_8[0]", "Washington, DC  22222");
        FormField formField6 = new FormField("topmostSubform[0].Page1[0].f1_9[0]", "Any Requester");
        FormField formField7 = new FormField("topmostSubform[0].Page1[0].f1_10[0]", "17288825617");
        FormField formField8 = new FormField("topmostSubform[0].Page1[0].EmployerID[0].f1_14[0]", "52");
        FormField formField9 = new FormField("topmostSubform[0].Page1[0].EmployerID[0].f1_15[0]", "1234567");

        //add the form fields to the pdf's FormFields array
        pdf.getFormFields().add(formField);
        pdf.getFormFields().add(formField2);
        pdf.getFormFields().add(formField3);
        pdf.getFormFields().add(formField4);
        pdf.getFormFields().add(formField5);
        pdf.getFormFields().add(formField6);
        pdf.getFormFields().add(formField7);
        pdf.getFormFields().add(formField8);
        pdf.getFormFields().add(formField9);

        //call the pdf endpoint and get response
        PdfResponse response = pdf.process();

		// if the response is successful, save merged pdf to file. if error, then
		// printout JSON error

		if (response.getIsSuccessful()) {
			try {
				FileUtils.writeByteArrayToFile(new File(basePath + "fill-acro-form-output.pdf"), 
						response.getContent());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(response.getErrorJson());
		}

    }
}
