package com.sapient.client;

import java.util.List;

import com.sapient.dao.IBankDao;
import com.sapient.exception.NotFoundException;
import com.sapient.util.CustomerUtil;
import com.sapient.vo.Transaction;

public class ClientA {
	public static void main(String[] args) {
		IBankDao dao = CustomerUtil.getDaoInstance();
		try {
			List<Transaction> lst = dao.viewTrans(12345678910l);
			for (Transaction tr : lst) {
				System.out.println(tr);
			}
		} catch (NotFoundException e) {
			CustomerUtil.viewLogger().info(e.getMessage());
		}
	}
}
