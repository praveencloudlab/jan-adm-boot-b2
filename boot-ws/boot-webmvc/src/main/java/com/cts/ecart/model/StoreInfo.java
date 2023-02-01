package com.cts.ecart.model;

public class StoreInfo {

	private int storeId;
	private String location;
	private String storeName;

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	@Override
	public String toString() {
		return "StoreInfo [storeId=" + storeId + ", location=" + location + ", storeName=" + storeName + "]";
	}

}
