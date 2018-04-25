package com.eriegarbage.garbageapp.dao;

import com.eriegarbage.garbageapp.models.Dispute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karle on 4/17/2018.
 */
public interface DisputeDao extends JpaRepository<Dispute, Long> {
    @Modifying
    @Transactional
    @Query("update Dispute d set d.response = ?2 where d.disputeID = ?1")
    void respondToDispute(int id, String response);
}
