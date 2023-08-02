
package com.dynamicpdf.api.examples.reportobjects;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ProductID",
    "ProductName",
    "QuantityPerUnit",
    "UnitPrice",
    "Discontinued"
})

public class Product implements Serializable
{

    @JsonProperty("ProductID")
    private int productID;
    @JsonProperty("ProductName")
    private String productName;
    @JsonProperty("QuantityPerUnit")
    private String quantityPerUnit;
    @JsonProperty("UnitPrice")
    private double unitPrice;
    @JsonProperty("Discontinued")
    private boolean discontinued;
    private final static long serialVersionUID = -1284360730234634540L;

    @JsonProperty("ProductID")
    public int getProductID() {
        return productID;
    }

    @Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", quantityPerUnit="
				+ quantityPerUnit + ", unitPrice=" + unitPrice + ", discontinued=" + discontinued + "]";
	}

	@JsonProperty("ProductID")
    public void setProductID(int productID) {
        this.productID = productID;
    }

    @JsonProperty("ProductName")
    public String getProductName() {
        return productName;
    }

    @JsonProperty("ProductName")
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @JsonProperty("QuantityPerUnit")
    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    @JsonProperty("QuantityPerUnit")
    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    @JsonProperty("UnitPrice")
    public double getUnitPrice() {
        return unitPrice;
    }

    @JsonProperty("UnitPrice")
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @JsonProperty("Discontinued")
    public boolean isDiscontinued() {
        return discontinued;
    }

    @JsonProperty("Discontinued")
    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

}
