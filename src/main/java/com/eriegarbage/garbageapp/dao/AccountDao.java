package com.eriegarbage.garbageapp.dao;

import com.eriegarbage.garbageapp.dto.OverdueAccountDto;
import com.eriegarbage.garbageapp.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public interface AccountDao extends JpaRepository<Account, Long> {
    Account getAccountByUserName(String username);

    @Query("select a from Account a where a.requestSuspend = true")
    ArrayList<Account> getAccountsThatRequestSuspension();

    @Modifying
    @Transactional
    @Query("update Account a set a.firstName = ?1, a.lastName = ?2, a.address = ?3 where a.accountID = ?4")
    void updateAccountInfo(String firstname, String lastName, String address, int accountID);

    @Modifying
    @Transactional
    @Query("update Account a set a.requestSuspend = true where a.accountID = ?1")
    void updateAccountSuspendRequest(int accountID);

    @Modifying
    @Transactional
    @Query("update Account a set a.isSuspended = true where a.userName = ?1")
    void updateAccountSuspended(String accountName);

    @Modifying
    @Transactional
    @Query("delete from Account a where accountID = ?1")
    void deleteAccount(int accountID);
}
