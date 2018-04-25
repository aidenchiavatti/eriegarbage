package com.eriegarbage.garbageapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OverdueAccountDto implements Comparable<OverdueAccountDto> {
    private int accountId;
    private int daysOverdue;
    private String username;

    @Override
    public int compareTo(OverdueAccountDto o) {
        return Integer.compare(this.daysOverdue, o.daysOverdue);
    }
}
