package com.sapient.dao;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import com.sapient.exception.IdExcepetion;
import com.sapient.vo.Account;
import com.sapient.vo.Customer;
import com.sapient.vo.Transaction;

public class BankDaoImpl extends DBConnection implements IBankDao {

	@Override
	public int addCust(Customer newCustObj) {

		return 0;
	}

	@Override
	public int delCust(long custId) {

		return 0;
	}

	@Override
	public List<Account> viewAccLst(long custId) {

		return null;
	}

	@Override
	public Account viewAcc(long accNo) {

		return null;
	}

	@Override
	public List<Transaction> viewTrans(long custAccNo) throws IdExcepetion {
		Connection conn = getCon();

		return null;
	}

	@Override
	public List<Transaction> viewTrans(long custAccNo, Date startDate, Date endDate) {

		return null;
	}

	@Override
	public int updateBal(long custAccNo, long transAmt, String transType) {

		return 0;
	}

	@Override
	public int createAcc(Account newAccObj) {

		return 0;
	}

	@Override
	public int delAcc(long accNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int createCust(Customer newCustObj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertTrans(Transaction newTransObj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int editPass(long cust_id, String newPass) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Customer viewCust(long custId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> viewCust(Date custDob) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer viewCust(String custPan) {
		// TODO Auto-generated method stub
		return null;
	}

}
