package com.cts.ecart.model;

public class StockInfo {

	private int stockId;
	private int stock;

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "StockInfo [stockId=" + stockId + ", stock=" + stock + "]";
	}

}
