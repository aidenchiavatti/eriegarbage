package com.eriegarbage.garbageapp.dao;

import com.eriegarbage.garbageapp.models.Complaint;

import java.util.ArrayList;

public interface ComplaintDAO {
    public void createComplaint(Complaint c);
    public void updateMarkComplaint(Complaint c);
    public ArrayList<Complaint> readComplaint();

}
