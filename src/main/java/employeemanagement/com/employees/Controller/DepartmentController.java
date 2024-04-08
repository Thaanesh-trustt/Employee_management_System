package employeemanagement.com.employees.Controller;

import employeemanagement.com.employees.Model.Department;
import employeemanagement.com.employees.Service.DepartmentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//added rest controller
//added cross origin
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DepartmentController {
    private DepartmentService theDepartmentService;

    @Autowired
    public DepartmentController(DepartmentService theDepartmentService) {
        this.theDepartmentService = theDepartmentService;
    }

    @PostMapping("/addDepartment")
    public Department addDepartment(@RequestBody Department theDepartment)
    {
        theDepartmentService.save(theDepartment);
        return  theDepartment;
    }
    @GetMapping("/Departments")
    public List<Department> findAll()
    {
        return theDepartmentService.findAll();
    }
    @GetMapping("/Departments/{dept_id}")
    public Department findById( @PathVariable  int dept_id)
    {
        Department theDepartment=theDepartmentService.findById(dept_id);
        if(theDepartment==null)
        {
            throw new EntityNotFoundException("Department id not found" +dept_id);
        }
        return theDepartment;
    }
    @PutMapping("/Departments/{dept_id}")
    public Department updateDepartment(@PathVariable int dept_id, @RequestBody Department updateDepartment) {
        return theDepartmentService.update(dept_id, updateDepartment);
    }
    @DeleteMapping("/Departments/{dept_id}")
    private void deleteById(@PathVariable("dept_id") int dept_id)
    {
        theDepartmentService.deleteById(dept_id);
    }

    @GetMapping("/getDept/{dept}")
    public Department findByName(@PathVariable(value="dept") String name){
        return theDepartmentService.findByDeptName(name);
    }
}
