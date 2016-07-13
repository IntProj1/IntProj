package com.sapient.util;

import java.util.ResourceBundle;

import org.apache.log4j.*;

public class BankUtil {

	private static ResourceBundle rbundle;
	private static Logger Logger;
	static {
		rbundle = ResourceBundle.getBundle("sap");
		Logger = Logger.getRootLogger();
	}

	/**
	 * @return ResourceBundle
	 */
	public static ResourceBundle getBundle() {
		return rbundle;

	}

	/**
	 * @return Log4j Logger
	 */
	public static Logger viewLogger() {

		return Logger;
	}

	/**
	 * @return Employee dao instance in Idoa reference
	 *
	 *         public static BankDao getDaoInstance() {
	 * 
	 *         return dao;
	 * 
	 *         }
	 */

}
