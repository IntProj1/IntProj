package com.sapient.vo;

import java.util.Date;
import java.util.List;

public class Customer {

	private long custId;
	private String custName;
	private String custSex;
	private long custMob;
	private String custEmail;
	private String custAdd;
	private Date custDob;
	private long custIncome;
	private String custPan;
	private String custPass;
	private List<Account> custAccLst = null;

	public Customer() {
		super();
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustSex() {
		return custSex;
	}

	public void setCustSex(String custSex) {
		this.custSex = custSex;
	}

	public long getCustMob() {
		return custMob;
	}

	public void setCustMob(long custMob) {
		this.custMob = custMob;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustAdd() {
		return custAdd;
	}

	public void setCustAdd(String custAdd) {
		this.custAdd = custAdd;
	}

	public Date getCustDob() {
		return custDob;
	}

	public void setCustDob(Date custDob) {
		this.custDob = custDob;
	}

	public long getCustIncome() {
		return custIncome;
	}

	public void setCustIncome(long custIncome) {
		this.custIncome = custIncome;
	}

	public String getCustPan() {
		return custPan;
	}

	public void setCustPan(String custPan) {
		this.custPan = custPan;
	}

	public String getCustPass() {
		return custPass;
	}

	public void setCustPass(String custPass) {
		this.custPass = custPass;
	}

	public List<Account> getCustAcclst() {
		return custAccLst;
	}

	public void setCustAcclst(List<Account> custAcclst) {
		this.custAccLst = custAcclst;
	}

	@Override
	public boolean equals(Object obj) {
		Customer c = (Customer) obj;
		if (this.custId == c.custId)
			return true;
		return false;
	}

	/*
	 * @Override public int hashCode() { // TODO Auto-generated method stub
	 * return super.hashCode(); }
	 */
	@Override
	public String toString() {

		return this.custId + " " + this.custName + " " + this.custSex + " " + this.custMob + " " + this.custEmail + " "
				+ " " + this.custAdd + " " + this.custDob + " " + this.custIncome + " " + this.custPan;
	}

}
