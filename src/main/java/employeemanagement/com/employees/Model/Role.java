package employeemanagement.com.employees.Model;

import jakarta.persistence.*;

@Entity
@Table(name="Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int role_id;

    @Column(name="dept_id")
    private int dept_id;


    @Column(name="emp_id")
    private int emp_id;
    @Column(name="role_name")
    private String role_name;

    public  Role()
    {

    }

    public Role(int dept_id, int emp_id, String role_name) {
        this.dept_id = dept_id;
        this.emp_id = emp_id;
        this.role_name = role_name;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", dept_id=" + dept_id +
                ", emp_id=" + emp_id +
                ", role_name='" + role_name + '\'' +
                '}';
    }
}
