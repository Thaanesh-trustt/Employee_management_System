package employeemanagement.com.employees.Service;

import employeemanagement.com.employees.DAO.EmployeeRepository;
import employeemanagement.com.employees.Model.Employee;
import employeemanagement.com.employees.Model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee theEmployee = null;
        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Id not found - " + id);
        }
        return theEmployee;
    }

    @Override
    public Employee update(int emp_id, Employee updatedEmployee) {
        Employee existingEmployee = employeeRepository.findById(emp_id).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setEmp_name(updatedEmployee.getEmp_name());
            existingEmployee.setPhn_number(updatedEmployee.getPhn_number());
            existingEmployee.setGender(updatedEmployee.getGender());
            existingEmployee.setEmail(updatedEmployee.getEmail());
            existingEmployee.setAddress(updatedEmployee.getAddress());
            existingEmployee.setAccount_number(updatedEmployee.getAccount_number());
            return employeeRepository.save(existingEmployee);
        }
        else {
            throw new RuntimeException("Employee with ID " + emp_id + " not found");
        }


    }

    @Override
    public void deleteById(int emp_id) {
            employeeRepository.deleteById(emp_id);
    }
}

