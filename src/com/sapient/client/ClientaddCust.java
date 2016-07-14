package com.sapient.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sapient.dao.IBankDao;
import com.sapient.exceptions.IdExcepetion;
import com.sapient.util.CustomerUtil;
import com.sapient.vo.Customer;

public class ClientaddCust {

	public static void main(String[] args) throws ParseException {
		Customer cust = new Customer();
		cust.setCustAdd("651  i block  barra up ");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-YYY");
		Date dt = sdf.parse("09-aug-1978");
		cust.setCustDob(dt);
		cust.setCustEmail("ram.sapient93@gmail.com");
		cust.setCustId(10002);
		cust.setCustIncome(423344);
		cust.setCustMob(8858837671l);
		cust.setCustName("shaym tripathi");
		cust.setCustPan("AHBCGT98VE");
		cust.setCustPass("ytyau");
		cust.setCustSex("MALE");
		IBankDao ibdao = CustomerUtil.getDaoInstance();
		try {
			ibdao.addCust(cust);
			CustomerUtil.viewLogger().info("row added");
		} catch (com.sapient.exceptions.IdExcepetion e) {
			CustomerUtil.viewLogger().info(e.getMessage());

		}

	}

}
