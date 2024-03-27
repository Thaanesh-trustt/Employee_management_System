package employeemanagement.com.employees.Service;

import employeemanagement.com.employees.Model.Employee;
import employeemanagement.com.employees.Model.Role;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee theEmployee);
    List<Employee> findAll();

    Employee findById(int id);

    Employee update(int emp_id, Employee updatedEmployee);
    void deleteById(int emp_id);

}
