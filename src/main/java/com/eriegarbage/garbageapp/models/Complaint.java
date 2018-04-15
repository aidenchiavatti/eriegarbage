package com.eriegarbage.garbageapp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by karle on 4/11/2018.
 */
@Getter
@Setter
@NoArgsConstructor

@Entity
public class Complaint {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int complaintID;

    private boolean viewed;
    private String complaint;

    public Complaint(String complaintString) {
        this.viewed = false;
        this.complaint = complaintString;
    }

    public void wasViewed()
    {
        viewed = true;
    }

    public boolean validateComplaint()
    {
        //logic for the complaint validation such as swears censorship
        return false;
    }
}
