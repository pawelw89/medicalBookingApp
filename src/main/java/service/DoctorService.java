package service;

import entity.Doctor;
import java.util.List;

public interface DoctorService {

    List<Doctor> getAllDoctors();

    Doctor findDoctorByPesel (long pesel);

    Doctor updateDoctor (long pesel, Doctor doctor);

    Doctor saveDoctor (Doctor doctor);

    void deleteDoctorByPesel (long pesel);
}
