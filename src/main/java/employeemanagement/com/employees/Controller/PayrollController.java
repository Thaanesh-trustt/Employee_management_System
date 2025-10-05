package employeemanagement.com.employees.Controller;

import employeemanagement.com.employees.Model.Employee;
import employeemanagement.com.employees.Model.Payroll;
import employeemanagement.com.employees.Service.EmployeeService;
import employeemanagement.com.employees.Service.PayrollService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//added rest controller
//added cross origin
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PayrollController {
    private PayrollService thePayrollService;
    private EmployeeService theEmployeService;
    @Autowired
    public PayrollController(PayrollService thePayrollService,EmployeeService employeeService) {
        this.thePayrollService = thePayrollService;
        theEmployeService = employeeService;
    }
    @PostMapping("/addPayroll/{empId}")
    public Payroll addPayroll(@PathVariable(value="empId") int id,@RequestBody Payroll thePayroll)
    {
        Employee emp = theEmployeService.findById(id);
        thePayroll.setEmployee(emp);

        Payroll payroll=thePayrollService.save(thePayroll);
        return payroll;
    }
    @GetMapping("/payroll")
    public List<Payroll> findAll()
    {
        return thePayrollService.findAll();
    }
    @PutMapping("/payroll/{payroll_id}")
    public Payroll updatepayroll(@PathVariable int payroll_id,@RequestBody Payroll updatePayroll)
    {
        return thePayrollService.update(payroll_id,updatePayroll);
    }
    @GetMapping("/payroll/{payroll_id}")
    public Payroll findById(@PathVariable int payroll_id)
    {
    Payroll thePayroll=thePayrollService.findById(payroll_id);
        if(thePayroll==null)
        {
            throw new EntityNotFoundException("Payroll id not found -" + payroll_id);
        }
        return thePayroll;
    } @DeleteMapping("/payroll/{payroll_id}")
    public void deleteEmployee(@PathVariable("payroll_id") int payroll_id)
    {
       thePayrollService.deleteById(payroll_id);
    }
}
