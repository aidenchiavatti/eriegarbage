package com.eriegarbage.garbageapp.managers;

import com.eriegarbage.garbageapp.dao.ComplaintDao;
import com.eriegarbage.garbageapp.models.Complaint;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplaintManager {
    @Autowired
    private ComplaintDao complaintDao;

    public ComplaintManager(ComplaintDao complaintDao) {
        this.complaintDao = complaintDao;
    }

    public List<Complaint> readComplaints() {
        return complaintDao.getUnreadComplaints();
    }

    //public List<String> readComplaintResponses(){ return complaintDao.getComplaintResponses(); }

    public void submitComplaint(Complaint complaint) {
        complaintDao.save(complaint);
    }

    public void markComplaintAsViewed(int complaintId) {
        complaintDao.updateMarkedComplaint(complaintId);
    }

    public void respondToComplaint(int id, String response) {
        complaintDao.respondToComplaint(id, response);
    }

}
