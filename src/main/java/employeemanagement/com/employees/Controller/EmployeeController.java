package employeemanagement.com.employees.Controller;

import employeemanagement.com.employees.Model.Employee;
import employeemanagement.com.employees.Model.Role;
import employeemanagement.com.employees.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.EnumMap;
import java.util.List;
//added rest controller
//added cross origin
@RestController
@CrossOrigin
//@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee emp)
    {
        Employee em=employeeService.save(emp);
        return em;
    }
    @GetMapping("/employees")
    public List<Employee>findAll()
    {
        return employeeService.findAll();
    }
    @GetMapping("/employees/{emp_id}")
    public Employee getEmployee(@PathVariable int emp_id)
    {
        Employee theEmployee=employeeService.findById(emp_id);
        if(theEmployee==null)
        {
            throw new RuntimeException("Employee id not found -" + emp_id);
        }
        return theEmployee;
    }
    @PutMapping("/employees/{emp_id}")
    public Employee updateEmployee(@PathVariable int emp_id, @RequestBody Employee updatedEmployee) {
        return employeeService.update(emp_id, updatedEmployee);
    }
    @DeleteMapping("/employees/{emp_id}")
    private void deleteEmployee(@PathVariable("emp_id") int emp_id)
    {
        employeeService.deleteById(emp_id);
    }
}
