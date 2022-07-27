

![](./logo-banner2.png)

# java-client-examples

The Java Client Examples (`java-client-examples`) project uses the DynamicPDF Cloud API Java client library to create, merge, split, form fill, stamp, obtain metadata, convert, and secure/encrypt PDF documents.  This project contains numerous sample projects for the tutorials and examples at the [DynamicPDF Cloud API](https://cloud.dynamicpdf.com/) website.

The DynamicPDF Cloud API consists of the following endpoints.

* `dlex-layout`
* `image-info`
* `pdf`
* `pdf-info`
* `pdf-text`
* `pdf-xmp`

For more information, please visit [DynamicPDF Cloud API](https://cloud.dynamicpdf.com/ "DynamicPDF Cloud API Homepage"). Support for other languages/platforms (PHP, C#, Node.js) is available on GitHub ([DynamicPDF Cloud API at GitHub](https://github.com/dynamicpdf-api "DynamicPDF Cloud API at GitHub")).

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

| Tutorial Title                                     | Project/File/Class      | Tutorial Location                                            |
| -------------------------------------------------- | ----------------------- | ------------------------------------------------------------ |
| Merging PDFs                                       | MergePdfs               | https://cloud.dynamicpdf.com/docs/tutorials/cloud-api/merging-pdfs |
| Completing an AcroForm                             | `CompletingAcroForm`    | https://cloud.dynamicpdf.com/docs/tutorials/cloud-api/form-completion |
| Creating a PDF Using a DLEX and the `pdf` Endpoint | `CreatingPdfDlex`       | https://cloud.dynamicpdf.com/docs/tutorials/cloud-api/dlex-pdf-endpoint |
| Adding Bookmarks to a PDF                          | `AddBookmarks`          | https://cloud.dynamicpdf.com/docs/tutorials/cloud-api/bookmarks |
| Creating a PDF Using the `dlex-layout` Endpoint    | `CreatingPdfDlexLayout` | https://cloud.dynamicpdf.com/docs/tutorials/cloud-api/dlex-layout |
| Extracting Image Metadata                          | `GetImageInfo`          | https://cloud.dynamicpdf.com/docs/tutorials/cloud-api/image-info |
| Extract PDF Metadata                               | `GetPdfInfo`            | https://cloud.dynamicpdf.com/docs/tutorials/cloud-api/pdf-info |
| Extracting PDF's Text                              | `ExtractingText`        | https://cloud.dynamicpdf.com/docs/tutorials/cloud-api/pdf-text |
| Extract XMP Metadata                               | `GetXmpMetaData`        | https://cloud.dynamicpdf.com/docs/tutorials/cloud-api/pdf-xmp |

# Support

The primary source for the DynamicPDF Cloud API support is through [Stack Overflow](https://stackoverflow.com/questions/tagged/dynamicpdf-api). Please use the "[dynamicpdf-api](https://stackoverflow.com/questions/tagged/dynamicpdf-api)" tag to ask questions. Our support team actively monitors the tag and responds promptly to any questions.  Also, let us know you asked the question by following up with an email to [support@dynamicpdf.com](mailto:support@dynamicpdf.com). 

## Pro Plan Subscribers[#](https://cloud.dynamicpdf.com/support#pro-plan-subscribers)

Ticket support is available to Pro Plan subscribers. But we still encourage you to help the community by posting on Stack Overflow when possible. You can also email [support@dynamicpdf.com](mailto:support@dynamicpdf.com) if you need to ask something specific to your use case that may not help the DynamicPDF Cloud API community.

# License

The `java-client-examples` library is licensed under the [MIT License](./LICENSE).