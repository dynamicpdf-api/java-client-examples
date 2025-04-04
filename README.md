

![](./logo-banner2.png)

# java-client-examples

The Java Client Examples (`java-client-examples`) project uses the DynamicPDF API Java client library to create, merge, split, form fill, stamp, obtain metadata, convert, and secure/encrypt PDF documents.  This project contains numerous sample projects for the tutorials and examples at the [DynamicPDF API](https://dpdf.io/) website.

The DynamicPDF API consists of the following endpoints.

* `dlex-layout`
* `image-info`
* `pdf`
* `pdf-info`
* `pdf-text`
* `pdf-xmp`

For more information, please visit [DynamicPDF API](https://dpdf.io/ "DynamicPDF Cloud API Homepage"). Support for other languages/platforms (PHP, C#, Node.js) is available on GitHub ([DynamicPDF Cloud API at GitHub](https://github.com/dynamicpdf-api "DynamicPDF Cloud API at GitHub")).

### **`java-client` Client Library**

The `java-client-examples` project relies on the `java-client` library.

* Obtain the library from sonatype at [com.dynamicpdf.api](https://search.maven.org/search?q=g:com.dynamicpdf.api). There you will find the instructions for adding the `java-client` library to your project using Maven, Gradle, and other build systems.

```
<dependency>
  <groupId>com.dynamicpdf.api</groupId>
  <artifactId>dynamicpdf-api</artifactId>
  <version>1.5.0</version>
</dependency>
```

> :memo: *Be certain to use the latest java-client version.*

### **Apache Commons IO Library**

Many of the examples in this project also rely upon the Apache Commons IO library.

```xml
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.8.0</version>
</dependency>
```

### Maven

The examples project contains a sample Maven POM file for building the project. 

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.dynamicpdf.cloud.api.examples</groupId>
	<artifactId>dynamicpdf-api-examples</artifactId>
	<version>1.1.0</version>
	<description>DynamicPDF Cloud API Java client library examples.</description>
	<properties>
		<maven.compiler.source>1.8</maven.compiler.source>
		<maven.compiler.target>1.8</maven.compiler.target>
	</properties>
	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>com.dynamicpdf.api</groupId>
				<artifactId>dynamicpdf-api</artifactId>
				<version>1.5.0</version>
			</dependency>
			<dependency>
				<groupId>commons-io</groupId>
				<artifactId>commons-io</artifactId>
				<version>2.8.0</version>
			</dependency>
		</dependencies>
	</dependencyManagement>
	<dependencies>
		<dependency>
			<groupId>com.dynamicpdf.api</groupId>
			<artifactId>dynamicpdf-api</artifactId>
		</dependency>
		<dependency>
			<groupId>commons-io</groupId>
			<artifactId>commons-io</artifactId>
		</dependency>
	</dependencies>
</project>
```

* When first running any of the examples, be certain to first build the project using Maven so that your IDE pulls in all necessary dependencies. You can then run the examples for each tutorial independently from the command line.

## Running
Each example is designed to be run standalone.  However, you can run all the examples at once by running the `DynamicPdfCloudApiExamples` class in `DynamicPDFCloudApiExamples.java` file.

## Resources

To obtain the resources for the project, login to [dpdf.io](https://dpdf.io/) (assuming you have an account), and go to the **File Manager**. Use the `samples` folder to add the resources for the tutorial or example. Local resources are in the `resources` folder.

You need the following samples folder in your Cloud Storage space to run all the examples.

* samples/report-with-cover-page
* samples/creating-pdf-pdf-endpoint
* samples/creating-a-report-template-designer
* samples/creating-a-page-template-designer
* samples/dlex-layout
* samples/merge-pdfs-pdf-endpoint
* samples/fill-acro-form-pdf-endpoint
* samples/creating-a-page-template-designer
* samples/creating-pdf-dlex-layout-endpoint
* samples/image-info
* samples/blog-dynamic-columns

The local files are in the resources folder.

## Tutorials

The following table lists the available tutorials.

| Tutorial Title                                     | Project/File/Class      | Tutorial Location                                            |
| -------------------------------------------------- | ----------------------- | ------------------------------------------------------------ |
| Merging PDFs                                       | MergePdfs               | https://dpdf.io/docs/tutorials/cloud-api/merging-pdfs |
| Completing an AcroForm                             | `CompletingAcroForm`    | https://dpdf.io/docs/tutorials/cloud-api/form-completion |
| Creating a PDF Using a DLEX and the `pdf` Endpoint | `CreatingPdfDlex`       | https://dpdf.io/docs/tutorials/cloud-api/dlex-pdf-endpoint |
| Adding Bookmarks to a PDF                          | `AddBookmarks`          | https://dpdf.io/docs/tutorials/cloud-api/bookmarks |
| Creating a PDF Using the `dlex-layout` Endpoint    | `CreatingPdfDlexLayout` | https://dpdf.io/docs/tutorials/cloud-api/dlex-layout |
| Extracting Image Metadata                          | `GetImageInfo`          | https://dpdf.io/docs/tutorials/cloud-api/image-info |
| Extract PDF Metadata                               | `GetPdfInfo`            | https://dpdf.io/docs/tutorials/cloud-api/pdf-info |
| Extracting PDF's Text                              | `ExtractingText`        | https://dpdf.io/docs/tutorials/cloud-api/pdf-text |
| Extract XMP Metadata                               | `GetXmpMetaData`        | https://dpdf.io/docs/tutorials/cloud-api/pdf-xmp |

# Support

The primary source for the DynamicPDF Cloud API support is through [Stack Overflow](https://stackoverflow.com/questions/tagged/dynamicpdf-api). Please use the "[dynamicpdf-api](https://stackoverflow.com/questions/tagged/dynamicpdf-api)" tag to ask questions. Our support team actively monitors the tag and responds promptly to any questions.  Also, let us know you asked the question by following up with an email to [support@dynamicpdf.com](mailto:support@dynamicpdf.com). 

## Pro Plan Subscribers[#](https://dpdf.io/support#pro-plan-subscribers)

Ticket support is available to Pro Plan subscribers. But we still encourage you to help the community by posting on Stack Overflow when possible. You can also email [support@dynamicpdf.com](mailto:support@dynamicpdf.com) if you need to ask something specific to your use case that may not help the DynamicPDF Cloud API community.

# License

The `java-client-examples` library is licensed under the [MIT License](./LICENSE).
