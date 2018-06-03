package com.eriegarbage.garbageapp.account;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends JpaRepository<Account, Integer> {
    @Query
    Account findByUserName(String username);

    @Query
    ArrayList<Account> findByRequestSuspendTrue();
}
