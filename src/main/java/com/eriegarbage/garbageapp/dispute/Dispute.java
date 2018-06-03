package com.eriegarbage.garbageapp.dispute;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter

@Entity
public class Dispute {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer disputeID;
    private String dispute;
    private String response;

    public String viewDispute(){
        return dispute;
    }

    public void addResponse(String r) {
        response = r;
    }

    //Active if no response has been logged
    public boolean isActive() {
        return response == null;
    }
}
