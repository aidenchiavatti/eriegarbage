package com.eriegarbage.garbageapp.bill;

import com.eriegarbage.garbageapp.payment.Payment;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by karle on 4/17/2018.
 */
@Controller
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping("/bills/bills.html")
    public String getBillPage() {
        return "bill/Bills";
    }

    @GetMapping("/bills")
    @ResponseBody
    public List<Bill> bills(Principal principal) {
        return billService.getBillsForUser(principal.getName());
    }

    @PostMapping("/bills/{billId}/pay")
    @ResponseStatus(value = HttpStatus.OK)
    public void processBillPayment(@PathVariable("billId") int billId, @RequestBody Payment payment) {
        billService.payBill(billId, payment);
    }

    @GetMapping("/admin/bills")
    @ResponseBody
    public List<Bill> adminBills() {
        return billService.getBills();
    }
}
