
package com.dynamicpdf.api.examples.reportobjects;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ReportCreatedFor",
    "Products"
})
public class SimpleReport implements Serializable
{

    @JsonProperty("ReportCreatedFor")
    private String reportCreatedFor;
    @JsonProperty("Products")
    private List<Product> products;
    private final static long serialVersionUID = 5450595077597584169L;

    @JsonProperty("ReportCreatedFor")
    public String getReportCreatedFor() {
        return reportCreatedFor;
    }

    @Override
	public String toString() {
		return "SimpleReport [reportCreatedFor=" + reportCreatedFor + ", products=" + products + "]";
	}

	@JsonProperty("ReportCreatedFor")
    public void setReportCreatedFor(String reportCreatedFor) {
        this.reportCreatedFor = reportCreatedFor;
    }

    @JsonProperty("Products")
    public List<Product> getProducts() {
        return products;
    }

    @JsonProperty("Products")
    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
