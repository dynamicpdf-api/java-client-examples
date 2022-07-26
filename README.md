

![](./logo-banner2.png)

***

# java-client-examples

The Java Client Examples project uses the DynamicPDF Cloud API Java client library to create, merge, split, form fill, stamp, obtain metadata, convert, and secure/encrypt PDF documents.  This project contains numerous sample projects for the tutorials and examples on [cloud.dynamicpdf.com](cloud.dynamicpdf.com). 

The DynamicPDF Cloud API consists of the following endpoints.

* `dlex-layout`
* `image-info`
* `pdf`
* `pdf-info`
* `pdf-text`
* `pdf-xmp`

The Java client project is available on Github ([java-client](https://github.com/dynamicpdf-api/java-client)). For more information, please visit [DynamicPDF Cloud API](https://cloud.dynamicpdf.com/ "DynamicPDF Cloud API Homepage"). Support for other languages/platforms (PHP, C#, Node.js) is available on GitHub ([DynamicPDF Cloud API at GitHub](https://github.com/dynamicpdf-api "DynamicPDF Cloud API at GitHub")).

## Repository

* The Java client project source is available on Github ([java-client](https://github.com/dynamicpdf-api/java-client)). 

### **Available on Maven**

https://search.maven.org/search?q=g:com.dynamicpdf.api

```xml
<dependency>
    <groupId>com.dynamicpdf.api</groupId>
    <artifactId>dynamicpdf-api</artifactId>
    <version>1.1.0</version>
</dependency>
```

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

The examples project contains a Maven POM file for building the project. 

> :memo: *Note that the dynamicpdf-api artifact is probably different than the version in the example POM, be certain to use the correct version when building the examples project.*

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.dynamicpdf.cloud.api.examples</groupId>
	<artifactId>dynamicpdf-api-examples</artifactId>
	<version>0.0.1-SNAPSHOT</version>
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
				<version>0.9.0</version>
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

## Resources

To obtain the resources for the project, login to [cloud.dynamicpdf.com](cloud.dynamicpdf.com) (assuming you have an account), and go to the **Resource Manager**. Use the `samples` folder to add the resources for the tutorials and examples from this project.

- [Resource Manager Samples](https://cloud.dynamicpdf.com/docs/usersguide/environment-manager/environment-manager-sample-resources)  

## Tutorials

For more information on the tutorials and example code, refer to:

- https://cloud.dynamicpdf.com/docs/tutorials/tutorials-overview
- https://cloud.dynamicpdf.com/docs/usersguide/cloud-api/cloud-api-overview

* The following table lists the tutorials provided by DynamicPDF Cloud API that illustrate using the API's endpoints.

| Tutorial                                                     | Endpoint/Tool | Sample Project                              | Description                                                  |
| ------------------------------------------------------------ | ------------- | ------------------------------------------- | ------------------------------------------------------------ |
| [Merging PDFs](./cloud-api/merging-pdfs)                     | `pdf`         | Merge PDFs (pdf endpoint)                   | Use the `pdf` endpoint to merge three pre-existing `pdf` documents. |
| [Completing an Acroform](./cloud-api/form-completion)        | `pdf`         | Fill an Acroform (pdf endpoint)             | Use the `pdf` endpoint to fill-out a pre-existing PDF form with values and save the resulting PDF. |
| [Creating a PDF from DLEX (`pdf` Endpoint)](./cloud-api/dlex-pdf-endpoint) | `pdf`         | Create a PDF (pdf endpoint)                 | Use the `pdf` endpoint to generate a PDF report using DLEX. Then merge two PDF documents and then append the merged PDFs to the PDF created using the DLEX report. |
| [Adding Bookmarks to a PDF](./cloud-api/bookmarks)           | `pdf`         | Add Bookmarks (pdf endpoint)                | Use the Outline element in JSON instructions with the `pdf` endpoint to create a PDF that includes bookmarks. |
| [Creating a PDF from DLEX (`dlex-layout` Endpoint)](./cloud-api/dlex-layout) | `dlex-layout` | Create a PDF (dlex-layout endpoint)         | Use the `dlex-layout` endpoint to create PDF reports dynamically on the cloud. |
| [Get Image Metadata](./cloud-api/image-info)                 | `image-info`  | Get Image Information (image-info endpoint) | Use the `image-info` endpoint to get metadata describing an image. |
| [Extract PDF Metadata](./cloud-api/pdf-info)                 | `pdf-info`    | Get PDF Information (pdf-info endpoint)     | The `pdf-info` endpoint returns metadata from a PDF document. |
| [Extract PDF Text](./cloud-api/pdf-text)                     | `pdf-text`    | Extract Text (pdf-text endpoint)            | Extract text from PDF documents using the `pdf-text` endpoint. |
| [Extract XMP Metadata](./cloud-api/pdf-xmp)                  | `pdf-xmp`     | Get XMP Metadata (pdf-xmp endpoint)         | Extract XMP meta-data from PDF documents using the `pdf-xmp` endpoint. |