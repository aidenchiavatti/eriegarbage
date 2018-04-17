package com.eriegarbage.garbageapp.dao;

import com.eriegarbage.garbageapp.models.Dispute;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by karle on 4/17/2018.
 */
public interface DisputeDao extends JpaRepository<Dispute, Long> {
}
