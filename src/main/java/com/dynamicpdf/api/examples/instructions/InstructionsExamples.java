package com.dynamicpdf.api.examples.instructions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.Aes256Security;
import com.dynamicpdf.api.Font;
import com.dynamicpdf.api.FormField;
import com.dynamicpdf.api.ImageResource;
import com.dynamicpdf.api.Outline;
import com.dynamicpdf.api.PageInput;
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
import com.dynamicpdf.api.util.PrettyPrintUtility;

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
				FileUtils.writeByteArrayToFile(new File(basePath + "/output/" + outputFile), response.getContent());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		String apiKey = "DP.xxx--api-key--xxx";
		String basePath = "c:/temp/dynamicpdf-api-usersguide-examples/";

		Pdf exampleOne = InstructionsExamples.TopLevelMetaData();
		InstructionsExamples.printOut(exampleOne, apiKey, basePath, "java-top-level-metadata-output.pdf");
		Pdf exampleTwo = InstructionsExamples.FontsExample(basePath);
		InstructionsExamples.printOut(exampleTwo, apiKey, basePath, "java-fonts-output.pdf");

		Pdf exampleThree = InstructionsExamples.SecurityExample(basePath);
		InstructionsExamples.printOut(exampleThree, apiKey, basePath, "java-security-output.pdf");

		Pdf exampleFour = InstructionsExamples.MergeExample(basePath);
		InstructionsExamples.printOut(exampleFour, apiKey, basePath, "java-merging-output.pdf");

		Pdf exampleFive = InstructionsExamples.FormFieldsExample(basePath);
		InstructionsExamples.printOut(exampleFive, apiKey, basePath, "java-form-output.pdf");

		Pdf exampleSix = InstructionsExamples.AddOutlinesForNewPdf();
		InstructionsExamples.printOut(exampleFive, apiKey, basePath, "java-outline-create-output.pdf");

		Pdf exampleSeven = InstructionsExamples.AddOutlinesExistingPdf(basePath);
		InstructionsExamples.printOut(exampleSix, apiKey, basePath, "java-outline-existing-output.pdf");

		Pdf exampleEight = InstructionsExamples.TemplateExample(basePath);
		InstructionsExamples.printOut(exampleEight, apiKey, basePath, "java-templates-output.pdf");

		Pdf exampleNine = InstructionsExamples.BarcodeExample(basePath);
		InstructionsExamples.printOut(exampleNine, apiKey, basePath, "java-barcode-output.pdf");

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

		String filePathFont = basePath + "/cnr.otf";
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
		String fileResource = basePath + "/DocumentB.pdf";
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
		ImageResource imageResource = new ImageResource(basePath + "dynamicpdfLogo.png");
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
		PdfResource resource = new PdfResource(basePath + "/DocumentA.pdf");
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

		PdfResource resource = new PdfResource(basePath + "/DocumentA.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		Template template = new Template("Temp1");

		AztecBarcodeElement element = new AztecBarcodeElement("Hello World", ElementPlacement.TOPCENTER, 0, 500);
		template.getElements().add(element);
		input.setTemplate(template);
		return pdf;
	}

}
