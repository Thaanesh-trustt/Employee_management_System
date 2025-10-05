package employeemanagement.com.employees.DAO;

import employeemanagement.com.employees.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    @Query("select u from Department u where u.name = ?1")
    Department findByDeptName(String dept);
}