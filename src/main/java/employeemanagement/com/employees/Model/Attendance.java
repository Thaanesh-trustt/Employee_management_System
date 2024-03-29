package employeemanagement.com.employees.Model;

import jakarta.persistence.*;
//import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "emp_id")
    private int emp_id;
    @Column(name = "presentdate")
    private LocalDate presentdate;
    @Column(name = "check_in")
    private LocalTime check_in;
    @Column(name = "check_out")
    private LocalTime check_out;
    public Attendance(){

    }

    public Attendance(int emp_id, LocalDate presentdate, LocalTime check_in, LocalTime check_out) {
        this.emp_id = emp_id;
        this.presentdate = presentdate;
        this.check_in = check_in;
        this.check_out = check_out;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public LocalDate getPresentdate() {
        return presentdate;
    }

    public void setPresentdate(LocalDate presentdate) {
        this.presentdate = presentdate;
    }

    public LocalTime getCheck_in() {
        return check_in;
    }

    public void setCheck_in(LocalTime check_in) {
        this.check_in = check_in;
    }

    public LocalTime getCheck_out() {
        return check_out;
    }

    public void setCheck_out(LocalTime check_out) {
        this.check_out = check_out;
    }


}
