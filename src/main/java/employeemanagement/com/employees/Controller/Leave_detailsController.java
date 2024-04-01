package employeemanagement.com.employees.Controller;

import employeemanagement.com.employees.DAO.Leave_detailsRepository;
import employeemanagement.com.employees.Model.Leave_details;
import employeemanagement.com.employees.Service.Leave_detailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//added rest controller
//added cross origin
@RestController
@CrossOrigin
public class Leave_detailsController {
    private Leave_detailsService theLeave_detailsService;
    @Autowired

    public Leave_detailsController(Leave_detailsService theLeave_detailsService) {
        this.theLeave_detailsService = theLeave_detailsService;
    }
    @PostMapping("/addLeave")
    public Leave_details addLeave(@RequestBody Leave_details theLeave_details)
    {
        return theLeave_detailsService.save(theLeave_details);
    }
    @GetMapping("/Leave_details")
    public List<Leave_details> findAll()
    {
        return theLeave_detailsService.findAll();
    }
    @GetMapping("/Leave_details/{leave_id}")
    public Leave_details findById(@PathVariable int leave_id)
    {
        Leave_details theLeave_details=theLeave_detailsService.findById(leave_id);
        return theLeave_details;
    }
    @PutMapping("/Leave_details/{leave_id}")
    public Leave_details updateLeave_details(@PathVariable int leave_id, @RequestBody  Leave_details updateLeave_details)
    {
        return theLeave_detailsService.update(leave_id,updateLeave_details);
    }
    @DeleteMapping("/Leave_details/{leave_id}")
    public void deleteById(@PathVariable int leave_id)
    {
        theLeave_detailsService.deleteById(leave_id);
    }
}
