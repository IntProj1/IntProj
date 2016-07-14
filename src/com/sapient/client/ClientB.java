package com.sapient.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.sapient.dao.IBankDao;
import com.sapient.exceptions.NotFoundException;
import com.sapient.util.CustomerUtil;
import com.sapient.vo.Transaction;

public class ClientB {

	public static void main(String[] args) throws ParseException {
		IBankDao dao = CustomerUtil.getDaoInstance();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			Date dt1 = sdf.parse("11-FEB-2015");
			Date dt2 = sdf.parse("11-JUN-2016");
			List<Transaction> lst = dao.viewTrans(12345678910l, dt1, dt2);
			for (Transaction tr : lst) {
				System.out.println(tr);
			}
		} catch (NotFoundException e) {
			CustomerUtil.viewLogger().info(e.getMessage());
		}
	}
}
