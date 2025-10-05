package employeemanagement.com.employees.Service;

import employeemanagement.com.employees.Model.Role;

import java.util.List;


public interface RoleService {
    Role save(Role theRole);

    List<Role> findAll();

    Role findById(int id);

    Role update(int id, Role updatedRole);

    void deleteById(int theId);

    Role findByRole(String role);
}
