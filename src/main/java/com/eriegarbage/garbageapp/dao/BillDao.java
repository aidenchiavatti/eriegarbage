package com.eriegarbage.garbageapp.dao;

import com.eriegarbage.garbageapp.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by karle on 4/17/2018.
 */
public interface BillDao extends JpaRepository<Bill, Long> {

   // @Query("insert into Billing (amount) value = (Bill)")
    //@Query("select b from Bill where Bill.billID =")
    //public void createBill(Bill billInfo);
}
