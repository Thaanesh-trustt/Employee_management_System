package employeemanagement.com.employees.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private int attendance_id;
    @Column(name = "emp_id")
    private int emp_id;
    @Column(name = "present_date")
    private String present_date;

    @Column(name = "check_in")
    private String check_in;
    @Column(name = "check_out")
    private String check_out;
    public Attendance() {

    }

    public Attendance(int emp_id, String present_date, String check_in, String check_out) {
        this.emp_id = emp_id;
        this.present_date = present_date;
        this.check_in = check_in;
        this.check_out = check_out;
    }

    public int getAttendance_id() {
        return attendance_id;
    }

    public void setAttendance_id(int attendance_id) {
        this.attendance_id = attendance_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getPresent_date() {
        return present_date;
    }

    public void setPresent_date(String present_date) {
        this.present_date = present_date;
    }

    public String getCheck_in() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public String getCheck_out() {
        return check_out;
    }

    public void setCheck_out(String check_out) {
        this.check_out = check_out;
    }
}
