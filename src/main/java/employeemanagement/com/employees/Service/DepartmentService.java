package employeemanagement.com.employees.Service;

import employeemanagement.com.employees.Model.Department;

import java.util.List;

public interface DepartmentService {
    Department save(Department theDepartment);
    Department findById(int id);
    List<Department> findAll();

    void deleteById(int id);

    Department update(int id, Department updateDepartment);

    Department findByDeptName(String dept);
}
