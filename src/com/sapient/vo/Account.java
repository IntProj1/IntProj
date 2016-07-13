package com.sapient.vo;

import java.util.Date;
import java.util.List;

public class Account {

	private List<Transaction> transLst = null;
	private long accNo;
	private String accType;
	private long accBal;
	private String accIfsc;
	private Date accDate;
	private int accRoi;

	public Account() {
		super();
	}

	public List<Transaction> getTransLst() {
		return transLst;
	}

	public void setTransLst(List<Transaction> transLst) {
		this.transLst = transLst;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public long getAccBal() {
		return accBal;
	}

	public void setAccBal(long accBal) {
		this.accBal = accBal;
	}

	public String getAccIfsc() {
		return accIfsc;
	}

	public void setAccIfsc(String accIfsc) {
		this.accIfsc = accIfsc;
	}

	public Date getAccDate() {
		return accDate;
	}

	public void setAccDate(Date accDate) {
		this.accDate = accDate;
	}

	public int getAccRoi() {
		return accRoi;
	}

	public void setAccRoi(int accRoi) {
		this.accRoi = accRoi;
	}

	@Override
	public boolean equals(Object obj) {
		Account t = (Account) obj;
		if (t.accNo == t.accNo)
			return true;
		return false;
	}

	@Override
	public String toString() {

		return this.accNo + " " + this.accType + " " + this.accBal + " " + this.accIfsc + " " + this.accDate + " "
				+ this.accRoi;
	}

}
