package com.sapient.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.sapient.util.CustomerUtil;

/**
 * abstract class having methods for getting connection and closing connection
 * 
 * @author ktrip5
 *
 */
public class DBConnection {

	static {
		String driver = CustomerUtil.getBundle().getString("driver");
		CustomerUtil.viewLogger().trace(driver);
		try {
			Class.forName(driver);
			CustomerUtil.viewLogger().debug("driver loaded ");
		} catch (ClassNotFoundException e) {
			CustomerUtil.viewLogger().error(e.getMessage());
		}

	}

	/**
	 * return connection instance based on the dbdetails configured in
	 * properties file
	 * 
	 * @return
	 */

	public Connection getCon() {
		Connection con = null;
		String url = CustomerUtil.getBundle().getString("url");
		String uname = CustomerUtil.getBundle().getString("uname");
		String pwd = CustomerUtil.getBundle().getString("pwd");
		CustomerUtil.viewLogger().trace(url + " " + uname + " " + pwd);
		try {
			con = DriverManager.getConnection(url, uname, pwd);
			CustomerUtil.viewLogger().debug("db connection established");
		} catch (SQLException e) {
			CustomerUtil.viewLogger().error("db connection fails");
			e.printStackTrace();
		}
		return con;

	}

	/**
	 * this method closes the connection
	 * 
	 * @param con
	 */

	public void closeCon(Connection con) {
		if (con != null) {
			CustomerUtil.viewLogger().trace("connection not null");
		}
		try {
			con.close();
			CustomerUtil.viewLogger().debug("db connection closed");
		} catch (SQLException e) {

			CustomerUtil.viewLogger().error("db connection fails to close");

		}
		CustomerUtil.viewLogger().trace("connection is null");

	}
}
