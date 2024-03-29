package employeemanagement.com.employees.Controller;

import employeemanagement.com.employees.Model.LeaveDetails;
import employeemanagement.com.employees.Service.Leave_detailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Leave_detailsController {
    private Leave_detailsService leave_detailsService;
    @Autowired
    public Leave_detailsController(Leave_detailsService theleave_detailsService) {

        this.leave_detailsService = theleave_detailsService;
    }
    @PostMapping("/addleavedetails")
    public LeaveDetails addLeave_details(@RequestBody LeaveDetails leave_details) {

        return leave_detailsService.addLeave_details(leave_details);
    }
    @GetMapping ("/leavedetails")
    public List<LeaveDetails> findAllLeave_details() {
        return leave_detailsService.findAllLeave_details();
    }
    @GetMapping("/leavedetails/{leave_id}")
    public LeaveDetails findLeave_detailsById(@PathVariable int leave_id) {
        LeaveDetails theleave_details=leave_detailsService.findLeave_detailsById(leave_id);
        if(theleave_details==null){
            throw new RuntimeException("Leave details not found");
        }
        else{
            return theleave_details;
        }
    }
    @PutMapping("/leavedetails/{leave_id}")
    public LeaveDetails updateLeave_details(LeaveDetails leave_details) {
        return leave_detailsService.updateLeave_details(leave_details);
    }
   @DeleteMapping("/leavedetails/{leave_id}")
    public void deleteLeave_details(@PathVariable("leave_id") int leave_id) {

        leave_detailsService.deleteLeave_details(leave_id);
    }
    }



