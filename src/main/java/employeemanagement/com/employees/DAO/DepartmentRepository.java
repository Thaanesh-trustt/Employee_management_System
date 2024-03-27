package employeemanagement.com.employees.DAO;

import employeemanagement.com.employees.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
