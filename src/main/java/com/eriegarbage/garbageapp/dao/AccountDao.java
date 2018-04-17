package com.eriegarbage.garbageapp.dao;

import com.eriegarbage.garbageapp.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountDao extends JpaRepository<Account, Long> {

    //TODO How to do this based of of what get username is
    @Query("select a from Account a where usernmae = ''")
    Account getAccountByUserName(String username);
}
