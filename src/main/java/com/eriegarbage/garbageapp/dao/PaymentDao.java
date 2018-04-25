package com.eriegarbage.garbageapp.dao;

import com.eriegarbage.garbageapp.models.Payment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by karle on 4/17/2018.
 */
@Repository
public interface PaymentDao extends JpaRepository<Payment, Long> {

    @Query("select p from Payment p join p.bill b join b.account a where a.userName = ?1")
    List<Payment> findPaymentsForUsername(String username);
}
