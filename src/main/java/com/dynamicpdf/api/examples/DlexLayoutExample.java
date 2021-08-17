package com.dynamicpdf.api.examples;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.DlexLayout;
import com.dynamicpdf.api.LayoutDataResource;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.util.PrettyPrintUtility;

public class DlexLayoutExample {

    public static void DlexLayoutExampleOne(String apiKey, String basePath)
    {
        LayoutDataResource layoutData = new LayoutDataResource(basePath + "/AllReportElementsData.json");
        DlexLayout dlexEndpoint = new DlexLayout("samples/getting-started/AllReportElements.dlex", layoutData);
        dlexEndpoint.setApiKey(apiKey);
        PdfResponse response = dlexEndpoint.process();
        if (response.getErrorJson() == null)
        {
        	try {
				FileUtils.writeByteArrayToFile(new File(basePath + "/dlex-output.pdf"), (byte[])response.getContent());
			} catch (IOException e) {
				e.printStackTrace();
			}
        } else
        {        	
        	System.out.println(PrettyPrintUtility.prettyPrintJSON(response.getErrorJson()));
        }
    }
}
