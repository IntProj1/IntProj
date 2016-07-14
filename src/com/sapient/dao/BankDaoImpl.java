package com.sapient.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sapient.exceptions.NotFoundException;
import com.sapient.exceptions.IdExcepetion;
import com.sapient.exceptions.TransactionException;
import com.sapient.util.CustomerUtil;
import com.sapient.vo.Account;
import com.sapient.vo.Customer;
import com.sapient.vo.Transaction;

public class BankDaoImpl extends DBConnectiondao implements IBankDao {

	@Override
	public int addCust(Customer newCustObj) throws IdExcepetion {
		Connection con = getCon();
		try {
			PreparedStatement st = con.prepareStatement(Queries.addcust);
			st.setLong(1, newCustObj.getCustId());
			st.setString(2, newCustObj.getCustName());
			st.setString(3, newCustObj.getCustSex());
			st.setLong(4, newCustObj.getCustMob());
			st.setString(5, newCustObj.getCustEmail());
			st.setString(6, newCustObj.getCustAdd());
			st.setDate(7, new java.sql.Date(newCustObj.getCustDob().getTime()));
			st.setLong(8, newCustObj.getCustIncome());
			st.setString(9, newCustObj.getCustPan());
			st.setString(10, newCustObj.getCustPass());

			CustomerUtil.viewLogger().trace("parameters are binded to row");
			int row = st.executeUpdate();
			CustomerUtil.viewLogger().debug(row + "row added");
			return row;
		} catch (SQLException e) {
			CustomerUtil.viewLogger().error(e.getMessage());
			throw new IdExcepetion("customer id already exist");
		} finally {
			closeCon(con);
		}
	}

	@Override
	public int delCust(long custId) throws IdExcepetion {
		Connection con = getCon();
		// Customer cust = new Customer();
		try {
			PreparedStatement st = con.prepareStatement(Queries.delcust);
			st.setLong(1, custId);

			int row = st.executeUpdate();
			CustomerUtil.viewLogger().debug(row + "row deleted");
			return row;

		} catch (SQLException e) {
			CustomerUtil.viewLogger().error(e.getMessage());
			throw new IdExcepetion("cid is not  present");

		} finally {
			closeCon(con);
		}

	}

	@Override
	public List<Account> viewAccLst(long custId) {
		List<Account> accnt = null;
		Account account = null;
		Connection con = getCon();
		try {

			PreparedStatement st = con.prepareStatement(Queries.viewaccntlst);
			st.setLong(1, custId);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {

				account = new Account();
				account.setAccNo(rs.getLong(1));
				account.setCid(rs.getLong(2));
				account.setAccType(rs.getString(3));
				account.setAccRoi(rs.getInt(4));
				account.setAccBal(rs.getLong(5));
				account.setAccIfsc(rs.getString(6));
				account.setAccDate(rs.getDate(7));

				accnt.add(account);

				CustomerUtil.viewLogger().trace("rows viewed");
			}

		} catch (SQLException e) {
			CustomerUtil.viewLogger().error(e.getMessage());

		} finally {

			closeCon(con);
		}
		return accnt;
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
	public int delAcc(long accNo) throws NotFoundException {
		Connection con = getCon();
		try {
			PreparedStatement st = con.prepareStatement(Queries.delAcc);
			st.setLong(1, accNo);
			CustomerUtil.viewLogger().trace("accno binded to query");
			int row = st.executeUpdate();
			CustomerUtil.viewLogger().debug(row + "Row from account table Deleted");
			return row;
		}

		catch (SQLException e) {
			CustomerUtil.viewLogger().error(e.getMessage());
			throw new NotFoundException("No such account found !");
		} finally {
			closeCon(con);

		}

	}

	@Override
	public int createCust(Customer newCustObj) throws IdExcepetion {
		Connection con = getCon();
		int row = 0;
		try {
			PreparedStatement st = con.prepareStatement(Queries.createCust);
			st.setLong(1, newCustObj.getCustId());
			st.setString(2, newCustObj.getCustPass());
			st.setString(3, newCustObj.getCustName());
			st.setString(4, newCustObj.getCustSex());
			st.setLong(5, newCustObj.getCustMob());
			st.setString(6, newCustObj.getCustEmail());
			st.setString(7, newCustObj.getCustAdd());
			st.setDate(8, (java.sql.Date) newCustObj.getCustDob());
			st.setLong(9, newCustObj.getCustIncome());
			st.setString(10, newCustObj.getCustPan());
			CustomerUtil.viewLogger().trace("Customer Details binded to query");
			row = st.executeUpdate();
			CustomerUtil.viewLogger().debug(row + "Row added to customer table");
			return row;
		} catch (SQLException e) {
			CustomerUtil.viewLogger().error(e.getMessage());
			throw new IdExcepetion("Customer Already Exists !");

		} finally {
			closeCon(con);

		}

	}

	@Override
	public int insertTrans(Transaction newTransObj) throws TransactionException {
		Connection con = getCon();
		try {
			PreparedStatement st = con.prepareStatement(Queries.insertTrans);
			st.setLong(1, newTransObj.getTransSrcaccno());
			st.setLong(2, newTransObj.getTransAmt());
			st.setString(3, newTransObj.getTransType());
			st.setLong(4, newTransObj.getTransId());
			st.setLong(5, newTransObj.getTransDestaccno());
			st.setDate(6, (java.sql.Date) newTransObj.getTransDate());
			CustomerUtil.viewLogger().trace("Transaction details binded to query");
			int row = st.executeUpdate();
			CustomerUtil.viewLogger().debug(row + "Row added to Transaction Table ");
			return row;
		} catch (SQLException e) {
			CustomerUtil.viewLogger().error(e.getMessage());
			throw new TransactionException("Transaction Already Exists !");

		} finally {
			closeCon(con);

		}

	}

	@Override
	public int editPass(long custId, String newPass) {
		Connection con = getCon();
		int row = 0;
		try {
			PreparedStatement st = con.prepareStatement(Queries.editPass);
			st.setString(1, newPass);
			st.setLong(2, custId);
			CustomerUtil.viewLogger().trace("Password details binded to query");
			row = st.executeUpdate();
			CustomerUtil.viewLogger().debug(row + "Password is updated");
			return row;
		} catch (SQLException e) {
			CustomerUtil.viewLogger().error(e.getMessage());

		} finally {
			closeCon(con);

		}
		return row;

	}

	@Override
	public Customer viewCust(long custId) throws NotFoundException {
		Connection con = getCon();
		Customer c = null;
		try {
			PreparedStatement st = con.prepareStatement(Queries.viewCustbyId);
			st.setLong(1, custId);
			CustomerUtil.viewLogger().trace("Customer ID detail binded to query");

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				CustomerUtil.viewLogger().trace("Customer found");
				c = new Customer();
				c.setCustId(rs.getLong("cid"));
				c.setCustPass(rs.getString("pass"));
				c.setCustName(rs.getString("name"));
				c.setCustSex(rs.getString("sex"));
				c.setCustMob(rs.getLong("mob"));
				c.setCustEmail(rs.getString("email"));
				c.setCustAdd(rs.getString("address"));
				c.setCustDob(rs.getDate("dob"));
				c.setCustIncome(rs.getLong("income"));
				c.setCustPan(rs.getString("pan"));

			}
			CustomerUtil.viewLogger().debug(c + "Fetched Customer");
			return c;
		} catch (SQLException e) {
			CustomerUtil.viewLogger().error(e.getMessage());
			throw new NotFoundException("No such customer exists");
		} finally {
			closeCon(con);
		}

	}

	@Override
	public List<Customer> viewCust(Date custDob) throws NotFoundException {
		List<Customer> custlst = new ArrayList<Customer>();
		Customer cst1 = null;
		Connection conn = getCon();
		try {
			PreparedStatement st = conn.prepareStatement(Queries.viewAccList);
			st.setDate(1, new java.sql.Date(custDob.getTime()));
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				cst1 = new Customer();
				cst1.setCustId(rs.getLong("cid"));
				cst1.setCustName(rs.getString("cust_name"));

				cst1.setCustSex(rs.getString("custsex"));
				cst1.setCustDob(rs.getDate("custDob"));
				cst1.setCustMob(rs.getLong("custmob"));
				cst1.setCustEmail(rs.getString("custemail"));
				cst1.setCustAdd(rs.getString("custadd"));
				cst1.setCustIncome(rs.getLong("custincome"));
				cst1.setCustPan(rs.getString("custpan"));
				cst1.setCustPass(rs.getString("custPass"));
				custlst.add(cst1);
			}
			CustomerUtil.viewLogger().debug("size" + custlst.size());
		} catch (SQLException e) {
			CustomerUtil.viewLogger().error(e.getMessage());
		} finally {
			closeCon(conn);
		}
		if (custlst.size() == 0)
			throw new NotFoundException("no employess found");
		return custlst;
	}

	@Override
	public Customer viewCust(String custPan) throws NotFoundException {
		Customer cst2 = null;
		Connection conn = getCon();
		try {
			PreparedStatement st = conn.prepareStatement(Queries.viewAcl);
			st.setString(1, custPan);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				cst2 = new Customer();
				cst2.setCustId(rs.getLong("cid"));
				cst2.setCustName(rs.getString("name"));

				cst2.setCustSex(rs.getString("sex"));
				cst2.setCustDob(rs.getDate("Dob"));
				cst2.setCustMob(rs.getLong("mob"));
				cst2.setCustEmail(rs.getString("email"));
				cst2.setCustAdd(rs.getString("address"));
				cst2.setCustIncome(rs.getLong("income"));
				cst2.setCustPan(rs.getString("pan"));
				cst2.setCustPass(rs.getString("Pass"));

			}
		} catch (SQLException e) {
			CustomerUtil.viewLogger().error(e.getMessage());
		} finally {
			closeCon(conn);
		}
		if (cst2 == null)
			throw new NotFoundException("no employess found");
		return cst2;
	}

}
