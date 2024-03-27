package employeemanagement.com.employees.DAO;

import employeemanagement.com.employees.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {

}
