package com.eriegarbage.garbageapp.dto;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DisputeResponseDto implements Serializable {
    private int id;
    private  String response;
}
