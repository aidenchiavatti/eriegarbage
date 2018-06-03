package com.eriegarbage.garbageapp.complaint;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplaintService {
    @Autowired
    private ComplaintDao complaintDao;

    public ComplaintService(ComplaintDao complaintDao) {
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
