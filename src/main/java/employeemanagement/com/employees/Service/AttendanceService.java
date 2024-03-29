package employeemanagement.com.employees.Service;

import employeemanagement.com.employees.Model.Attendance;
import org.springframework.stereotype.Service;

import java.util.List;
public interface AttendanceService {

    Attendance addAttendance(Attendance attendance);
    Attendance findAttendanceById(int attendance_id);
    List<Attendance> findAllAttendance();
    Attendance updateAttendance(Attendance attendance);
    void deleteAttendance(int attendance_id);
}
