package employeemanagement.com.employees.Controller;

import employeemanagement.com.employees.Model.Attendance;
import employeemanagement.com.employees.Service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AttendanceController {

    private AttendanceService attendanceService;
    @Autowired
    public AttendanceController(AttendanceService attendanceService) {

        this.attendanceService = attendanceService;
    }

  @PostMapping("/addattendance")
    public Attendance addAttendance(@RequestBody Attendance attendance) {

        return attendanceService.addAttendance(attendance);
    }
    @GetMapping("/attendance")
    public List<Attendance> findAllAttendance() {

        return attendanceService.findAllAttendance();
    }
    @GetMapping("/attendance/{attendance_id}")
    public Attendance findAttendanceById(@PathVariable int attendance_id) {
        Attendance theattendance=attendanceService.findAttendanceById(attendance_id);
        if(theattendance==null){
            throw new RuntimeException("Attendance not found");
        }
        else{
            return theattendance;
        }
    }

    @PutMapping("/attendance/{attendance_id}")
    public Attendance updateAttendance(Attendance attendance) {
        return attendanceService.updateAttendance(attendance);
    }
    @DeleteMapping("/attendance/{attendance_id}")
    public void deleteAttendance(@PathVariable("attendance_id") int attendance_id) {

        attendanceService.deleteAttendance(attendance_id);
    }

}
