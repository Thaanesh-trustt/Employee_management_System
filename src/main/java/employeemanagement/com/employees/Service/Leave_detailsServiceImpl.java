package employeemanagement.com.employees.Service;

import employeemanagement.com.employees.DAO.Leave_detailsRepository;
import employeemanagement.com.employees.Model.Leave_details;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
@Service
public class Leave_detailsServiceImpl implements Leave_detailsService{
    private Leave_detailsRepository theLeave_detailsRepository;
    @Autowired

    public Leave_detailsServiceImpl(Leave_detailsRepository theLeave_detailsRepository) {
        this.theLeave_detailsRepository = theLeave_detailsRepository;
    }

    @Override
    @Transactional
    public Leave_details save(Leave_details theLeave_details) {
        return theLeave_detailsRepository.save(theLeave_details);
    }

    @Override
    public List<Leave_details> findAll() {
        return theLeave_detailsRepository.findAll();
    }

    @Override
    public Leave_details findById(int leave_id) {
        Optional<Leave_details> result =theLeave_detailsRepository.findById(leave_id);
        Leave_details leaveDetails=null;
        if(result.isPresent())
        {
            leaveDetails=result.get();
        }
        else
        {
            throw new EntityNotFoundException("leave_id not found" + leave_id);
        }
        return leaveDetails;
    }

    @Override
    @Transactional
    public Leave_details update(int leave_id, Leave_details updateLeave_details) {
        Optional<Leave_details> leaveDetailsOptional = theLeave_detailsRepository.findById(leave_id);
            if (leaveDetailsOptional.isPresent()) {
                Leave_details existingLeaveDetails = leaveDetailsOptional.get();
                existingLeaveDetails.setLeave_type(updateLeave_details.getLeave_type());
                existingLeaveDetails.setFrom_date(updateLeave_details.getFrom_date());
                existingLeaveDetails.setTo_date(updateLeave_details.getTo_date());
                existingLeaveDetails.setApplying_to(updateLeave_details.getApplying_to());
                existingLeaveDetails.setReason(updateLeave_details.getReason());
                // Save the updated entity
                return theLeave_detailsRepository.save(existingLeaveDetails);
            }
            return null;
            }
            @Override
           @Transactional
           public void deleteById(int leave_id) {
         theLeave_detailsRepository.deleteById(leave_id);
    }

    @Override
    public long CalculatingLeaves(int empId) {
        Optional<Leave_details> leave_detailsOptional  = theLeave_detailsRepository.findById(empId);
        if (!leave_detailsOptional.isPresent()) {
            throw new EntityNotFoundException("No leave details found for employee id: " + empId);
        }
        Leave_details leave_details = leave_detailsOptional.get();
        LocalDate fromDate = leave_details.getFrom_date();
        LocalDate toDate = leave_details.getTo_date();
        long Days = ChronoUnit.DAYS.between(fromDate, toDate);
        System.out.print("Days:");
        return Days ;

    }

}
