package com.eriegarbage.garbageapp;

import com.eriegarbage.garbageapp.dao.AccountDao;
import com.eriegarbage.garbageapp.models.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GarbageappApplication {

	public static void main(String[] args) {
		SpringApplication.run(GarbageappApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AccountDao accountDao) {
		return (args) -> {
			Account account = new Account();
			account.setUserName("username");
			account.setPickupTime("Monday, 11 PM");
			accountDao.save(account);
		};
	}
}
