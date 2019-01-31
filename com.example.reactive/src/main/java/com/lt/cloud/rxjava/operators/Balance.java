package com.lt.cloud.rxjava.operators;

public class Balance {
	Long B_AdItemID;
	Double B_Amount;
	public Balance(Long B_AdItemID,Double B_Amount) {
		this.B_AdItemID=B_AdItemID;
		this.B_Amount=B_Amount;
	}
	
	@Override
	public String toString() {
		return "Balance [B_AdItemID=" + B_AdItemID + ", B_Amount=" + B_Amount + "]";
	}

	public Long getB_AdItemID() {
		return B_AdItemID;
	}
	public void setB_AdItemID(Long b_AdItemID) {
		B_AdItemID = b_AdItemID;
	}
	public Double getB_Amount() {
		return B_Amount;
	}
	public void setB_Amount(Double b_Amount) {
		B_Amount = b_Amount;
	}
	
}
