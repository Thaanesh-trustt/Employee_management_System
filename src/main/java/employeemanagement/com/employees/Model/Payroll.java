package employeemanagement.com.employees.Model;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;

@Entity
@Data
@Table(name="payroll")
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payroll_id;

    @Column(name="amount")
    private long amount;

    @Column(name="emp_id")
    private int emp_id;

    @Column(name="role_id")
    private int role_id;

    public Payroll()
    {

    }

    public Payroll(long amount, int emp_id, int role_id) {
        this.amount = amount;
        this.emp_id = emp_id;
        this.role_id = role_id;
    }

    public int getPayroll_id() {
        return payroll_id;
    }

    public void setPayroll_id(int payroll_id) {
        this.payroll_id = payroll_id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    @Override
    public String toString() {
        return "Payroll{" +
                "payroll_id=" + payroll_id +
                ", amount=" + amount +
                ", emp_id=" + emp_id +
                ", role_id=" + role_id +
                '}';
    }
}
