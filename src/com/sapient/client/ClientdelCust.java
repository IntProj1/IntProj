package com.sapient.client;

import com.sapient.dao.IBankDao;
import com.sapient.exceptions.IdExcepetion;
import com.sapient.util.CustomerUtil;

public class ClientdelCust {

	public static void main(String[] args) {

		IBankDao ibdao = CustomerUtil.getDaoInstance();
		try {
			ibdao.delCust(10001l);
			CustomerUtil.viewLogger().trace("row deleted");
		} catch (com.sapient.exceptions.IdExcepetion e) {
			CustomerUtil.viewLogger().info(e.getMessage());
		}

	}

}
