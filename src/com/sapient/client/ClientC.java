package com.sapient.client;

import com.sapient.dao.IBankDao;
import com.sapient.exception.NotFoundException;
import com.sapient.util.CustomerUtil;

public class ClientC {

	public static void main(String[] args) {
		IBankDao dao = CustomerUtil.getDaoInstance();
		try {
			int res = dao.updateBal(12345678910l, 100l, "DEBIT");
			CustomerUtil.viewLogger().info("bal updated");
		} catch (NotFoundException e) {
			CustomerUtil.viewLogger().info(e.getMessage());
		}

	}
}
