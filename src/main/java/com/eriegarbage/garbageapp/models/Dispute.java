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
<<<<<<< HEAD
    private String dispute;
    private String response;

    public String viewDispute(){
        return dispute;
    }

    public void addResponse(String r){
        response = r;
=======
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int disputeID;

    private String dispute;
    private String response;

    public void addResponse(String r)
    {

>>>>>>> ca86f89229eae0d45a6b2a1d4a5d3ab2e519682f
    }
}
