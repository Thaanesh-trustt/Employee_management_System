package employeemanagement.com.employees.Controller;

import employeemanagement.com.employees.Model.Attendance;
import employeemanagement.com.employees.Model.Employee;
import employeemanagement.com.employees.Service.AttendanceService;
import employeemanagement.com.employees.Service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") //added cross origin
public class AttendanceController {
    private AttendanceService attendanceService;
    private EmployeeService employeeService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService,EmployeeService employeeService){
        this.attendanceService=attendanceService;
        this.employeeService = employeeService;
    }

    @GetMapping("/attendance")
    public List<Attendance> findAll(){
        return attendanceService.findAll();
    }

    @PostMapping("/addAttendance/{empId}")
    public Attendance addAttendance(@PathVariable(value="empId") int empId,@RequestBody Attendance attendance){
        Employee data = employeeService.findById(empId);
        attendance.setEmployee(data);
        return attendanceService.save(attendance);
    }

    @GetMapping("/attendance/{id}")
    public Attendance findById(@PathVariable int id){
        Attendance theAttendance=attendanceService.findById(id);
        if (theAttendance==null)
        {
            throw new EntityNotFoundException("Attendance not found" + id);
        }
        return theAttendance;
    }

    @PutMapping("/attendance/{id}")
    public Attendance updateAttendance(@PathVariable int id, @RequestBody Attendance attendance){
        return attendanceService.update(id, attendance);
    }

    @DeleteMapping("/attendance/{id}")
    void deleteById(@PathVariable int id){
        attendanceService.deleteById(id);
    }

    @GetMapping("/attendance/status/{emp_id}")
    public String getAttendanceStatus(@PathVariable int emp_id, @RequestParam LocalDate presentdate){
        return attendanceService.getAttendanceStatus(emp_id, presentdate);
    }
    @GetMapping("/attendance/dailyWorkingHours/{emp_id}")
    public double dailyWorkingHours(@PathVariable int emp_id, @RequestParam LocalDate presentdate){
        return attendanceService.dailyWorkingHours(emp_id, presentdate);
    }

}