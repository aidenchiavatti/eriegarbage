package com.eriegarbage.garbageapp.dao;

import com.eriegarbage.garbageapp.models.Complaint;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ComplaintDAOImpl implements ComplaintDAO {
    @Override
    public void createComplaint(Complaint c) {

    }

    @Override
    public void updateMarkComplaint(Complaint c) {

    }

    @Override
    public ArrayList<Complaint> readComplaint() {
        return null;
    }
}
