package service;

import entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DoctorRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor findDoctorByPesel(long pesel) {
        return doctorRepository.getOne(pesel);
    }

    @Override
    public Doctor updateDoctor(long pesel, Doctor doctor) {
        Doctor doctorFromDatabase = doctorRepository.getOne(pesel);
        doctorFromDatabase.setFirstName(doctor.getFirstName());
        doctorFromDatabase.setSurname(doctor.getSurname());
        doctorFromDatabase.setSpeciality(doctor.getSpeciality());
        doctorRepository.flush();
        return doctorRepository.getOne(pesel);
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctorByPesel(long pesel) {
        doctorRepository.deleteById(pesel);
    }
}
