package com.eriegarbage.garbageapp;

import com.eriegarbage.garbageapp.dao.AccountDao;
import com.eriegarbage.garbageapp.dao.BillDao;
import com.eriegarbage.garbageapp.models.Account;
import com.eriegarbage.garbageapp.models.Bill;
import com.eriegarbage.garbageapp.models.Payment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GarbageappApplication {

	public static void main(String[] args) {
		SpringApplication.run(GarbageappApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AccountDao accountDao, BillDao billDao) {
		return (args) -> {
			Account account = new Account();
			Bill bill = new Bill();
			//TODO do we need paymentDao
			//Payment payment = new Payment();
			//payment.setDate("2018-12-11");
			//payment.setPaymentTotal(55.00);
			bill.setDueDate("2018-12-12");
			bill.setTotal(55.00);
			//bill.setPayment(payment);
			List<Bill> bills = new ArrayList<>();
			bills.add(bill);
			account.setUserName("username");
			account.setPickupTime("Monday, 11 PM");
			//TODO it needs more for mapping
			//account.setBills(bills);

			billDao.save(bill);
			accountDao.save(account);
		};
	}
}
