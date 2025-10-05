package employeemanagement.com.employees.Service;

import employeemanagement.com.employees.Model.Leave_details;

import java.util.List;

public interface Leave_detailsService {
    Leave_details save(Leave_details theLeave_details);
    List<Leave_details> findAll();
    Leave_details findById(int leave_id);

    Leave_details update(int leave_id,Leave_details updateLeave_details);

    void deleteById(int leave_id);

   long CalculatingLeaves(int empId);
}
