package com.eriegarbage.garbageapp.dispute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DisputeController {

    @Autowired
    private DisputeService disputeService;

    @GetMapping("/admin/disputes")
    public String viewBillDisputes(Model model) {
        //only show active disputeService (disputeService without a response)
        model.addAttribute(disputeService.getAll().stream().filter(Dispute::isActive));
        return "dispute/ManageBillDisputesPage";
    }

    @PostMapping("/admin/disputes/{disputeId}/respond")
    @ResponseStatus(HttpStatus.OK)
    public void respondToDispute(@PathVariable("disputeId") int disputeId, @RequestBody DisputeResponseDto response){
        disputeService.respondToDispute(disputeId, response.getResponse());
    }
}
