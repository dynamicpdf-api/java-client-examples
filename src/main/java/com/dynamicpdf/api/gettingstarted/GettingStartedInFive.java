package com.dynamicpdf.api.gettingstarted;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.LayoutDataResource;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResponse;

public class GettingStartedInFive {

	public static void main(String[] args) {
        Pdf pdf = new Pdf();
        pdf.setApiKey("DP.poEtD7F5tD1Ulp3qPcolUFaCcQFxWOvuNUqm/WragUdOSaAesnu3L6XE");
        pdf.setAuthor("John Doe");
        pdf.setTitle("Getting Started In Five Minutes");
        LayoutDataResource layoutDataResource = new LayoutDataResource("C:/holding/instructions-examples/getting-started-data.json");
        pdf.addDlex("samples/shared/dlex/getting-started.dlex", layoutDataResource);
        PdfResponse pdfResponse = pdf.process();
	    
        try {
			FileUtils.writeByteArrayToFile(new File("C:/holding/instructions-examples/getting-started-output.pdf"), 
					pdfResponse.getContent());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
