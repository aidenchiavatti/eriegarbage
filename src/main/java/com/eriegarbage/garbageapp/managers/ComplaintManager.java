package com.eriegarbage.garbageapp.managers;

import com.eriegarbage.garbageapp.dao.ComplaintDao;
import com.eriegarbage.garbageapp.models.Complaint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintManager {
    @Autowired
    private ComplaintDao complaintDao;

    public ComplaintManager(ComplaintDao complaintDao){ this.complaintDao = complaintDao; }

    public List<Complaint> readComplaints() {
        return complaintDao.getUnreadComplaints();
    }

    public void submitComplaint(Complaint complaint) {
        complaintDao.save(complaint);
    }

    //public void markComplaintAsViewed(Complaint complaint) { complaintDao.updateMarkedComplaint(complaint); }

}
