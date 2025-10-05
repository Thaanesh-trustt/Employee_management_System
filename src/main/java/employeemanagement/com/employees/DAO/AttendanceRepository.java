package employeemanagement.com.employees.DAO;

import employeemanagement.com.employees.Model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
    @Query("SELECT a FROM Attendance a WHERE a.employee.id = :emp_id AND a.presentdate = :presentdate")
    Optional <Attendance>getAttendanceStatus(@PathVariable int emp_id, @RequestParam LocalDate presentdate);

    @Query("SELECT a FROM Attendance a WHERE a.employee.id = :emp_id AND a.presentdate = :presentdate")
    Optional<Attendance>dailyWorkingHours(@PathVariable int emp_id, @RequestParam LocalDate presentdate);
}
