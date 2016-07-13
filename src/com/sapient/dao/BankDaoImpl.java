package com.sapient.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sapient.exception.*;

import com.sapient.util.CustomerUtil;
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
	public List<Transaction> viewTrans(long custAccNo) throws NotFoundException {
		List<Transaction> translst = new ArrayList<Transaction>();
		Connection conn = getCon();
		Transaction trans = null;
		try {
			PreparedStatement st = conn.prepareStatement(Queries.viewTransList);
			st.setLong(1, custAccNo);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				CustomerUtil.viewLogger().trace("row found");
				trans = new Transaction();
				trans.setTransSrcaccno(rs.getLong("acno"));
				trans.setTransAmt(rs.getLong("amt"));
				trans.setTransType(rs.getString("transt"));
				trans.setTransId(rs.getLong("transid"));
				trans.setTransDestaccno(rs.getLong("destacno"));
				trans.setTransDate(rs.getDate("transd"));
				translst.add(trans);
			}
			CustomerUtil.viewLogger().debug("size " + translst.size());
		} catch (SQLException e) {
			CustomerUtil.viewLogger().error(e.getMessage());
		} finally {
			closeCon(conn);
		}

		if (translst.size() == 0)
			throw new NotFoundException("No transaction Found");
		return translst;
	}

	@Override
	public List<Transaction> viewTrans(long custAccNo, Date startDate, Date endDate) throws NotFoundException {
		List<Transaction> translst = new ArrayList<Transaction>();
		Connection conn = getCon();
		Transaction trans = null;
		try {
			PreparedStatement st = conn.prepareStatement(Queries.viewTransListbyDate);
			st.setLong(1, custAccNo);
			st.setDate(2, new java.sql.Date(startDate.getTime()));
			st.setDate(3, new java.sql.Date(endDate.getTime()));
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				CustomerUtil.viewLogger().trace("row found");
				trans = new Transaction();
				trans.setTransSrcaccno(rs.getLong("acno"));
				trans.setTransAmt(rs.getLong("amt"));
				trans.setTransType(rs.getString("transt"));
				trans.setTransId(rs.getLong("transid"));
				trans.setTransDestaccno(rs.getLong("destacno"));
				trans.setTransDate(rs.getDate("transd"));
				translst.add(trans);
			}
			CustomerUtil.viewLogger().debug("size " + translst.size());
		} catch (SQLException e) {
			CustomerUtil.viewLogger().error(e.getMessage());
		} finally {
			closeCon(conn);
		}

		if (translst.size() == 0)
			throw new NotFoundException("No transaction Found");
		return translst;
	}

	@Override
	public int updateBal(long custAccNo, long transAmt, String transType) throws NotFoundException {
		int i = 1;
		if ("DEBIT".equals(transType.toUpperCase()))
			i = -1;
		Connection conn = getCon();
		try {
			PreparedStatement st = conn.prepareStatement(Queries.balUpdate);
			st.setInt(1, i);
			st.setLong(2, transAmt);
			st.setLong(3, custAccNo);
			CustomerUtil.viewLogger().trace("binded parameters to query");
			int row = st.executeUpdate();
			CustomerUtil.viewLogger().debug(row + "bal updated");
		} catch (SQLException ex) {
			CustomerUtil.viewLogger().error(ex.getMessage());
			throw new NotFoundException("Account not found");
		} finally {
			closeCon(conn);
		}
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
