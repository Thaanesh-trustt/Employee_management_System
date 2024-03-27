package employeemanagement.com.employees.Model;

import jakarta.persistence.*;

@Entity
@Table(name="Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="emp_id")
    private int  emp_id;

    @Column(name="emp_name")
    private String emp_name;

    @Column(nullable = false)
    private long phn_number;

    @Column(name="gender")
    private String gender;
    @Column(name="email")
    private String email;

    @Column(name="address")
    private String address;

    @Column(name="account_number")
    private long account_number;
    public Employee()
    {

    }
    public Employee(String emp_name, long phn_number, String gender, String email, String address, long account_number) {
        this.emp_name = emp_name;
        this.phn_number = phn_number;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.account_number = account_number;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public long getPhn_number() {
        return phn_number;
    }

    public void setPhn_number(long phn_number) {
        this.phn_number = phn_number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(long account_number) {
        this.account_number = account_number;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", phn_number=" + phn_number +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", account_number=" + account_number +
                '}';
    }
}
