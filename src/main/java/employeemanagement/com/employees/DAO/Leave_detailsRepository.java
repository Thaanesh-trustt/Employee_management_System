package employeemanagement.com.employees.DAO;

import employeemanagement.com.employees.Model.LeaveDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Leave_detailsRepository extends JpaRepository<LeaveDetails, Integer> {

}
