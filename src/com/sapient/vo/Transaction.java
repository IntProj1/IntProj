package com.sapient.vo;

import java.util.Date;

public class Transaction {

	private long transSrcAccNo;
	private long transAmt;
	private String transType;
	private long transId;
	private long transDestAccNo;
	private Date transDate;

	public Transaction() {
		super();
	}

	public Transaction(long transSrcaccno, long transAmt, String transType, long transId, long transDestaccno,
			Date transDate) {
		super();
		this.transSrcAccNo = transSrcaccno;
		this.transAmt = transAmt;
		this.transType = transType;
		this.transId = transId;
		this.transDestAccNo = transDestaccno;
		this.transDate = transDate;
	}

	public long getTransSrcaccno() {
		return transSrcAccNo;
	}

	public void setTransSrcaccno(long transSrcaccno) {
		this.transSrcAccNo = transSrcaccno;
	}

	public long getTransAmt() {
		return transAmt;
	}

	public void setTransAmt(long transAmt) {
		this.transAmt = transAmt;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public long getTransId() {
		return transId;
	}

	public void setTransId(long transId) {
		this.transId = transId;
	}

	public long getTransDestaccno() {
		return transDestAccNo;
	}

	public void setTransDestaccno(long transDestaccno) {
		this.transDestAccNo = transDestaccno;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	@Override
	public boolean equals(Object obj) {
		Transaction t = (Transaction) obj;
		if (this.transId == t.transId)
			return true;
		return false;
	}

	@Override
	public String toString() {

		return this.transDate + " " + this.transId + " " + this.transType + " " + this.transSrcAccNo + " "
				+ this.transDestAccNo + " " + this.transAmt;
	}

}
