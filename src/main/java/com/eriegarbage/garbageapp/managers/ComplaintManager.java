package com.eriegarbage.garbageapp.managers;

import com.eriegarbage.garbageapp.dao.ComplaintDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplaintManager {
    @Autowired
    private ComplaintDAO complaintDAO;

    public ComplaintManager(ComplaintDAO complaintDAO){ this.complaintDAO = complaintDAO; }

}
