package com.eriegarbage.garbageapp.dao;

import com.eriegarbage.garbageapp.models.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface ComplaintDao extends JpaRepository<Complaint, Long> {
   // void createComplaint(Complaint c); Note: use .save(Complaint) instead
   // void updateMarkComplaint(Complaint c); Note: use .save(Complaint) instead

    @Query("select c from Complaint c where c.viewed = false")
    ArrayList<Complaint> getUnreadComplaints();

    @Query("update Complaint c set c.viewed = true where complaint.complaintID = ?1")
    public void updateMarkedComplaint(Complaint complaint);
}
