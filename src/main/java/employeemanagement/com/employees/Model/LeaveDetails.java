package employeemanagement.com.employees.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Leave_details")
public class LeaveDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leave_id;
    @Column(name = "emp_id")
    private int emp_id;
    @Column(name = "leave_type")
    private String leave_type;
    @Column(name = "start_date")
    private String start_date;
    @Column(name = "end_date")
    private String end_date;
    @Column(name = "applying_to")
    private String Applying_to;
    @Column(name = "reason")
    private String reason;
    public LeaveDetails() {

    }

    public LeaveDetails(int emp_id, String leave_type, String start_date, String end_date, String applying_to, String reason) {
        this.emp_id = emp_id;
        this.leave_type = leave_type;
        this.start_date = start_date;
        this.end_date = end_date;
        Applying_to = applying_to;
        this.reason = reason;
    }

    public int getLeaveId() {
        return leave_id;
    }

    public void setLeaveId(int leaveId) {
        this.leave_id = leave_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getLeave_type() {
        return leave_type;
    }

    public void setLeave_type(String leave_type) {
        this.leave_type = leave_type;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getApplying_to() {
        return Applying_to;
    }

    public void setApplying_to(String applying_to) {
        Applying_to = applying_to;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
