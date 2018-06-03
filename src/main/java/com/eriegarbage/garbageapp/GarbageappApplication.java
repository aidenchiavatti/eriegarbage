package com.eriegarbage.garbageapp;

import com.eriegarbage.garbageapp.account.AccountDao;
import com.eriegarbage.garbageapp.complaint.ComplaintDao;
import com.eriegarbage.garbageapp.account.AccountManager;
import com.eriegarbage.garbageapp.bill.BillService;
import com.eriegarbage.garbageapp.account.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

import static com.eriegarbage.garbageapp.system.TestConstants.*;

@SpringBootApplication
public class GarbageappApplication {

	public static void main(String[] args) {
		SpringApplication.run(GarbageappApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AccountDao accountDao, ComplaintDao complaintDao, AccountManager accountManager, BillService billService) {
		return (args) -> {
			accountManager.registerNewAccount(DEFAULT_ACCOUNT_DTO);
			accountManager.registerNewAdmin(ADMIN_ACCOUNT_DTO);

			Account account = accountManager.getAccount(DEFAULT_USERNAME);
			account.setPickupTime(DEFAULT_ACCOUNT.getPickupTime());
			BILL_1.setAccount(account);
			BILL_2.setAccount(account);
			BILL_3.setAccount(account);
			account.setBills(Arrays.asList(BILL_1, BILL_2, BILL_3));
			accountDao.save(account);

			complaintDao.save(COMPLAINT_1);
			complaintDao.save(COMPLAINT_2);

			long billId = (billService.getBillsForUser(DEFAULT_USERNAME).get(2).getBillId());
			billService.payBill(billId, PAYMENT_1);
		};
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
