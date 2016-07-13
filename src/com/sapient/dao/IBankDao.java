package com.sapient.dao;

import java.util.Date;
import java.util.List;

import com.sapient.vo.*;

public interface IBankDao {

	int addCust(Customer newCustObj);

	int delCust(long custId);

	List<Account> viewAccLst(long custId);

	Account viewAcc(long accNo);

	List<Transaction> viewTrans(long custAccNo);

	List<Transaction> viewTrans(long custAccNo, Date startDate, Date endDate);

	int updateBal(long custAccNo, long transAmt, String transType);

	int createAcc(Account newAccObj);

	int delAcc(long accNo);

	int createCust(Customer newCustObj);

	int insertTrans(Transaction newTransObj);

	int editPass(long cust_id, String newPass);

	Customer viewCust(long custId);

	List<Customer> viewCust(Date custDob);

	Customer viewCust(String custPan);

}
