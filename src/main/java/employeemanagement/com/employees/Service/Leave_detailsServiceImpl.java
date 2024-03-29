package employeemanagement.com.employees.Service;

import employeemanagement.com.employees.DAO.Leave_detailsRepository;
import employeemanagement.com.employees.Model.LeaveDetails;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Leave_detailsServiceImpl implements Leave_detailsService {

    private Leave_detailsRepository leave_detailsRepository;

    @Autowired
    public Leave_detailsServiceImpl(Leave_detailsRepository theleave_detailsRepository) {
        leave_detailsRepository = theleave_detailsRepository;
    }
    @Override
    public LeaveDetails addLeave_details(LeaveDetails leave_details) {
        return leave_detailsRepository.save(leave_details);
    }

    @Override
    public LeaveDetails findLeave_detailsById(int leave_id) {
        Optional<LeaveDetails> leave_details = leave_detailsRepository.findById(leave_id);
        if (leave_details.isPresent()) {
//            System.out.println(leave_details.get());
            return leave_details.get();
        }
        return null;
    }

    @Override
    public List<LeaveDetails> findAllLeave_details() {
        return leave_detailsRepository.findAll();
    }

    @Override
    @Transactional
    public LeaveDetails updateLeave_details(LeaveDetails leave_details) {
       return leave_detailsRepository.save(leave_details);
    }

    @Override
    @Transactional
    public void deleteLeave_details(int leave_id) {
        leave_detailsRepository.deleteById(leave_id);
    }


}
