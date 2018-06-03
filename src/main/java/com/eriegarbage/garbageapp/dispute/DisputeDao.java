package com.eriegarbage.garbageapp.dispute;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by karle on 4/17/2018.
 */
public interface DisputeDao extends JpaRepository<Dispute, Long> {
    @Modifying
    @Transactional
    @Query("update Dispute d set d.response = :response where d.disputeID = :id")
    void respondToDispute(@Param("id") int id, @Param("response") String response);
}
