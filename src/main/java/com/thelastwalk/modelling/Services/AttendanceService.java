package com.thelastwalk.modelling.Services;

import com.thelastwalk.modelling.Models.Attendance;
import com.thelastwalk.modelling.Repositories.AttendanceRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    @Autowired
    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    // Create
    public Attendance createAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    // Read
    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    public Optional<Attendance> getAttendanceById(Long id) {
        return attendanceRepository.findById(id);
    }

    // Update
    public Attendance updateAttendance(Long id, Attendance updatedAttendance) {
        Attendance existingAttendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Attendance not found with id: " + id));

        existingAttendance.setAttendanceTotal(updatedAttendance.getAttendanceTotal());
        existingAttendance.setCourse(updatedAttendance.getCourse());

        return attendanceRepository.save(existingAttendance);
    }

    // Delete
    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}
