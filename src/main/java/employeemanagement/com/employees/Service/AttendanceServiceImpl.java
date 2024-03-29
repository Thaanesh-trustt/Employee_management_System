package employeemanagement.com.employees.Service;

import employeemanagement.com.employees.DAO.AttendanceRepository;
import employeemanagement.com.employees.Model.Attendance;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AttendanceServiceImpl implements AttendanceService {
    private AttendanceRepository attendanceRepository;

    @Autowired
    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public Attendance addAttendance(Attendance attendance) {

       return attendanceRepository.save(attendance);
    }

    @Override
    public Attendance findAttendanceById(int attendance_id) {
        Optional<Attendance> attendance = attendanceRepository.findById(attendance_id);
        if (attendance.isPresent()) {
//            System.out.println(attendance.get());
            return attendance.get();

        } else {
//            System.out.println("Attendance not found");
            return null;
        }

    }

        @Override
        public List<Attendance> findAllAttendance () {
            return attendanceRepository.findAll();
        }

        @Override
        @Transactional
        public Attendance updateAttendance (Attendance attendance){
            return attendanceRepository.save(attendance);
        }

        @Override
        @Transactional
        public void deleteAttendance (int attendance_id){
            attendanceRepository.deleteById(attendance_id);
        }
    }

