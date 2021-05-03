package service;

import entity.Doctor;
import java.util.List;

public interface DoctorService {

    List<Doctor> getAllDoctors();

    Doctor findDoctorById (long id);

    Doctor updateDoctor (long id, Doctor doctor);

    Doctor saveDoctor (Doctor doctor);

    void deleteDoctorById (long id);
}
