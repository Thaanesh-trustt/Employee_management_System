package employeemanagement.com.employees.Service;

import employeemanagement.com.employees.DAO.AttendanceRepository;
import employeemanagement.com.employees.Model.Attendance;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
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
        Optional<Attendance> result = theAttendanceRepository.findById(id);
        Attendance theAttendance = null;
        if (result.isPresent()) {
            theAttendance = result.get();
        } else {
            throw new EntityNotFoundException("Attendance id not found" + id);
        }
        return theAttendance;
    }

    @Override
    public List<Attendance> findAll() {
        return theAttendanceRepository.findAll();
    }

    @Override
    @Transactional
    public Attendance update(int id, Attendance updateAttendance) {
        if (theAttendanceRepository.findById(id).isPresent()) {
            updateAttendance.setId(id);
            return theAttendanceRepository.save(updateAttendance);
        } else {
            throw new EntityNotFoundException("Attendance id not found" + id);
        }
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        theAttendanceRepository.deleteById(id);
    }

    public String getAttendanceStatus(int emp_id, LocalDate presentdate) {
        Optional<Attendance> result = theAttendanceRepository.getAttendanceStatus(emp_id, presentdate);
        if (result.isPresent()) {
            Attendance theAttendance = result.get();
            LocalDate PresentDate = theAttendance.getPresentdate();
            if (PresentDate.equals(presentdate)) {
                return "Present";
            } else {
                return "Absent";
            }
        } else {
            return "No attendance record found for this id";
        }
    }

    @Override
    public double dailyWorkingHours(int emp_id, LocalDate presentDate) {
        Optional<Attendance> result = theAttendanceRepository.dailyWorkingHours(emp_id, presentDate);
        if (result.isPresent()) {
            Attendance theAttendance = result.get();
            LocalTime checkIn = theAttendance.getCheck_in();
            LocalTime checkOut = theAttendance.getCheck_out();
            long WorkingHours = ChronoUnit.HOURS.between(checkIn,checkOut);
            return WorkingHours;
        }
        else
        {
            return 0;
        }
    }
}
