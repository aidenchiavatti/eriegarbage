package com.eriegarbage.garbageapp.bill;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.persistence.*;

import com.eriegarbage.garbageapp.account.Account;
import com.eriegarbage.garbageapp.dispute.Dispute;
import com.eriegarbage.garbageapp.payment.Payment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long billId;

    private Date dueDate;
    private double total;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;

    @JsonIgnore
    @OneToMany
    private List<Dispute> disputes;

    @JsonIgnore
    @ManyToOne(cascade=CascadeType.ALL)
    private Account account;

    public void pay(Payment payment) {
        this.total = 0;
        this.payment = payment;
    }

    public int daysOverdue() {
        if(payment != null) {
            return 0;
        }
        long timeDiff = Calendar.getInstance().getTime().getTime() - dueDate.getTime();
        return Math.toIntExact(TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS));
    }
}
