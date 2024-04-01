package employeemanagement.com.employees.Controller;

import employeemanagement.com.employees.Model.Employee;
import employeemanagement.com.employees.Model.Payroll;
import employeemanagement.com.employees.Service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//added rest controller
//added cross origin
@RestController
@CrossOrigin
public class PayrollController {
    private PayrollService thePayrollService;
    @Autowired
    public PayrollController(PayrollService thePayrollService) {
        this.thePayrollService = thePayrollService;
    }
    @PostMapping("/addPayroll")
    public Payroll addPayroll(@RequestBody Payroll thePayroll)
    {
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
            throw new RuntimeException("Payroll id not found -" + payroll_id);
        }
        return thePayroll;
    } @DeleteMapping("/payroll/{payroll_id}")
    private void deleteEmployee(@PathVariable("payroll_id") int payroll_id)
    {
       thePayrollService.deleteById(payroll_id);
    }

}
