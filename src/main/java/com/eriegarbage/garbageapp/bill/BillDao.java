package com.eriegarbage.garbageapp.bill;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 * Created by karle on 4/17/2018.
 */
public interface BillDao extends JpaRepository<Bill, Long> {
    @Query
    List<Bill> findByAccountUserName(String username);

    @Query
    List<Bill> findByAccountUserNameAndTotalGreaterThan(String username, double amountOwed);
}
