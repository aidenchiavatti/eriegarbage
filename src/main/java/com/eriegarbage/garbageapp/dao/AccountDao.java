package com.eriegarbage.garbageapp.dao;

import com.eriegarbage.garbageapp.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, Long> {

    Account getAccountByUserName(String username);
}
