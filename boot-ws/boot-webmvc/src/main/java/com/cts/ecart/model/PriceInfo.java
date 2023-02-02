package com.cts.ecart.model;

public class PriceInfo {

	private int priceId;
	private double price;

	public int getPriceId() {
		return priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "PriceInfo [priceId=" + priceId + ", price=" + price + "]";
	}

}
