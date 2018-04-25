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

    // @Query("insert into Billing (amount) value = (Bill)")
    // @Query("select b from Bill b where b.dueDate > current_date")
    // public Bill getBill();
    //public void createBill(Bill billInfo);
    Bill findByBillId(int billId);

    @Query("select b from Bill b join b.account a where a.userName =?1")
    List<Bill> findBillsByUsername(String username);

    @Query("select b from Bill b join b.account a where a.userName =?1 and b.total > 0")
    List<Bill> findUnpaidBillsByUsername(String username);
}
