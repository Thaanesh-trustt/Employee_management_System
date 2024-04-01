package employeemanagement.com.employees.Controller;

import employeemanagement.com.employees.Model.Employee;
import employeemanagement.com.employees.Model.Leave_details;
import employeemanagement.com.employees.Service.EmployeeService;
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
    private EmployeeService theEmployeeService;
    @Autowired

    public Leave_detailsController(Leave_detailsService theLeave_detailsService, EmployeeService employeeService) {
        this.theLeave_detailsService = theLeave_detailsService;
        theEmployeeService = employeeService;
    }
    @PostMapping("/addLeave/{empId}")
    public Leave_details addLeave(@PathVariable(value="empId") int id, @RequestBody Leave_details theLeave_details)
    {
        Employee emp = theEmployeeService.findById(id);
        theLeave_details.setEmployee(emp);
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
