package com.dynamicpdf.api.examples.instructions;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.Aes256Security;

import com.dynamicpdf.api.DlexResource;
import com.dynamicpdf.api.DynamicPdfCloudApiExamples;
import com.dynamicpdf.api.Font;
import com.dynamicpdf.api.FormField;
import com.dynamicpdf.api.HtmlResource;
import com.dynamicpdf.api.ImageResource;
import com.dynamicpdf.api.LayoutDataResource;
import com.dynamicpdf.api.Outline;
import com.dynamicpdf.api.PageInput;
import com.dynamicpdf.api.PageOrientation;
import com.dynamicpdf.api.PageSize;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfInput;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.RgbColor;
import com.dynamicpdf.api.Template;
import com.dynamicpdf.api.elements.AztecBarcodeElement;
import com.dynamicpdf.api.elements.ElementPlacement;
import com.dynamicpdf.api.elements.PageNumberingElement;
import com.dynamicpdf.api.elements.TextElement;
import com.dynamicpdf.api.examples.reportobjects.SimpleReport;
import com.dynamicpdf.api.util.PrettyPrintUtility;
import com.fasterxml.jackson.databind.ObjectMapper;

public class InstructionsExamples {

	public static void printOut(Pdf pdf, String apiKey, String basePath, String outputFile) {
		pdf.setApiKey(apiKey);
		PdfResponse response = pdf.process();

		if (response.getErrorJson() != null) {
			System.out.println(PrettyPrintUtility.prettyPrintJSON(response.getErrorJson()));
		} else {
			System.out.println(PrettyPrintUtility.prettyPrintJSON(pdf.getInstructionsJson()));
			System.out.println("==================================================================");
			try {
				FileUtils.writeByteArrayToFile(new File(DynamicPdfCloudApiExamples.OUTPUT_PATH + "/" + outputFile), response.getContent());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		InstructionsExamples.Run(DynamicPdfCloudApiExamples.API_KEY, DynamicPdfCloudApiExamples.BASE_DIR, DynamicPdfCloudApiExamples.OUTPUT_PATH);
	}

	public static void Run(String apiKey, String basePath, String outputPath) {

		
		  Pdf exampleOne = InstructionsExamples.TopLevelMetaData();
		  InstructionsExamples.printOut(exampleOne, apiKey, outputPath,
		  "java-top-level-metadata-output.pdf"); 
		  
		  Pdf exampleTwo =
		  InstructionsExamples.FontsExample(basePath);
		  InstructionsExamples.printOut(exampleTwo, apiKey, outputPath,
		  "java-fonts-output.pdf");
		  
		  Pdf exampleThree = InstructionsExamples.SecurityExample(basePath);
		  InstructionsExamples.printOut(exampleThree, apiKey, outputPath,
		  "java-security-output.pdf");
		  
		  Pdf exampleFour = InstructionsExamples.MergeExample(basePath);
		  InstructionsExamples.printOut(exampleFour, apiKey, outputPath,
		  "java-merging-output.pdf");
		  
		  Pdf exampleFive = InstructionsExamples.FormFieldsExample(basePath);
		  InstructionsExamples.printOut(exampleFive, apiKey, outputPath,
		  "java-form-fields-output.pdf");
		  
		  Pdf exampleSix = InstructionsExamples.AddOutlinesForNewPdf();
		  InstructionsExamples.printOut(exampleSix, apiKey, outputPath,
		  "java-outline-create-output.pdf");
		  
		  Pdf exampleSeven = InstructionsExamples.AddOutlinesExistingPdf(basePath);
		  InstructionsExamples.printOut(exampleSeven, apiKey, outputPath,
		  "java-outline-existing-output.pdf");
		  
		  Pdf exampleEight = InstructionsExamples.TemplateExample(basePath);
		  InstructionsExamples.printOut(exampleEight, apiKey, outputPath,
		  "java-templates-output.pdf");
		  
		  Pdf exampleNine = InstructionsExamples.BarcodeExample(basePath);
		  InstructionsExamples.printOut(exampleNine, apiKey, outputPath,
		  "java-barcode-output.pdf");
		  
		  Pdf exampleTen = InstructionsExamples.DlexExample(basePath);
		  InstructionsExamples.printOut(exampleTen, apiKey, outputPath,
		  "java-dlex-output.pdf");
		  
		  Pdf exampleEleven = InstructionsExamples.DlexExampleObject(basePath);
		  InstructionsExamples.printOut(exampleEleven, apiKey, outputPath,
		  "java-dlex-object-output.pdf");
		  
		  Pdf exampleTwelve = InstructionsExamples.ImageExample(basePath);
		  InstructionsExamples.printOut(exampleTwelve, apiKey, outputPath,
		  "java-image-output.pdf");
		  
		  Pdf exampleThirteen = InstructionsExamples.PageExample(basePath);
		  InstructionsExamples.printOut(exampleThirteen, apiKey, outputPath,
		  "java-page-output.pdf");
		 
		
		Pdf exampleFourteen = InstructionsExamples.PdfExample(basePath);
		InstructionsExamples.printOut(exampleFourteen, apiKey, outputPath, "java-pdf-output.pdf");

		Pdf exampleFifteen = InstructionsExamples.HtmlExample(basePath);
		InstructionsExamples.printOut(exampleFifteen, apiKey, outputPath, "java-html-pdf-output.pdf");
		
	}

	public static Pdf PdfExample(String basePath) {

		Pdf pdf = new Pdf();

		// get pdf from local file system
		pdf.addPdf(new PdfResource(basePath + "DocumentA.pdf"));

		// get pdf from bytes
		PdfResource resource = null;
		try {
			resource = new PdfResource(Files.readAllBytes(Paths.get(basePath + "DocumentB.pdf")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		pdf.addPdf(resource);

		// get pdf from cloud storage
		pdf.addPdf("samples/users-guide-resources/DocumentC.pdf");
		return pdf;

	}

	public static Pdf PageExample(String basePath) {

		Pdf pdf = new Pdf();

		PageInput pageInput = pdf.addPage(1008, 612);
		PageNumberingElement pageNumberingElement = new PageNumberingElement("1", ElementPlacement.TOPRIGHT);
		pageNumberingElement.setColor(RgbColor.getRed());
		pageNumberingElement.setFont(Font.getCourier());
		pageNumberingElement.setFontSize(42);
		pageInput.getElements().add(pageNumberingElement);

		TextElement textElement = new TextElement("Hello from DynamicPDF Cloud API", ElementPlacement.BOTTOMCENTER);
		pageInput.getElements().add(textElement);

		return pdf;
	}

	public static Pdf ImageExample(String basePath) {

		Pdf pdf = new Pdf();
		// get image from local system
		ImageResource ir = new ImageResource(basePath + "A.png");
		pdf.addImage(ir);

		// get Image as binary from local system
		ImageResource ir2 = null;
		try {
			ir2 = new ImageResource(Files.readAllBytes(Paths.get(basePath + "B.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		pdf.addImage(ir2);
		// get image from cloud storage
		pdf.addImage("samples/users-guide-resources/C.png");
		return pdf;
	}

	public static Pdf DlexExample(String basePath) {

		Pdf pdf = new Pdf();

		// create pdf using local dlex and embedded image

		LayoutDataResource layoutDataResource = new LayoutDataResource(basePath + "SimpleReportWithCoverPage.json");
		DlexResource dlexResource = new DlexResource(basePath + "SimpleReportWithCoverPage.dlex");
		pdf.addDlex(dlexResource, layoutDataResource);
		pdf.addAdditionalResource(basePath + "/NorthwindLogo.gif");

		/// create pdf using cloud storage dlex and binary JSON data

		String jsonData = null;

		try {
			jsonData = Files.readString(Paths.get(basePath + "SimpleReportWithCoverPage.json"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		LayoutDataResource layoutData2 = new LayoutDataResource(jsonData);
		pdf.addDlex("samples/users-guide-resources/SimpleReportWithCoverPage.dlex", layoutData2);

		return pdf;
	}

	public static Pdf DlexExampleObject(String basePath) {

		String jsonText = null;
		SimpleReport simpleReport = null;

		Pdf pdf = new Pdf();

		try {

			jsonText = Files.readString(Paths.get(basePath + "/SimpleReportWithCoverPage.json"));

			// ObjectMapper instantiation
			ObjectMapper objectMapper = new ObjectMapper();

			// Deserialization into the `SimpleReport` class

			simpleReport = objectMapper.readValue(jsonText, SimpleReport.class);

			com.fasterxml.jackson.databind.ObjectMapper basicMapper = new ObjectMapper();

			System.out.println(basicMapper.writerWithDefaultPrettyPrinter().writeValueAsString(simpleReport));

			jsonText = basicMapper.writeValueAsString(simpleReport);

			try {
				jsonText = Files.readString(Paths.get(basePath + "SimpleReportWithCoverPage.json"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			LayoutDataResource layoutData = new LayoutDataResource(jsonText);
			pdf.addDlex("samples/users-guide-resources/SimpleReportWithCoverPage.dlex", layoutData);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return pdf;

	}

	public static Pdf HtmlExample(String basePath) {
		
		Pdf pdf = new Pdf();

		pdf.AddHtml("<html>An example HTML fragment.</html>", null, PageSize.LETTER, PageOrientation.PORTRAIT, 1F);

		// use basepath in an HTML string
		pdf.AddHtml("<html><p style='color:red;font-family:verdana;font-size:30px'>HTML with basePath.</p><img src='./images/logo.png'></img></html>",
				"https://www.dynamicpdf.com", PageSize.LETTER, PageOrientation.PORTRAIT, 1F);

		// add html from a path on local drive
		String temp = null;
		
		try {
			temp = Files.readString(Paths.get(basePath + "products.html"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		HtmlResource resource = new HtmlResource(temp);
		pdf.AddHtml(resource, null, PageSize.LETTER, PageOrientation.PORTRAIT, 1F);
		
		return pdf;
	}

	public static Pdf TopLevelMetaData() {

		// create a blank page

		Pdf pdf = new Pdf();
		pdf.addPage(1008, 612);

		// top level pdf document metadata

		pdf.setAuthor("John Doe");
		pdf.setKeywords("dynamicpdf api example pdf java instructions");
		pdf.setCreator("John Creator");
		pdf.setSubject("topLevel document metadata");
		pdf.setTitle("Sample PDF");
		return pdf;
	}

	public static Pdf FontsExample(String basePath) {

		// create a blank page

		Pdf pdf = new Pdf();

		PageInput pageInput = pdf.addPage(1008, 612);
		PageNumberingElement pageNumberingElement = new PageNumberingElement("A", ElementPlacement.TOPRIGHT);
		pageNumberingElement.setColor(RgbColor.getRed());
		pageNumberingElement.setFont(Font.getHelvetica());
		pageNumberingElement.setFontSize(42);

		String cloudResourceName = "old_samples/shared/font/Calibri.otf";

		PageNumberingElement pageNumberingElementTwo = new PageNumberingElement("B", ElementPlacement.TOPLEFT);
		pageNumberingElementTwo.setColor(RgbColor.getDarkOrange());
		pageNumberingElementTwo.setFont(new Font(cloudResourceName));
		pageNumberingElementTwo.setFontSize(32);

		String filePathFont = basePath + "cnr.otf";
		PageNumberingElement pageNumberingElementThree = new PageNumberingElement("C", ElementPlacement.TOPCENTER);
		pageNumberingElementThree.setColor(RgbColor.getGreen());
		pageNumberingElementThree.setFont(Font.fromFile(filePathFont));
		pageNumberingElementThree.setFontSize(42);

		pageInput.getElements().add(pageNumberingElement);
		pageInput.getElements().add(pageNumberingElementTwo);
		pageInput.getElements().add(pageNumberingElementThree);

		return pdf;
	}

	public static Pdf SecurityExample(String basePath) {
		String fileResource = basePath + "DocumentB.pdf";
		String userName = "myuser";
		String passWord = "mypassword";
		Pdf pdf = new Pdf();
		PdfResource pdfResource = new PdfResource(fileResource);
		pdf.addPdf(pdfResource);
		Aes256Security sec = new Aes256Security(userName, passWord);
		sec.setAllowCopy(false);
		sec.setAllowPrint(false);
		pdf.setSecurity(sec);
		return pdf;
	}

	public static Pdf MergeExample(String basePath) {
		Pdf pdf = new Pdf();
		PdfResource resourceA = new PdfResource(basePath + "DocumentA.pdf");
		ImageResource imageResource = new ImageResource(basePath + "DPDFLogo.png");
		PdfResource resourceB = new PdfResource(basePath + "DocumentB.pdf");
		pdf.addPdf(resourceA);
		pdf.addImage(imageResource);
		pdf.addPdf(resourceB);
		return pdf;
	}

	public static Pdf FormFieldsExample(String basePath) {
		Pdf pdf = new Pdf();
		pdf.addPdf(new PdfResource(basePath + "simple-form-fill.pdf"));
		FormField formField = new FormField("nameField", "DynamicPdf");
		FormField formField2 = new FormField("descriptionField", "RealTime Pdf's. Real FAST!");
		pdf.getFormFields().add(formField);
		pdf.getFormFields().add(formField2);
		return pdf;
	}

	public static Pdf AddOutlinesForNewPdf() {
		Pdf pdf = new Pdf();
		pdf.setAuthor("John Doe");
		pdf.setTitle("New Outline Sample Pdf");

		PageInput pageInput = pdf.addPage();
		TextElement element = new TextElement("Hello World 1", ElementPlacement.TOPCENTER);
		pageInput.getElements().add(element);

		PageInput pageInput1 = pdf.addPage();
		TextElement element1 = new TextElement("Hello World 2", ElementPlacement.TOPCENTER);
		pageInput1.getElements().add(element1);

		PageInput pageInput2 = pdf.addPage();
		TextElement element2 = new TextElement("Hello World 3", ElementPlacement.TOPCENTER);
		pageInput2.getElements().add(element2);

		Outline rootOutline = pdf.getOutlines().add("Root Outline");

		rootOutline.getChildren().add("Page 1", pageInput);
		rootOutline.getChildren().add("Page 2", pageInput1);
		rootOutline.getChildren().add("Page 3", pageInput2);
		return pdf;
	}

	public static Pdf AddOutlinesExistingPdf(String basePath) {

		Pdf pdf = new Pdf();
		PdfResource resource = new PdfResource(basePath + "AllPageElements.pdf");
		PdfInput input = pdf.addPdf(resource);
		input.setId("AllPageElements");
		pdf.getInputs().add(input);

		PdfResource resource1 = new PdfResource(basePath + "OutlineExisting.pdf");
		PdfInput input1 = pdf.addPdf(resource1);
		input1.setId("outlineDoc1");
		pdf.getInputs().add(input1);

		Outline rootOutline = pdf.getOutlines().add("Imported Outline");
		rootOutline.setExpanded(true);
		rootOutline.getChildren().addPdfOutlines(input);
		rootOutline.getChildren().addPdfOutlines(input1);
		return pdf;
	}

	public static Pdf TemplateExample(String basePath) {
		Pdf pdf = new Pdf();
		pdf.setAuthor("John User");
		pdf.setTitle("Template Example");
		PdfResource resource = new PdfResource(basePath + "DocumentA.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		TextElement element = new TextElement("Hello World", ElementPlacement.TOPCENTER);
		template.getElements().add(element);
		input.setTemplate(template);
		return pdf;
	}

	public static Pdf BarcodeExample(String basePath) {

		Pdf pdf = new Pdf();
		pdf.setAuthor("John Doe");
		pdf.setTitle("Barcode Example");

		PdfResource resource = new PdfResource(basePath + "DocumentA.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		Template template = new Template("Temp1");

		AztecBarcodeElement element = new AztecBarcodeElement("Hello World", ElementPlacement.TOPCENTER, 0, 500);
		template.getElements().add(element);
		input.setTemplate(template);
		return pdf;
	}

}
