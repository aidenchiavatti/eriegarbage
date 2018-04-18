package com.eriegarbage.garbageapp;

import com.eriegarbage.garbageapp.dao.AccountDao;
import com.eriegarbage.garbageapp.dao.BillDao;
import com.eriegarbage.garbageapp.dao.PaymentDao;
import com.eriegarbage.garbageapp.dto.AccountDto;
import com.eriegarbage.garbageapp.managers.AccountManager;
import com.eriegarbage.garbageapp.models.Account;
import com.eriegarbage.garbageapp.models.Bill;
import com.eriegarbage.garbageapp.models.Payment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GarbageappApplication {

	public static void main(String[] args) {
		SpringApplication.run(GarbageappApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AccountDao accountDao, BillDao billDao, PaymentDao paymentDao, AccountManager accountManager) {
		return (args) -> {
			Bill bill = new Bill();
			Payment payment = new Payment();
			payment.setDate("2018-12-11");
			payment.setPaymentTotal(55.00);
			bill.setDueDate("2018-12-12");
			bill.setTotal(55.00);
			bill.setPayment(payment);
			List<Bill> bills = new ArrayList<>();
			bills.add(bill);

			bill = new Bill();
			bill.setDueDate("2018-11-11");
			bill.setTotal(20.00);
			bills.add(bill);

			AccountDto accountDto = new AccountDto();
			accountDto.setFirstName("Test");
			accountDto.setLastName("User");
			accountDto.setPassword("password");
			accountDto.setMatchingPassword("password");
			accountDto.setUsername("user");
			accountManager.registerNewAccount(accountDto);

			accountDto = new AccountDto();
			accountDto.setFirstName("Admin");
			accountDto.setLastName("Admin");
			accountDto.setPassword("admin");
			accountDto.setMatchingPassword("admin");
			accountDto.setUsername("admin");
			accountManager.registerNewAdmin(accountDto);

			Account account = accountDao.getAccountByUserName("user");
			account.setPickupTime("Monday, 11 PM");
			account.setBills(bills);
			accountDao.save(account);
		};
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
