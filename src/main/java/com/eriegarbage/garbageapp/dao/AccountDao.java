package com.eriegarbage.garbageapp.dao;

import com.eriegarbage.garbageapp.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AccountDao extends JpaRepository<Account, Long> {
    Account getAccountByUserName(String username);

    @Modifying
    @Transactional
    @Query("update Account a set a.firstName = ?1, a.lastName = ?2, a.address = ?3 where a.accountID = ?4")
    public void updateAccountInfo(String firstname, String lastName, String address, int accountID);

    @Modifying
    @Transactional
    @Query("delete from Account a where accountID = ?1")
    public void deleteAccount(int accountID);
}
