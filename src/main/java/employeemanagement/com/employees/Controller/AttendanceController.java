package employeemanagement.com.employees.Controller;

import employeemanagement.com.employees.Model.Attendance;
import employeemanagement.com.employees.Service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AttendanceController {
    private AttendanceService attendanceService;
    @Autowired
    public AttendanceController(AttendanceService attendanceService){
        this.attendanceService=attendanceService;
    }
    @GetMapping("/attendance")
    public List<Attendance> findAll(){

        return attendanceService.findAll();
    }

    @PostMapping("/addAttendance")
    public Attendance addAttendance(@RequestBody Attendance attendance){
        return attendanceService.save(attendance);

    }
    @GetMapping("/attendance/{id}")
    public Attendance findById(@PathVariable int id){
        Attendance theAttendance=attendanceService.findById(id);
        if (theAttendance==null)
        {
            throw new RuntimeException("Attendance not found" + id);
        }
        return theAttendance;
    }
    @PutMapping("/attendance/{id}")
    public Attendance updateAttendance(@PathVariable int id, @RequestBody Attendance attendance){
        return attendanceService.update(id, attendance);
    }
    @DeleteMapping("/attendance/{id}")
    public void deleteById(@PathVariable int id){
        attendanceService.deleteById(id);
    }

}
