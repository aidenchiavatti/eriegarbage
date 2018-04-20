package com.eriegarbage.garbageapp;

import com.eriegarbage.garbageapp.dto.AccountDto;
import com.eriegarbage.garbageapp.models.Account;
import com.eriegarbage.garbageapp.models.Bill;
import com.eriegarbage.garbageapp.models.Complaint;

import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;

public class TestConstants {
    public static final Account DEFAULT_ACCOUNT = defaultAccount();
    public static final String DEFAULT_USERNAME = "user";
    public static final String DEFAULT_PASSWORD = "password";
    public static final String DEFAULT_PICKUP_TIME = "Monday, 12 AM";
    public static final String DEFAULT_FIRST_NAME = "John";
    public static final String DEFAULT_LAST_NAME = "Doe";
    public static final String DEFAULT_ADDRESS = "123 Fake Street";

    public static final AccountDto DEFAULT_ACCOUNT_DTO = defaultAccountDto();

    public static final Account ADMIN_ACCOUNT = adminAccount();
    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "admin";
    public static final String ADMIN_FIRST_NAME = "Super";
    public static final String ADMIN_LAST_NAME = "User";

    public static final AccountDto ADMIN_ACCOUNT_DTO = adminAccountDto();

    public static final String COMPLAINT_STRING_1 = "i am mad";
    public static final String COMPLAINT_STRING_2 = "I AM SO MAD!!";
    public static final Complaint COMPLAINT_1 = new Complaint(COMPLAINT_STRING_1);
    public static final Complaint COMPLAINT_2 = new Complaint(COMPLAINT_STRING_2);

    public static final Bill BILL_1 = bill1();
    public static final Bill BILL_2 = bill2();

    private static Account defaultAccount() {
        Account account = new Account();
        account.setUserName(DEFAULT_USERNAME);
        account.setPassword(DEFAULT_PASSWORD);
        account.setPickupTime(DEFAULT_PICKUP_TIME);
        account.setAdmin(false);
        account.setFirstName(DEFAULT_FIRST_NAME);
        account.setLastName(DEFAULT_LAST_NAME);
        account.setAddress(DEFAULT_ADDRESS);
        return account;
    }

    private static AccountDto defaultAccountDto() {
        AccountDto accountDto = new AccountDto();
        accountDto.setUsername(DEFAULT_USERNAME);
        accountDto.setPassword(DEFAULT_PASSWORD);
        accountDto.setMatchingPassword(DEFAULT_PASSWORD);
        accountDto.setFirstName(DEFAULT_FIRST_NAME);
        accountDto.setLastName(DEFAULT_LAST_NAME);
        accountDto.setAddress(DEFAULT_ADDRESS);
        return accountDto;
    }

    private static Account adminAccount() {
        Account account = new Account();
        account.setUserName(ADMIN_USERNAME);
        account.setPassword(ADMIN_PASSWORD);
        account.setAdmin(true);
        account.setFirstName(ADMIN_FIRST_NAME);
        account.setLastName(ADMIN_LAST_NAME);
        return account;
    }

    private static AccountDto adminAccountDto() {
        AccountDto accountDto = new AccountDto();
        accountDto.setUsername(ADMIN_USERNAME);
        accountDto.setPassword(ADMIN_PASSWORD);
        accountDto.setMatchingPassword(ADMIN_PASSWORD);
        accountDto.setFirstName(ADMIN_FIRST_NAME);
        accountDto.setLastName(ADMIN_LAST_NAME);
        return accountDto;
    }

    private static Bill bill1() {
        Bill bill = new Bill();
        bill.setTotal(20);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, Calendar.JANUARY, 1);
        bill.setDueDate(calendar.getTime());
        return bill;
    }

    private static Bill bill2() {
        Bill bill = new Bill();
        bill.setTotal(20);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, Calendar.DECEMBER, 30);
        bill.setDueDate(calendar.getTime());
        return bill;
    }


}
