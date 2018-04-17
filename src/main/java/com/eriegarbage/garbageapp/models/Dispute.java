package com.eriegarbage.garbageapp.models;

public class Dispute {
    private String dispute;
    private String response;

    public String viewDispute(){
        return dispute;
    }

    public void addResponse(String r){
        response = r;
    }
}
