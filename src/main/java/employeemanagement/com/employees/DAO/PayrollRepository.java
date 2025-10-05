package employeemanagement.com.employees.DAO;

import employeemanagement.com.employees.Model.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll,Integer> {
}
