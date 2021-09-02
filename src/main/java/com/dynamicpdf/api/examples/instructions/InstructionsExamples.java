package com.dynamicpdf.api.examples.instructions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.dynamicpdf.api.Aes256Security;
import com.dynamicpdf.api.DlexResource;
import com.dynamicpdf.api.Font;
import com.dynamicpdf.api.FormField;
import com.dynamicpdf.api.GoToAction;
import com.dynamicpdf.api.ImageResource;
import com.dynamicpdf.api.LayoutDataResource;
import com.dynamicpdf.api.Outline;
import com.dynamicpdf.api.PageInput;
import com.dynamicpdf.api.PageZoom;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfInput;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.RgbColor;
import com.dynamicpdf.api.elements.ElementPlacement;
import com.dynamicpdf.api.elements.PageNumberingElement;
import com.dynamicpdf.api.elements.TextElement;
import com.dynamicpdf.api.util.PrettyPrintUtility;

public class InstructionsExamples {
	
			public static Pdf MergeOptions(String basePath)
	        {
				String cloudResource = "samples/shared/pdf/documentA.pdf";
				String fileResource = basePath + "/documentB.pdf";

				// add pdf from cloud resources

				Pdf pdf = new Pdf();
				pdf.addPdf(cloudResource);

				// add pdf from local file path

				PdfResource pdfResource = new PdfResource(fileResource);
				pdf.addPdf(pdfResource);
				return pdf;
			}

			public static Pdf MergingExample(String basePath)
			{

				String cloudResource = "samples/shared/pdf/documentA.pdf";
				String fileResource = basePath + "/documentB.pdf";

				// add pdf from cloud resources

				Pdf pdf = new Pdf();
				pdf.addPdf(cloudResource);

				// add pdf from local file path

				PdfResource pdfResource = new PdfResource(fileResource);
				pdf.addPdf(pdfResource);

				// add blank page to pdf

				PageInput pageInput = pdf.addPage(1008, 612);

				// add image to pdf from cloud api

				pdf.addImage("samples/shared/image/Image3.png");

				// add image to pdf from local file system

				ImageResource imageResource = new ImageResource(basePath + "/Image1.jpg");
				pdf.addImage(imageResource);

				// add dlex to pdf from cloud

				LayoutDataResource layoutData = new LayoutDataResource(basePath + "/getting-started-data.json");
				pdf.addDlex("samples/getting-started/getting-started.dlex", layoutData);

				// add dlex to pdf from local

				DlexResource dlexResource = new DlexResource(basePath + "/example-two.dlex");
				layoutData = new LayoutDataResource(basePath + "/example-two.json");
				pdf.addDlex(dlexResource, layoutData);

				return pdf;

			}


			public static Pdf topLevelMetaData()
			{

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

			public static Pdf FontsExample(String basePath)
			{

				// create a blank page

				Pdf pdf = new Pdf();

				PageInput pageInput = pdf.addPage(1008, 612);
				PageNumberingElement pageNumberingElement =
					new PageNumberingElement("A", ElementPlacement.TOPRIGHT);
				pageNumberingElement.setColor(RgbColor.getRed());
				pageNumberingElement.setFont(Font.getHelvetica());
				pageNumberingElement.setFontSize(42);

				String cloudResourceName = "samples/shared/Calibri.otf";

				PageNumberingElement pageNumberingElementTwo = new PageNumberingElement("B", ElementPlacement.TOPLEFT);
				pageNumberingElementTwo.setColor(RgbColor.getDarkOrange());
				pageNumberingElementTwo.setFont(new Font(cloudResourceName));
				pageNumberingElementTwo.setFontSize(32);


				String filePathFont = basePath + "/cnr.otf";
				PageNumberingElement pageNumberingElementThree = new PageNumberingElement("C", ElementPlacement.TOPCENTER);
				pageNumberingElementThree.setColor(RgbColor.getGreen());
				pageNumberingElementThree.setFont( Font.fromFile(filePathFont));
				pageNumberingElementThree.setFontSize(42);

				pageInput.getElements().add(pageNumberingElement);
				pageInput.getElements().add(pageNumberingElementTwo);
				pageInput.getElements().add(pageNumberingElementThree);


				return pdf;
			}

			public static Pdf FormFieldsExample()
			{
				Pdf pdf = new Pdf();
				pdf.addPdf("samples/shared/simple-form-fill.pdf");


				FormField formField = new FormField("nameField", "DynamicPdf");
				FormField formField2 = new FormField("descriptionField", "RealTime Pdf's. Real FAST!");

				pdf.getFormFields().add(formField);
				pdf.getFormFields().add(formField2);

				return pdf;
			}


			public static Pdf SecurityExample(String basePath)
			{
				String fileResource = basePath + "/documentB.pdf";
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
			
			
			public static Pdf AddOutlinesExistingPdf(String basePath) {
				Pdf pdf = new Pdf();
				pdf.setAuthor("John Doe");
				pdf.setTitle("Existing Pdf Example");

				PdfResource resource = new PdfResource(basePath + "/AllPageElements.pdf");
				PdfInput input = pdf.addPdf(resource);
				input.setId("AllPageElements"_;
				pdf.getInputs().add(input);

				PdfResource resource1 = new PdfResource(basePath + "/outline-existing.pdf");
				PdfInput input1 = pdf.addPdf(resource1);
				input1.setId("outlineDoc1");
				pdf.getInputs().add(input1);

				Outline rootOutline = pdf.getOutlines().add("Imported Outline");
				rootOutline.setExpanded(true);

				rootOutline.getChildren().addPdfOutlines(input);
				rootOutline.getChildren().addPdfOutlines(input1);

				return pdf;

			}
			
			
			
			  public static Pdf AddOutlinesForNewPdf()
		        {
		            String name = "TextElement";
		            Pdf pdf = new Pdf();
		            pdf.setAuthor("John Doe");
		            pdf.setTitle("Sample Pdf");

		            PageInput pageInput = pdf.addPage();
		            pageInput.setId("page1");
		            TextElement element = new TextElement("Hello World 1", ElementPlacement.TOPCENTER);
		            pageInput.getElements().add(element);

		            PageInput pageInput1 = pdf.addPage();
		            pageInput1.setId("page2");
		            TextElement element1 = new TextElement("Hello World 2", ElementPlacement.TOPCENTER);
		            pageInput1.getElements().add(element1);

		            PageInput pageInput2 = pdf.addPage();
		            pageInput2.setId("page3");
		            TextElement element2 = new TextElement("Hello World 3", ElementPlacement.TOPCENTER);
		            pageInput2.getElements().add(element2);


		            Outline rootOutline = new Outline("Root Outline");
		            rootOutline.setExpanded(true);

		            Outline outline = new Outline("Page 1");
		            outline.setExpanded(true);
		            GoToAction linkTo = new GoToAction(pageInput);
		            outline.setAction(linkTo);

		            Outline outline2 = new Outline("Page 2");
		            outline2.setExpanded(true);
		            GoToAction linkTo1 = new GoToAction(pageInput1);
		            outline2.setAction(linkTo1);

		            Outline outline3 = new Outline("Page 3");
		            outline3.setExpanded(true);
		            GoToAction linkTo3 = new GoToAction(pageInput2);
		            outline3.setAction(linkTo3);

		            rootOutline.getChildren().add(outline);
		            rootOutline.getChildren().add(outline2);
		            rootOutline.getChildren().add(outline3);

		            pdf.getOutlines().add(rootOutline);

		            return pdf;
		        }

			

			public static void printOut(Pdf pdf, String apiKey, String basePath, String outputFile)
			{
				pdf.setApiKey(apiKey);
				PdfResponse response = pdf.process();

				if (response.getErrorJson() != null)
				{
					System.out.println(PrettyPrintUtility.prettyPrintJSON(response.getErrorJson()));
				}
				else
				{
					System.out.println(PrettyPrintUtility.prettyPrintJSON(pdf.buildJsonInstructions()));
					System.out.println("==================================================================");
				       try {
							FileUtils.writeByteArrayToFile(new File(basePath + "/output/" + outputFile), response.getContent());
						} catch (IOException e) {
							e.printStackTrace();
						}
				}
			}
			
			
	public static void main(String[] args) {
		
		Pdf exampleOne = InstructionsExamples.topLevelMetaData();
		InstructionsExamples.printOut(exampleOne, args[0], args[1], "java-top-level-metadata.pdf");
		Pdf exampleTwo = InstructionsExamples.SecurityExample(args[1]);
		InstructionsExamples.printOut(exampleTwo, args[0], args[1], "java-security.pdf");
		Pdf exampleThree = InstructionsExamples.MergingExample(args[1]);
		InstructionsExamples.printOut(exampleThree, args[0], args[1], "java-merging.pdf");
		Pdf exampleFour = InstructionsExamples.FormFieldsExample();
		InstructionsExamples.printOut(exampleFour, args[0], args[1], "java-fonts.pdf");
		Pdf exampleFive = InstructionsExamples.AddOutlinesForNewPdf();
		InstructionsExamples.printOut(exampleFive, args[0], args[1], "java-outline-create.pdf");
		Pdf exampleSix = InstructionsExamples.AddOutlinesExistingPdf(args[1]);
		InstructionsExamples.printOut(exampleSix, args[0], args[1], "java-outline-existing.pdf");
	}

}
