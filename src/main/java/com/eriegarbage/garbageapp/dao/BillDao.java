package com.eriegarbage.garbageapp.dao;

import com.eriegarbage.garbageapp.models.Account;
import com.eriegarbage.garbageapp.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by karle on 4/17/2018.
 */
public interface BillDao extends JpaRepository<Bill, Long> {

   // @Query("insert into Billing (amount) value = (Bill)")
//    @Query("select b from Bill b where b.dueDate > current_date")
//    public Bill getBill();
    //public void createBill(Bill billInfo);
    Bill findByBillID(int billID);
}
