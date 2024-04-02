package employeemanagement.com.employees.DAO;

import employeemanagement.com.employees.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findByEmail(String email);
}
