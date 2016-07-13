package com.sapient.util;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.sapient.dao.BankDaoImpl;
import com.sapient.dao.IBankDao;

public class CustomerUtil {

	private static ResourceBundle bundle;
	private static Logger logger;

	/**
	 * loaded when class is loaded
	 */
	static {
		bundle = ResourceBundle.getBundle("data");
		logger = Logger.getRootLogger();
	}

	/**
	 * return resource bundle
	 * 
	 * @return
	 */
	public static ResourceBundle getBundle() {
		return bundle;
	}

	/**
	 * view log4j logger
	 * 
	 * @return
	 */
	public static Logger viewLogger() {
		return logger;

	}
	/**
	 * getting the instance of BankDaoImpl in Ibank dao object
	 */
	public static IBankDao getDaoInstance() {
		IBankDao ibdao = new BankDaoImpl();
		return ibdao;
	}

}
