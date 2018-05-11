package com.eriegarbage.garbageapp.dao;

import com.eriegarbage.garbageapp.models.Account;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AccountDao extends JpaRepository<Account, Long> {
    @Query
    Account findByUserName(String username);

    @Query
    ArrayList<Account> findByRequestSuspendTrue();
}
