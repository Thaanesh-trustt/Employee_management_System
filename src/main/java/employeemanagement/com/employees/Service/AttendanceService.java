package employeemanagement.com.employees.Service;

import employeemanagement.com.employees.Model.Attendance;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceService {

     Attendance save(Attendance theAttendance);
     Attendance findById(int id);
     List<Attendance> findAll();
     Attendance update(int id, Attendance updateAttendance);
     void deleteById(int id);

     String getAttendanceStatus(int emp_id, LocalDate presentDate);

     double dailyWorkingHours(int emp_id, LocalDate presentDate);
}
