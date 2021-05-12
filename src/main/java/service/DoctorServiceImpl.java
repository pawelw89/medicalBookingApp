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
    public Doctor findDoctorById(long id) {
        return doctorRepository.getOne(id);
    }

    @Override
    public Doctor updateDoctor(long id, Doctor doctor) {
        Doctor doctorFromDatabase = doctorRepository.getOne(id);
        doctorFromDatabase.setFirstName(doctor.getFirstName());
        doctorFromDatabase.setSurname(doctor.getSurname());
        doctorFromDatabase.setSpeciality(doctor.getSpeciality());
        doctorRepository.flush();
        Doctor updatedDoctor = doctorRepository.getOne(id);
        return updatedDoctor;
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctorById(long id) {
        doctorRepository.deleteById(id);
    }
}
