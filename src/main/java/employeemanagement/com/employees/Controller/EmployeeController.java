package employeemanagement.com.employees.Controller;

import employeemanagement.com.employees.Model.Department;
import employeemanagement.com.employees.Model.Employee;
import employeemanagement.com.employees.Model.Role;
import employeemanagement.com.employees.Service.DepartmentService;
import employeemanagement.com.employees.Service.EmployeeService;
import employeemanagement.com.employees.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//added rest controller
//added cross origin
@RestController
@CrossOrigin(origins = "http://localhost:3000")
//@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService employeeService;
    private DepartmentService deptService;
    private RoleService roleService;
    @Autowired
    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService,RoleService roleService) {
        this.employeeService = employeeService;
        deptService = departmentService;
        this.roleService = roleService;
    }
    @PostMapping("/add/{dept}/{role}")
    public Employee addEmployee(@PathVariable(value="dept") String dept,@PathVariable(value="role") String roleName,@RequestBody Employee emp)
    {
        Department department = deptService.findByDeptName(dept);
        emp.setDepartment(department);

        Role role = roleService.findByRole(roleName);
        emp.setRole(role);
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
    @GetMapping("/employee/{email}")
    public Employee getEmail(@PathVariable(value="email") String email){
      return employeeService.findByEmail(email);
    }
    @PutMapping("/employees/{emp_id}")
    public Employee updateEmployee(@PathVariable int emp_id, @RequestBody Employee updatedEmployee) {
        return employeeService.update(emp_id, updatedEmployee);
    }
    @DeleteMapping("/employees/{emp_id}")
    public void deleteEmployee(@PathVariable("emp_id") int emp_id)
    {
        employeeService.deleteById(emp_id);
    }
}
