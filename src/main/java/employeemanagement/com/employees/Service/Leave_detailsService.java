package employeemanagement.com.employees.Service;

import employeemanagement.com.employees.Model.LeaveDetails;

import java.util.List;

public interface Leave_detailsService {
 LeaveDetails addLeave_details(LeaveDetails leave_details);
 LeaveDetails findLeave_detailsById(int leave_id);
 List<LeaveDetails> findAllLeave_details();
  LeaveDetails updateLeave_details(LeaveDetails leave_details);
 void deleteLeave_details(int leave_id);
}
