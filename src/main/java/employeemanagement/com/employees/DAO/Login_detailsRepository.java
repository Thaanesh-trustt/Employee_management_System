package employeemanagement.com.employees.DAO;

import employeemanagement.com.employees.Model.Login_details;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Login_detailsRepository extends JpaRepository<Login_details,Integer> {
    Login_details findByEmail(String email);
}
