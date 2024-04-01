package employeemanagement.com.employees.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dept_id;

    @Column(name="dept_name")
    private String dept_name;

    @Column(name="emp_id")
    private int emp_id;
    public Department()
    {

    }

    public Department(String dept_name, int emp_id) {
        this.dept_name = dept_name;
        this.emp_id = emp_id;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dept_id=" + dept_id +
                ", dept_name='" + dept_name + '\'' +
                ", emp_id=" + emp_id +
                '}';
    }
}
