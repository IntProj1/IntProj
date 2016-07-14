package com.sapient.dao;

public interface Queries {
	String addcust = "insert into customer values(?,?,?,?,?,?,?,?,?,?)";
	String delcust = "delete from customer where cid=?";
	String viewaccntlst = "select *from account where cid=?";
	String delAcc = "delete from account where acno = ?";
	String createCust = "insert into customer (?,?,?,?,?,?,?,?,?,?)";
	String insertTrans = "insert into transaction (?,?,?,?,?,?)";
	String editPass = "UPDATE customer set pass = ? where cid = ?";
	String viewCustbyId = "SELECT * FROM customer where cid= ?";
	String viewTransList = "select*from transaction where acno=?";
	String viewTransListbyDate = "select*from transaction where acno=? and transd between ? and ? ";
	String balUpdate = "Update account set bal=bal+(?*?) where acno=?";
	String viewAccList = "select * from customer where dob=?";
	String viewAcl = "select*from customer where pan=?";

}
