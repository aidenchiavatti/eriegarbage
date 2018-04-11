package com.eriegarbage.garbageapp.models;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by karle on 4/11/2018.
 */
@Getter
@Setter
public class Complaint {
    private boolean viewed;
    private String complaint;

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
