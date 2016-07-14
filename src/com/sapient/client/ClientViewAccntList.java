package com.sapient.client;

import com.sapient.dao.IBankDao;
import com.sapient.exceptions.NotFoundException;
import com.sapient.util.CustomerUtil;
import com.sapient.vo.Customer;

public class ClientViewAccntList {

	public static void main(String[] args) {

		Customer cust = new Customer();
		cust.setCustId(1000l);

		IBankDao idbao = CustomerUtil.getDaoInstance();
		try {
			idbao.viewAccLst(cust.getCustId());
			CustomerUtil.viewLogger().trace("details regarding cid");
		} catch (com.sapient.exceptions.NotFoundException e) {
			CustomerUtil.viewLogger().error("not found");
		}

	}

}
