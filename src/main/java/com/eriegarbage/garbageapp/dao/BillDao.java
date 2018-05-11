package com.eriegarbage.garbageapp.dao;

import com.eriegarbage.garbageapp.models.Bill;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;



/**
 * Created by karle on 4/17/2018.
 */
public interface BillDao extends JpaRepository<Bill, Long> {
    @Query
    List<Bill> findByAccountUserName(String username);

    @Query
    List<Bill> findByAccountUserNameAndTotalGreaterThan(String username, double amountOwed);
}
