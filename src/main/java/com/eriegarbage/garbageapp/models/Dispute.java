package com.eriegarbage.garbageapp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
//@NoArgsConstructor

@Entity
public class Dispute {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int disputeID;

    private String dispute;
    private String response;

    public void addResponse(String r)
    {

    }
}
