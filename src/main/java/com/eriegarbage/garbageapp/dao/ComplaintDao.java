package com.eriegarbage.garbageapp.dao;

import com.eriegarbage.garbageapp.models.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

public interface ComplaintDao extends JpaRepository<Complaint, Long> {
   // void createComplaint(Complaint c); Note: use .save(Complaint) instead
   // void updateMarkComplaint(Complaint c); Note: use .save(Complaint) instead

    @Query("select c from Complaint c where c.viewed = false")
    ArrayList<Complaint> getUnreadComplaints();

    @Modifying
    @Transactional
    @Query("update Complaint c set c.viewed = true where c.complaintID = ?1")
    public void updateMarkedComplaint(int complaintID);

    @Modifying
    @Transactional
    @Query("update Complaint c set c.response = ?2 where c.complaintID = ?1")
    public void respondToComplaint(int complaintID, String response);
}
