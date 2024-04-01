package employeemanagement.com.employees.Controller;

import employeemanagement.com.employees.Model.Role;
import employeemanagement.com.employees.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//added rest controller
//added cross origin
@RestController
@CrossOrigin

public class RoleController {
    private RoleService theRoleService;
    @Autowired

    public RoleController(RoleService theRoleService) {
        this.theRoleService = theRoleService;
    }
    @PostMapping("/addrole")
    public Role addRole( @RequestBody  Role theRole)
    {
        Role role=theRoleService.save(theRole);
        return role;
    }
    @GetMapping("/Roles")
    public List<Role> findAll()
    {
        return theRoleService.findAll();
    }
    @GetMapping("/Roles/{role_id}")
    public  Role findById(@PathVariable int role_id){
        Role theRole=theRoleService.findById(role_id);
        if(theRole==null)
        {
            throw new RuntimeException("Role id not found" +role_id);
        }
        return theRole;
    }
    @PutMapping("/Roles/{id}")
    public Role updateRole(@PathVariable int id, @RequestBody Role updatedRole) {
        return theRoleService.update(id, updatedRole);
    }
    @DeleteMapping("/Roles/{role_id}")
    private void deleteById(@PathVariable("role_id") int role_id) {
        theRoleService.deleteById(role_id);
    }
}
