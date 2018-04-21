package com.eriegarbage.garbageapp;

import com.eriegarbage.garbageapp.dao.AccountDao;
import com.eriegarbage.garbageapp.dao.BillDao;
import com.eriegarbage.garbageapp.dao.ComplaintDao;
import com.eriegarbage.garbageapp.dao.PaymentDao;
import com.eriegarbage.garbageapp.managers.AccountManager;
import com.eriegarbage.garbageapp.managers.BillingManager;
import com.eriegarbage.garbageapp.models.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

import static com.eriegarbage.garbageapp.TestConstants.*;

@SpringBootApplication
public class GarbageappApplication {

	public static void main(String[] args) {
		SpringApplication.run(GarbageappApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AccountDao accountDao, ComplaintDao complaintDao, AccountManager accountManager, BillingManager billingManager) {
		return (args) -> {
			accountManager.registerNewAccount(DEFAULT_ACCOUNT_DTO);
			accountManager.registerNewAdmin(ADMIN_ACCOUNT_DTO);

			Account account = accountManager.getAccount(DEFAULT_USERNAME);
			account.setPickupTime(DEFAULT_ACCOUNT.getPickupTime());
			BILL_1.setAccount(account);
			BILL_2.setAccount(account);
			account.setBills(Arrays.asList(BILL_1, BILL_2));
			accountDao.save(account);

			complaintDao.save(COMPLAINT_1);
			complaintDao.save(COMPLAINT_2);

			int billId = (billingManager.getBills(DEFAULT_USERNAME).get(0).getBillID());
			billingManager.payBill(billId, PAYMENT_DTO_1);
		};
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
