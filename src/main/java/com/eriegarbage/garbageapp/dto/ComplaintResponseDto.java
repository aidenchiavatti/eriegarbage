package com.eriegarbage.garbageapp.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComplaintResponseDto implements Serializable {
    private int id;
    private  String response;
}
