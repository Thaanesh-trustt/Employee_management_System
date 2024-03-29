package employeemanagement.com.employees.Service;

import employeemanagement.com.employees.DAO.AttendanceRepository;
import employeemanagement.com.employees.Model.Attendance;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
@Service
public class AttendanceServiceImpl implements AttendanceService {
    private AttendanceRepository theAttendanceRepository;
    @Autowired
   public AttendanceServiceImpl(AttendanceRepository theAttendanceRepository) {
       this.theAttendanceRepository = theAttendanceRepository;
   }
    @Override
    @Transactional
    public Attendance save(Attendance theAttendance) {
     return theAttendanceRepository.save(theAttendance);
    }

    @Override
    public Attendance findById(int id) {
        Optional<Attendance> result=theAttendanceRepository.findById(id);
        Attendance theAttendance=null;
        if(result.isPresent())
        {
            theAttendance=result.get();
        }
        else
        {
            throw new RuntimeException("Attendance id not found" + id);
        }
        return theAttendance;
    }

    @Override
    public List<Attendance> findAll() {
       return theAttendanceRepository.findAll();
    }

    @Override
    public Attendance update(int id, Attendance updateAttendance) {
        if(theAttendanceRepository.findById(id).isPresent())
        {
            updateAttendance.setId(id);
            return theAttendanceRepository.save(updateAttendance);
        }
        else
        {
            throw new RuntimeException("Attendance id not found" + id);
        }
    }

    @Override
    public void deleteById(int id) {
        theAttendanceRepository.deleteById(id);
    }
}
