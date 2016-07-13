package com.sapient.dao;

public class Queries {

	static String viewTransList="select*from transaction where acno=?";
	static String viewTransListbyDate="select*from transaction where acno=? and transd between ? and ? ";
}
