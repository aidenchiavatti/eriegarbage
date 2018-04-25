package com.eriegarbage.garbageapp.dao;

import com.eriegarbage.garbageapp.models.Account;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AccountDao extends JpaRepository<Account, Long> {
    Account getAccountByUserName(String username);

    @Query("select a from Account a where a.requestSuspend = true")
    ArrayList<Account> getAccountsThatRequestSuspension();

    @Modifying
    @Transactional
    @Query("update Account a set a.firstName = ?1, a.lastName = ?2,"
            + "a.address = ?3 where a.accountId = ?4")
    void updateAccountInfo(String firstname, String lastName, String address, int accountId);

    @Modifying
    @Transactional
    @Query("update Account a set a.requestSuspend = true where a.accountId = ?1")
    void updateAccountSuspendRequest(int accountId);

    @Modifying
    @Transactional
    @Query("update Account a set a.suspensionApproved = true where a.userName = ?1")
    void updateAccountSuspendedApproved(String accountName);

    @Modifying
    @Transactional
    @Query("update Account a set a.isSuspended = true where a.accountId = ?1")
    void updateAccountSuspended(int accountId);

    @Modifying
    @Transactional
    @Query("delete from Account a where accountId = ?1")
    void deleteAccount(int accountId);
}
