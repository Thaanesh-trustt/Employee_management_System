package employeemanagement.com.employees.DAO;

import employeemanagement.com.employees.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    @Query("select u from Role u where name = ?1")
    Role findByRoleName(String role);
}
