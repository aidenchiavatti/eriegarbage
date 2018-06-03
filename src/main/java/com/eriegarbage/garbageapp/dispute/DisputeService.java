package com.eriegarbage.garbageapp.dispute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisputeService {

    @Autowired
    private DisputeDao disputeDao;

    public void respondToDispute(int id, String response) {
        disputeDao.respondToDispute(id, response);
    }

    public List<Dispute> getAll() {
        return disputeDao.findAll();
    }
}
