package employeemanagement.com.employees.Service;

import employeemanagement.com.employees.Model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee theEmployee);
    List<Employee> findAll();

    Employee findById(int id);


    void deleteById(int empId);
}
