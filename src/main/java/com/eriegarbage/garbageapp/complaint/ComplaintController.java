package com.eriegarbage.garbageapp.complaint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ComplaintController {

    @Autowired
    ComplaintService complaintService;

    @GetMapping("/complaints/complaints.html")
    public String complaintsPage(Model model) {
        model.addAttribute(complaintService.readComplaints()); //TODO: remove. admin only
        return "complaint/ComplaintPage";
    }

    //TODO: add admin api mapping to get complaints

    @PostMapping("/complaints")
    @ResponseStatus(value = HttpStatus.OK)
    public void submitComplaint(@RequestParam("input") String complaintString) {
        Complaint complaint = new Complaint(complaintString);
        complaintService.submitComplaint(complaint);
    }

    @GetMapping("/admin/complaints.html")
    public String adminComplaintsPage(Model model) {
        model.addAttribute(complaintService.readComplaints());
        return "complaint/ViewComplaintsPage";
    }

    @PostMapping("/admin/complaints/{complaintId}/viewed")
    @ResponseStatus(value = HttpStatus.OK)
    public void markComplaintAsViewed(@PathVariable("complaintId") int complaintId) {
        complaintService.markComplaintAsViewed(complaintId);
    }

    @PostMapping("/admin/complaints/{complaintId}/respond")
    @ResponseStatus(value = HttpStatus.OK)
    public void respondToComplaint(@PathVariable("complaintId") int complaintId,
                                   @RequestBody ComplaintResponseDto response) {
        complaintService.respondToComplaint(complaintId, response.getResponse());
    }
}
