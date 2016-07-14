package com.sapient.dao;

import java.util.Date;
import java.util.List;

import com.sapient.exceptions.NotFoundException;
import com.sapient.exceptions.IdExcepetion;
import com.sapient.exceptions.TransactionException;
import com.sapient.vo.*;

public interface IBankDao {

	int addCust(Customer newCustObj) throws IdExcepetion;

	int delCust(long custId) throws IdExcepetion;

	List<Account> viewAccLst(long custId) throws NotFoundException;

	Account viewAcc(long accNo) throws NotFoundException;

	List<Transaction> viewTrans(long custAccNo) throws NotFoundException, NotFoundException;

	List<Transaction> viewTrans(long custAccNo, Date startDate, Date endDate)
			throws NotFoundException, NotFoundException;

	int updateBal(long custAccNo, long transAmt, String transType) throws NotFoundException;

	int createAcc(Account newAccObj);

	int delAcc(long accNo) throws NotFoundException;

	int createCust(Customer newCustObj) throws IdExcepetion;

	int insertTrans(Transaction newTransObj) throws TransactionException;

	int editPass(long cust_id, String newPass);

	Customer viewCust(long custId) throws IdExcepetion, NotFoundException;

	List<Customer> viewCust(Date custDob) throws NotFoundException;

	Customer viewCust(String custPan) throws NotFoundException;

}
