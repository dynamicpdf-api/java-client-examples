# java-client-examples

The project contains numerous sample projects for the tutorials and examples on cloud.dynamicpdf.com. Each example project is designed to run independently. All resources can be found on the cloud.dynamicpdf.com website.

- **This project contains the tutorials and examples from [cloud.dynamicpdf.com](https://cloud.dynamicpdf.com)**

## Repository

The client library jar and client library source jar are available online.

**Available on Maven**

https://search.maven.org/search?q=g:com.dynamicpdf.api

```xml
<dependency>
    <groupId>com.dynamicpdf.api</groupId>
    <artifactId>dynamicpdf-api</artifactId>
    <version>1.0.0</version>
</dependency>
```

**Apache Commons IO Library**

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

## Resources

To obtain the resources for the project, login to cloud.dynamicpdf.com (assuming you have an account), and go to the **Resource Manager**. You use the `samples` folder to add the resources for the tutorials and examples from this project.

- [Resource Manager Samples](https://cloud.dynamicpdf.com/docs/usersguide/environment-manager/environment-manager-sample-resources)  

For more information on the tutorials and example code, refer to:

- https://cloud.dynamicpdf.com/docs/tutorials/tutorials-overview
- https://cloud.dynamicpdf.com/docs/usersguide/cloud-api/cloud-api-overview

## **Tutorials**

The following table lists the tutorial project or file name.  In Visual Studio each tutorial is it's own project. In the remaining client libraries each tutorial is its own individual class.

| Tutorial Title                                      | Project/File/Class      | Tutorial Location                                            |
| --------------------------------------------------- | ----------------------- | ------------------------------------------------------------ |
| Getting Started in 5 Minutes                        | `GettingStartedInFive`  | https://cloud.dynamicpdf.com/docs/tutorials/getting-started/getting-started-5-min |
| Completing a Form using the `pdf` Endpoint          | `CompletingAcroForm`    | https://cloud.dynamicpdf.com/docs/tutorials/cloud-api/pdf-tutorial-form-completion |
| Creating a PDF Using a DLEX and the `pdf` Endpoint  | `CreatingPdfDlex`       | https://cloud.dynamicpdf.com/docs/tutorials/cloud-api/pdf-tutorial-dlex-merge |
| Adding Bookmarks to a PDF                           | `AddBookmarks`          | https://cloud.dynamicpdf.com/docs/tutorials/cloud-api/pdf-tutorial-outlines |
| Creating a PDF Using the `dlex-layout` Endpoint     | `CreatingPdfDlexLayout` | https://cloud.dynamicpdf.com/docs/tutorials/cloud-api/dlex-layout/tutorial-dlex-layout |
| Extracting Metadata Using the `image-info` Endpoint | `GetImageInfo`          | https://cloud.dynamicpdf.com/docs/tutorials/cloud-api/image-info/tutorial-image-info |
| Extract PDF Metadata Using the `pdf-info` Endpoint  | `GetPdfInfo`            | https://cloud.dynamicpdf.com/docs/tutorials/cloud-api/pdf-info/tutorial-pdf-info |
| Extracting Text Using the `pdf-text` Endpoint       | `ExtractingText`        | https://cloud.dynamicpdf.com/docs/tutorials/cloud-api/pdf-text/tutorial-pdf-text |
| Extract XMP Metadata Using the `pdf-xmp` Endpoint   | `GetXmpMetaData`        | https://cloud.dynamicpdf.com/docs/tutorials/cloud-api/pdf-xmp/tutorial-pdf-xmp |
