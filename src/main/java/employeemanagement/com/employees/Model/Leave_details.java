package employeemanagement.com.employees.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Leave_details")
public class Leave_details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leave_id;
    @Column(name="leave_type")
    private String leave_type;

    @Column(name="from_date")
    private LocalDate from_date;

    @Column(name="to_date")
    private LocalDate to_date;

    @Column(name="emp_id")
    private int emp_id;

    @Column(name="applying_to")
    private String applying_to;

    @Column(name="reason")
    private String reason;


    public Leave_details()
    {

    }

    public Leave_details(String leave_type, LocalDate from_date, LocalDate to_date, int emp_id, String applying_to, String reason) {
        this.leave_type = leave_type;
        this.from_date = from_date;
        this.to_date = to_date;
        this.emp_id = emp_id;
        this.applying_to = applying_to;
        this.reason = reason;
    }

    public int getLeave_id() {
        return leave_id;
    }

    public void setLeave_id(int leave_id) {
        this.leave_id = leave_id;
    }

    public String getLeave_type() {
        return leave_type;
    }

    public void setLeave_type(String leave_type) {
        this.leave_type = leave_type;
    }

    public LocalDate getFrom_date() {
        return from_date;
    }

    public void setFrom_date(LocalDate from_date) {
        this.from_date = from_date;
    }

    public LocalDate getTo_date() {
        return to_date;
    }

    public void setTo_date(LocalDate to_date) {
        this.to_date = to_date;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getApplying_to() {
        return applying_to;
    }

    public void setApplying_to(String applying_to) {
        this.applying_to = applying_to;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Leave_details{" +
                "leave_id=" + leave_id +
                ", leave_type='" + leave_type + '\'' +
                ", from_date=" + from_date +
                ", to_date=" + to_date +
                ", emp_id=" + emp_id +
                ", applying_to='" + applying_to + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }

}
